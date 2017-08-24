package com.zhaoyao.miaomiao;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.GlideUtil;
import com.zhaoyao.miaomiao.util.system.AppUtils;

public class LApplication extends Application {
	public static boolean AppAnmobAgent = false;
	/**
	 * 当前用户nickname,为了苹果推送不是userid而是昵称
	 */
	public static String currentUserNick = "";

	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.getInstance().init(this,true);
		App.init(this);
		MMLog.isLog(true);
		// 开启logcat输出，方便debug，发布时请关闭
		 XGPushConfig.enableDebug(this, true);
		 //	 在主进程设置信鸽相关的内容
		 if(AppUtils.isMainProcess(this))
			// 为保证弹出通知前一定调用本方法，需要在application的onCreate注册
			// 收到通知时，会调用本回调函数。
			// 相当于这个回调会拦截在信鸽的弹出通知之前被截取
			// 一般上针对需要获取通知内容、标题，设置通知点击的跳转逻辑等等
			XGPushManager.setNotifactionCallback(new XGPushNotifactionCallback() {
						@Override
						public void handleNotify(XGNotifaction xGNotifaction) {
							MMLog.i("test", "处理信鸽通知：" + xGNotifaction);
							// 获取标签、内容、自定义内容
							String title = xGNotifaction.getTitle();
							String content = xGNotifaction.getContent();
							String customContent = xGNotifaction.getCustomContent();
							// 其它的处理
							// 如果还要弹出通知，可直接调用以下代码或自己创建Notifaction，否则，本通知将不会弹出在通知栏中。
							xGNotifaction.doNotify();
						}
					});
		
		// 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(),
		// XGIOperateCallback)带callback版本
		// 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
		// 具体可参考详细的开发指南
		// 传递的参数为ApplicationContext
//		XGPushManager.registerPush(this, "miaomiaomiaomiao", new XGIOperateCallback() {
//			@Override
//			public void onSuccess(Object arg0, int arg1) {
//				MMLog.i(arg0);
//			}
//			@Override
//			public void onFail(Object arg0, int arg1, String arg2) {
//				MMLog.i(arg0);
//			}
//		});
		// 2.36（不包括）之前的版本需要调用以下2行代码
//		Intent service = new Intent(context, XGPushService.class);
//		context.startService(service);

		// 其它常用的API：
		// 绑定账号（别名）注册：registerPush(context,account)或registerPush(context,account,
		// XGIOperateCallback)，其中account为APP账号，可以为任意字符串（qq、openid或任意第三方），业务方一定要注意终端与后台保持一致。
		// 取消绑定账号（别名）：registerPush(context,"*")，即account="*"为取消绑定，解绑后，该针对该账号的推送将失效
		// 反注册（不再接收消息）：unregisterPush(context)
		// 设置标签：setTag(context, tagName)
		// 删除标签：deleteTag(context, tagName)
		GlideUtil.getGlideUtil().Init(this);
//		MMLocation.getMMLocation().getLocation(this);
	}
	private static void initScreenSize(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        mScreenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）
        mScreenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
    }
	  private static int mScreenWidth;
	    private static int mScreenHeight;
	    private static int mStatusBarHeight;
	    public static int getScreenWidth(Context context) {
	        if (mScreenWidth * mScreenHeight == 0) {
	            initScreenSize(context);
	        }
	        return mScreenWidth;
	    }
	    public static int getScreenHeight(Context context) {
	        if (mScreenWidth * mScreenHeight == 0) {
	            initScreenSize(context);
	        }
	        return mScreenHeight;
	    }
	    public static void setStatusBarHeight(int statusBarHeight) {
	        mStatusBarHeight = statusBarHeight;
	    }
	    public static int getStatusBarHeight() {
	        return mStatusBarHeight;
	    }
}
