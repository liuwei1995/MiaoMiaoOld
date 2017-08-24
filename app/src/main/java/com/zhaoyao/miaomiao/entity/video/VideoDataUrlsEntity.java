package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoDataUrlsEntity implements Parcelable{
	
/**
 * videos: 
    [{
        domain: "sohu",
        urls: 
        [{
            private String no:  [整型]  集数序号
            private String pubtime: [字符串] 发布时间						            						        	
            private String url: [字符串] 播放地址
            private String vid: [整型]   视频ID
        }]
    }],
 */
	private String no ;//   [整型]  集数序号
    private String pubtime ;//  [字符串] 发布时间						            						        	
    private String url ;//  [字符串] 播放地址
    private String vid ;//  [整型]   视频ID
    
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(no);//   [整型]  集数序号
	    dest.writeString(pubtime);//  [字符串] 发布时间						            						        	
	    dest.writeString(url);//  [字符串] 播放地址
	    dest.writeString(vid);//  [整型]   视频ID
	}
	public static final Creator<VideoDataUrlsEntity> CREATOR = new Creator<VideoDataUrlsEntity>() {

		@Override
		public VideoDataUrlsEntity[] newArray(int size) {
			return new VideoDataUrlsEntity[size];
		}

		@Override
		public VideoDataUrlsEntity createFromParcel(Parcel source) {
			VideoDataUrlsEntity entivity = new VideoDataUrlsEntity();
			entivity.setNo(source.readString());//   [整型]  集数序号
			entivity.setPubtime(source.readString());//  [字符串] 发布时间						            						        	
			entivity.setUrl(source.readString()) ;//  [字符串] 播放地址
			entivity.setVid(source.readString()) ;//  [整型]   视频ID
			return entivity;
		}
	};
}
