package com.zhaoyao.miaomiao.view.textview;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 跑马灯
 * 
 * @author liuwei   直接当  TextView用就行了   
 * 			里面还有的属性可以设置,也可以不设置: <可不用>  MarqueeTextView marquee = new MarqueeTextView(this);
 *         marquee.setText("内容"); RelativeLayout.LayoutParams
 *         titleParams = new RelativeLayout.LayoutParams( 300,
 *         LayoutParams.WRAP_CONTENT);// dip(275)
 *         titleParams.addRule(RelativeLayout.CENTER_IN_PARENT); 
 *         marquee.setSingleLine(true); //单行显示
 *         marquee.setEllipsize(TruncateAt.MARQUEE); //显示格式，跑马灯
 *         marquee.setMarqueeRepeatLimit(-1);//跑马灯重复次数，无线次
 *         marquee.setGravity(Gravity.CENTER_HORIZONTAL); 
 *         marquee.setFocusableInTouchMode(true);//可touch聚焦
 *          marquee.setTextSize(30);
 *         marquee.setTextColor(Color.BLACK);
 *         marquee.setBackgroundColor(Color.GRAY);
 *         marquee.setLayoutParams(titleParams);
 */
public class MarqueeTextView extends TextView {

	public MarqueeTextView(Context context) {
		super(context);
	}

	public MarqueeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public boolean isFocused() {
		return true;// 返回true，任何时候都处于focused状态，就能跑马
	}
}
