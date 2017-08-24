package com.zhaoyao.miaomiao.testActivitytest.http;

import com.zhaoyao.miaomiao.entity.showapi.PicModel;
import com.zhaoyao.miaomiao.util.UserJSON;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class JavaHttp {
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
			String pagebean = jsonObject.getString("pagebean");
			jsonObject=new JSONObject(pagebean);
			model = UserJSON.parseEntity(PicModel.class,jsonObject,true);
//			String allPages=jsonObject.getString("allPages");
//			String contentlist=jsonObject.getString("contentlist");
//			JSONArray jsonArray=new JSONArray(contentlist);
//
//			for(int i=0;i<jsonArray.length();i++){
//				JSONObject jObj=jsonArray.getJSONObject(i);
//				id=jObj.getString("id");
//				image=jObj.getString("image3");
//				name=jObj.getString("name");
//				text=jObj.getString("text");
//				create_time=jObj.getString("create_time");
//				if(image.contains(".gif")){
//					PicModel model=new PicModel();
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
	public interface HT{
		void getData(String object);
	}
	public static void httpGet(final String httpUrl,final HT ht) {
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			String object = getData(connection);
			ht.getData(object);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						URL url = new URL(httpUrl);
//						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//						connection.setRequestMethod("GET");
//						String object = getData(connection);
//						ht.getData(object);
//					} catch (MalformedURLException e) {
//						e.printStackTrace();
//					} catch (ProtocolException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}).start();
	}
	public static synchronized void httpPOST(final String httpUrl,final HT ht) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						URL url = new URL(httpUrl);
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setRequestMethod("GET");
						String object = getData(connection);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (ProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
	}
	private static synchronized String getData(final HttpURLConnection connection) {
		String result = null;
		try {
			connection.connect();
			InputStream is = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null; 
			StringBuffer sbf = new StringBuffer();
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
