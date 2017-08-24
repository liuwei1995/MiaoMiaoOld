package com.zhaoyao.miaomiao.entity.qq;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class QQLoginEntity implements Parcelable,Serializable{
	private String ret;
	private String openid ;//968F157F064D3CC1EBBEB9BA0F479DA2" 
	private String access_token ;//A706DD5426312A78F8D9180F13EB2C60" 
	private String pay_token ;//2D37BF0E3428230E128F1CFFCB90D8BB" 
	private String expires_in;//":7776000 
	private String pf ;//desktop_m_qq-10000144-android-2002-" 
	private String pfkey ;//49f8e21706e7e4f8946a1c72f11e5a05" 
	private String msg ;//" 
	private String login_cost;//":815 
	private String query_authority_cost;//":598 
	private String authority_cost;//":2767}
	
	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getPay_token() {
		return pay_token;
	}

	public void setPay_token(String pay_token) {
		this.pay_token = pay_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getPfkey() {
		return pfkey;
	}

	public void setPfkey(String pfkey) {
		this.pfkey = pfkey;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLogin_cost() {
		return login_cost;
	}

	public void setLogin_cost(String login_cost) {
		this.login_cost = login_cost;
	}

	public String getQuery_authority_cost() {
		return query_authority_cost;
	}

	public void setQuery_authority_cost(String query_authority_cost) {
		this.query_authority_cost = query_authority_cost;
	}

	public String getAuthority_cost() {
		return authority_cost;
	}

	public void setAuthority_cost(String authority_cost) {
		this.authority_cost = authority_cost;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel source, int flags) {
		source.writeString(access_token);
		source.writeString(authority_cost);
		source.writeString(expires_in);
		source.writeString(login_cost);
		source.writeString(msg);
		source.writeString(openid);
		source.writeString(pay_token);
		source.writeString(pf);
		source.writeString(pfkey);
		source.writeString(query_authority_cost);
		source.writeString(ret);
	}
	public static final Creator<QQLoginEntity> CREATOR = new Creator<QQLoginEntity>() {

		@Override
		public QQLoginEntity[] newArray(int size) {
			return new QQLoginEntity[size];
		}

		@Override
		public QQLoginEntity createFromParcel(Parcel source) {
			QQLoginEntity entivity = new QQLoginEntity();
			entivity.setAccess_token(source.readString());
			entivity.setAuthority_cost(source.readString());
			entivity.setExpires_in(source.readString());
			entivity.setLogin_cost(source.readString());
			entivity.setMsg(source.readString());
			entivity.setOpenid(source.readString());
			entivity.setPay_token(source.readString());
			entivity.setPf(source.readString());
			entivity.setPfkey(source.readString());
			entivity.setQuery_authority_cost(source.readString());
			entivity.setRet(source.readString());
			return entivity;
		}
	};
}
