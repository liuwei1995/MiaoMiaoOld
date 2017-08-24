package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;
/**
 * 新闻
 * @author liuwei
 *
 */
public class VideoNewsEntity extends MyParcelable{
	
	private String  aid ;// ";//  
	private String  albumPC ;// ";//  
	private String  albumTitle ;// 视频：潘基文呼吁叙利亚政府提供全面合作";//  
	private String  albumUrl ;// ";//  
	private String  area ;// ";//  
	private String  bigPic ;// http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic23.jpg";//  
	private String  cid ;// 122";//  
	private String  clarity ;// 1";//  
	private String  cname ;// 新闻";//  
	private String  desc ;// ";//  
	private String  dt ;// ";//  
	private String  fee ;// ";//  
	private String  hidden ;// ";//  
	private String  horBigPic ;// http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic24.jpg";//  
	private String  horSmallPic ;// ";//  
	private String  id ;// 641312";//  
	private String  isover ;// ";//  
	private String  mA ;// ";//  
	private String  newcid ;// 122";//  
	private String  nowSet ;// ";//  
	private String  pid ;// ";//  
	private String  playcount ;// 13510";//  
	private String  sc ;// 央视网";//  
	private String  scategory ;// ";//  
	private String  score ;//":0;//  
	private String  showtime ;// 1334892603";//  
	private String  tip ;// 0分58秒";//  
	private String  title ;// 视频：潘基文呼吁叙利亚政府提供全面合作";//  
	private String  totalSet ;// ";//  
	private String  url ;// ";//  
	private String  verBigPic ;// ";//  
	private String  verSmallPic ;// ";//  
	private String  videoTvType ;// ";//  
	private String  videoUrl ;// http:\/\/tv.sohu.com\/20120420\/n341140545.shtml?lcode=AAAASJIr9PL1t82v8izsN5WNN68rTFA6JHt8I5trjW98nSrtZU_W5Fm0ctLfHD0fWC56dnBNOTBGhBM6CVnxekLniF7mgMMw_tR706..sk5&lqd=18805";//  
	private String  year ;// "}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(aid);//  ";//  
		dest.writeString(albumPC);//  ";//  
		dest.writeString(albumTitle);//  视频：潘基文呼吁叙利亚政府提供全面合作";//  
		dest.writeString(albumUrl);//  ";//  
		dest.writeString(area);//  ";//  
		dest.writeString(bigPic);//  http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic23.jpg";//  
		dest.writeString(cid);//  122";//  
		dest.writeString(clarity);//  1";//  
		dest.writeString(cname);//  新闻";//  
		dest.writeString(desc);//  ";//  
		dest.writeString(dt);//  ";//  
		dest.writeString(fee);//  ";//  
		dest.writeString(hidden);//  ";//  
		dest.writeString(horBigPic);//  http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic24.jpg";//  
		dest.writeString(horSmallPic);//  ";//  
		dest.writeString(id);//  641312";//  
		dest.writeString(isover);//  ";//  
		dest.writeString(mA);//  ";//  
		dest.writeString(newcid);//  122";//  
		dest.writeString(nowSet);//  ";//  
		dest.writeString(pid);//  ";//  
		dest.writeString(playcount);//  13510";//  
		dest.writeString(sc);//  央视网";//  
		dest.writeString(scategory);//  ";//  
		dest.writeString(score);// ":0;//  
		dest.writeString(showtime);//  1334892603";//  
		dest.writeString(tip);//  0分58秒";//  
		dest.writeString(title);//  视频：潘基文呼吁叙利亚政府提供全面合作";//  
		dest.writeString(totalSet);//  ";//  
		dest.writeString(url);//  ";//  
		dest.writeString(verBigPic);//  ";//  
		dest.writeString(verSmallPic);//  ";//  
		dest.writeString(videoTvType);//  ";//  
		dest.writeString(videoUrl);//  http:\/\/tv.sohu.com\/20120420\/n341140545.shtml?lcode=AAAASJIr9PL1t82v8izsN5WNN68rTFA6JHt8I5trjW98nSrtZU_W5Fm0ctLfHD0fWC56dnBNOTBGhBM6CVnxekLniF7mgMMw_tR706..sk5&lqd=18805";//  
		dest.writeString(year);//  "}
	}

	public static final Creator<VideoNewsEntity> CREATOR = new Creator<VideoNewsEntity>() {

		@Override
		public VideoNewsEntity[] newArray(int size) {
			return new VideoNewsEntity[size];
		}

		@Override
		public VideoNewsEntity createFromParcel(Parcel source) {
			VideoNewsEntity entivity = new VideoNewsEntity();
			entivity.setAid(source.readString());// ";//  
			entivity.setAlbumPC(source.readString());// ";//  
			entivity.setAlbumTitle(source.readString());// 视频：潘基文呼吁叙利亚政府提供全面合作";//  
			entivity.setAlbumUrl(source.readString());// ";//  
			entivity.setArea(source.readString());// ";//  
			entivity.setBigPic(source.readString());// http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic23.jpg";//  
			entivity.setCid(source.readString());// 122";//  
			entivity.setClarity(source.readString());// 1";//  
			entivity.setCname(source.readString());// 新闻";//  
			entivity.setDesc(source.readString());// ";//  
			entivity.setDt(source.readString());// ";//  
			entivity.setFee(source.readString());// ";//  
			entivity.setHidden(source.readString());// ";//  
			entivity.setHorBigPic(source.readString());// http:\/\/i2.itc.cn\/20120420\/06e31fcd-2408-4529-bb02-cb160457da4f_499117_641312_S_b_pic24.jpg";//  
			entivity.setHorSmallPic(source.readString());// ";//  
			entivity.setId(source.readString());// 641312";//  
			entivity.setIsover(source.readString());// ";//  
			entivity.setmA(source.readString());// ";//  
			entivity.setNewcid(source.readString());// 122";//  
			entivity.setNowSet(source.readString());// ";//  
			entivity.setPid(source.readString());// ";//  
			entivity.setPlaycount(source.readString());// 13510";//  
			entivity.setSc(source.readString());// 央视网";//  
			entivity.setScategory(source.readString());// ";//  
			entivity.setScore(source.readString());//":0;//  
			entivity.setShowtime(source.readString());// 1334892603";//  
			entivity.setTip(source.readString());// 0分58秒";//  
			entivity.setTitle(source.readString());// 视频：潘基文呼吁叙利亚政府提供全面合作";//  
			entivity.setTotalSet(source.readString());// ";//  
			entivity.setUrl(source.readString());// ";//  
			entivity.setVerBigPic(source.readString());// ";//  
			entivity.setVerSmallPic(source.readString());// ";//  
			entivity.setVideoTvType(source.readString());// ";//  
			entivity.setVideoUrl(source.readString());// http:\/\/tv.sohu.com\/20120420\/n341140545.shtml?lcode=AAAASJIr9PL1t82v8izsN5WNN68rTFA6JHt8I5trjW98nSrtZU_W5Fm0ctLfHD0fWC56dnBNOTBGhBM6CVnxekLniF7mgMMw_tR706..sk5&lqd=18805";//  
			entivity.setYear(source.readString());// "}
			return entivity;
		}
	};

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAlbumPC() {
		return albumPC;
	}

	public void setAlbumPC(String albumPC) {
		this.albumPC = albumPC;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBigPic() {
		return bigPic;
	}

	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getClarity() {
		return clarity;
	}

	public void setClarity(String clarity) {
		this.clarity = clarity;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getHorBigPic() {
		return horBigPic;
	}

	public void setHorBigPic(String horBigPic) {
		this.horBigPic = horBigPic;
	}

	public String getHorSmallPic() {
		return horSmallPic;
	}

	public void setHorSmallPic(String horSmallPic) {
		this.horSmallPic = horSmallPic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsover() {
		return isover;
	}

	public void setIsover(String isover) {
		this.isover = isover;
	}

	public String getmA() {
		return mA;
	}

	public void setmA(String mA) {
		this.mA = mA;
	}

	public String getNewcid() {
		return newcid;
	}

	public void setNewcid(String newcid) {
		this.newcid = newcid;
	}

	public String getNowSet() {
		return nowSet;
	}

	public void setNowSet(String nowSet) {
		this.nowSet = nowSet;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPlaycount() {
		return playcount;
	}

	public void setPlaycount(String playcount) {
		this.playcount = playcount;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getScategory() {
		return scategory;
	}

	public void setScategory(String scategory) {
		this.scategory = scategory;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalSet() {
		return totalSet;
	}

	public void setTotalSet(String totalSet) {
		this.totalSet = totalSet;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVerBigPic() {
		return verBigPic;
	}

	public void setVerBigPic(String verBigPic) {
		this.verBigPic = verBigPic;
	}

	public String getVerSmallPic() {
		return verSmallPic;
	}

	public void setVerSmallPic(String verSmallPic) {
		this.verSmallPic = verSmallPic;
	}

	public String getVideoTvType() {
		return videoTvType;
	}

	public void setVideoTvType(String videoTvType) {
		this.videoTvType = videoTvType;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
