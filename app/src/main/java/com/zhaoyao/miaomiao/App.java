package com.zhaoyao.miaomiao;

import android.app.Application;

import com.sohuvideo.api.SohuPlayerSDK;
import com.tencent.tauth.Tencent;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.ImageLoaderUtil;
public class App {
	private static Application instance;
	private static Tencent tencent;
	private static App app;
	private App() {
	}
	public static App getApp() {
		if(app==null)
		   app = new App();
		return app;
	}
	public static void init(final Application application) {
		instance = application;
		ImageLoaderUtil.init(application);
		HttpClientUtils.init(application);
		//qq登录初始化
		tencent = Tencent.createInstance("1105184875", application);
//		MusicUtils.inIt();
//		application.startService(new Intent(application, PlayMusicService.class));
//		initAnmobAgent(application);
//		SingletonController.setupSpotAd();
//		try {
//			
////			 Ads.init(application, GlobalConstantUtil.WANDOUJIA_APP_ID, GlobalConstantUtil.WANDOUJIA_SECRET_KEY);
//			 MMLog.i("11111111111111");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
         * 设置渠道号 必须 或这通过清单文件来设置 请在init方法之前调用
         * 配置渠道号 请不要和SDK初始化setPartner同时设置
         */
        // SohuPlayerSDK.setPartner("18805");
        // SohuPlayerSDK.setAppKey("a6719304d387489c3f6b54a56e9f7e87");
		//搜狐视频播放器初始化
		 SohuPlayerSDK.init(application);
	}
	public static Tencent getTencent() {
		return tencent ;
	}
//	public static void initAnmobAgent(final Application application) {
//		AnmobAgent.init(application, new AnmobCallback() {
//			@Override
//			public void onSuccess() {
//				LApplication.AppAnmobAgent = true;
////				Toast.makeText(application, "初始化成功", Toast.LENGTH_LONG).show();
//			}
//
//			@Override
//			public void onFail(String arg0) {
//				LApplication.AppAnmobAgent = false;
////				Toast.makeText(application, "初始化失败,错误信息{"+arg0+"}", Toast.LENGTH_LONG).show();
//			}
//		});
//	}
	public static Application getApplication() {
		return instance;
	}
}
