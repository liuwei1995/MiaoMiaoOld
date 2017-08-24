package com.zhaoyao.miaomiao.entity.video.souhu;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 专辑详情
 * @author lw
 * private String status;// 200 
	 private String statusText;// "OK" 
	 private String data;// {"aid;// 109 
 */
public class AlbumDetailsEntity implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		 dest.writeString(is_download);// 1 
		 dest.writeString(ip_limit);// 1 
		 dest.writeString(mobile_limit);// 0 
		 dest.writeString(fee);// 0 
		 dest.writeString(album_name);// "87版红楼梦" 
		 dest.writeString(album_desc);// "青埂峰下女娲补天剩下的顽石在一僧一道的指引下下尘世去经历一番那富贵温柔乡了。一天，与甄士隐深交的贫困书生贾雨村向他借盘缠上京赴考，断定次子日后必定飞黄腾达的甄士隐慷慨解囊，于是雨村上京赴考了。不料甄士隐的爱女甄英莲却遭拐子拐了去，随后甄家在一场火灾后败落。贾雨村不负众望果然中了进士，随后当州官时遇到了被薛蟠强买的英莲，为了自己的利益，不得罪四大家族，雨村胡乱判了案。 \r\n　　林黛玉（陈晓旭 饰）母亲早逝，自幼多病，父亲林如海拖上京的贾雨村将她带到外祖母家。贾母见了黛玉后喜不自胜，从此黛玉就在贾家安顿了下来。这日王夫人的姐妹薛姨妈一家也到了京城，从此贾宝玉（欧阳奋强 饰）、林黛玉和薛宝钗（张莉 饰）和袭人等一众少年少女一同见证了四大家族的兴盛衰败……" 
		 dest.writeString(search_name);// "87版红楼梦" 
		 dest.writeString(is_original_code);// 0 
		 dest.writeString(ver_high_pic);// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318648011069.jpg" 
		 dest.writeString(hor_high_pic);// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310717991889.jpg" 
		 dest.writeString(cid);// 2 
		 dest.writeString(cate_code);// "101;101104;101106;101127" 
		 dest.writeString(second_cate_name);// "言情剧;古装剧;剧情片" 
		 dest.writeString(is_trailer);// 0 
		 dest.writeString(director);// "王扶林" 
		 dest.writeString(actor);// "陈晓旭,欧阳奋强,邓婕,张莉,郑铮,郭霄珍,安雯,周贤珍,东方闻樱,袁玫"
		 dest.writeString(area_id);// 6 
		 dest.writeString(area);// "内地剧" 
		 dest.writeString(year);// "1986" 
		 dest.writeString(total_video_count);// 36
		 dest.writeString(latest_video_count);// 0 
		 dest.writeString(score);// 7.3 
		 dest.writeString(play_count);// 77885194 
		 dest.writeString(recommend_tip);// "韵味经典永留存" 
		 dest.writeString(is_over);// 0 
		 dest.writeString(is_sohu_own);// 0 
		 dest.writeString(is_super_code);// 0 
		 dest.writeString(ver_original_pic);// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318651781679.jpg" 
		 dest.writeString(hor_original_pic);// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310716741529.jpg" 
		 dest.writeString(language_id);// 1 
		 dest.writeString(language);// "普通话"}}
	}
	public static final Creator<AlbumDetailsEntity> CREATOR = new Creator<AlbumDetailsEntity>() {

		@Override
		public AlbumDetailsEntity[] newArray(int size) {
			return new AlbumDetailsEntity[size];
		}

		@Override
		public AlbumDetailsEntity createFromParcel(Parcel source) {
			AlbumDetailsEntity entivity = new AlbumDetailsEntity();
			 entivity.setIs_download(source.readString());//  1 
			 entivity.setIp_limit(source.readString());//  1 
			 entivity.setMobile_limit(source.readString());//  0 
			 entivity.setFee(source.readString());//  0 
			 entivity.setAlbum_name(source.readString());//  "87版红楼梦" 
			 entivity.setAlbum_desc(source.readString());//  "青埂峰下女娲补天剩下的顽石在一僧一道的指引下下尘世去经历一番那富贵温柔乡了。一天，与甄士隐深交的贫困书生贾雨村向他借盘缠上京赴考，断定次子日后必定飞黄腾达的甄士隐慷慨解囊，于是雨村上京赴考了。不料甄士隐的爱女甄英莲却遭拐子拐了去，随后甄家在一场火灾后败落。贾雨村不负众望果然中了进士，随后当州官时遇到了被薛蟠强买的英莲，为了自己的利益，不得罪四大家族，雨村胡乱判了案。 \r\n　　林黛玉（陈晓旭 饰）母亲早逝，自幼多病，父亲林如海拖上京的贾雨村将她带到外祖母家。贾母见了黛玉后喜不自胜，从此黛玉就在贾家安顿了下来。这日王夫人的姐妹薛姨妈一家也到了京城，从此贾宝玉（欧阳奋强 饰）、林黛玉和薛宝钗（张莉 饰）和袭人等一众少年少女一同见证了四大家族的兴盛衰败……" 
			 entivity.setSearch_name(source.readString());//  "87版红楼梦" 
			 entivity.setIs_original_code(source.readString());//  0 
			 entivity.setVer_high_pic(source.readString());//  "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318648011069.jpg" 
			 entivity.setHor_high_pic(source.readString());//  "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310717991889.jpg" 
			 entivity.setCid(source.readString());//  2 
			 entivity.setCate_code(source.readString());//  "101;101104;101106;101127" 
			 entivity.setSecond_cate_name(source.readString());//  "言情剧;古装剧;剧情片" 
			 entivity.setIs_trailer(source.readString());//  0 
			 entivity.setDirector(source.readString());//  "王扶林" 
			 entivity.setActor(source.readString());//  "陈晓旭,欧阳奋强,邓婕,张莉,郑铮,郭霄珍,安雯,周贤珍,东方闻樱,袁玫"
			 entivity.setArea_id(source.readString());//  6 
			 entivity.setArea(source.readString());//  "内地剧" 
			 entivity.setYear(source.readString());//  "1986" 
			 entivity.setTotal_video_count(source.readString());//  36
			 entivity.setLatest_video_count(source.readString());//  0 
			 entivity.setScore(source.readString());//  7.3 
			 entivity.setPlay_count(source.readString());//  77885194 
			 entivity.setRecommend_tip(source.readString());//  "韵味经典永留存" 
			 entivity.setIs_over(source.readString());//  0 
			 entivity.setIs_sohu_own(source.readString());//  0 
			 entivity.setIs_super_code(source.readString());//  0 
			 entivity.setVer_original_pic(source.readString());//  "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318651781679.jpg" 
			 entivity.setHor_original_pic(source.readString());//  "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310716741529.jpg" 
			 entivity.setLanguage_id(source.readString());//  1 
			 entivity.setLanguage(source.readString());//  "普通话"}}
			return entivity;
		}
	};
	
	// private String status;// 200 
	// private String statusText;// "OK" 
//	 private String data;// {"aid;// 109 
	 private String is_download;// 1 
	 private String ip_limit;// 1 
	 private String mobile_limit;// 0 
	 private String fee;// 0 
	 private String album_name;// "87版红楼梦" 
	 private String album_desc;// "青埂峰下女娲补天剩下的顽石在一僧一道的指引下下尘世去经历一番那富贵温柔乡了。一天，与甄士隐深交的贫困书生贾雨村向他借盘缠上京赴考，断定次子日后必定飞黄腾达的甄士隐慷慨解囊，于是雨村上京赴考了。不料甄士隐的爱女甄英莲却遭拐子拐了去，随后甄家在一场火灾后败落。贾雨村不负众望果然中了进士，随后当州官时遇到了被薛蟠强买的英莲，为了自己的利益，不得罪四大家族，雨村胡乱判了案。 \r\n　　林黛玉（陈晓旭 饰）母亲早逝，自幼多病，父亲林如海拖上京的贾雨村将她带到外祖母家。贾母见了黛玉后喜不自胜，从此黛玉就在贾家安顿了下来。这日王夫人的姐妹薛姨妈一家也到了京城，从此贾宝玉（欧阳奋强 饰）、林黛玉和薛宝钗（张莉 饰）和袭人等一众少年少女一同见证了四大家族的兴盛衰败……" 
	 private String search_name;// "87版红楼梦" 
	 private String is_original_code;// 0 
	 private String ver_high_pic;// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318648011069.jpg" 
	 private String hor_high_pic;// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310717991889.jpg" 
	 private String cid;// 2 
	 private String cate_code;// "101;101104;101106;101127" 
	 private String second_cate_name;// "言情剧;古装剧;剧情片" 
	 private String is_trailer;// 0 
	 private String director;// "王扶林" 
	 private String actor;// "陈晓旭,欧阳奋强,邓婕,张莉,郑铮,郭霄珍,安雯,周贤珍,东方闻樱,袁玫"
	 private String area_id;// 6 
	 private String area;// "内地剧" 
	 private String year;// "1986" 
	 private String total_video_count;// 36
	 private String latest_video_count;// 0 
	 private String score;// 7.3 
	 private String play_count;// 77885194 
	 private String recommend_tip;// "韵味经典永留存" 
	 private String is_over;// 0 
	 private String is_sohu_own;// 0 
	 private String is_super_code;// 0 
	 private String ver_original_pic;// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881318651781679.jpg" 
	 private String hor_original_pic;// "http://photocdn.sohu.com/tvmobile/20140121/1928/13881310716741529.jpg" 
	 private String language_id;// 1 
	 private String language;// "普通话"}}


	public String getIs_download() {
		return is_download;
	}

	public void setIs_download(String is_download) {
		this.is_download = is_download;
	}

	public String getIp_limit() {
		return ip_limit;
	}

	public void setIp_limit(String ip_limit) {
		this.ip_limit = ip_limit;
	}

	public String getMobile_limit() {
		return mobile_limit;
	}

	public void setMobile_limit(String mobile_limit) {
		this.mobile_limit = mobile_limit;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_desc() {
		return album_desc;
	}

	public void setAlbum_desc(String album_desc) {
		this.album_desc = album_desc;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
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

	public String getSecond_cate_name() {
		return second_cate_name;
	}

	public void setSecond_cate_name(String second_cate_name) {
		this.second_cate_name = second_cate_name;
	}

	public String getIs_trailer() {
		return is_trailer;
	}

	public void setIs_trailer(String is_trailer) {
		this.is_trailer = is_trailer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTotal_video_count() {
		return total_video_count;
	}

	public void setTotal_video_count(String total_video_count) {
		this.total_video_count = total_video_count;
	}

	public String getLatest_video_count() {
		return latest_video_count;
	}

	public void setLatest_video_count(String latest_video_count) {
		this.latest_video_count = latest_video_count;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPlay_count() {
		return play_count;
	}

	public void setPlay_count(String play_count) {
		this.play_count = play_count;
	}

	public String getRecommend_tip() {
		return recommend_tip;
	}

	public void setRecommend_tip(String recommend_tip) {
		this.recommend_tip = recommend_tip;
	}

	public String getIs_over() {
		return is_over;
	}

	public void setIs_over(String is_over) {
		this.is_over = is_over;
	}

	public String getIs_sohu_own() {
		return is_sohu_own;
	}

	public void setIs_sohu_own(String is_sohu_own) {
		this.is_sohu_own = is_sohu_own;
	}

	public String getIs_super_code() {
		return is_super_code;
	}

	public void setIs_super_code(String is_super_code) {
		this.is_super_code = is_super_code;
	}

	public String getVer_original_pic() {
		return ver_original_pic;
	}

	public void setVer_original_pic(String ver_original_pic) {
		this.ver_original_pic = ver_original_pic;
	}

	public String getHor_original_pic() {
		return hor_original_pic;
	}

	public void setHor_original_pic(String hor_original_pic) {
		this.hor_original_pic = hor_original_pic;
	}

	public String getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(String language_id) {
		this.language_id = language_id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	 
}
