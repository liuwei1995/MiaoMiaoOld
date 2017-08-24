package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;
/**
 * 动漫
 * @author liuwei
 *
 */
public class VideoAnimeEntity extends MyParcelable{
	
	 private String aid;// "1007177" 
	 private String albumPC;// "22.21亿" 
	 private String albumTitle;// "妖精的尾巴" 
	 private String albumUrl;// "http:\/\/tv.sohu.com\/s2011\/yjdwb\/?lcode=AAAAL9RYOeT5NrOIi190Q98l4wrq6Blr_F09YB6EYs1ngl8EzHenrqFOXRTM1BaPwI5Az6..xdl&lqd=18805" 
	 private String area;// "日本" 
	 private String bigPic;// "http:\/\/i2.itc.cn\/kis\/fengmian\/982\/982821\/982821_ver_big.jpg" 
	 private String cid;// "115" 
	 private String clarity;// "21" 
	 private String cname;// "动漫" 
	 private String desc;// "少女露西一直希望能加入云集众多厉害魔法师的名为“妖精尾巴”的公会，在纳兹的引导下，露西终于得偿所愿，随后，露西跟纳兹、格雷、艾尔莎和哈比组成“最强！？”队伍，二男二女一猫的旅程就此展开……\r\n　　原作者真岛浩酷似《海贼王》作者尾田荣一郎的热血清朗画风本身就是很大一个卖点，再加上平野绫，钉宫理惠等强力党声优加盟，不俗的故事情节，难道有打算把该动画打造为《海贼王》第二的野心？好吧，真岛浩老师老师反复强调，人家和尾田荣一郎真是一点关系都没有啊。" 
	 private String dt;// "石平信司" 
	 private String fee;// "0" 
	 private String hidden;// "1" 
	 private String horBigPic;// "http:\/\/i2.itc.cn\/20111215\/vrsab_hor1007177.jpg" 
	 private String horSmallPic;// "http:\/\/i2.itc.cn\/20111215\/vrsas_hor1007177.jpg" 
	 private String id;// "2950319" 
	 private String isover;// "false" 
	 private String mA;// "" 
	 private String newcid;// "115" 
	 private String nowSet;// "277" 
	 private String pid;// "330046174" 
	 private String playcount;// "2221497557" 
	 private String sc;// "sohu" 
	 private String scategory;// "" 
	 private String score;// 9 
	 private String showtime;// "1458972000" 
	 private String tip;// "更新至277集" 
	 private String title;// "妖精的尾巴" 
	 private String totalSet;// "500" 
	 private String url;// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASTRYOeT5NrOIi190Q98l4wrq6Blr_F09YNrixrao9xRy6fDwpbu5BBanCsTOeyvA1cNe0FGW0YQkqhAEWYiWUxmpWUmZzuu9QEzax36tkb3jxdl&lqd=18805" 
	 private String verBigPic;// "http:\/\/i2.itc.cn\/20140404\/vrsab_ver1007177.jpg" 
	 private String verSmallPic;// "http:\/\/i2.itc.cn\/20140404\/vrsas_ver1007177.jpg" 
	 private String videoTvType;// "0" 
	 private String videoUrl;// "http:\/\/tv.sohu.com\/20160326\/n442206707.shtml?lcode=AAAASUmi6isv3gkF5zeKnIOEV-R1kKhcl3yfWrzQ4g5U2KayTDMuzqrTbJpRYva7iv0OJD6nPxbsgfYhDSANdqJkLHCAaXtaCYRS8FesZ9BroUOKzua&lqd=18805" 
	 private String videos;// [{"domain;// "sohu" private String urls;// [{"aid;// "1007177" private String length;// "1464" private String name;// "1" private String no;// "1" private String pubtime;// "2011-12-23" private String url;// "http:\/\/tv.sohu.com\/20111223\/n330048227.shtml?lcode=AAAASEmi6isv3gkF5zeKnIOEV-R1kKhcl3yfWqW6bSla7N-SRlwx_fZc-QyOBahMzq7xkmFqBweFdEzl5gSIGH7J2xDdQc4UunH5Jk..zua&lqd=18805" private String vid;// "517980" private String videoPic;// ""},

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(aid);//                [整型]      专辑ID
	    dest.writeString(albumPC);//            [字符串]    专辑播放数
	    dest.writeString(albumTitle);//         [字符串]    专辑标题
	    dest.writeString(albumUrl);//           [字符串]    专辑地址
	    dest.writeString(area);//               [字符串]    专辑所属区域
	    dest.writeString(bigPic);//             [字符串]    专辑封面图
	    dest.writeString(cid);// 100                [整型]      专辑分类
	    dest.writeString(clarity);//            [整型]      视频质量1：高清21：超清
	    dest.writeString(cname);//              [字符串]    分类名称
	    dest.writeString(dt);//                      [字符串]    导演
	    dest.writeString(fee);//
	    dest.writeString(hidden);//
	    dest.writeString(horBigPic);//          [字符串]    横大图
	    dest.writeString(horSmallPic);//        [字符串]    横小图
	    dest.writeString(id);//                 [整型]      视频ID
	    dest.writeString(isover);//             [整型]      完结标识 1：完结
	    dest.writeString(mA);//                 [字符串]    主演
	    dest.writeString(newcid);//                 
	    dest.writeString(nowSet);//             [整型]      当前集数
	   	dest.writeString( pid);//                [字符串]    PID
	    dest.writeString(playcount);// "0",
	    dest.writeString(sc);// "",
	    dest.writeString(scategory);
	    dest.writeString(score);//              [浮点型]    打分
	    dest.writeString(showtime);//           [整型]      更新时间
	    dest.writeString(tip);//                [字符串]    tip
	   	dest.writeString( title);//              [字符串]    标题
	    dest.writeString(totalSet);//           [整型]      总集数
	    dest.writeString(url);//                    
	    dest.writeString(verBigPic);//          [字符串]    封面图
	    dest.writeString(verSmallPic);// "",
	   	dest.writeString(videoTvType);// 0,
	    dest.writeString(videoUrl);// "",
	    dest.writeString(desc);//          [字符串]    简介
	    dest.writeString(videos);
	}

	public static final Creator<VideoAnimeEntity> CREATOR = new Creator<VideoAnimeEntity>() {

		@Override
		public VideoAnimeEntity[] newArray(int size) {
			return new VideoAnimeEntity[size];
		}

		@Override
		public VideoAnimeEntity createFromParcel(Parcel source) {
			VideoAnimeEntity entivity = new VideoAnimeEntity();
			entivity.setAid(source.readString());//                 [整型]      专辑ID
		    entivity.setAlbumPC(source.readString());//              [字符串]    专辑播放数
		    entivity.setAlbumTitle(source.readString());//           [字符串]    专辑标题
		    entivity.setAlbumUrl(source.readString());//             [字符串]    专辑地址
		    entivity.setArea(source.readString());//                 [字符串]    专辑所属区域
		    entivity.setBigPic(source.readString());//               [字符串]    专辑封面图
		    entivity.setCid(source.readString());//   100                [整型]      专辑分类
		    entivity.setClarity(source.readString());//              [整型]      视频质量1：高清21：超清
		    entivity.setCname(source.readString());//                [字符串]    分类名称
		    entivity.setDt(source.readString());//                        [字符串]    导演
		    entivity.setFee(source.readString());//  
		    entivity.setHidden(source.readString());//  
		    entivity.setHorBigPic(source.readString());//            [字符串]    横大图
		    entivity.setHorSmallPic(source.readString());//          [字符串]    横小图
		    entivity.setId(source.readString());//                   [整型]      视频ID
		    entivity.setIsover(source.readString());//               [整型]      完结标识 1：完结
		    entivity.setmA(source.readString());//                   [字符串]    主演
		    entivity.setNewcid(source.readString());//                   
		    entivity.setNowSet(source.readString());//               [整型]      当前集数
		   	entivity.setPid(source.readString());//                  [字符串]    PID
		    entivity.setPlaycount(source.readString());//   "0",
		    entivity.setSc(source.readString());//   "",
		    entivity.setScategory(source.readString());
		    entivity.setScore(source.readString());//                [浮点型]    打分
		    entivity.setShowtime(source.readString());//             [整型]      更新时间
		    entivity.setTip(source.readString());//                  [字符串]    tip
		   	entivity.setTitle(source.readString());//                [字符串]    标题
		    entivity.setTotalSet(source.readString());//             [整型]      总集数
		    entivity.setUrl(source.readString());//                      
		    entivity.setVerBigPic(source.readString());//            [字符串]    封面图
			entivity.setVerSmallPic(source.readString());//   "",
		   	entivity.setVideoTvType(source.readString());//   0,
		    entivity.setVideoUrl(source.readString());//   "",
		    entivity.setDesc(source.readString());//            [字符串]    简介
		    entivity.setVideos(source.readString());
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

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	
}
