package com.zhaoyao.miaomiao.entity.dt;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.tgb.lk.ahibernate.annotation.Column;
import com.tgb.lk.ahibernate.annotation.Table;
import com.zhaoyao.miaomiao.entity.Person;
/**
 * 
 * @author lw
 * 编写时间: 2016年4月13日下午1:35:58
 * 类说明 : 阿凡达最新趣图  gif图片
 */
@Table(name = "t_DTJokeEntiry")
public class DTLatestOnEntiry extends Person implements Parcelable ,Serializable{

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
		dest.writeString(content);// "凤仙花" 
		dest.writeString(hashId);// "045353932C0FF36B1831DB2E318E8B53" 
		dest.writeString(unixtime);// "1457688795" 
		dest.writeString(updatetime);// "2016-03-11 17:33:15" 
		dest.writeString(url);// "http://api.avatardata.cn/Joke/Img?file=31e0b32feb844a32b62165f0a24d3412.gif"}
	}
	public static final Creator<DTLatestOnEntiry> CREATOR = new Creator<DTLatestOnEntiry>() {

		@Override
		public DTLatestOnEntiry[] newArray(int size) {
			return new DTLatestOnEntiry[size];
		}

		@Override
		public DTLatestOnEntiry createFromParcel(Parcel source) {
			DTLatestOnEntiry entivity = new DTLatestOnEntiry();
			entivity.setContent(source.readString());
			entivity.setHashId(source.readString());
			entivity.setUnixtime(source.readString());
			entivity.setUpdatetime(source.readString());
			entivity.setUrl(source.readString());
			return entivity;
		}
	};
	@Column(name = "content",length = 3000)
	private String content;// "凤仙花" 
	@Column(name = "hashId",length = 100)
	private String hashId;// "045353932C0FF36B1831DB2E318E8B53" 
	@Column(name = "unixtime",length = 20)
	private String unixtime;// "1457688795" 
	@Column(name = "updatetime",length = 20)
	private String updatetime;// "2016-03-11 17:33:15" 
	@Column(name = "url",length = 500)
	private String url;// "http://api.avatardata.cn/Joke/Img?file=31e0b32feb844a32b62165f0a24d3412.gif"}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(String unixtime) {
		this.unixtime = unixtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "DTJokeEntiry ["+super.toString()+", content=" + content + ", hashId=" + hashId
				+ ", unixtime=" + unixtime + ", updatetime=" + updatetime
				+ ", url=" + url + "]";
	}
	
}
