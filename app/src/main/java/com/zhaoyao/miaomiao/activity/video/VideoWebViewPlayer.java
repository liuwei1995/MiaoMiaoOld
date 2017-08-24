package com.zhaoyao.miaomiao.activity.video;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.qq.e.union.demo.Constants;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.activity.webview.WebViewActivity;
import com.zhaoyao.miaomiao.entity.video.VideoEntertainmentEntity;
import com.zhaoyao.miaomiao.entity.video.VideoEntity;
import com.zhaoyao.miaomiao.entity.video.VideoMusicEntity;
import com.zhaoyao.miaomiao.entity.video.VideoNewsEntity;
import com.zhaoyao.miaomiao.entity.video.VideoVarietyEntity;
import com.zhaoyao.miaomiao.entity.video.souhu.AnimeEntity;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
import com.zhaoyao.miaomiao.view.modelview.NetworkDataView;

public class VideoWebViewPlayer extends WebViewActivity {
	@ViewInject(id = R.id.root)
	private NetworkDataView view;
	private FrameLayout bannerContainer3;
	private FrameLayout bannerContainer4;
	 BannerView bv3;
	 BannerView bv4;
	 private static final int ZOO = 0;
		private static final int ONE = 1;
		Handler handler = new Handler(){
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case ZOO:
					new Thread(new Runnable() {
						@Override
						public void run() {
							SystemClock.sleep(5000);
							doRefreshBanner3();
						}
					}).start();
					break;
				case ONE:
					new Thread(new Runnable() {
						@Override
						public void run() {
							SystemClock.sleep(5000);
							doRefreshBanner4();
						}
					}).start();
					break;
				default:
					break;
				}
			};
		};
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network_data);
		InjectView.Inject(this);
		 Bundle bundle = getIntent().getExtras();
	        if (bundle==null) {
				finish();return;
			}
		if (Build.VERSION.SDK_INT >= 19) {
			WebView.setWebContentsDebuggingEnabled(true);
		}
		VideoEntity videoEntity = bundle.getParcelable("VideoEntity");
		String videoUrl = "";
		if(videoEntity!=null){
			 videoUrl = videoEntity.getVideoUrl();
		}
		VideoNewsEntity VideoNewsEntity = bundle.getParcelable("VideoNewsEntity");
		if (VideoNewsEntity!=null) {
			videoUrl = VideoNewsEntity.getVideoUrl();
		}
		VideoVarietyEntity VideoVarietyEntity = bundle.getParcelable("VideoVarietyEntity");
		if(VideoVarietyEntity!=null){
			videoUrl = VideoVarietyEntity.getVideoUrl();
		}
		VideoMusicEntity VideoMusicEntity = bundle.getParcelable("VideoMusicEntity");
		if(VideoMusicEntity!=null){
			videoUrl = VideoMusicEntity.getVideoUrl();
		}
		VideoEntertainmentEntity VideoEntertainmentEntity = bundle.getParcelable("VideoEntertainmentEntity");
		if(VideoEntertainmentEntity!=null){
			videoUrl = VideoEntertainmentEntity.getVideoUrl();
		}
		if(TextUtils.isEmpty(videoUrl))finish();
		view.init(view);
		WebView web = view.getWebView();
		ProgressBar progressBar = view.getProgressBar();
		setWebView(web,progressBar).loadUrl(videoUrl);
		bannerContainer3 = (FrameLayout)findViewById(R.id.bannerContainer);
		initBanner3();
		bv3.loadAD();
		bannerContainer4 = (FrameLayout)findViewById(R.id.bannerContainer2);
		initBanner4();
		bv4.loadAD();
	}
	private void initBanner3() {
	    this.bv3 = new BannerView(this, ADSize.BANNER, Constants.APPID, Constants.BannerPosID3);
	    bv3.setRefresh(30);
	    bv3.setADListener(new AbstractBannerADListener() {
	      @Override
	      public void onNoAD(int arg0) {
	        Message msg = new Message();
	        msg.what = ZOO;
	        handler.handleMessage(msg);
	      }
	      @Override
	      public void onADReceiv() {
	    	  System.out.println();
	      }
	    });
	    bannerContainer3.addView(bv3);
	  }
	private void initBanner4() {
		this.bv4 = new BannerView(this, ADSize.BANNER, Constants.APPID, Constants.BannerPosID4);
		bv4.setRefresh(30);
		bv4.setADListener(new AbstractBannerADListener() {
			@Override
			public void onNoAD(int arg0) {
				Message msg = new Message();
				msg.what = ONE;
				handler.handleMessage(msg);
			}
			
			@Override
			public void onADReceiv() {
				System.out.println();
			}
		});
		bannerContainer4.addView(bv4);
	}
	 private void doRefreshBanner3() {
		    if (bv3 == null) {
		      initBanner3();
		    }
		    bv3.loadAD();
		  }
		  private void doRefreshBanner4() {
			  if (bv4 == null) {
				  initBanner4();
			  }
			  bv4.loadAD();
		  }
		  @Override
			protected void onDestroy() {
				  if (bv3!=null) {
					  doCloseBanner3();
				  }
				  if (bv4!=null) {
					  doCloseBanner4();
				  }
				super.onDestroy();
			}
		  private void doCloseBanner3() {
			    bannerContainer3.removeAllViews();
			    bv3.destroy();
			    bv3 = null;
			  }
			  private void doCloseBanner4() {
				  bannerContainer4.removeAllViews();
				  bv4.destroy();
				  bv4 = null;
			  }
}
