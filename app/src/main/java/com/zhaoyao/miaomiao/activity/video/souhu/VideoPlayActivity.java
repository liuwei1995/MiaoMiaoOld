package com.zhaoyao.miaomiao.activity.video.souhu;

import android.app.Activity;
import android.os.Bundle;

import com.sohuvideo.api.SohuPlayerError;
import com.sohuvideo.api.SohuPlayerItemBuilder;
import com.sohuvideo.api.SohuPlayerMonitor;
import com.sohuvideo.api.SohuPlayerStatCallback;
import com.sohuvideo.api.SohuScreenView;
import com.sohuvideo.api.SohuVideoPlayer;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.entity.video.souhu.MusicEntity;
import com.zhaoyao.miaomiao.log.MMLog;

public class VideoPlayActivity extends Activity {
	private SohuScreenView mSohuScreenView;
	private SohuVideoPlayer mSohuVideoPlayer;

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_play_sohu_screen_view);
		mSohuScreenView = (SohuScreenView) findViewById(R.id.sohu_screen);
		mSohuVideoPlayer = new SohuVideoPlayer();
		mSohuVideoPlayer.setSohuScreenView(mSohuScreenView);
		mSohuVideoPlayer.setSohuPlayerMonitor(new MySohuPlayerMonitor());
		mSohuVideoPlayer.setSohuPlayerStatCallback(new MySohuPlayerStatCallback());
		Bundle extras = getIntent().getExtras();
		if(extras==null){
			finish();return;
		}
		MusicEntity entity = extras.getParcelable("MusicEntity");
		if(entity==null){
			finish();return;
		}
		final long aid = entity.getAid();
		final long vid = entity.getVid();
		final int site = entity.getSite();
		mSohuVideoPlayer.setDataSource(new SohuPlayerItemBuilder("",  aid,  vid,  site));
//		mSohuVideoPlayer.seekTo(0);
		mSohuVideoPlayer.play();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//			}
//		}).start();
	}
	@Override
	protected void onPause() {
		if(mSohuVideoPlayer!=null){
			mSohuVideoPlayer.pause();
		}
		super.onPause();
	}
	@Override
	protected void onDestroy() {
		if(mSohuVideoPlayer!=null){
			mSohuVideoPlayer.stop(true);
		}
		super.onDestroy();
	}
	class MySohuPlayerStatCallback implements SohuPlayerStatCallback{
		@Override
		public void onEnd(SohuPlayerItemBuilder sohuPlayerItemBuilder, int arg1, boolean arg2) {
			String uri = sohuPlayerItemBuilder.getUri();
			MMLog.i("onEnd==="+uri);
		}

		@Override
		public void onHeartBeat(SohuPlayerItemBuilder sohuPlayerItemBuilder, int arg1) {
			String uri = sohuPlayerItemBuilder.getUri();
			MMLog.i("onHeartBeat==="+uri);
		}

		@Override
		public void onRealVV(SohuPlayerItemBuilder sohuPlayerItemBuilder, int arg1) {
			String uri = sohuPlayerItemBuilder.getUri();
			MMLog.i("onRealVV==="+uri);
		}

		@Override
		public void onVV(SohuPlayerItemBuilder sohuPlayerItemBuilder) {
			
		}
		
	}
private	class MySohuPlayerMonitor extends SohuPlayerMonitor{
		@Override
		public void onLoadSuccess() {
			super.onLoadSuccess();
		}
		@Override
		public void onAppPlayStart() {
			super.onAppPlayStart();
		}
		@Override
		public void onError(SohuPlayerError arg0) {
			super.onError(arg0);
		}
		@Override
		public void onDefinitionChanged() {
			super.onDefinitionChanged();
		}
	}
}
