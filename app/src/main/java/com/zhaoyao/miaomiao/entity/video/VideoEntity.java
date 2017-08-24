package com.zhaoyao.miaomiao.entity.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;
/**
 * c:                          [整型]      视频总数 
r:                          [数组]      结果列表
[{
private String aid ;//              [整型]      专辑ID
private String albumPC ;//          [字符串]    专辑播放数
private String albumTitle ;//       [字符串]    专辑标题
private String albumUrl ;//         [字符串]    专辑地址
private String area ;//             [字符串]    专辑所属区域
private String bigPic ;//           [字符串]    专辑封面图
private String cid: 100                [整型]      专辑分类
private String clarity ;//          [整型]      视频质量1：高清21：超清
private String cname ;//            [字符串]    分类名称
private String dt;//                      [字符串]    导演
private String fee;//
private String hidden;//
private String horBigPic ;//        [字符串]    横大图
private String horSmallPic ;//      [字符串]    横小图
private String id ;//               [整型]      视频ID
private String isover ;//           [整型]      完结标识 1：完结
private String mA ;//               [字符串]    主演
private String newcid ;//               
private String nowSet ;//           [整型]      当前集数
	private String  pid ;//              [字符串]    PID
private String playcount: "0",
private String sc: "",
private String score ;//            [浮点型]    打分
private String showtime ;//         [整型]      更新时间
private String tip ;//              [字符串]    tip
	private String  title ;//            [字符串]    标题
private String totalSet ;//         [整型]      总集数
private String url ;//                  
private String verBigPic ;//        [字符串]    封面图
private String verSmallPic;// "",
	private String videoTvType;// 0,
private String videoUrl;// "",
private String desc ;//        [字符串]    简介
videos: 
[{
    domain: "sohu",
    urls: 
    [{
        no:  [整型]  集数序号
        pubtime: [字符串] 发布时间						            						        	
        url: [字符串] 播放地址
        vid: [整型]   视频ID
    }]
}],
year: "1992"
}]  
 */
public class VideoEntity extends MyParcelable{
	private String aid ;//              [整型]      专辑ID
    private String albumPC ;//          [字符串]    专辑播放数
    private String albumTitle ;//       [字符串]    专辑标题
    private String albumUrl ;//         [字符串]    专辑地址
    private String area ;//             [字符串]    专辑所属区域
    private String bigPic ;//           [字符串]    专辑封面图
    private String cid;// 100                [整型]      专辑分类
    private String clarity ;//          [整型]      视频质量1：高清21：超清
    private String cname ;//            [字符串]    分类名称
    private String dt;//                      [字符串]    导演
    private String fee;//
    private String hidden;//
    private String horBigPic ;//        [字符串]    横大图
    private String horSmallPic ;//      [字符串]    横小图
    private String id ;//               [整型]      视频ID
    private String isover ;//           [整型]      完结标识 1：完结
    private String mA ;//               [字符串]    主演
    private String newcid ;//               
    private String nowSet ;//           [整型]      当前集数
   	private String  pid ;//              [字符串]    PID
    private String playcount;// "0",
    private String sc;// "",
    private String score ;//            [浮点型]    打分
    private String showtime ;//         [整型]      更新时间
    private String tip ;//              [字符串]    tip
   	private String  title ;//            [字符串]    标题
    private String totalSet ;//         [整型]      总集数
    private String url ;//                  
    private String verBigPic ;//        [字符串]    封面图
    private String verSmallPic;// "",
   	private String videoTvType;// 0,
    private String videoUrl;// "",
    private String desc ;//        [字符串]    简介
    private String videos;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

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

	public static final Creator<VideoEntity> CREATOR = new Creator<VideoEntity>() {

		@Override
		public VideoEntity[] newArray(int size) {
			return new VideoEntity[size];
		}

		@Override
		public VideoEntity createFromParcel(Parcel source) {
			VideoEntity entivity = new VideoEntity();
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
}
