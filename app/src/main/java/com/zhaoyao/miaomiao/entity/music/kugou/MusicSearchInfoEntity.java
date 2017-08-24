package com.zhaoyao.miaomiao.entity.music.kugou;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;

/**
 * 搜索  MusicSearchEntity 里面的info字段
 */
public class MusicSearchInfoEntity extends MyParcelable {
	 private String filename;// "叶洛洛 - 无语伦比的美丽" 
	 private String songname;// "无语伦比的美丽"
	 private String m4afilesize;// 1282423 
	 private String l320hash;// "" 
	 private String mvhash;// "" 
	 private String privilege;// 0 
	 private String filesize;// 5000570 
	 private String source;// "sc" 
	 private String bitrate;// 128 
	 private String ownercount;// 280 
	 private String group;// [] 
	 private String album_name;// "" 
	 private String topic;// "" 
	 private String l320filesize;// 0 
	 private String isnew;// 0 
	 private String duration;// 312 
	 private String album_id;// "" 
	 private String Accompany;// 0 
	 private String singername;// "叶洛洛" 
	 private String extname;// "mp3" 
	 private String l320privilege;// 0 
	 private String sourceid;// 1 
	 private String srctype;// 1 
	 private String feetype;// 0 
	 private String sqfilesize;// 0 
	 private String hash;// "7b7fbf914ae9b8b263946f113e2ed8a5" 
	 private String sqprivilege;// 0 
	 private String sqhash;// "" 
	 private String othername;// ""
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}

	public static final Creator<MusicSearchInfoEntity> CREATOR = new Creator<MusicSearchInfoEntity>() {

		@Override
		public MusicSearchInfoEntity[] newArray(int size) {
			return new MusicSearchInfoEntity[size];
		}

		@Override
		public MusicSearchInfoEntity createFromParcel(Parcel source) {
			MusicSearchInfoEntity entivity = new MusicSearchInfoEntity();
			return entivity;
		}
	};

}
