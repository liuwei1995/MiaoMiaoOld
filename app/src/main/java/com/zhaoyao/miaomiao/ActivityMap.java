package com.zhaoyao.miaomiao;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;

public class ActivityMap {
	private static ActivityMap activityMap;
	private ActivityMap() {
	}
	public static ActivityMap instance() {
		if(activityMap==null)
			activityMap = new ActivityMap();
		return activityMap;
	}
	private static final Map<Activity ,Activity> map = new HashMap<Activity, Activity>();
	public void addActivity(Activity activity) {
		map.put(activity, activity);
	}
	public static Map<Activity ,Activity> getMap() {
		return map;
	}
}
