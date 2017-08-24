package com.zhaoyao.miaomiao.dao.impl;

import android.content.Context;

import com.tgb.lk.ahibernate.dao.impl.BaseDaoImpl;
import com.zhaoyao.miaomiao.dao.util.DBHelper;
import com.zhaoyao.miaomiao.entity.ShowApiJokeEntity;

public class ShowApiJokeEntityDaoImpl  extends BaseDaoImpl<ShowApiJokeEntity> {

	public ShowApiJokeEntityDaoImpl(Context context) {
		super(new DBHelper(context),ShowApiJokeEntity.class);
	}

}
