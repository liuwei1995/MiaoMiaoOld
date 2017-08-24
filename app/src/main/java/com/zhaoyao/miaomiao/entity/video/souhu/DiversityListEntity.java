package com.zhaoyao.miaomiao.entity.video.souhu;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 分集列表 
 * @author lw
 * http://open.mb.hd.sohu.com/v4/album/videos/9108694.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page=1
 */
public class DiversityListEntity implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(ver_high_pic);// "http://photocdn.sohu.com/20160315/vrs83196874_5A478_pic3.jpg" 
		dest.writeString(hor_high_pic);// "http://photocdn.sohu.com/20160315/vrs83196874_oLrif_pic2.jpg" 
		dest.writeString(cate_code);// "101;101103;101104" 
		dest.writeString(cid);// 2 
		dest.writeString(video_name);// "两个女人的战争第1集" 
		dest.writeString(aid);// 9108694 
		dest.writeString(vid);// 2933672 
		dest.writeString(time_length);// 2738 
		dest.writeString(video_order);// 1 
		dest.writeString(site);// 1 
		dest.writeString(url_html5);// "http://m.tv.sohu.com/v2933672.shtml?src=" 
		dest.writeString(create_date);// "2016-03-16" 
		dest.writeString(clarity);// "高清480P" 
		dest.writeString(hor_original_pic);// "http://photocdn.sohu.com/20160315/vrs83196874.jpg" 
		dest.writeString(url_PC);// "http://tv.sohu.com/20160316/n440547586.shtml"},
	}
	public static final Creator<DiversityListEntity> CREATOR = new Creator<DiversityListEntity>() {

		@Override
		public DiversityListEntity[] newArray(int size) {
			return new DiversityListEntity[size];
		}

		@Override
		public DiversityListEntity createFromParcel(Parcel source) {
			DiversityListEntity entivity = new DiversityListEntity();
			entivity.setVer_high_pic(source.readString());// "http://photocdn.sohu.com/20160315/vrs83196874_5A478_pic3.jpg" 
			entivity.setHor_high_pic(source.readString());// "http://photocdn.sohu.com/20160315/vrs83196874_oLrif_pic2.jpg" 
			entivity.setCate_code(source.readString());// "101;101103;101104" 
			entivity.setCid(source.readString());// 2 
			entivity.setVideo_name(source.readString());// "两个女人的战争第1集" 
			entivity.setAid(source.readString());// 9108694 
			entivity.setVid(source.readString());// 2933672 
			entivity.setTime_length(source.readString());// 2738 
			entivity.setVideo_order(source.readString());// 1 
			entivity.setSite(source.readString());// 1 
			entivity.setUrl_html5(source.readString());// "http://m.tv.sohu.com/v2933672.shtml?src=" 
			entivity.setCreate_date(source.readString());// "2016-03-16" 
			entivity.setClarity(source.readString());// "高清480P" 
			entivity.setHor_original_pic(source.readString());// "http://photocdn.sohu.com/20160315/vrs83196874.jpg" 
			entivity.setUrl_PC(source.readString());// "http://tv.sohu.com/20160316/n440547586.shtml"},
			return entivity;
		}
	};
	
//	private String status ;// 200 
//	private String statusText ;// "entivity.sete String data ;// {"count ;// 38 
//	private String videos ;// [{"
	private String ver_high_pic ;// "http://photocdn.sohu.com/20160315/vrs83196874_5A478_pic3.jpg" 
	private String hor_high_pic ;// "http://photocdn.sohu.com/20160315/vrs83196874_oLrif_pic2.jpg" 
	private String cate_code ;// "101;101103;101104" 
	private String cid ;// 2 
	private String video_name ;// "两个女人的战争第1集" 
	private String aid ;// 9108694 
	private String vid ;// 2933672 
	private String time_length ;// 2738 
	private String video_order ;// 1 
	private String site ;// 1 
	private String url_html5 ;// "http://m.tv.sohu.com/v2933672.shtml?src=" 
	private String create_date ;// "2016-03-16" 
	private String clarity ;// "高清480P" 
	private String hor_original_pic ;// "http://photocdn.sohu.com/20160315/vrs83196874.jpg" 
	private String url_PC ;// "http://tv.sohu.com/20160316/n440547586.shtml"},
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getTime_length() {
		return time_length;
	}

	public void setTime_length(String time_length) {
		this.time_length = time_length;
	}

	public String getVideo_order() {
		return video_order;
	}

	public void setVideo_order(String video_order) {
		this.video_order = video_order;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUrl_html5() {
		return url_html5;
	}

	public void setUrl_html5(String url_html5) {
		this.url_html5 = url_html5;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getClarity() {
		return clarity;
	}

	public void setClarity(String clarity) {
		this.clarity = clarity;
	}

	public String getHor_original_pic() {
		return hor_original_pic;
	}

	public void setHor_original_pic(String hor_original_pic) {
		this.hor_original_pic = hor_original_pic;
	}

	public String getUrl_PC() {
		return url_PC;
	}

	public void setUrl_PC(String url_PC) {
		this.url_PC = url_PC;
	}
	
}
