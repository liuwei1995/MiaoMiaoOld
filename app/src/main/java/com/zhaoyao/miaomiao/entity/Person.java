package com.zhaoyao.miaomiao.entity;

import java.io.Serializable;

import com.tgb.lk.ahibernate.annotation.Column;
import com.tgb.lk.ahibernate.annotation.Id;

public class Person implements Serializable {
	@Id
	@Column(name = "Id")
	private int Id; // 主键,int类型,数据库建表时此字段会设为自增长

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Override
	public String toString() {
		return " Id=" + Id + "";
	}

}
