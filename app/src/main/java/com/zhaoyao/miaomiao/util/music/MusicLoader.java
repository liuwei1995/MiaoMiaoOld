package com.zhaoyao.miaomiao.util.music;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

import com.zhaoyao.miaomiao.App;

public class MusicLoader {
	public interface Music{
		void interMusic(List<MusicInfo> list);
	}
	public static synchronized void getMusicList(final Music music) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				final List<MusicInfo> musicList = new ArrayList<MusicInfo>();
				ContentResolver cr = App.getApplication().getContentResolver();
				if (cr == null) {
				    return;
				}
				// 获取所有歌曲
				Cursor cursor = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
				    null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
				if (null == cursor) {
				    return;
				}
				if (cursor.moveToFirst()) {
				    do {
				        String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
				        String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
				        long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
				        long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
				        int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
				        String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
				        String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
				        MusicInfo musicInfo = new MusicInfo(id, title);
						musicInfo.setAlbum(album);
						musicInfo.setDuration(duration);
						musicInfo.setSize(size);
						musicInfo.setArtist(artist);
						musicInfo.setUrl(url);
						musicList.add(musicInfo);
				    } while (cursor.moveToNext());
				}
				music.interMusic(musicList);
			}
		}).start();
	}
/**	[_id, _data, _display_name, _size, mime_type,
 *  date_added, is_drm, date_modified, title, title_key,
 *   duration, artist_id, composer, album_id, track, year, 
 *   is_ringtone, is_music, is_alarm, is_notification,
 *    is_podcast, bookmark, album_artist, artist_id:1, 
 *    artist_key, artist, album_id:1, album_key, album]
*///
        //下面是自定义的一个MusicInfo子类，实现了Parcelable，为的是可以将整个MusicInfo的ArrayList在Activity和Service中传送，=_=!!,但其实不用
	public	static class MusicInfo implements Parcelable{										
		private long id;
		private String title;
		private String album;
		private int duration;
		private long size;
		private String artist;		
		private String url;		
		private int click;
		
		public MusicInfo(){
			
		}
		
		public MusicInfo(long pId, String pTitle){
			id = pId;
			title = pTitle;
		}
		
		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAlbum() {
			return album;
		}

		public void setAlbum(String album) {
			this.album = album;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}	

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getClick() {
			return click;
		}

		public void setClick(int click) {
			this.click = click;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeLong(id);
			dest.writeString(title);
			dest.writeString(album);
			dest.writeString(artist);
			dest.writeString(url);
			dest.writeInt(duration);
			dest.writeLong(size);
			dest.writeInt(click);
		}
		
		public static final Creator<MusicInfo>
			CREATOR = new Creator<MusicInfo>() {
			
			@Override
			public MusicInfo[] newArray(int size) {
				return new MusicInfo[size];
			}
			
			@Override
			public MusicInfo createFromParcel(Parcel source) {
				MusicInfo musicInfo = new MusicInfo();
				musicInfo.setId(source.readLong());
				musicInfo.setTitle(source.readString());
				musicInfo.setAlbum(source.readString());
				musicInfo.setArtist(source.readString());
				musicInfo.setUrl(source.readString());
				musicInfo.setDuration(source.readInt());
				musicInfo.setSize(source.readLong());
				musicInfo.setClick(source.readInt());
				return musicInfo;
			}
		};
	}
}
