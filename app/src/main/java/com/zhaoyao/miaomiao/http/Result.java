package com.zhaoyao.miaomiao.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Result {
	/** 应答状态码 */
	private int res_code;//
	/** 错误消息 */
	private String res_error;//
	
	public int getRes_code() {
		return res_code;
	}

	public void setRes_code(int res_code) {
		this.res_code = res_code;
	}

	public String getRes_error() {
		return res_error;
	}

	public void setRes_error(String res_error) {
		this.res_error = res_error;
	}

	/** JSONObject JSONArray */
	private JSONObject data;//
	private JSONArray Array;//



	public JSONArray getArray() {
		return Array;
	}

	public void setArray(JSONArray array) {
		Array = array;
	}


	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public static Result resultFromJSON(JSONObject json,int type,String key){
		Result result = new Result();
		try {//errNum
			int res_code = 0;
			String res_error = null;
			if(type==1){
				res_error = json.getString("showapi_res_error");
				res_code = json.getInt("showapi_res_code");
			}else if (type==2) {
				res_code = json.getInt("errNum");
				res_error = json.getString("retMsg");
			}
				if (0==res_code) {
					get(json, result, res_code, res_error,key);
				} else {
					result.setRes_code(res_code);
					result.setRes_error(res_error);
				}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
/***
 * 
 * @param json
 * @param result
 * @param res_code
 * @param res_error
 * @param key
 * @throws JSONException
 */
	private static void get(JSONObject json, Result result, int res_code,
			String res_error,String key) throws JSONException {
		String res_body = json.getString(key);
		if (!"null".equals(res_body)&& res_body.trim().length() != 0) {
			CharSequence substring = res_body.subSequence(0, 1);
			result.setRes_code(res_code);
			result.setRes_error(res_error);
			if ("{".equals(substring)) {
				result.setData(new JSONObject(res_body));
			} else if ("[".equals(substring)) {
				result.setArray(new JSONArray(res_body));
			}
		} else {
			result.setRes_code(res_code);
			result.setRes_error(res_error);
			result.setData(null);
		}
	}

}
