package com.zhaoyao.miaomiao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhaoyao.miaomiao.entity.video.souhu.VideoSearchEntity;
import com.zhaoyao.miaomiao.util.inject.TotalInterface;

public class SouHuVideoSearchController extends TotalInterface {
	private SouHuVideoSearchController() {
	}
	private static SouHuVideoSearchController controller;
	public static SouHuVideoSearchController getInstance() {
		if(controller==null)
		   controller = new SouHuVideoSearchController();
		return controller;
	}
	private Map<String, List<VideoSearchEntity>> maplist = new HashMap<String, List<VideoSearchEntity>>();
	private List<VideoSearchEntity> listeEntities = new ArrayList<VideoSearchEntity>();
	public Map<String, List<VideoSearchEntity>> getMap() {
		if(maplist==null)
			maplist = new HashMap<String, List<VideoSearchEntity>>();
		return maplist;
	}

	public void setMap(Map<String, List<VideoSearchEntity>> map) {
		for (String key : map.keySet()) {
			List<VideoSearchEntity> list = map.get(key);
			if(maplist.containsKey(key))continue;
				maplist.put(key, list);
		}
	}
}
