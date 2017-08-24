package com.zhaoyao.miaomiao.util.system;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
/**
 * 
 * @author lw
 * 编写时间: 2016年4月27日上午9:28:27
 * 类说明 :<li>{@link #isMainProcess(Context)}{@literal 是否在主进程}
 */
public class AppUtils {
	/**
	 * 是否在主进程
	 * @param context
	 * @return
	 */
	public static boolean isMainProcess(Context context) {
		ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
		List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
		String mainProcessName = context.getPackageName();
		int myPid = android.os.Process.myPid();
		for (RunningAppProcessInfo info : processInfos) {
			if (info.pid == myPid && mainProcessName.equals(info.processName)) {
				return true;
			}
		}
		return false;
	}

}
