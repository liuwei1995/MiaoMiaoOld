package com.zhaoyao.miaomiao.entity.video.souhu;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 关键字搜索
 * @author lw
 * 		  private String status ;// 200 
		  private String statusText ;// "OK" 
		  private String data ;// {"videos ;// [{"
	==========http://open.mb.hd.sohu.com/v4/search/keyword.json?key=%E7%AC%AC%E4%B8%80%E6%AC%A1&api_key=a6719304d387489c3f6b54a56e9f7e87&page=1&page_size=1
 */
public class KeywordSearchEntity implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		  dest.writeString(ver_big_pic);//  "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_3.jpg" 
		  dest.writeString(hor_big_pic);//  "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
		  dest.writeString(ver_high_pic);//  "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_2.jpg" 
		  dest.writeString(hor_high_pic);//  "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
		  dest.writeString(cate_code);//  "133;133113" 
		  dest.writeString(is_album);//  0 
		  dest.writeString(video_name);//  "不忍直视！处男处女的第一次羞羞体验~" 
		  dest.writeString(aid);//  1000000152044 
		  dest.writeString(vid);//  81124903 
		  dest.writeString(play_count);//  5033422 
		  dest.writeString(second_cate_name);//  "恶搞吐槽" 
		  dest.writeString(time_length);//  35 
		  dest.writeString(site);//  2}] 
		  dest.writeString(count);//  1}}
	}
	public static final Creator<KeywordSearchEntity> CREATOR = new Creator<KeywordSearchEntity>() {

		@Override
		public KeywordSearchEntity[] newArray(int size) {
			return new KeywordSearchEntity[size];
		}

		@Override
		public KeywordSearchEntity createFromParcel(Parcel source) {
			KeywordSearchEntity entivity = new KeywordSearchEntity();
			  entivity.setVer_big_pic(source.readString());// "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_3.jpg" 
			  entivity.setHor_big_pic(source.readString());// "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
			  entivity.setVer_high_pic(source.readString());// "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_2.jpg" 
			  entivity.setHor_high_pic(source.readString());// "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
			  entivity.setCate_code(source.readString());// "133;133113" 
			  entivity.setIs_album(source.readString());// 0 
			  entivity.setVideo_name(source.readString());// "不忍直视！处男处女的第一次羞羞体验~" 
			  entivity.setAid(source.readString());// 1000000152044 
			  entivity.setVid(source.readString());// 81124903 
			  entivity.setPlay_count(source.readString());// 5033422 
			  entivity.setSecond_cate_name(source.readString());// "恶搞吐槽" 
			  entivity.setTime_length(source.readString());// 35 
			  entivity.setSite(source.readString());// 2}] 
			  entivity.setCount(source.readString());// 1}}
			return entivity;
		}
	};
	
//		  private String status ;// 200 
//		  private String statusText ;// "OK" 
//		  private String data ;// {"videos ;// [{"
		  private String ver_big_pic ;// "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_3.jpg" 
		  private String hor_big_pic ;// "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
		  private String ver_high_pic ;// "http://photocdn.sohu.com/tvpgc/20151107/6_1500465fd27g104SysCutcloud_81124903_7_7b_811_2.jpg" 
		  private String hor_high_pic ;// "http://photocdn.sohu.com/tvmobile/20150814/14395482285441305.jpg" 
		  private String cate_code ;// "133;133113" 
		  private String is_album ;// 0 
		  private String video_name ;// "不忍直视！处男处女的第一次羞羞体验~" 
		  private String aid ;// 1000000152044 
		  private String vid ;// 81124903 
		  private String play_count ;// 5033422 
		  private String second_cate_name ;// "恶搞吐槽" 
		  private String time_length ;// 35 
		  private String site ;// 2}] 
		  private String count ;// 1}}
		public String getVer_big_pic() {
			return ver_big_pic;
		}

		public void setVer_big_pic(String ver_big_pic) {
			this.ver_big_pic = ver_big_pic;
		}

		public String getHor_big_pic() {
			return hor_big_pic;
		}

		public void setHor_big_pic(String hor_big_pic) {
			this.hor_big_pic = hor_big_pic;
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

		public String getCate_code() {
			return cate_code;
		}

		public void setCate_code(String cate_code) {
			this.cate_code = cate_code;
		}

		public String getIs_album() {
			return is_album;
		}

		public void setIs_album(String is_album) {
			this.is_album = is_album;
		}

		public String getVideo_name() {
			return video_name;
		}

		public void setVideo_name(String video_name) {
			this.video_name = video_name;
		}

		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		public String getVid() {
			return vid;
		}

		public void setVid(String vid) {
			this.vid = vid;
		}

		public String getPlay_count() {
			return play_count;
		}

		public void setPlay_count(String play_count) {
			this.play_count = play_count;
		}

		public String getSecond_cate_name() {
			return second_cate_name;
		}

		public void setSecond_cate_name(String second_cate_name) {
			this.second_cate_name = second_cate_name;
		}

		public String getTime_length() {
			return time_length;
		}

		public void setTime_length(String time_length) {
			this.time_length = time_length;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}
	 
}
