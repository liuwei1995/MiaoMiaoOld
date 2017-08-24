package com.zhaoyao.miaomiao;//package com.zhaoyao.miaomiao;
//
//import java.util.List;
//import java.util.Map;
//
//import net.youmi.android.spot.SpotDialogListener;
//import net.youmi.android.spot.SpotManager;
//import android.os.SystemClock;
//
//import com.zhaoyao.miaomiao.controller.joke.JokeController;
//import com.zhaoyao.miaomiao.entity.ShowApiJokeEntity;
//import com.zhaoyao.miaomiao.log.MMLog;
//import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
//
//public class SingletonController {
//	private static final String TAG = SingletonController.class.getName();
//	private SingletonController() {
//	}
//	private static SingletonController singletonController;
//	public static SingletonController getSingletonController() {
//		if(singletonController==null)
//		singletonController = new SingletonController();
//		return singletonController;
//	}
//	public static Map<Integer, List<ShowApiJokeEntity>> map;
//	public static Map<Integer, List<ShowApiJokeEntity>> getContent() {
//		String pageAndNumber = SharedPreferencesUtil.getString(App.getApplication(), "pageAndNumber", "pageAndNumber");
//		Map<Integer, List<ShowApiJokeEntity>> content = JokeController.getContent(pageAndNumber,map);
//		return content;
//	}
//	public static boolean setupSpotAd = false;
//	public static boolean isonPause = false;
//	public static boolean is = false;
//	public static void setupSpotAd() {
//		if(!setupSpotAd){
//			// 预加载插屏广告数据
//			SpotManager.getInstance(App.getApplication()).loadSpotAds();
//			// 设置插屏动画的横竖屏展示方式，如果设置了横屏，则在有广告资源的情况下会是优先使用横屏图
//			SpotManager.getInstance(App.getApplication())
//			.setSpotOrientation(SpotManager.ORIENTATION_LANDSCAPE);
//			// 插屏动画效果，0:ANIM_NONE为无动画，1:ANIM_SIMPLE为简单动画效果，2:ANIM_ADVANCE为高级动画效果
//			SpotManager.getInstance(App.getApplication()).setAnimationType(SpotManager.ANIM_ADVANCE);
//			setupSpotAd = true;
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					int time = 2*60*1000;
//					while (is) {
//						if(isonPause){
//							if(time > 0){
//								time-=2;
//								showSpotAds();
//							}else {
//								time = 5*60*1000;
//							}
//						}
//						SystemClock.sleep(2000);
//					}
//				}
//			}).start();
//		}
//	}
//	private static void showSpotAds() {
//		SingletonController.getSingletonController().setupSpotAd = false;
//		// 展示插屏广告，可以不调用预加载方法独立使用
//		SpotManager.getInstance(App.getApplication())
//				.showSpotAds(App.getApplication(), new SpotDialogListener() {
//					@Override
//					public void onShowSuccess() {
//						MMLog.i(TAG, "插屏展示成功");
//					}
//
//					@Override
//					public void onShowFailed() {
//						MMLog.i(TAG, "插屏展示失败");
//					}
//
//					@Override
//					public void onSpotClosed() {
//						MMLog.i(TAG, "插屏被关闭");
//					}
//
//					@Override
//					public void onSpotClick(boolean isWebPath) {
//						MMLog.i(TAG, "插屏被点击，isWebPath = " + isWebPath);
//					}
//
//				});
//	}
//}
