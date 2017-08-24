package com.zhaoyao.miaomiao.dao.util;

import android.content.Context;

import com.tgb.lk.ahibernate.util.MyDBHelper;
import com.zhaoyao.miaomiao.entity.ShowApiJokeEntity;
import com.zhaoyao.miaomiao.entity.dt.DTLatestOnEntiry;

public class DBHelper extends MyDBHelper {
	private static final String DBNAME = "miaomiao.db";// 数据库名
	private static final int DBVERSION = 1;
	private static final Class<?>[] clazz = {ShowApiJokeEntity.class,DTLatestOnEntiry.class};// 要初始化的表

	public DBHelper(Context context) {
		super(context, DBNAME, null, DBVERSION, clazz);
	}


}
