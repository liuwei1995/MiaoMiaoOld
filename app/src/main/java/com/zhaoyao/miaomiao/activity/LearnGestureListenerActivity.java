package com.zhaoyao.miaomiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.zhaoyao.miaomiao.R;

public class LearnGestureListenerActivity extends Activity implements OnGestureListener {
	private GestureDetector mGestureDetector;
	private ViewFlipper flipper;
    private GestureDetector detector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_gesture_listener_activity);
//		mGestureDetector = new GestureDetector(this, new LearnGestureListener());
		 detector = new GestureDetector(this,this);
		 flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper1);
		//添加图片
	        flipper.addView(addImageView(R.drawable.youmi_btn_pressed));
	        flipper.addView(addImageView(R.drawable.youmi_bg_activity));
	        flipper.addView(addImageView(R.drawable.youmi_bg_divider));
	        flipper.addView(addImageView(R.drawable.youmi_star_half));
	        flipper.addView(addImageView(R.drawable.youmi_btn_download));
	        //添加layout
	        //flipper.addView(addView(R.layout.layout1));
	}
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		return mGestureDetector.onTouchEvent(event);
//	}
	 private View addImageView(int id) {
	        ImageView iv = new ImageView(this);
	        iv.setImageResource(id);
	        return iv;
	    }
	 
	 
	 @Override
	    public boolean onTouchEvent(MotionEvent event) {
	        // TODO Auto-generated method stub
	        return this.detector.onTouchEvent(event);
	    }
	    
	    @Override
	    public boolean onDown(MotionEvent e) {
	        // TODO Auto-generated method stub
	        return false;
	    }
	    
	    @Override
	    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
	            float velocityY) {
	        if (e1.getX() - e2.getX() > 120) {
	            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.learn_gesture_listener_push_left_in));
	            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.learn_gesture_listener_push_left_out));
	            this.flipper.showNext();
	            return true;
	        } else if (e1.getX() - e2.getX() < -120) {
	            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.learn_gesture_listener_push_right_in));
	            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.learn_gesture_listener_push_right_out));
	            this.flipper.showPrevious();
	            return true;
	        }
	        
	        return false;
	    }
	 
	    @Override
	    public void onLongPress(MotionEvent e) {
	        // TODO Auto-generated method stub
	        
	    }
	    
	    @Override
	    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
	            float distanceY) {
	        // TODO Auto-generated method stub
	        return false;
	    }
	    
	    @Override
	    public void onShowPress(MotionEvent e) {
	        // TODO Auto-generated method stub
	        
	    }
	    
	    @Override
	    public boolean onSingleTapUp(MotionEvent e) {
	        // TODO Auto-generated method stub
	        return false;
	    }
	 
}
