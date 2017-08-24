package com.zhaoyao.miaomiao.http.kugou;

import org.json.JSONObject;

import com.zhaoyao.miaomiao.util.UserJSON;

public class ResultKuGou {
	 private String status;// 1 
	 private String error;// "" 
	 private String errcode;// 0})	
	 private String data;// {"
	 
	public static ResultKuGou paseResult(String s) {
//		if(s.contains("kgJSONP904378219")){
//			s = s.replace("kgJSONP904378219", "");
//			if(s.contains("("))
//				s = s.replace("(", "");
//				if(s.contains(")"))
//					s = s.replace(")", "");
//		}
		JSONObject jsonObject = UserJSON.getJSONObject(s);
		String errcode = UserJSON.getString(jsonObject, "errcode");
		ResultKuGou result = new ResultKuGou();
		result.setErrcode(errcode);
		if(!"0".equals(errcode)){
			String status = UserJSON.getString(jsonObject, "status");
			result.setStatus(status);
			if("1".equals(status)){
				String error = UserJSON.getString(jsonObject, "error");
				result.setError(error);
				if("".equals(error)){
					result.setData(s);
				}
			}
		}
		return result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
