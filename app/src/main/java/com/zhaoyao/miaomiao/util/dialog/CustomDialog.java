package com.zhaoyao.miaomiao.util.dialog;

import java.util.HashMap;
import java.util.Map;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import com.zhaoyao.miaomiao.R;

public class CustomDialog {
	private static int Animations = R.style.dialogWindowAnimone;
	private static Map<Integer, Dialog> maptype = new HashMap<Integer, Dialog>();
	
	public static void show(Context context,int type,View voiceView) {
		Dialog customDialog = null;
		if(maptype.containsKey(type)){
			customDialog = maptype.get(type);
		}else {
			customDialog =	new Dialog(context, R.style.CustomDialog);
			maptype.put(type, customDialog);
		}
		Window window = customDialog.getWindow();
		window.setWindowAnimations(Animations);  //添加动画	
		customDialog.setContentView(voiceView);
		customDialog.setCanceledOnTouchOutside(false);
	}
}
