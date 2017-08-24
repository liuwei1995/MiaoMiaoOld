package com.zhaoyao.miaomiao.entity.neihanduanzi;

import android.os.Parcel;
import android.os.Parcelable;

public class NeiHanDuanZiRecommendedUserEntiry implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	private String  user;// {"user_id;// 5993466239 
	private String  name;// "\u66b4\u8d70\u7684\u592a\u9633" 
	private String  followings;// 3 
	private String  ugc_count;// 17 
	private String  avatar_url;// "http://p3.pstatp.com/thumb/4120001f06568e9feda" 
	private String  followers;// 110 
	private boolean  is_following;// false 
	private boolean  user_verified;// false} 
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFollowings() {
		return followings;
	}

	public void setFollowings(String followings) {
		this.followings = followings;
	}

	public String getUgc_count() {
		return ugc_count;
	}

	public void setUgc_count(String ugc_count) {
		this.ugc_count = ugc_count;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getFollowers() {
		return followers;
	}

	public void setFollowers(String followers) {
		this.followers = followers;
	}

	public boolean isIs_following() {
		return is_following;
	}

	public void setIs_following(boolean is_following) {
		this.is_following = is_following;
	}

	public boolean isUser_verified() {
		return user_verified;
	}

	public void setUser_verified(boolean user_verified) {
		this.user_verified = user_verified;
	}
	
	
}
