package com.zhaoyao.miaomiao.entity.music.kugou;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 搜索  请求路劲http://mobilecdn.kugou.com/api/v3/search/song?format=jsonp&keyword=无语伦比的美丽&page=1&pagesize=30&showtype=1&callback=kgJSONP904378219
 * @author lw  json里面的data 字段   kgJSONP904378219({
 * 								 kgJSONP904378219
 *==========//	 private String status;// 1 
			//	 private String error;// "" 
 			//	 private String errcode;// 0})	
 			//	 private String data;// {"
 */
public class MusicSearchEntity implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}

	public static final Creator<MusicSearchEntity> CREATOR = new Creator<MusicSearchEntity>() {

		@Override
		public MusicSearchEntity[] newArray(int size) {
			return new MusicSearchEntity[size];
		}

		@Override
		public MusicSearchEntity createFromParcel(Parcel source) {
			MusicSearchEntity entivity = new MusicSearchEntity();
			return entivity;
		}
	};
		
	
//	 * kgJSONP904378219({
//	 private String status;// 1 
//	 private String error;// "" 
//	 private String data;// {"
	 private String timestamp;// 1460020461 
	 private String correctiontype;// 5 
	 private String info;// [{"
//	 private String filename;// "叶洛洛 - 无语伦比的美丽" 
//	 private String songname;// "无语伦比的美丽"
//	 private String m4afilesize;// 1282423 
//	 private String l320hash;// "" 
//	 private String mvhash;// "" 
//	 private String privilege;// 0 
//	 private String filesize;// 5000570 
//	 private String source;// "sc" 
//	 private String bitrate;// 128 
//	 private String ownercount;// 280 
//	 private String group;// [] 
//	 private String album_name;// "" 
//	 private String topic;// "" 
//	 private String l320filesize;// 0 
//	 private String isnew;// 0 
//	 private String duration;// 312 
//	 private String album_id;// "" 
//	 private String Accompany;// 0 
//	 private String singername;// "叶洛洛" 
//	 private String extname;// "mp3" 
//	 private String l320privilege;// 0 
//	 private String sourceid;// 1 
//	 private String srctype;// 1 
//	 private String feetype;// 0 
//	 private String sqfilesize;// 0 
//	 private String hash;// "7b7fbf914ae9b8b263946f113e2ed8a5" 
//	 private String sqprivilege;// 0 
//	 private String sqhash;// "" 
//	 private String othername;// ""}] 
	 
	 private String total;// 1 
	 private String istag;// 0 
	 private String correctiontip;// "无与伦比的美丽" 
	 private String forcecorrection;// 0 
	 private String istagresult;// 0} 
//	 private String errcode;// 0})	
	 
		
}
