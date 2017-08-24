package com.zhaoyao.miaomiao.entity.neihanduanzi;

import android.os.Parcel;
import android.os.Parcelable;

public class NeiHanDuanZiRecommendedDislike_reasonEntity implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	private String  type;// 1 
	private String  id;// 302 
	private String  title;// "\u7cd7\u4eba\u7cd7\u4e8b"},
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
