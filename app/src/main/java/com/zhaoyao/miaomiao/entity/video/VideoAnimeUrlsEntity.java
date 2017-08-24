package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;

/**
private String 新闻
 * urls
 * @author liuwei
 *
 */
public class VideoAnimeUrlsEntity extends MyParcelable {
	private String aid;// 1007177"
	private String length;// 1464"
	private String name;// 19"
	private String no;// 19"
	private String pubtime;// 2011-12-23"
	private String url;// http:\/\/tv.sohu.com\/20111223\/n330056822.shtml?lcode=AAAASJEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN9CURNysmgwt_btMx4LmA81vKQBHyTnvNpkGEE75Z5y6T4yBeQGNlXdZoDdulp7brk..d4y&lqd=18805"
	private String vid;// 519567"
	private String videoPic;// "}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
	}

	public static final Creator<VideoAnimeUrlsEntity> CREATOR = new Creator<VideoAnimeUrlsEntity>() {

		@Override
		public VideoAnimeUrlsEntity[] newArray(int size) {
			return new VideoAnimeUrlsEntity[size];
		}

		@Override
		public VideoAnimeUrlsEntity createFromParcel(Parcel source) {
			VideoAnimeUrlsEntity entivity = new VideoAnimeUrlsEntity();
			return entivity;
		}
	};

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getVideoPic() {
		return videoPic;
	}

	public void setVideoPic(String videoPic) {
		this.videoPic = videoPic;
	}

}
