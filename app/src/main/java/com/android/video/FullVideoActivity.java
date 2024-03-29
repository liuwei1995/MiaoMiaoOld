package com.android.video;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.android.video.widget.MediaHelp;
import com.android.video.widget.VideoMediaController;
import com.android.video.widget.VideoSuperPlayer;
import com.android.video.widget.VideoSuperPlayer.VideoPlayCallbackImpl;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.entity.neihanduanzi.NeiHanDuanZiRecommendedEntiry;

public class FullVideoActivity extends Activity {
	private VideoSuperPlayer mVideo;
	private NeiHanDuanZiRecommendedEntiry info;
//	private VideoBean info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏
		this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_full);
		mVideo = (VideoSuperPlayer) findViewById(R.id.video);
		info = getIntent().getExtras().getParcelable("video");
//		info = (NeiHanDuanZiRecommendedEntiry) getIntent().getExtras().getSerializable("video");
//		info = (VideoBean) getIntent().getExtras().getSerializable("video");
		mVideo.loadAndPlay(MediaHelp.getInstance(), info.getMp4_url(), getIntent()
				.getExtras().getInt("position"), true);
//		mVideo.loadAndPlay(MediaHelp.getInstance(), info.getUrl(), getIntent()
//				.getExtras().getInt("position"), true);
		mVideo.setPageType(VideoMediaController.PageType.EXPAND);
		mVideo.setVideoPlayCallback(new VideoPlayCallbackImpl() {

			@Override
			public void onSwitchPageType() {
				if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
					finish();
				}
			}

			@Override
			public void onPlayFinish() {
				finish();
			}

			@Override
			public void onCloseVideo() {
				finish();
			}
		});
	}

	@Override
	public void finish() {
		Intent intent = new Intent();
		intent.putExtra("position", mVideo.getCurrentPosition());
		setResult(RESULT_OK, intent);
		super.finish();
	}

	@Override
	protected void onPause() {
		super.onPause();
		MediaHelp.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		MediaHelp.resume();
	}
}
