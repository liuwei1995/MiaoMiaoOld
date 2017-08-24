package com.zhaoyao.miaomiao.http;

import org.json.JSONObject;

import com.zhaoyao.miaomiao.util.UserJSON;


public class ResultNeiHanDuanZi {
	private static ResultNeiHanDuanZi getNeiHanDuanZiResult(){
		return new ResultNeiHanDuanZi();
	}
	private String message;
	private boolean has_more;
	private String tip;
	private boolean has_new_message;
	private long max_time;
	private long min_time;
	private String data;
	/**
	 * {"message": "success", "data": {"has_more": true, "tip": "30\u6761\u65b0\u5185\u5bb9", "has_new_message": true, "max_time": 1460085636.0, "min_time": 1460086825, "data": [{"group": {"text": 
	 */
	public static ResultNeiHanDuanZi resultFromString(String s) {
		ResultNeiHanDuanZi result = getNeiHanDuanZiResult();
		JSONObject jsonObject = UserJSON.getJSONObject(s);
		String message = UserJSON.getString(jsonObject, "message");
		result.setMessage(message);
		if("success".equals(message)){
			JSONObject data = UserJSON.getJSONObject(jsonObject,"data");
			String has_more = UserJSON.getString(data, "has_more");
			result.setHas_more(Boolean.parseBoolean(has_more));
			String has_new_message = UserJSON.getString(data, "has_new_message");
			result.setHas_new_message(Boolean.parseBoolean(has_new_message));
			String string = UserJSON.getString(data, "data");
			result.setData(string);
		}
		return result;
	}
	

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isHas_more() {
		return has_more;
	}
	public void setHas_more(boolean has_more) {
		this.has_more = has_more;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public boolean getHas_new_message() {
		return has_new_message;
	}
	public void setHas_new_message(boolean has_new_message) {
		this.has_new_message = has_new_message;
	}
	public long getMax_time() {
		return max_time;
	}
	public void setMax_time(long max_time) {
		this.max_time = max_time;
	}
	public long getMin_time() {
		return min_time;
	}
	public void setMin_time(long min_time) {
		this.min_time = min_time;
	}
	
}
