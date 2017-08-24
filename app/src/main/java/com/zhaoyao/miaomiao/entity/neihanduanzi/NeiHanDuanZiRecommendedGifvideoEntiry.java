package com.zhaoyao.miaomiao.entity.neihanduanzi;

import android.os.Parcel;
import android.os.Parcelable;

public class NeiHanDuanZiRecommendedGifvideoEntiry implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	
	
	// {"360p_video;// {"width;// 196 private String  url_list;// [
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=360p&line=0&is_gif=1"}, 
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=360p&line=1&is_gif=1"}] 
//	private String  uri;// "360p/c1007f0eba07421da2cd56d95e13cae0" 
//	private String  height;// 112} 
	
//	private String  origin_video;// {"width;// 196 private String  url_list;// [
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=origin&line=0&is_gif=1"}, 
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=origin&line=1&is_gif=1"}] 
//	private String  uri;// "origin/c1007f0eba07421da2cd56d95e13cae0" 
//	private String  height;// 112} 
	
	
//	private String  720p_video;// {"width;// 196 private String  url_list;// [
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=720p&line=0&is_gif=1"}, 
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=720p&line=1&is_gif=1"}] 
//	private String  uri;// "720p/c1007f0eba07421da2cd56d95e13cae0" 
//	private String  height;// 112}
	
	
//	private String  480p_video;// {"width;// 196 private String  url_list;// [
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=480p&line=0&is_gif=1"}, 
//	{"url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=480p&line=1&is_gif=1"}] 
//	private String  uri;// "480p/c1007f0eba07421da2cd56d95e13cae0" 
//	private String  height;// 112} 
	
	
	private String  mp4_url;// "http://i.snssdk.com/neihan/video/playback/?video_id=c1007f0eba07421da2cd56d95e13cae0&quality=480p&line=0&is_gif=1.mp4"
	private String  video_height;// 112 
	private String  cover_image_uri;// "3e300048ffff0915c74" 
	private String  duration;// 11.8 
	private String  video_width;// 196} 
	/**播放地址*/
	public String getMp4_url() {
		return mp4_url;
	}

	public void setMp4_url(String mp4_url) {
		this.mp4_url = mp4_url;
	}

	public String getVideo_height() {
		return video_height;
	}

	public void setVideo_height(String video_height) {
		this.video_height = video_height;
	}

	public String getCover_image_uri() {
		return cover_image_uri;
	}

	public void setCover_image_uri(String cover_image_uri) {
		this.cover_image_uri = cover_image_uri;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getVideo_width() {
		return video_width;
	}

	public void setVideo_width(String video_width) {
		this.video_width = video_width;
	}
	
}
