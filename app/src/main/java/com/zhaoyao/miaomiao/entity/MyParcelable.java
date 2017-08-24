package com.zhaoyao.miaomiao.entity;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}

}
