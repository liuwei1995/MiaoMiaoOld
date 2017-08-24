package com.zhaoyao.miaomiao.util.system;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
/**
 * @author lw
 * 编写时间: 2016年4月22日下午12:45:52
 * 类说明 : <pre><li>有权查看使用权限的应用</pre>
 */
@SuppressLint("NewApi")
public class SystemApp {
	/**
	 * 判断当前设备中有没有“有权查看使用权限的应用”这个选项
	 * <pre>
	 * <li>android.permission.PACKAGE_USAGE_STATS
	 * <li>这个权限必须在 manifest 标签中配置下面内容加这句  xmlns:tools="http://schemas.android.com/tools"
	 * </pre>
	 * @param context
	 * @return
	 */
	public static boolean isNoOption(Context context) {  
        PackageManager packageManager = context.getPackageManager();  
        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);  
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,  
                PackageManager.MATCH_DEFAULT_ONLY);  
        return list.size() > 0;  
    }  
	/**
	 * 判断调用该设备中“有权查看使用权限的应用”这个选项的APP有没有打开
	 * <pre>
	 * <li>android.permission.PACKAGE_USAGE_STATS
	 * <li>这个权限必须在 manifest 标签中配置下面内容加这句  xmlns:tools="http://schemas.android.com/tools"
	 * </pre>
	 * @param context
	 * @return
	 */
	public static  boolean isNoSwitch(Context context) {  
	        long ts = System.currentTimeMillis();  
	        UsageStatsManager usageStatsManager = (UsageStatsManager)context.getSystemService("usagestats");  
	        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(  
	                UsageStatsManager.INTERVAL_BEST, 0, ts);  
	        if (queryUsageStats == null || queryUsageStats.isEmpty()) {  
	            return false;  
	        }  
	        return true;  
	}
	/**
	 * 然后就是跳转的代码了：
	 * <pre>
	 * <li>android.permission.PACKAGE_USAGE_STATS
	 * <li>这个权限必须在 manifest 标签中配置下面内容加这句  xmlns:tools="http://schemas.android.com/tools"
	 * </pre>
	 * @param context
	 */
	public static void start(Context context) {
		 Intent intent = new Intent(  
                 Settings.ACTION_USAGE_ACCESS_SETTINGS);  
		 context.startActivity(intent);  
	}
}
