package com.zhaoyao.miaomiao.entity.neihanduanzi;

import android.os.Parcel;
import android.os.Parcelable;

public class NeiHanDuanZiRecommendedMiddle_imageEntiry implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	
	
	private String  middle_image;// {"width;// 195 
	private String  r_height;// 111 
	private String  r_width;// 195 
	private String  url_list;// [
//	{"url;// "http://p1.pstatp.com/w195/32d00057e31a2f875c4.webp"}, 
//	{"url;// "http://pb3.pstatp.com/w195/32d00057e31a2f875c4.webp"}, 
//	{"url;// "http://pb3.pstatp.com/w195/32d00057e31a2f875c4.webp"}] 
	private String  uri;// "w195/32d00057e31a2f875c4" 
	private String  height;// 112} 
	public String getMiddle_image() {
		return middle_image;
	}

	public void setMiddle_image(String middle_image) {
		this.middle_image = middle_image;
	}

	public String getR_height() {
		return r_height;
	}

	public void setR_height(String r_height) {
		this.r_height = r_height;
	}

	public String getR_width() {
		return r_width;
	}

	public void setR_width(String r_width) {
		this.r_width = r_width;
	}
	/**
	 * //	{"url;// "http://p1.pstatp.com/w195/32d00057e31a2f875c4.webp"}, 
	//	{"url;// "http://pb3.pstatp.com/w195/32d00057e31a2f875c4.webp"}, 
	//	{"url;// "http://pb3.pstatp.com/w195/32d00057e31a2f875c4.webp"}] 
	 * @return
	 */
	public String getUrl_list() {
		return url_list;
	}

	public void setUrl_list(String url_list) {
		this.url_list = url_list;
	}
	/**"http://p1.pstatp.com/w195/32d00057e31a2f875c4.webp"====
	 * "w195/32d00057e31a2f875c4" 
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
}
