package com.zhaoyao.miaomiao.receiver;

import com.zhaoyao.miaomiao.MainActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		//接收广播：系统启动完成后运行程序
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
//             Intent newIntent = new Intent(context, MainActivity.class);
//             newIntent.setAction("android.intent.action.MAIN");             
//             newIntent.addCategory("android.intent.category.LAUNCHER");           
//             newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);            
//             context.startActivity(newIntent);
        }
        //接收广播：设备上新安装了一个应用程序包后自动启动新安装应用程序。
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
//            String packageName = intent.getDataString().substring(8);
//            System.out.println("---------------" + packageName);
//            Intent newIntent = new Intent();
//            newIntent.setClassName(packageName,packageName+ ".MainActivity");
//			newIntent.setAction("android.intent.action.MAIN");            
//			newIntent.addCategory("android.intent.category.LAUNCHER");
//			newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(newIntent);
        }
        //接收广播：设备上删除了一个应用程序包。
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
//            System.out.println("********************************");
        }
	}
}
