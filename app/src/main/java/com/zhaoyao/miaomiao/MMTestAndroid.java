package com.zhaoyao.miaomiao;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;

import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.entity.neihanduanzi.NeiHanDuanZiRecommendedEntiry;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.ToastUtil;
import com.zhaoyao.miaomiao.util.UserJSON;

public class MMTestAndroid extends AndroidTestCase {
	private static final int ZOO = 0;
	private static final int ONE = 1;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				List<NeiHanDuanZiRecommendedEntiry> list = (List<NeiHanDuanZiRecommendedEntiry>) msg.obj;
				listpositive.clear();
				for (int i = 0; i < list.size(); i++) {
					NeiHanDuanZiRecommendedEntiry entiry = list.get(i);
					String media_type = entiry.getMedia_type();
					if(entiry.getType().equals("3")&&"0".equals(media_type))continue;
					listpositive.add(entiry);
				}
				setlistpositiveAdapter();
				break;
			case ONE:
				ToastUtil.show(mContext, "网络连接失败");
				break;
			default:
				break;
			}
		}
	};
	@Override
	public void testAndroidTestCaseSetupProperly() {
		super.testAndroidTestCaseSetupProperly();
	}
	private Context mContext;
	public List<NeiHanDuanZiRecommendedEntiry> testgetdata(Context mContext) {
		this.mContext = mContext;
		List<NeiHanDuanZiRecommendedEntiry> list = new ArrayList<NeiHanDuanZiRecommendedEntiry>();
		try {
			InputStream is = mContext.getAssets().open("neihanduanzijson.txt");
			 int size = is.available();  
			   // Read the entire asset into a local byte buffer.  
			   byte[] buffer = new byte[size];  
			   is.read(buffer);  
			   is.close();  
			   // Convert the buffer into a string.  
			   String text = new String(buffer, "UTF-8");  
			   JSONObject jsonObject = UserJSON.getJSONObject(text);
//           String text = new String(buffer, "GB2312");  
			   JSONObject data = UserJSON.getJSONObject(jsonObject, "data");
			    JSONArray jsonArray = UserJSON.getJSONArray(data, "data");
			    for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = UserJSON.getJSONObject(jsonArray, i);
					String type = UserJSON.getString(object, "type");
					if(!"1".equals(type))continue;
					JSONObject group = UserJSON.getJSONObject(object, "group");
					NeiHanDuanZiRecommendedEntiry entiry = UserJSON.parseObject(NeiHanDuanZiRecommendedEntiry.class, group);
					list.add(entiry);
				}
//			    list = UserJSON.parsUser(NeiHanDuanZiRecommendedEntiry.class, jsonArray);
			    Message msg = new Message();
			    msg.obj = list;
			    msg.what = ZOO;
			    handler.handleMessage(msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	private List<NeiHanDuanZiRecommendedEntiry> listpositive = new ArrayList<NeiHanDuanZiRecommendedEntiry>();
	public void setlistpositiveAdapter() {
		ListView listView1 = new ListView(this.mContext);
		ZhaoYaoAdapter<NeiHanDuanZiRecommendedEntiry> listMicroFilmAdapter = new ZhaoYaoAdapter<NeiHanDuanZiRecommendedEntiry>(mContext, listpositive,  R.layout.neihanduanzi_jokes_fragment_item) {
			@Override//搞笑囧图2//爆笑GIF//花美男28
			public void convert(ViewHolder helper, NeiHanDuanZiRecommendedEntiry item) {
				String type = item.getType();
				if("3".equals(type)){
					String media_type = item.getMedia_type();
					if("0".equals(media_type)){
//						helper.getView(R.id.iv_neihanduanzi).setVisibility(View.GONE);
//						helper.setText(R.id.tv, item.getContent());
					}else
					if ("1".equals(media_type)) {
						String large_image = item.getLarge_image();
						JSONObject jsonObject = UserJSON.getJSONObject(large_image);
						JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
						String url = "";
						for (int i = 0; i < jsonArray.length(); i++) {
							url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
							break;
						}
//						helper.setImageByUrl(R.id.iv_neihanduanzi, url);
//					helper.setText(R.id.tv, item.getTitle());
					}else if ("2".equals(media_type)) {
						String middle_image = item.getMiddle_image();
						JSONObject jsonObject = UserJSON.getJSONObject(middle_image);
						JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
						String url = "";
						for (int i = 0; i < jsonArray.length(); i++) {
							url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
							break;
						}
//						helper.setImageByUrlGlideUtil(R.id.iv_neihanduanzi, url);
//						helper.setText(R.id.tv, item.getContent());
					}
				}else if ("4".equals(type)) {//url_list":[{"url"
					String media_type = item.getMedia_type();
					if("5".equals(media_type)){
						String large_image = item.getLarge_image();
						JSONObject jsonObject = UserJSON.getJSONObject(large_image);
						JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
						String url = "";
						for (int i = 0; i < jsonArray.length(); i++) {
							url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
							break;
						}
//						helper.setImageByUrlGlideUtil(R.id.iv_neihanduanzi, url);
//						helper.setText(R.id.iv_neihanduanzi, item.getTitle());
					}
				}
				else if ("2".equals(type)) {//搞笑视频65
					String large_cover = item.getLarge_cover();
					JSONObject jsonObject = UserJSON.getJSONObject(large_cover);
					JSONArray url_list = UserJSON.getJSONArray(UserJSON.getString(jsonObject, "url_list"));
					String url = "";
					for (int i = 0; i < url_list.length(); i++) {
						JSONObject json = UserJSON.getJSONObject(url_list, i);
						 url = UserJSON.getString(json, "url");
						if(url!=null&&!TextUtils.isEmpty(url))
						break;
					}
					helper.setImageByUrl(R.id.iv_neihanduanzi, url);
					helper.setText(R.id.iv_neihanduanzi, item.getContent());
				}else if ("5".equals(type)) {//二次元
//					thumb_image_list
//					large_image_list
				}
			}
		};
		listView1.setAdapter(listMicroFilmAdapter);
		ListViewHeightUtil.setListViewHeightBasedOnChildren(listView1);
	};
}
