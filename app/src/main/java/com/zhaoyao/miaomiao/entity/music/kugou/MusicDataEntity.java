package com.zhaoyao.miaomiao.entity.music.kugou;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.zhaoyao.miaomiao.entity.MyParcelable;

/**
 * 酷狗音乐通过  hash 值获得的详情
 * http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash=7112E1FE7CB49A19B83E0E3588470954
 */
public class MusicDataEntity extends MyParcelable {

	 private String privilege;// 0 
	 private String bitRate;// 128 
	 private String extra;// {"320filesize;// 9323907 
	 private String sqfilesize;// 0 
	 private String sqhash;// "" 
	 private String hash128;// "7112e1fe7cb49a19b83e0e3588470954" 
	 private String hash320;// "bff3f886649b2aafbfbcee1a9c297ede" private String 128filesize;// 3729988} 
	 private String status;// 1 
	 private String hash;// "7112E1FE7CB49A19B83E0E3588470954" 
	 private String stype;// 11323 
	 private String errcode;// 0 
	 private String error;// "" 
	 private String fileName;// "孙燕姿 - 在,也不见" 
	 private String fileSize;// 3729988 
	 private String singerHead;// "" 
	 private String url;// "http:\/\/fs.open.kugou.com\/ab1134dc58357b0af40dbe47725efce1\/5707485b\/G057\/M06\/0C\/11\/2YYBAFb-JMiIbnA2AA6qjQjeGTUAABHGAKXy2IADqql303.m4a" 
	 private String extName;// "m4a" 
	 private String ctype;// 1009 
	 private String timeLength;// 233}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}

	public static final Creator<MusicDataEntity> CREATOR = new Creator<MusicDataEntity>() {

		@Override
		public MusicDataEntity[] newArray(int size) {
			return new MusicDataEntity[size];
		}

		@Override
		public MusicDataEntity createFromParcel(Parcel source) {
			MusicDataEntity entivity = new MusicDataEntity();
			return entivity;
		}
	};

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getBitRate() {
		return bitRate;
	}

	public void setBitRate(String bitRate) {
		this.bitRate = bitRate;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getSqfilesize() {
		return sqfilesize;
	}

	public void setSqfilesize(String sqfilesize) {
		this.sqfilesize = sqfilesize;
	}

	public String getSqhash() {
		return sqhash;
	}

	public void setSqhash(String sqhash) {
		this.sqhash = sqhash;
	}

	public String getHash128() {
		return hash128;
	}

	public void setHash128(String hash128) {
		this.hash128 = hash128;
	}

	public String getHash320() {
		return hash320;
	}

	public void setHash320(String hash320) {
		this.hash320 = hash320;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getSingerHead() {
		return singerHead;
	}

	public void setSingerHead(String singerHead) {
		this.singerHead = singerHead;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}

	
}
