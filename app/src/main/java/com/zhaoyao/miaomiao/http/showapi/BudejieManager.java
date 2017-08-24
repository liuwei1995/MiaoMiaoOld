package com.zhaoyao.miaomiao.http.showapi;

import android.graphics.Canvas;

import com.alibaba.fastjson.JSON;
import com.zhaoyao.miaomiao.entity.showapi.PicModel;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BudejieManager {

	 /**
     * 记录播放位置
     */
    public static int playPosition=-1;
    
    private static  Canvas canvas;

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void setCanvas(Canvas canvas) {
    	BudejieManager.canvas = canvas;
    }
    
	/**
	 * 获取图片及资源的接口
	 * @param httpUrl
	 * @param page
//	 * @param num
//	 * @param apikey
	 * @return
	 */
	public static PicModel requestLifeHealth(String httpUrl,String page,String type,String showapi_appid,String showapi_sign,String showapi_timestamp) {
//		List<PicModel> listItems=new ArrayList<PicModel>();
		PicModel model = null;
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?page="+page+"&type="+type+"&showapi_appid="+showapi_appid+"&showapi_sign="+showapi_sign+"&showapi_timestamp="+showapi_timestamp;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null; 
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			JSONObject jsonObject=new JSONObject(result);
//			String id;
//			String image;
//			String name;
//			String text;
//			String create_time;
			String showapi_res_body=jsonObject.getString("showapi_res_body");
			jsonObject=new JSONObject(showapi_res_body);
			String pagebean=jsonObject.getString("pagebean");
//			jsonObject=new JSONObject(pagebean);
			 model = JSON.parseObject(pagebean,PicModel.class);
//			String allPages=jsonObject.getString("allPages");
//			String contentlist=jsonObject.getString("contentlist");
//			JSONArray jsonArray=new JSONArray(contentlist);
//
//			for(int i=0;i<jsonArray.length();i++){
//				JSONObject jObj=jsonArray.getJSONObject(i);
////				id=jObj.getString("id");
////				name=jObj.getString("name");
////				text=jObj.getString("text");
////				create_time=jObj.getString("create_time");
////				String image=jObj.getString("image3");
//				PicModel model = UserJSON.parseObject(PicModel.class,jObj,true);
//				if(!TextUtils.isEmpty(model.getImage0()) && model.getImage0().contains(".gif")){
////					model.setId(id);
////					model.setImage(image);
////					model.setName(name);
////					model.setText(text);
////					model.setCreate_time(create_time);
////					model.setAllPages(allPages);
//					listItems.add(model);
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 获取段子的接口
	 * @param httpUrl
	 * @param page
	 * @param type
	 * @param showapi_appid
	 * @param showapi_sign
	 * @param showapi_timestamp
	 * @return
	 */
	public static PicModel requestDuanzi(String httpUrl,String page,String type,String showapi_appid,String showapi_sign,String showapi_timestamp) {
		PicModel model = null;
//		List<PicModel> listItems=new ArrayList<PicModel>();
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?page="+page+"&type="+type+"&showapi_appid="+showapi_appid+"&showapi_sign="+showapi_sign+"&showapi_timestamp="+showapi_timestamp;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null; 
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			JSONObject jsonObject=new JSONObject(result);
			String id;
			String name;
			String text;
			String create_time;
			String showapi_res_body=jsonObject.getString("showapi_res_body");
			jsonObject=new JSONObject(showapi_res_body);
			String pagebean=jsonObject.getString("pagebean");
//			jsonObject=new JSONObject(pagebean);
			model = JSON.parseObject(pagebean,PicModel.class);
//			String allPages=jsonObject.getString("allPages");
//			String contentlist=jsonObject.getString("contentlist");
//			JSONArray jsonArray=new JSONArray(contentlist);
//
//			for(int i=0;i<jsonArray.length();i++){
//				JSONObject jObj=jsonArray.getJSONObject(i);
//				id=jObj.getString("id");
//				name=jObj.getString("name");
//				text=jObj.getString("text");
//				create_time=jObj.getString("create_time");
//				PicModel model=new PicModel();
//				model.setId(id);
//				model.setName(name);
//				model.setText(text);
//				model.setCreate_time(create_time);
//				model.setAllPages(allPages);
//				listItems.add(model);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	/**
	 * 声音的接口
	 * @param httpUrl
	 * @param page
	 * @param type
	 * @param showapi_appid
	 * @param showapi_sign
	 * @param showapi_timestamp
	 * @return
	 */
	public static PicModel requestVoice(String httpUrl,String page,String type,String showapi_appid,String showapi_sign,String showapi_timestamp) {
//		List<PicModel> listItems=new ArrayList<PicModel>();
		PicModel model = null;
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?page="+page+"&type="+type+"&showapi_appid="+showapi_appid+"&showapi_sign="+showapi_sign+"&showapi_timestamp="+showapi_timestamp;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null; 
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			JSONObject jsonObject=new JSONObject(result);
			String id;
			String name;
			String text;
			String create_time;
			String image;
			String voice_uri;
			String showapi_res_body=jsonObject.getString("showapi_res_body");
			jsonObject=new JSONObject(showapi_res_body);
			String pagebean=jsonObject.getString("pagebean");
//			jsonObject=new JSONObject(pagebean);
			model = JSON.parseObject(pagebean,PicModel.class);
//			String allPages=jsonObject.getString("allPages");
//			String contentlist=jsonObject.getString("contentlist");
//			JSONArray jsonArray=new JSONArray(contentlist);
//
//			for(int i=0;i<jsonArray.length();i++){
//				JSONObject jObj=jsonArray.getJSONObject(i);
//				id=jObj.getString("id");
//				name=jObj.getString("name");
//				text=jObj.getString("text");
//				create_time=jObj.getString("create_time");
//				image=jObj.getString("image3");
//				voice_uri=jObj.getString("voice_uri");
//				PicModel model=new PicModel();
//				model.setId(id);
//				model.setName(name);
//				model.setText(text);
//				model.setCreate_time(create_time);
//				model.setAllPages(allPages);
//				model.setImage(image);
//				model.setVoice_uri(voice_uri);
//				listItems.add(model);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 视频
	 * @param httpUrl
	 * @param page
	 * @param type
	 * @param showapi_appid
	 * @param showapi_sign
	 * @param showapi_timestamp
	 * @return
	 */
	public static PicModel requestVideo(String httpUrl,String page,String type,String showapi_appid,String showapi_sign,String showapi_timestamp) {
		PicModel model = null;
//			List<PicModel> listItems=new ArrayList<PicModel>();
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?page="+page+"&type="+type+"&showapi_appid="+showapi_appid+"&showapi_sign="+showapi_sign+"&showapi_timestamp="+showapi_timestamp;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null; 
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			JSONObject jsonObject=new JSONObject(result);
//			String id;
//			String name;
//			String text;
//			String create_time;
//			String image;
//			String video_uri;
			String showapi_res_body=jsonObject.getString("showapi_res_body");
			jsonObject=new JSONObject(showapi_res_body);
			String pagebean=jsonObject.getString("pagebean");
//			jsonObject=new JSONObject(pagebean);
			model = JSON.parseObject(pagebean,PicModel.class);
//			String allPages=jsonObject.getString("allPages");
//			String contentlist=jsonObject.getString("contentlist");
//			JSONArray jsonArray=new JSONArray(contentlist);
//
//			for(int i=0;i<jsonArray.length();i++){
//				JSONObject jObj=jsonArray.getJSONObject(i);
//				id=jObj.getString("id");
//				name=jObj.getString("name");
//				text=jObj.getString("text");
//				create_time=jObj.getString("create_time");
//				image=jObj.getString("image3");
//				video_uri=jObj.getString("video_uri");
//				PicModel model=new PicModel();
//				model.setId(id);
//				model.setName(name);
//				model.setText(text);
//				model.setCreate_time(create_time);
//				model.setAllPages(allPages);
//				model.setImage(image);
//				model.setVideo_uri(video_uri);
//				listItems.add(model);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
