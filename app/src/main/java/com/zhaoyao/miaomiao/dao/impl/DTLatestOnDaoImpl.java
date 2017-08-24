package com.zhaoyao.miaomiao.dao.impl;

import android.content.Context;

import com.tgb.lk.ahibernate.dao.impl.BaseDaoImpl;
import com.zhaoyao.miaomiao.dao.util.DBHelper;
import com.zhaoyao.miaomiao.entity.dt.DTLatestOnEntiry;

public class DTLatestOnDaoImpl  extends BaseDaoImpl<DTLatestOnEntiry> {

	public DTLatestOnDaoImpl(Context context) {
		super(new DBHelper(context),DTLatestOnEntiry.class);
	}

}
