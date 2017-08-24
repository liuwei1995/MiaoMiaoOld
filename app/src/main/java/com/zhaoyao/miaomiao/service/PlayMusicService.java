package com.zhaoyao.miaomiao.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.zhaoyao.miaomiao.util.GlobalConstantUtil;

@SuppressLint("NewApi")
public class PlayMusicService extends Service {
	private MediaPlayer mediaPlayer = new MediaPlayer(); // 媒体播放器对象
	private String path; // 音乐文件路径
	private boolean isPause = true; // 暂停状态
	private PlayMusicReceiver receiver;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		IntentFilter filter = new IntentFilter(
				GlobalConstantUtil.ACTION_RECEIVER);
		receiver = new PlayMusicReceiver();
		registerReceiver(receiver, filter);
		if (mediaPlayer.isPlaying()) {
			stop();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private void startThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(GlobalConstantUtil.The_current_click_play);
				while (istrue) {
					if(isPause)return;
					int currentPosition = mediaPlayer.getCurrentPosition();//45628//86297
					int duration = mediaPlayer.getDuration();//215815//215815//
					int trackType = mediaPlayer.getTrackInfo()[0].getTrackType();
					int selectedTrack = mediaPlayer.getSelectedTrack(trackType);
					if(currentPosition==duration){
						System.out.println(duration);
					}
					intent.putExtra("currentPosition", currentPosition);
					intent.putExtra("duration", duration);
					sendBroadcast(intent);
					SystemClock.sleep(1000);
				}
			}
		}).start();
	}
	private boolean istrue = false;
	/**
	 * 播放音乐
	 * 
	 * @param position
	 */
	private void play(int position) {
		try {
			boolean looping = mediaPlayer.isLooping();
			boolean playing = mediaPlayer.isPlaying();
			System.out.println(looping);
			if(isPause&&mediaPlayer.isPlaying()){
				isPause = false;
				mediaPlayer.seekTo(position);
				mediaPlayer.start();
			}else if (TextUtils.isEmpty(path)) {
				isPause = false;
				mediaPlayer.seekTo(position);
				mediaPlayer.start();
			}
			else {
				reset();// 把各项参数恢复到初始状态
				mediaPlayer.setDataSource(path);
				mediaPlayer.prepare(); // 进行缓冲
				mediaPlayer.setOnPreparedListener(new PreparedListener(position));// 注册一个监听器
				// release();//释放音频资源
				istrue = true;
				if(mediaPlayer.isLooping()){
					Log.i("", "");
				}
				if(mediaPlayer.isPlaying()){
					Log.i("", "");
				}
				startThread();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * 把各项参数恢复到初始状态
	 */
	private void reset() {
		if (mediaPlayer != null)
			mediaPlayer.reset();//
	}

	/**
	 * 释放音频资源
	 */
	private void release() {
		if (mediaPlayer != null)
			mediaPlayer.release();//
	}

	/**
	 * 暂停音乐
	 */
	private void pause() {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
			isPause = true;
			istrue = false;
		}
	}

	/**
	 * 停止音乐
	 */
	private void stop() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			istrue = false ; 
			// try {
			// mediaPlayer.prepare(); //
			// 在调用stop后如果需要再次通过start进行播放,需要之前调用prepare函数
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
		}
	}

	@Override
	public void onDestroy() {
		istrue = false;
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		unregisterReceiver(receiver);
	}

	/**
	 * 
	 * 实现一个OnPrepareLister接口,当音乐准备好的时候开始播放
	 *
	 */
	private final class PreparedListener implements OnPreparedListener {
		private int positon;

		public PreparedListener(int positon) {
			this.positon = positon;
		}

		@Override
		public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start(); // 开始播放
			if (positon > 0) { // 如果音乐不是从头播放
				mediaPlayer.seekTo(positon);
			}
		}
	}
	private void forward(int progress){
		if(mediaPlayer==null)return;
		mediaPlayer.seekTo(progress);
	}
	private int progress;

	class PlayMusicReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			path = intent.getStringExtra("url");
			int msg = intent.getIntExtra("MSG", 0);
			if (msg == GlobalConstantUtil.MUSIC_RETREAT_QUICKLY) {
				
			} else if (msg == GlobalConstantUtil.MUSIC_IN_A_SONG) {
				
			} else if (msg == GlobalConstantUtil.MUSIC_SUSPENDED) {
				pause();
			} else if (msg == GlobalConstantUtil.MUSIC_PLAY) {
				progress = intent.getIntExtra("progress", 0);
				play(progress);
			} else if (msg == GlobalConstantUtil.MUSIC_STOP) {
				stop();
			} else if (msg == GlobalConstantUtil.MUSIC_THE_NEXT_SONG) {

			} else if (msg == GlobalConstantUtil.MUSIC_FAST_FORWARD) {
				progress = intent.getIntExtra("progress", 0);
//				play(progress);
				forward(progress);
			}
		}
	}
}