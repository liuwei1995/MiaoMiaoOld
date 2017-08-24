package com.zhaoyao.miaomiao;

import java.io.Serializable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView implements Serializable{

	public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public MyTextView(Context context) {
		super(context);
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

}
