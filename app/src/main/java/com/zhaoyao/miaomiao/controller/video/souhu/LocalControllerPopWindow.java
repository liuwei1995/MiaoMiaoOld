package com.zhaoyao.miaomiao.controller.video.souhu;

import android.content.Context;

public class LocalControllerPopWindow extends SohuControllerWindow {

	public LocalControllerPopWindow(Context context) {
		super(context);
		setDisplayModeType(MODE_TYPE.MODE_LOCAL);
	}

	public LocalControllerPopWindow(Context context, int width, int height) {
		super(context, width, height);
	}

}
