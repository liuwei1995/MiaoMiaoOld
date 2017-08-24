package com.zhaoyao.miaomiao.util.system;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
/**
 * 
 * @author lw
 * 编写时间: 2016年4月18日下午12:35:20
 * 类说明 :   是否运行
 */
public class IsRunning {
	/**
	 * 检测Service是否已启动
	 * @param serviceClassName
	 * @param context
	 * @return
	 */
	public static boolean isServiceRunning(String serviceClassName,Context context){ 
        final ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE); 
        final List<RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE); 
 
        for (RunningServiceInfo runningServiceInfo : services) { 
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)){ 
                return true; 
            } 
        } 
        return false; 
     }
	/**
	 * 判断Activity是否正在运行
	 * @param serviceClassName
	 * @param context
	 */
	/**
	 * 
	 * @param context
	 * @param MY_PKG_NAME
	 */
	public static void isActivityRunning(Context context,String MY_PKG_NAME) {
		ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> list = am.getRunningTasks(100);
		boolean isAppRunning = false;
//		String MY_PKG_NAME = "com.cyberblue.iitag";
		for (RunningTaskInfo info : list) {
		    if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
		        isAppRunning = true;
//		        Log.i(TAG,info.topActivity.getPackageName() + " info.baseActivity.getPackageName()="+info.baseActivity.getPackageName());
		        break;
		    }
		}
	}
}
