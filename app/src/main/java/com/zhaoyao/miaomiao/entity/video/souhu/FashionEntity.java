package com.zhaoyao.miaomiao.entity.video.souhu;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 时尚 cid = 89
 * 
 * @author lw <28.json> http://open.mb.hd.sohu.com/v4/category/channel/27.json?
 *         api_key=a6719304d387489c3f6b54a56e9f7e87&page=1&is_pgc=1
 */
public class FashionEntity implements Parcelable {

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(is_album);// 0
		dest.writeString(is_trailer);// 0
		dest.writeString(aid);// 1000000466759
		dest.writeString(album_name);// "朱丽叶音乐频道"
		dest.writeString(search_name);// "《时光》朱丽叶音乐频道指弹吉他弹唱吉他独奏"
		dest.writeString(cid);// 121
		dest.writeString(cate_code);// "121"
		dest.writeString(is_original_code);// -1
		dest.writeString(ver_high_pic);// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_811_2.jpg"
		dest.writeString(hor_high_pic);// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_43_1.jpg"
		dest.writeString(hor_pic);// "http://223.img.pp.sohu.com.cn/p223/2015/10/22/15/17/6_15169723454g102SysCutcloud_81853502_7_5b.jpg"
		dest.writeString(tip);// "5分53秒"
		dest.writeString(year);// 0
		dest.writeString(area_id);// 0
		dest.writeString(update_time);// "2015-10-22 16:49:56"
		dest.writeString(time_length);// 353
		dest.writeString(vid);// 81853502
		dest.writeString(video_name);// "《时光》朱丽叶音乐频道指弹吉他弹唱吉他独奏"
		dest.writeString(video_desc);// "序列45 01_12"
		dest.writeString(is_download);// 0
		dest.writeString(site);// 2
		dest.writeString(hor_w8_pic);// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_169_2.jpg"},
	}

	public static final Creator<FashionEntity> CREATOR = new Creator<FashionEntity>() {

		@Override
		public FashionEntity[] newArray(int size) {
			return new FashionEntity[size];
		}

		@Override
		public FashionEntity createFromParcel(Parcel source) {
			FashionEntity entivity = new FashionEntity();
			entivity.setIs_album(source.readString());// 0
			entivity.setIs_trailer(source.readString());// 0
			entivity.setAid(source.readString());// 1000000466759
			entivity.setAlbum_name(source.readString());// "朱丽叶音乐频道"
			entivity.setSearch_name(source.readString());// "《时光》朱丽叶音乐频道指弹吉他弹唱吉他独奏"
			entivity.setCid(source.readString());// 121
			entivity.setCate_code(source.readString());// "121"
			entivity.setIs_original_code(source.readString());// -1
			entivity.setVer_high_pic(source.readString());// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_811_2.jpg"
			entivity.setHor_high_pic(source.readString());// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_43_1.jpg"
			entivity.setHor_pic(source.readString());// "http://223.img.pp.sohu.com.cn/p223/2015/10/22/15/17/6_15169723454g102SysCutcloud_81853502_7_5b.jpg"
			entivity.setTip(source.readString());// "5分53秒"
			entivity.setYear(source.readString());// 0
			entivity.setArea_id(source.readString());// 0
			entivity.setUpdate_time(source.readString());// "2015-10-22 16:49:56"
			entivity.setTime_length(source.readString());// 353
			entivity.setVid(source.readString());// 81853502
			entivity.setVideo_name(source.readString());// "《时光》朱丽叶音乐频道指弹吉他弹唱吉他独奏"
			entivity.setVideo_desc(source.readString());// "序列45 01_12"
			entivity.setIs_download(source.readString());// 0
			entivity.setSite(source.readString());// 2
			entivity.setHor_w8_pic(source.readString());// "http://photocdn.sohu.com/tvpgc/20151022/6_15169a10bd1g104SysCutcloud_81853502_7_5b_169_2.jpg"},
			return entivity;
		}
	};
	private String is_album;// 0
	private String is_trailer;// 0
	private String aid;// 1000000562226
	private String album_name;// "毁童年"
	private String search_name;// "毁童年 第6集 忘恩负义的阿拉丁"
	private String cid;// 115
	private String cate_code;// "115;115139"
	private String is_original_code;// -1
	private String ver_high_pic;// "http://photocdn.sohu.com/tvpgc/20160404/6_154bf8ffaa8g102SysCutcloud_83404683_7_5b_811_2.jpg"
	private String hor_high_pic;// "http://photocdn.sohu.com/tvpgc/20160404/6_154bf8ffaa8g102SysCutcloud_83404683_7_5b_43_1.jpg"
	private String hor_pic;// "http://224.img.pp.sohu.com.cn/p224/2016/4/4/22/1/6_154bf8a541ag104SysCutcloud_83404683_7_5b.jpg"
	private String tip;// "2分56秒"
	private String year;// 0
	private String area_id;// 0
	private String update_time;// "2016-04-04 22:35:18"
	private String time_length;// 176
	private String vid;// 83404683
	private String video_name;// "毁童年 第6集 忘恩负义的阿拉丁"
	private String video_desc;// " "
	private String is_download;// 0
	private String site;// 2
	private String hor_w8_pic;// "http://photocdn.sohu.com/tvpgc/20160404/6_154bf8ffaa8g102SysCutcloud_83404683_7_5b_169_2.jpg"},

	public String getIs_album() {
		return is_album;
	}

	public void setIs_album(String is_album) {
		this.is_album = is_album;
	}

	public String getIs_trailer() {
		return is_trailer;
	}

	public void setIs_trailer(String is_trailer) {
		this.is_trailer = is_trailer;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCate_code() {
		return cate_code;
	}

	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}

	public String getIs_original_code() {
		return is_original_code;
	}

	public void setIs_original_code(String is_original_code) {
		this.is_original_code = is_original_code;
	}

	public String getVer_high_pic() {
		return ver_high_pic;
	}

	public void setVer_high_pic(String ver_high_pic) {
		this.ver_high_pic = ver_high_pic;
	}

	public String getHor_high_pic() {
		return hor_high_pic;
	}

	public void setHor_high_pic(String hor_high_pic) {
		this.hor_high_pic = hor_high_pic;
	}

	public String getHor_pic() {
		return hor_pic;
	}

	public void setHor_pic(String hor_pic) {
		this.hor_pic = hor_pic;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getTime_length() {
		return time_length;
	}

	public void setTime_length(String time_length) {
		this.time_length = time_length;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_desc() {
		return video_desc;
	}

	public void setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
	}

	public String getIs_download() {
		return is_download;
	}

	public void setIs_download(String is_download) {
		this.is_download = is_download;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getHor_w8_pic() {
		return hor_w8_pic;
	}

	public void setHor_w8_pic(String hor_w8_pic) {
		this.hor_w8_pic = hor_w8_pic;
	}

}
