package com.zhaoyao.miaomiao.activity.webview;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.qq.e.union.demo.Constants;
import com.zhaoyao.miaomiao.AppManager;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
import com.zhaoyao.miaomiao.view.modelview.NetworkDataView;

/**
 * 网络资料 http://www.linxins.com/
 * 
 * @author lw
 *
 */
public class NetworkSearch extends WebViewActivity {
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network_data);
		AppManager.getAppManager().addActivity(this);
		if (Build.VERSION.SDK_INT >= 19) {
			WebView.setWebContentsDebuggingEnabled(true);
		}
		InjectView.Inject(this);
		view.init(view);
		WebView web = view.getWebView();
		ProgressBar progressBar = view.getProgressBar();
		setWebView(web,progressBar).loadUrl("http://hao.360.cn/?src=lm&ls=n29a430ee99");
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
	  @Override
	protected void onDestroy() {
		  if (bv3!=null) {
			  doCloseBanner3();
		  }
		  if (bv4!=null) {
			  doCloseBanner4();
		  }
		  AppManager.getAppManager().finishActivity();
		super.onDestroy();
	}
	  @Override
	public void finish() {
		super.finish();
		//关闭窗体动画显示  
	    this.overridePendingTransition(R.anim.anim_enter_from_bottom,R.anim.anim_exit_from_bottom);  
	}
}
