package com.zhaoyao.miaomiao.util.inject;

import android.annotation.SuppressLint;
import android.app.UiAutomation.OnAccessibilityEventListener;
import android.content.DialogInterface;
import android.media.RemoteController.MetadataEditor;
import android.media.RemoteController.OnClientUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.NumberPicker;

/**
 * 所有点击事件的父类
 * 
 * @author liuwei
 *
 */
@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class TotalInterface
		implements
		OnClickListener,
		OnItemClickListener,
		OnLongClickListener,
		OnItemLongClickListener,
		DialogInterface.OnClickListener,
		OnAccessibilityEventListener,
		OnClientUpdateListener,
		AdapterView.OnItemSelectedListener,OnScrollListener,NumberPicker.OnScrollListener,OnTouchListener,OnCheckedChangeListener{

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		return false;
	}

	@Override
	public boolean onLongClick(View v) {
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	@Override
	public void onClientChange(boolean clearing) {

	}

	@Override
	public void onClientPlaybackStateUpdate(int state) {

	}

	@Override
	public void onClientPlaybackStateUpdate(int state, long stateChangeTimeMs,
			long currentPosMs, float speed) {

	}

	@Override
	public void onClientTransportControlUpdate(int transportControlFlags) {

	}

	@Override
	public void onClientMetadataUpdate(MetadataEditor metadataEditor) {

	}

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}

	@Override
	public void onScrollStateChange(NumberPicker view, int scrollState) {
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
	}

}
