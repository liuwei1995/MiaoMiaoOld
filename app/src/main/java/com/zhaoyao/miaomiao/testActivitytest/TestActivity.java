package com.zhaoyao.miaomiao.testActivitytest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.zhaoyao.miaomiao.AppManager;
import com.zhaoyao.miaomiao.MainActivity;
import com.zhaoyao.miaomiao.MyTextView;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class TestActivity extends Activity {
	@ViewInject(id = R.id.button1)
	private Button button1;
	@ViewInject(id = R.id.button2)
	private Button button2;
	@ViewInject(id = R.id.imageView1)
	private ImageView imageView1;
	@ViewInject(id = R.id.textView1)
	private TextView textView1;
	@ViewInject(id = R.id.iv0)
	private ImageView iv0;
	@ViewInject(id = R.id.iv1)
	private ImageView iv1;
	@ViewInject(id = R.id.iv2)
	private ImageView iv2;
	@ViewInject(id = R.id.iv3)
	private ImageView iv3;
	@ViewInject(id = R.id.iv4)
	private ImageView iv4;
	@ViewInject(id = R.id.slidingDrawer1)
	private SlidingDrawer mDrawer;
	private MyTextView[] textView;
	private MainActivity m;
	private zidingyidonghua getinstain;
	private boolean is = false;
	List<ImageView> mimageviews = new ArrayList<ImageView>();
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
		if(savedInstanceState!=null){
			Looper mainLooper = Looper.getMainLooper();
			mainLooper.getClass();
			textView = (MyTextView[]) savedInstanceState.getSerializable("textView");
			System.out.println(textView.toString());
		}else {
			 textView = 
					 new MyTextView[]{
					 new MyTextView(this),
					 new MyTextView(this),
					 new MyTextView(this)
					 
			 };
		}
		getinstain = zidingyidonghua.getinstain();
//		for (int i = 0; i < 5; i++) {
//			ImageView imageView = new ImageView(this);
//			imageView.setImageResource(R.drawable.search_common_clear);
//			mimageviews.add(imageView);
//		}
		setContentView(R.layout.test);
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			setTranslucentStatus(true);
//		}
		InjectView.Inject(this);
		mimageviews.add(iv0);
		mimageviews.add(iv1);
		mimageviews.add(iv2);
		mimageviews.add(iv3);
		mimageviews.add(iv4);
//		button1.setText("TestActivity");
		iv0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(TestActivity.this,TestActivity1.class);
//				startActivityForResult(intent, 10);
//				finish();
				if(is){
					is = false;
					getinstain.closeAnim(mimageviews);
				}else {
					is = true;
					getinstain.startAnim(mimageviews);
				}
			}
		});
//		 mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener()
//		  {
//		   @Override
//		   public void onDrawerOpened() {
//			   
//		   }
//		   
//		  });
//		  
//		  mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener(){
//
//		   @Override
//		   public void onDrawerClosed() {
//		    
//		   }
//		   
//		  });
//		  
//		  mDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener(){
//
//		   @Override
//		   public void onScrollEnded() {
//		   }
//
//		   @Override
//		   public void onScrollStarted() {
//		   }
//		   
//		  });

		 
//		 }
//		 // 创建状态栏的管理实例  
//	    SystemBarTintManager tintManager = new SystemBarTintManager(this);  
//	    // 激活状态栏设置  
//	    tintManager.setStatusBarTintEnabled(true);  
////	    // 激活导航栏设置  
//	    tintManager.setNavigationBarTintEnabled(true);  
//	    
//		tintManager.setStatusBarTintResource(R.color.text_color_red);
	    
		// set a custom tint color for all system bars
//		tintManager.setTintColor(Color.parseColor("#99000FF"));
//		// set a custom navigation bar resource
//		tintManager.setNavigationBarTintResource(R.drawable.ic_play);
//		// set a custom status bar drawable
//		tintManager.setStatusBarTintDrawable(getResources().getDrawable(R.drawable.touxiang));
	    
//		MMLocation location = MMLocation.getMMLocation();
//		location.getLocation(this);
		
//		button1.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				AsyncHttpClient client = HttpClientUtils.getClient();
//				RequestParams params = UserRequest.getRequestParams();
//				/**
//				 * {"appid":"1005","clientver":"8000",
//				 * "mid":"152256398184752772413892713250964961118","
//				 * clienttime":"1460099600000",
//				 * "key":"baeaa751434fd6122a235e279d94ecab",
//				 * "rcmdsongcount":1}
//				 */
//				params.put("appid", "1005");
//				params.put("clientver", "8000");
//				params.put("mid", "152256398184752772413892713250964961118");
//				params.put("clienttime", "1460099600000");
//				params.put("key", "baeaa751434fd6122a235e279d94ecab");
//				params.put("rcmdsongcount", "1");
//				client.post("http://fm.service.kugou.com/v1/rcmd_list", params,new AsyncHttpResponseHandler() {
//					@Override
//					public void onSuccess(int arg0, Header[] arg1, byte[] b) {
//						String s = new String(b);
//						System.out.println(s);
//					}
//					
//					@Override
//					public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
//						
//					}
//				});
//			}
//		});
//		button2.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				AsyncHttpClient client = HttpClientUtils.getClient();
//				RequestParams params = UserRequest.getRequestParams();
//				/**
//				 * {"appid":"1005","clientver":"8000",
//				 * "mid":"152256398184752772413892713250964961118",
//				 * "clienttime":"1460099600","
//				 * key":"00b0d405a336a4640fe99003e77b3574",
//				 * "platform":"android"}
//				 */
//				params.put("appid", "1005");
//				params.put("clientver", "8000");
//				params.put("mid", "152256398184752772413892713250964961118");
//				params.put("clienttime", "1460099600");
//				params.put("key", "00b0d405a336a4640fe99003e77b3574");
//				params.put("platform", "android");
//				client.post("http://fm.service.kugou.com/v1/rcmd_list", params,new AsyncHttpResponseHandler() {
//					@Override
//					public void onSuccess(int arg0, Header[] arg1, byte[] b) {
//						String s = new String(b);
//						System.out.println(s);
//					}
//					
//					@Override
//					public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
//						
//					}
//				});
//			}
//		});
//		button1.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
////				get();
//				String code = Code.getInstance().getCode();
//				if(code==null||"".equals(code)){
//					textView1.setVisibility(View.GONE);
//					return;
//				}
//				textView1.setVisibility(View.VISIBLE);
//				textView1.setText(code);
//			}
//		});
//		button2.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
////				get();
//				textView1.setVisibility(View.GONE);
//				int height = imageView1.getHeight();
//				int width = imageView1.getWidth();
//				Bitmap bitmap = Code.getInstance().createBitmap(width, height);
//				Drawable drawable =new BitmapDrawable(getResources(),bitmap);
//				imageView1.setBackground(drawable);
//			}
//		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	@Override
	protected void onStop() {
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	@SuppressLint("NewApi")
	@Override
	public void onSaveInstanceState(Bundle outState,
			PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
		outState.putSerializable("textView", textView);
	}
	@SuppressLint("NewApi")
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		textView = (MyTextView[]) savedInstanceState.getSerializable("textView");
		System.out.println(textView.toString());
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable("textView", textView);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		textView = (MyTextView[]) savedInstanceState.getSerializable("textView");
		System.out.println(textView.toString());
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	public void get() {
		 try {
				InputStream is = getAssets().open("neihanduanzijson.txt");
				 int size = is.available();  
		            // Read the entire asset into a local byte buffer.  
		            byte[] buffer = new byte[size];  
		            is.read(buffer);  
		            is.close();  
		            
		            // Convert the buffer into a string.  
		            String text = new String(buffer, "UTF-8");  
		            JSONObject jsonObject = UserJSON.getJSONObject(text);
//		            String text = new String(buffer, "GB2312");  
		            JSONObject data = UserJSON.getJSONObject(jsonObject, "data");
		            JSONArray jsonArray = UserJSON.getJSONArray(data, "data");
		            Map<Object, Object> map = new HashMap<Object, Object>();
		            for (int i = 0; i < jsonArray.length(); i++) {
		            	List<Object> list = new ArrayList<Object>();
						JSONObject object = UserJSON.getJSONObject(jsonArray, i);
						String datatype = UserJSON.getString(object, "type");
						JSONObject group = UserJSON.getJSONObject(object, "group");
						if("1".equals(datatype)){
							String type = UserJSON.getString(group, "type");
							if("1".equals(type)){
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
							}
							else if ("2".equals(type)) {
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
								if("3".equals(media_type)){
//									category_name : "搞笑视频"
//mp4_url : "http://i.snssdk.com/neihan/video/playback/?video_id=650fc836010648faab468a434b362590&quality=480p&line=0&is_gif=0.mp4"									
									if(group.has("medium_cover"))
										group.remove("medium_cover");
//									medium_cover->url_list[{url}]图片地址
									if(group.has("large_cover"))
										group.remove("large_cover");
//									large_cover->url_list[{url}]大图片地址
									if(group.has("origin_video"))
										group.remove("origin_video");
//									origin_video->url_list[{url}]播放地址
									if(group.has("dislike_reason"))
										group.remove("dislike_reason");
									if(group.has("user"))
										group.remove("user");
									if(group.has("720p_video"))
										group.remove("720p_video");
									if(group.has("480p_video"))
										group.remove("480p_video");
									if(group.has("360p_video"))
										group.remove("360p_video");
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									list.add(group);
									MMLog.i(list.toString());
								}else if ("0".equals(media_type)) {
//									content : "有人喜欢日本姑娘吗"
//									category_name : "突然觉得哪里不对"
									if(group.has("dislike_reason"))
										group.remove("dislike_reason");
									if(group.has("large_image"))
										group.remove("large_image");
//									large_image{url_list[{url:}]}
									if(group.has("activity"))
										group.remove("activity");
									if(group.has("user"))
										group.remove("user");
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									if(group.has("middle_image"))
										group.remove("middle_image");
//									middle_image{url_list[{url:}]}
									list.add(group);
									MMLog.i(group);
									
								}else {
									MMLog.i(media_type);
								}
							}
							else if ("3".equals(type)) {
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
								if("0".equals(media_type)){
//									category_name : "内涵段子"
//									content  text 
//									user{}
									if(group.has("dislike_reason"))
									group.remove("dislike_reason");
									if(group.has("activity"))
										group.remove("activity");
									if(group.has("user"))
										group.remove("user");
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									list.add(group);
									MMLog.i(list.toString());
								}else if ("1".equals(media_type)) {
//									text null
//									status_desc : "热门投稿"
//									category_name : "突然觉得哪里不对"
									if(group.has("middle_image"))
										group.remove("middle_image");
//									middle_image{url_list[{url:}]}
									if(group.has("large_image"))
										group.remove("large_image");
//									large_image{url_list[{url:}]}
//									text : "如果说最让男性羡慕的工作，那无疑就是它。你天赋够长吗？#飞碟说#如何成为AV男优"
//									title : "如果说最让男性羡慕的工作，那无疑就是它。你天赋够长吗？#飞碟说#如何成为AV男优"
//									content : "如果说最让男性羡慕的工作，那无疑就是它。你天赋够长吗？#飞碟说#如何成为AV男优"
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									if(group.has("dislike_reason"))
										group.remove("dislike_reason");
									if(group.has("activity"))
										group.remove("activity");
									if(group.has("user"))
										group.remove("user");
									list.add(group);
									MMLog.i(list.toString());
								}
								else if ("2".equals(media_type)) {
//									category_name : "爆笑GIF"
									if(group.has("dislike_reason"))
										group.remove("dislike_reason");
									if(group.has("large_image"))
										group.remove("large_image");
									if(group.has("activity"))
										group.remove("activity");
									if(group.has("user"))
										group.remove("user");
									if(group.has("gifvideo"))
										group.remove("gifvideo");
//									gifvideo->mp4_url 
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									if(group.has("middle_image"))
										group.remove("middle_image");
//									middle_image{url_list[{url:}]}
									list.add(group);
									MMLog.i(list.toString());
								}else {
									MMLog.i(media_type);
								}
							}
							else if ("4".equals(type)) {
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
								if("5".equals(media_type)){
									if(group.has("large_image"))
										group.remove("large_image");
									if(group.has("middle_image"))
										group.remove("middle_image");
									if(group.has("thumb_list"))
										group.remove("thumb_list");
//									middle_image{url_list[{url:}]}
									list.add(group);
									MMLog.i(list.toString());
//									large_image{url_list[url:]}
//									middle_image{url_list[url:]}
//									thumb_list[{url_list[{url:}]},{}]
//									title : "每日逗比视频：你猜我是谁家的啊！"
//									online_time : 1460204305
//									group_id : 6271509778439079000
//									min_screen_width_percent : 0.167
								}else {
									MMLog.i(media_type);
								}
							}else if ("5".equals(type)) {
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
								if("4".equals(media_type)){
//									category_name : "二次元"
									if(group.has("large_image_list"))
										group.remove("large_image_list");
//									large_image_list[{url:},{}]
//									url : "http://p1.pstatp.com/large/32e000525134cd92424.webp"
									if(group.has("activity"))
										group.remove("activity");
									if(group.has("dislike_reason"))
										group.remove("dislike_reason");
									if(group.has("user"))
										group.remove("user");
									if(group.has("neihan_hot_link"))
										group.remove("neihan_hot_link");
									if(group.has("thumb_image_list"))
										group.remove("thumb_image_list");
//									thumb_image_list[{url:},{}]
//									url : "http://p1.pstatp.com/large/32e000525134cd92424.webp"
									MMLog.i(group);
								}else {
									MMLog.i(media_type);
								}
							}else {
								String media_type = UserJSON.getString(group, "media_type");
								MMLog.i(media_type);
							}
						}else {
							MMLog.i("");
						}
//						list.add("datatype : "+datatype);
//						String group_type = UserJSON.getString(group, "type");
//						list.add("group_type : "+group_type);
//						String group_media_type = UserJSON.getString(group, "media_type");
//						list.add("media_type : "+group_media_type);
//						String group_label = UserJSON.getString(group, "label");
//						list.add("group_label : "+group_label);
//						if("0".equals(group_media_type)){
//							
//						}
//						else if ("1".equals(group_media_type)) {
//							
//						}
//						else if ("2".equals(group_media_type)) {
//							
//						}
//						else if ("3".equals(group_media_type)) {
//							String mp4_url = UserJSON.getString(group, "mp4_url");
//							String category_name = UserJSON.getString(group, "category_name");
//							list.add("category_name : "+category_name);
//							list.add("mp4_url : "+mp4_url);
//							String title = UserJSON.getString(group, "title");
//							list.add("title : "+title);
//							String content  = UserJSON.getString(group, "content");
//							list.add("content : "+content);
//							JSONArray medium_cover = UserJSON.getJSONArray(group, "medium_cover");
//							for (int j = 0; j < medium_cover.length(); j++) {
//								
//								break;
//							}
//							list.add("");
//						}
//						else if ("4".equals(group_media_type)) {
//							
//						}
//						list.add("group_media_type : "+group_media_type);
//		            	media_type
		            }
//		            for (int i = 0; i < jsonArray.length(); i++) {
//		            	List<Object> list = new ArrayList<Object>();
//						JSONObject object = UserJSON.getJSONObject(jsonArray, i);
//						String datatype = UserJSON.getString(object, "type");
//						list.add("datatype : "+datatype);
//						if("1".equals(datatype)){
//							JSONArray comments = UserJSON.getJSONArray(object, "comments");
//							MMLog.i("comments======"+comments);
//							JSONObject group = UserJSON.getJSONObject(object, "group");
//							String group_media_type = UserJSON.getString(group, "media_type");
//							list.add("group_media_type : "+group_media_type);
//							String group_share_type  = UserJSON.getString(group, "share_type");
//							list.add("group_share_type : "+group_share_type);
//							String group_category_type  = UserJSON.getString(group, "category_type");
//							list.add("group_category_type : "+group_category_type);
//							String group_label  = UserJSON.getString(group, "label");
//							list.add("group_label : "+group_label);
//							String group_type = UserJSON.getString(group, "type");
//							list.add("group_type : "+group_type);
//							String group_category_name = UserJSON.getString(group, "category_name");
//							list.add("group_category_name : "+group_category_name);
//							JSONObject large_image = UserJSON.getJSONObject(group, "large_image");
//							String group_is_gif  = UserJSON.getString(group, "is_gif");
//							list.add("group_is_gif : "+group_is_gif);
//							JSONObject origin_video = UserJSON.getJSONObject(group, "gifvideo");
//							String mp4_url = UserJSON.getString(origin_video, "mp4_url");
//							list.add("group_gifvideo_mp4_url : "+mp4_url);
//							
//							JSONArray url_list = UserJSON.getJSONArray(large_image, "url_list");
//							for (int j = 0; j < url_list.length(); j++) {
//								String url_list_url = UserJSON.getString(UserJSON.getJSONObject(url_list, j), "url");
//								list.add("large_image->url_list->url : "+url_list_url);
//								break;
//							}
//							String grouptitle = UserJSON.getString(group, "title");
//							list.add("grouptitle : "+grouptitle);
//							JSONArray thumb_list = UserJSON.getJSONArray(group, "thumb_list");
//							for (int j = 0; j < thumb_list.length(); j++) {
//								String url = UserJSON.getString(UserJSON.getJSONObject(thumb_list, j), "url");
//								list.add("thumb_list->url_list->url : "+url);
//								break;
//							}
//							JSONObject middle_image = UserJSON.getJSONObject(group, "middle_image");
//							JSONArray middle_image_url_list = UserJSON.getJSONArray(middle_image, "url_list");
//							for (int j = 0; j < middle_image_url_list.length(); j++) {
//								String url = UserJSON.getString(UserJSON.getJSONObject(middle_image_url_list, j), "url");
//								list.add("middle_image->url_list->url : "+url);
//								break;
//							}
//							JSONObject group_activity = UserJSON.getJSONObject(group, "activity");
//							list.add("group_activity : "+group_activity);
//							JSONObject group_user = UserJSON.getJSONObject(group, "user");
//							list.add("group_user : "+group_user);
//							JSONObject group_neihan_hot_link = UserJSON.getJSONObject(group, "neihan_hot_link");
//							list.add("group_neihan_hot_link : "+group_neihan_hot_link);
//							System.out.println(list.toString());
//							
//							
//						}else {
//							MMLog.i("===========================");
//						}
//					}
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}
	public void add() {
		
	}
	public Object add(int i, int j) {
		return this;
	}
	@TargetApi(19) 
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
}
