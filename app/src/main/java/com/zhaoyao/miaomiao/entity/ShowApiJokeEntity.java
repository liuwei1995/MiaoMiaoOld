package com.zhaoyao.miaomiao.entity;

import com.tgb.lk.ahibernate.annotation.Column;
import com.tgb.lk.ahibernate.annotation.Table;
@Table(name = "t_showApiJokeEntity")
public class ShowApiJokeEntity extends Person {
	@Column(name = "createTime", length = 20)
	private String ct;
	@Column(name = "text", length = 3000)
	private String text;
	@Column(name = "title", length = 200)
	private String title;
	@Column(name = "type", length = 20)
	private int type;
	@Column(name = "time" ,length = 30)
	private String time;
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ShowApiJokeEntity ["+super.toString()+"ct=" + ct + ", text=" + text + ", title="
				+ title + ", type=" + type + ", time="+time + "]";
	}
	
}
