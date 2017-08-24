package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoDataEntity implements Parcelable {
	
/**
 * videos: 
    [{
        private String domain: "sohu",
        urls: 
        [{
            no:  [整型]  集数序号
            pubtime: [字符串] 发布时间						            						        	
            url: [字符串] 播放地址
            vid: [整型]   视频ID
        }]
    }],
 */
    private String domain ;// "sohu",
    
	public String getDomain() {
	return domain;
}

public void setDomain(String domain) {
	this.domain = domain;
}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(domain);
	}
	public static final Creator<VideoDataEntity> CREATOR = new Creator<VideoDataEntity>() {
		@Override
		public VideoDataEntity[] newArray(int size) {
			return new VideoDataEntity[size];
		}

		@Override
		public VideoDataEntity createFromParcel(Parcel source) {
			VideoDataEntity entivity = new VideoDataEntity();
			entivity.setDomain(source.readString());
			return entivity;
		}
	};
}
