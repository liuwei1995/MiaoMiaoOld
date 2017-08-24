package com.zhaoyao.miaomiao.testActivitytest;

import java.util.List;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
/**
 * 
 * @author lw
 * 编写时间: 2016年4月18日下午4:14:25
 * 类说明 :
 */
public class zidingyidonghua extends RecyclerView.Adapter<ViewHolder>{
	private zidingyidonghua() {
	}
	private static zidingyidonghua zidingyidonghua;
	public static zidingyidonghua getinstain() {
		if(zidingyidonghua==null)
			zidingyidonghua = new zidingyidonghua();
		return zidingyidonghua;
	}
	public void startAnim(List<ImageView> mimageviews) {
		ObjectAnimator animator0 = ObjectAnimator.ofFloat(mimageviews.get(0), "alpha", 1F, 0.5F);
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(mimageviews.get(1), "translationY", 200F);
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationX", 200F);
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationY", -200F);
		ObjectAnimator animator4 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationX", -200F);
		AnimatorSet set = new AnimatorSet();
		set.setDuration(500);
		set.setInterpolator(new BounceInterpolator());
		set.playTogether(
				animator0,
				animator1,
				animator2,
				animator3,
				animator4
				);
		set.start();
	}
	public void closeAnim(List<ImageView> mimageviews) {
		ObjectAnimator animator0 = ObjectAnimator.ofFloat(mimageviews.get(0), "alpha", 0.5F, 1F);
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(mimageviews.get(1), "translationY", -200F);
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationX", -200F);
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationY", 200F);
		ObjectAnimator animator4 = ObjectAnimator.ofFloat(mimageviews.get(2), "translationX", 200F);
		AnimatorSet set = new AnimatorSet();
		set.setDuration(500);
		set.setInterpolator(new BounceInterpolator());
		set.playTogether(
				animator0,
				animator1,
				animator2,
				animator3,
				animator4
				);
		set.start();
	}
	@Override
	public int getItemCount() {
		return 0;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		return null;
	}
	public class ViewHolder extends RecyclerView.ViewHolder {

		public ViewHolder(View itemView) {
			super(itemView);
			
		}
		
	}
	
	@Override
	public void onBindViewHolder(
			RecyclerView.ViewHolder arg0, int arg1) {
		
	}
}
