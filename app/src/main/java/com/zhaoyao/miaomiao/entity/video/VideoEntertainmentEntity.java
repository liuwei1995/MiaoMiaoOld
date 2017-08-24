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
public class VideoEntertainmentEntity extends MyParcelable{
	
	private String  aid ;// "1007177" 
	private String  albumPC ;// "22.21亿" 
	private String  albumTitle ;// "妖精的尾巴" 
	private String  albumUrl ;// "http:\/\/tv.sohu.com\/s2011\/yjdwb\/?lcode=AAAALdEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN_o4CzOJWX0i7xw1TF5aH_A-OWP3_skJ3Q..d4y&lqd=18805" 
	private String  area ;// "日本" 
	private String  bigPic ;// "http:\/\/i2.itc.cn\/kis\/fengmian\/982\/982821\/982821_ver_big.jpg" 
	private String  cid ;// "115" 
	private String  clarity ;// "21" 
	private String  cname ;// "动漫" 
	private String  desc ;// "少女露西一直希望能加入云集众多厉害魔法师的名为“妖精尾巴”的公会，在纳兹的引导下，露西终于得偿所愿，随后，露西跟纳兹、格雷、艾尔莎和哈比组成“最强！？”队伍，二男二女一猫的旅程就此展开……\r\n　　原作者真岛浩酷似《海贼王》作者尾田荣一郎的热血清朗画风本身就是很大一个卖点，再加上平野绫，钉宫理惠等强力党声优加盟，不俗的故事情节，难道有打算把该动画打造为《海贼王》第二的野心？好吧，真岛浩老师老师反复强调，人家和尾田荣一郎真是一点关系都没有啊。" 
	private String  dt ;// "石平信司" 
	private String  fee ;// "0" 
	private String  hidden ;// "1" 
	private String  horBigPic ;// "http:\/\/i2.itc.cn\/20111215\/vrsab_hor1007177.jpg" 
	private String  horSmallPic ;// "http:\/\/i2.itc.cn\/20111215\/vrsas_hor1007177.jpg" 
	private String  id ;// "2950319" 
	private String  isover ;// "false" 
	private String  mA ;// "" 
	private String  newcid ;// "115" 
	private String  nowSet ;// "277" 
	private String  pid ;// "330046174" 
	private String  playcount ;// "2221452724" 
	private String  sc ;// "sohu" 
	private String  scategory ;// "" 
	private String  score ;// 9 
	private String  showtime ;// "1458972000" 
	private String  tip ;// "更新至277集" 
	private String  title ;// "妖精的尾巴" 
	private String  totalSet ;// "500" 
	private String  url ;// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASZEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN-h6PtUc7HaJzN3M2h7CrfVccpKuh7Non8aF7AoMLZfbu1SfqLF5Pnx7G9p0tloNS502LVYItWLgd4y&lqd=18805" 
	private String  verBigPic ;// "http:\/\/i2.itc.cn\/20140404\/vrsab_ver1007177.jpg"
	private String  verSmallPic ;// "http:\/\/i2.itc.cn\/20140404\/vrsas_ver1007177.jpg" 
	private String  videoTvType ;// "0" 
	private String  videoUrl ;// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASUmi6isv3gkF5zeKnIOEV-R1kKhcl3yfWrzQ4g5U2KayTDMuzqrTbJpRYva7iv0OJD6nPxbsgfYhDSANdqJkLHCAaXtaCYRS8FesZ9BroUOKzua&lqd=18805"
	private String  videos ;//[[domain:"sohu",urls:[{},{}]]]
	// [{"domain ;// "sohu" 
//	private String  urls ;//[urls:[{},{}]]
	// [{"aid ;// "1007177" 
//	private String  length ;// "1464" 
//	private String  name ;// "1" 
//	private String  no ;// "1" 
//	private String  pubtime ;// "2011-12-23" private String  url ;// "http:\/\/tv.sohu.com\/20111223\/n330048227.shtml?lcode=AAAASJIr9PL1t82v8izsN5WNN68rTFA6JHt8IZu6qdTxQOCTOLh38KN9jmBMUH_tV9ivXlX6ARZMunVqaw_FudaBVJhShpGBfJ2-vQ..sk5&lqd=18805" 
//	private String  vid ;// "517980" 
//	private String  videoPic ;// ""},

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(aid);// "1007177" 
		dest.writeString(albumPC);// "22.21亿" 
		dest.writeString(albumTitle);// "妖精的尾巴" 
		dest.writeString(albumUrl);// "http:\/\/tv.sohu.com\/s2011\/yjdwb\/?lcode=AAAALdEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN_o4CzOJWX0i7xw1TF5aH_A-OWP3_skJ3Q..d4y&lqd=18805" 
		dest.writeString(area);// "日本" 
		dest.writeString(bigPic);// "http:\/\/i2.itc.cn\/kis\/fengmian\/982\/982821\/982821_ver_big.jpg" 
		dest.writeString(cid);// "115" 
		dest.writeString(clarity);// "21" 
		dest.writeString(cname);// "动漫" 
		dest.writeString(desc);// "少女露西一直希望能加入云集众多厉害魔法师的名为“妖精尾巴”的公会，在纳兹的引导下，露西终于得偿所愿，随后，露西跟纳兹、格雷、艾尔莎和哈比组成“最强！？”队伍，二男二女一猫的旅程就此展开……\r\n　　原作者真岛浩酷似《海贼王》作者尾田荣一郎的热血清朗画风本身就是很大一个卖点，再加上平野绫，钉宫理惠等强力党声优加盟，不俗的故事情节，难道有打算把该动画打造为《海贼王》第二的野心？好吧，真岛浩老师老师反复强调，人家和尾田荣一郎真是一点关系都没有啊。" 
		dest.writeString(dt);// "石平信司" 
		dest.writeString(fee);// "0" 
		dest.writeString(hidden);// "1" 
		dest.writeString(horBigPic);// "http:\/\/i2.itc.cn\/20111215\/vrsab_hor1007177.jpg" 
		dest.writeString(horSmallPic);// "http:\/\/i2.itc.cn\/20111215\/vrsas_hor1007177.jpg" 
		dest.writeString(id);// "2950319" 
		dest.writeString(isover);// "false" 
		dest.writeString(mA);// "" 
		dest.writeString(newcid);// "115" 
		dest.writeString(nowSet);// "277" 
		dest.writeString(pid);// "330046174" 
		dest.writeString(playcount);// "2221452724" 
		dest.writeString(sc);// "sohu" 
		dest.writeString(scategory);// "" 
		dest.writeString(score);// 9 
		dest.writeString(showtime);// "1458972000" 
		dest.writeString(tip);// "更新至277集" 
		dest.writeString(title);// "妖精的尾巴" 
		dest.writeString(totalSet);// "500" 
		dest.writeString(url);// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASZEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN-h6PtUc7HaJzN3M2h7CrfVccpKuh7Non8aF7AoMLZfbu1SfqLF5Pnx7G9p0tloNS502LVYItWLgd4y&lqd=18805" 
		dest.writeString(verBigPic);// "http:\/\/i2.itc.cn\/20140404\/vrsab_ver1007177.jpg"
		dest.writeString(verSmallPic);// "http:\/\/i2.itc.cn\/20140404\/vrsas_ver1007177.jpg" 
		dest.writeString(videoTvType);// "0" 
		dest.writeString(videoUrl);// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASUmi6isv3gkF5zeKnIOEV-R1kKhcl3yfWrzQ4g5U2KayTDMuzqrTbJpRYva7iv0OJD6nPxbsgfYhDSANdqJkLHCAaXtaCYRS8FesZ9BroUOKzua&lqd=18805"
		dest.writeString(videos);//[[domain:"sohu",urls:[{},{}]]]
	}

	public static final Creator<VideoEntertainmentEntity> CREATOR = new Creator<VideoEntertainmentEntity>() {

		@Override
		public VideoEntertainmentEntity[] newArray(int size) {
			return new VideoEntertainmentEntity[size];
		}

		@Override
		public VideoEntertainmentEntity createFromParcel(Parcel source) {
			VideoEntertainmentEntity entivity = new VideoEntertainmentEntity();
			entivity.setAid(source.readString()); ;// "1007177" 
			entivity.setAlbumPC(source.readString());// "22.21亿" 
			entivity.setAlbumTitle(source.readString());// "妖精的尾巴" 
			entivity.setAlbumUrl(source.readString());// "http:\/\/tv.sohu.com\/s2011\/yjdwb\/?lcode=AAAALdEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN_o4CzOJWX0i7xw1TF5aH_A-OWP3_skJ3Q..d4y&lqd=18805" 
			entivity.setArea(source.readString());// "日本" 
			entivity.setBigPic(source.readString());// "http:\/\/i2.itc.cn\/kis\/fengmian\/982\/982821\/982821_ver_big.jpg" 
			entivity.setCid(source.readString());// "115" 
			entivity.setClarity(source.readString());// "21" 
			entivity.setCname(source.readString());// "动漫" 
			entivity.setDesc(source.readString());// "少女露西一直希望能加入云集众多厉害魔法师的名为“妖精尾巴”的公会，在纳兹的引导下，露西终于得偿所愿，随后，露西跟纳兹、格雷、艾尔莎和哈比组成“最强！？”队伍，二男二女一猫的旅程就此展开……\r\n　　原作者真岛浩酷似《海贼王》作者尾田荣一郎的热血清朗画风本身就是很大一个卖点，再加上平野绫，钉宫理惠等强力党声优加盟，不俗的故事情节，难道有打算把该动画打造为《海贼王》第二的野心？好吧，真岛浩老师老师反复强调，人家和尾田荣一郎真是一点关系都没有啊。" 
			entivity.setDt(source.readString());// "石平信司" 
			entivity.setFee(source.readString());// "0" 
			entivity.setHidden(source.readString());// "1" 
			entivity.setHorBigPic(source.readString());// "http:\/\/i2.itc.cn\/20111215\/vrsab_hor1007177.jpg" 
			entivity.setHorSmallPic(source.readString());// "http:\/\/i2.itc.cn\/20111215\/vrsas_hor1007177.jpg" 
			entivity.setId(source.readString());// "2950319" 
			entivity.setIsover(source.readString());// "false" 
			entivity.setmA(source.readString());// "" 
			entivity.setNewcid(source.readString());// "115" 
			entivity.setNowSet(source.readString());// "277" 
			entivity.setPid(source.readString());// "330046174" 
			entivity.setPlaycount(source.readString());// "2221452724" 
			entivity.setSc(source.readString());// "sohu" 
			entivity.setScategory(source.readString());// "" 
			entivity.setScore(source.readString());// 9 
			entivity.setShowtime(source.readString());// "1458972000" 
			entivity.setTip(source.readString());// "更新至277集" 
			entivity.setTitle(source.readString());// "妖精的尾巴" 
			entivity.setTotalSet(source.readString());// "500" 
			entivity.setUrl(source.readString());// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASZEgnOj_WrGgDBIe-FsGcC2PLi3Z7gpoN-h6PtUc7HaJzN3M2h7CrfVccpKuh7Non8aF7AoMLZfbu1SfqLF5Pnx7G9p0tloNS502LVYItWLgd4y&lqd=18805" 
			entivity.setVerBigPic(source.readString());// "http:\/\/i2.itc.cn\/20140404\/vrsab_ver1007177.jpg"
			entivity.setVerSmallPic(source.readString());// "http:\/\/i2.itc.cn\/20140404\/vrsas_ver1007177.jpg" 
			entivity.setVideoTvType(source.readString());// "0" 
			entivity.setVideoUrl(source.readString());// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASUmi6isv3gkF5zeKnIOEV-R1kKhcl3yfWrzQ4g5U2KayTDMuzqrTbJpRYva7iv0OJD6nPxbsgfYhDSANdqJkLHCAaXtaCYRS8FesZ9BroUOKzua&lqd=18805"
			entivity.setVideos(source.readString());//[[domain:"sohu",urls:[{},{}]]]
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
	/**
	 * [[domain:"sohu",urls:[{},{}]]]
	 * @return
	 */
	public String getVideos() {
		return videos;
	}
	/**
	 * [[domain:"sohu",urls:[{},{}]]]
	 * @param videos
	 */
	public void setVideos(String videos) {
		this.videos = videos;
	}

}
