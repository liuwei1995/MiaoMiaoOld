package com.zhaoyao.miaomiao.controller.joke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zhaoyao.miaomiao.App;
import com.zhaoyao.miaomiao.dao.impl.ShowApiJokeEntityDaoImpl;
import com.zhaoyao.miaomiao.entity.ShowApiJokeEntity;
import com.zhaoyao.miaomiao.util.inject.TotalInterface;

public class JokeController extends TotalInterface {
//	private static Map<Integer, List<ShowApiJokeEntity>> map = new HashMap<Integer, List<ShowApiJokeEntity>>();
	public static Map<Integer, List<ShowApiJokeEntity>> getContent(String pageAndNumber,Map<Integer, List<ShowApiJokeEntity>> map) {
		List<ShowApiJokeEntity> Jokelist = new ArrayList<ShowApiJokeEntity>();
		String[] split = pageAndNumber.split(",");
		 int page = Integer.parseInt(split[0]);
		 int Number = Integer.parseInt(split[1]);
		 ShowApiJokeEntityDaoImpl daoImpl = new ShowApiJokeEntityDaoImpl(App.getApplication());
		 List<ShowApiJokeEntity> find = daoImpl.find();
		 if(find!=null)
		 for (int i = 0; i < find.size(); i++) {
			 Jokelist.add(find.get(i));
		}
		 if(!map.isEmpty())map.clear();
		 	map.put(Number, Jokelist);
//		 setAdapter();
		 ++Number;
//		 lv_a_main.setSelection(Number);//定位到10行;
		return map;
	}
}
