package com.zhaoyao.miaomiao.entity.qq;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 
 * @author 
 *
 */
public class QQUserEntity implements Parcelable,Serializable{
	
	private String ret ;//0,
	private String msg ;//      ,
	private String is_lost ;//  :0,
	private String nickname ;//   、一梦一失落-\/   ,
	private String gender ;//   男   ,
	private String province ;//   四川   ,
	private String city ;//   成都   ,
	private String year ;//   1995   ,
	private String figureurl ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/30   ,
	private String figureurl_1 ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/50   ,
	private String figureurl_2 ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
	private String figureurl_qq_1 ;//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/40   ,
	private String figureurl_qq_2 ;//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
	private String is_yellow_vip ;//   0   ,
	private String vip ;//   0   ,
	private String yellow_vip_level ;//   0   ,
	private String level ;//   0   ,
	private String is_yellow_year_vip ;//   0  
	
	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIs_lost() {
		return is_lost;
	}

	public void setIs_lost(String is_lost) {
		this.is_lost = is_lost;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFigureurl() {
		return figureurl;
	}

	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}

	public String getFigureurl_1() {
		return figureurl_1;
	}

	public void setFigureurl_1(String figureurl_1) {
		this.figureurl_1 = figureurl_1;
	}

	public String getFigureurl_2() {
		return figureurl_2;
	}

	public void setFigureurl_2(String figureurl_2) {
		this.figureurl_2 = figureurl_2;
	}

	public String getFigureurl_qq_1() {
		return figureurl_qq_1;
	}

	public void setFigureurl_qq_1(String figureurl_qq_1) {
		this.figureurl_qq_1 = figureurl_qq_1;
	}

	public String getFigureurl_qq_2() {
		return figureurl_qq_2;
	}

	public void setFigureurl_qq_2(String figureurl_qq_2) {
		this.figureurl_qq_2 = figureurl_qq_2;
	}

	public String getIs_yellow_vip() {
		return is_yellow_vip;
	}

	public void setIs_yellow_vip(String is_yellow_vip) {
		this.is_yellow_vip = is_yellow_vip;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getYellow_vip_level() {
		return yellow_vip_level;
	}

	public void setYellow_vip_level(String yellow_vip_level) {
		this.yellow_vip_level = yellow_vip_level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIs_yellow_year_vip() {
		return is_yellow_year_vip;
	}

	public void setIs_yellow_year_vip(String is_yellow_year_vip) {
		this.is_yellow_year_vip = is_yellow_year_vip;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(ret);//0,
		dest.writeString(msg);//      ,
		dest.writeString(is_lost);//  :0,
		dest.writeString(nickname);//   、一梦一失落-\/   ,
		dest.writeString(gender);//   男   ,
		dest.writeString(province);//   四川   ,
		dest.writeString(city);//   成都   ,
		dest.writeString(year);//   1995   ,
		dest.writeString(figureurl);//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/30   ,
		dest.writeString(figureurl_1);//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/50   ,
		dest.writeString(figureurl_2);//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
		dest.writeString(figureurl_qq_1);//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/40   ,
		dest.writeString(figureurl_qq_2);//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
		dest.writeString(is_yellow_vip);//   0   ,
		dest.writeString(vip);//   0   ,
		dest.writeString(yellow_vip_level);//   0   ,
		dest.writeString(level);//   0   ,
		dest.writeString(is_yellow_year_vip);//   0  
	}
	public static final Creator<QQUserEntity> CREATOR = new Creator<QQUserEntity>() {

		@Override
		public QQUserEntity[] newArray(int size) {
			return new QQUserEntity[size];
		}

		@Override
		public QQUserEntity createFromParcel(Parcel source) {
			QQUserEntity entityentity = new QQUserEntity();
			entityentity.setRet(source.readString()); ;//0,
			entityentity.setMsg(source.readString()); ;//      ,
			entityentity.setIs_lost(source.readString()); ;//  :0,
			entityentity.setNickname(source.readString()); ;//   、一梦一失落-\/   ,
			entityentity.setGender(source.readString()); ;//   男   ,
			entityentity.setProvince(source.readString()); ;//   四川   ,
			entityentity.setCity(source.readString()); ;//   成都   ,
			entityentity.setYear(source.readString()); ;//   1995   ,
			entityentity.setFigureurl(source.readString()); ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/30   ,
			entityentity.setFigureurl_1(source.readString()); ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/50   ,
			entityentity.setFigureurl_2(source.readString()); ;//   http:\/\/qzapp.qlogo.cn\/qzapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
			entityentity.setFigureurl_qq_1(source.readString()); ;//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/40   ,
			entityentity.setFigureurl_qq_2(source.readString()); ;//   http:\/\/q.qlogo.cn\/qqapp\/1105184875\/968F157F064D3CC1EBBEB9BA0F479DA2\/100   ,
			entityentity.setIs_yellow_vip(source.readString()); ;//   0   ,
			entityentity.setVip(source.readString()); ;//   0   ,
			entityentity.setYellow_vip_level(source.readString()); ;//   0   ,
			entityentity.setLevel(source.readString()); ;//   0   ,
			entityentity.setIs_yellow_year_vip(source.readString()); ;//   0
			return entityentity;
		}
	};
}
