/**
 * 
 */
package com.zhaoyao.miaomiao.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	public static void show(Context context, int info) {
		Toast.makeText(context, info, 0).show();
		if (mToast == null) {
			mToast = Toast.makeText(context, info, 0);
		} else {
			mToast.setText(info);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	private static Toast mToast;

	public static void show(Context context, String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	public static void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

	public static long lastClickTime;

	public static boolean isFastDoubleClick() {
		long time = System.currentTimeMillis();
		if (time - lastClickTime < 500) {
			return true;
		}
		lastClickTime = time;
		return false;
	}
}
