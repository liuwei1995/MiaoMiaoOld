package com.zhaoyao.miaomiao.log;

import android.util.Log;

public class MMLog {
	private static final String TAG = "MiaoMiao";
	private static boolean log = false;
	public static void isLog(boolean islog) {
		log = islog;
	}
	public static void v(String TAG,Object o) {
		if(!log)return;
		Log.v(TAG,o+"");        //verbose模式,打印最详细的日志 
	}
	public static void v(Object o) {
		if(!log)return;
		v(TAG, o);
	}
	public static void d(String TAG,Object o) {
		if(!log)return;
		Log.d(TAG,o+"");        //debug级别的日志 
	}
	public static void d(Object o) {
		if(!log)return;
		d(TAG, o);
	}
	public static void i(String TAG,Object o) {
		if(!log)return;
		Log.i(TAG,o+"");        //info级别的日志 
	}
	public static void i(Object o) {
		if(!log)return;
		i(TAG, o);//info级别的日志 
	}
	public static void w(String TAG,Object o) {
		if(!log)return;
		Log.e(TAG,o+"");        //error级别的日志 
	}
	public static void w(Object o) {
		if(!log)return;
		w(TAG, o);        //error级别的日志 
	}
	public static void e(String TAG,Object o) {
		if(!log)return;
		Log.e(TAG,o+"");        //error级别的日志 
	}
	public static void e(Object o) {
		if(!log)return;
		e(TAG,o+"");        //error级别的日志 
	}
}
