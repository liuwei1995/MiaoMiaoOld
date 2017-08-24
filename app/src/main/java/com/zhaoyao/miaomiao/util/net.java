package com.zhaoyao.miaomiao.util;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/** 网络判断 */
public class net {
	/**
	 * 打开设置网络界面
	 */
	public static void setNetworkMethod(final Context context) {
		// 提示对话框
		Builder builder = new Builder(context);
		builder.setTitle("网络设置提示")
				.setMessage("网络连接不可用,是否进行设置?")
				.setPositiveButton("设置", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = null;
						// 判断手机系统的版本 即API大于10 就是3.0或以上版本
						if (android.os.Build.VERSION.SDK_INT > 10) {
							intent = new Intent(
									android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						} else {
							intent = new Intent();
							ComponentName component = new ComponentName(
									"com.android.settings",
									"com.android.settings.WirelessSettings");
							intent.setComponent(component);
							intent.setAction("android.intent.action.VIEW");
						}
						context.startActivity(intent);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).show();
	}

	public net() {
	}

	/** 判断网络连接是否可用 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm == null) {
		} else {
			// 如果仅仅是用来判断网络连接
			// 则可以使用 cm.getActiveNetworkInfo().isAvailable();
			NetworkInfo[] info = cm.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/** 判断GPS是否打开 */
	public static boolean isGpsEnabled(Context context) {
		LocationManager lm = ((LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE));
		List<String> accessibleProviders = lm.getProviders(true);
		return accessibleProviders != null && accessibleProviders.size() > 0;
	}

	/** 判断WIFI是否打开 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel
				.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}

	/** 判断是否是3G网络 */
	public static boolean is3rd(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		if (networkINfo != null
				&& networkINfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			return true;
		}
		return false;
	}

	/** 判断是wifi还是3g网络,用户的体现性在这里了，wifi就可以建议下载或者在线播放。 */
	public static boolean isWifi(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		if (networkINfo != null
				&& networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {
			return true;
		}
		return false;
	}
//	/**
//     * 检查当前网络是否可用
//     * 
//     * @param context
//     * @return
//     */
//    
//    public boolean isNetworkAvailable(Activity activity)
//    {
//        Context context = activity.getApplicationContext();
//        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        
//        if (connectivityManager == null)
//        {
//            return false;
//        }
//        else
//        {
//            // 获取NetworkInfo对象
//            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
//            
//            if (networkInfo != null && networkInfo.length > 0)
//            {
//                for (int i = 0; i < networkInfo.length; i++)
//                {
//                    System.out.println(i + "===状态===" + networkInfo[i].getState());
//                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
//                    // 判断当前网络状态是否为连接状态
//                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
