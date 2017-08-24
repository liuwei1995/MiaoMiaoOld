package com.zhaoyao.miaomiao.util;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;

import com.zhaoyao.miaomiao.App;
import com.zhaoyao.miaomiao.util.music.MusicLoader.MusicInfo;

public class MusicUtils {
	private static List<MusicInfo> listMusicInfo;
	interface Music{
		void interMusic(List<MusicInfo> list);
	}
	public static List<MusicInfo> getListMusicInfo() {
		return listMusicInfo;
	}
	public static void setListMusicInfo(List<MusicInfo> list) {
		listMusicInfo = list;
	}
	public static void inIt() {
		final Music music = new Music() {
			@Override
			public void interMusic(List<MusicInfo> list) {
				listMusicInfo = list;
			}
		};
		new Thread(new Runnable() {
			@Override
			public void run() {
				final List<MusicInfo> musicList = new ArrayList<MusicInfo>();
				ContentResolver cr = App.getApplication().getContentResolver();
				if (cr == null) {
					return;
				}
				// 获取所有歌曲
				Cursor cursor = cr.query(
						MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,
						null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
				if (null == cursor) {
					return;
				}
				if (cursor.moveToFirst()) {
					do {
						String title = cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.TITLE));
						String album = cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.ALBUM));
						long size = cursor.getLong(cursor
								.getColumnIndex(MediaStore.Audio.Media.SIZE));
						long id = cursor.getLong(cursor
								.getColumnIndex(MediaStore.Audio.Media._ID));
						int duration = cursor.getInt(cursor
								.getColumnIndex(MediaStore.Audio.Media.DURATION));
						String url = cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.DATA));
						String artist = cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.ARTIST));
						MusicInfo musicInfo = new MusicInfo(id, title);
						musicInfo.setAlbum(album);
						musicInfo.setDuration(duration);
						musicInfo.setSize(size);
						musicInfo.setArtist(artist);
						musicInfo.setUrl(url);
						musicList.add(musicInfo);
					} while (cursor.moveToNext());
					music.interMusic(musicList);
				}
			}
		}).start();

	}
}
