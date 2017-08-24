package com.zhaoyao.miaomiao.activity.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.controller.SouHuVideoSearchController;
import com.zhaoyao.miaomiao.entity.video.souhu.VideoSearchEntity;
import com.zhaoyao.miaomiao.helper.PlayVideoHelper;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

public class VideoSearchActivity extends Activity implements TextWatcher,OnTouchListener,OnItemClickListener{
	@ViewInject(id = R.id.tv_video_search_activity_main_search,click = "doClick")
	private TextView tv_video_search_activity_main_search;
	@ViewInject(id = R.id.et_video_activity_main)
	private EditText et_video_activity_main;
	@ViewInject(id = R.id.pb_video_search_activity_main_search)
	private ProgressBar pb_video_search_activity_main_search;
	@ViewInject(id = R.id.lv_video_search_activity_main_search)
	private ListView lv_video_search_activity_main_search;
	private String et_text;
	private SouHuVideoSearchController instance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.video_search_activity_main);
		InjectView.Inject(this);
		lv_video_search_activity_main_search.setOnItemClickListener(this);
		lv_video_search_activity_main_search.setOnTouchListener(this);
		et_video_activity_main.addTextChangedListener(this);
		instance = SouHuVideoSearchController.getInstance();
//		setOnEditorActionListener();
	}
	private int page_size= 30;
	private int page = 1;
	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.tv_video_search_activity_main_search:
			String trim = et_video_activity_main.getText().toString().trim();
			if(TextUtils.isEmpty(trim))return;
			if(trim.equals(et_text))return;
			et_text = trim;
			if(instance.getMap().containsKey(trim)){
				Map<String, List<VideoSearchEntity>> map = instance.getMap();
				List<VideoSearchEntity> listeEntities = map.get(trim);
				list.clear();
				for (int i = 0; i < listeEntities.size(); i++) {
					list.add(listeEntities.get(i));
				}
				adapter.notifyDataSetChanged();
			}else {
				getData(et_text, page_size, page);
			}
//			pb_video_search_activity_main_search.setVisibility(View.VISIBLE);
//			tv_video_search_activity_main_search.setVisibility(View.GONE);
//			new Handler().postDelayed(new Runnable() {
//				@Override
//				public void run() {
//					pb_video_search_activity_main_search.setVisibility(View.GONE);
//					tv_video_search_activity_main_search.setVisibility(View.VISIBLE);
//				}
//			}, 5000);
			break;
//		case R.id.et_video_activity_main:
//			softIsActive();
//			//隐藏软键盘
//			// imm.hideSoftInputFromWindow(editView.getWindowToken(), 0);
//			//显示软键盘
//			// imm.showSoftInputFromInputMethod(editView.getWindowToken(), 0);
//			break;
		default:
			break;
		}
	}
	private boolean IsActive = false;
	/**
	 * 软键盘是否打开
	 * @return  若返回true，则表示输入法打开 
	 */
//	private void softIsActive(){
//		et_video_activity_main.setFocusable(true);
//		et_video_activity_main.requestFocus();
//		InputMethodManager immm = (InputMethodManager) et_video_activity_main.getContext().getSystemService(INPUT_METHOD_SERVICE);   
//		immm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS); 
////		WindowManager.LayoutParams params = getWindow().getAttributes();
////        if (params.softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) {
////            // 隐藏软键盘
////            getWindow().setSoftInputMode(
////                    WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
////            params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN;
////            params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
////        }
////        InputMethodManager m = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
////        m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//        
////        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);     
////        imm.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
////		et_video_activity_main.requestFocus();
////        InputMethodManager immm = (InputMethodManager) et_video_activity_main.getContext().getSystemService(INPUT_METHOD_SERVICE);   
////        immm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS); 
////		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);  
////		boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开 
////		
////		if(!isOpen){
////			imm.showSoftInputFromInputMethod(et_video_activity_main.getWindowToken(), 0);
////			IsActive = true;
////		}
////		return isOpen;
//	}
	/**
	 * ?key=第一次&api_key=a6719304d387489c3f6b54a56e9f7e87&page=1&page_size=1
	 * @param key  搜索的类容
	 * @param page_size
	 * @param page
	 */
	private synchronized void getData(final String key,final int page_size,final int page){
		pb_video_search_activity_main_search.setVisibility(View.VISIBLE);
		tv_video_search_activity_main_search.setVisibility(View.GONE);
		final AsyncHttpClient client = HttpClientUtils.getClient();
		final RequestParams params = new RequestParams();
		params.put("api_key", "a6719304d387489c3f6b54a56e9f7e87");
		params.put("key", key);
		params.put("page", page);
		params.put("page_size", page_size);
		client.get("http://open.mb.hd.sohu.com/v4/search/keyword.json",params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				pb_video_search_activity_main_search.setVisibility(View.GONE);
				tv_video_search_activity_main_search.setVisibility(View.VISIBLE);
				JSONObject jsonObject = UserJSON.getJSONObject(new String(b));
				JSONObject data = UserJSON.getJSONObject(jsonObject, "data");
				List<VideoSearchEntity> list = UserJSON.parsUser(VideoSearchEntity.class, data, "videos");
				Map<String, List<VideoSearchEntity>> map = new HashMap<String, List<VideoSearchEntity>>();
				map.put(key, list);
				Message msg = new Message();
				msg.obj = map;
				msg.what = ZOO;
				handler.handleMessage(msg);
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				pb_video_search_activity_main_search.setVisibility(View.GONE);
				tv_video_search_activity_main_search.setVisibility(View.VISIBLE);
			}
		});
	}
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.activity_fade_in,R.anim.activity_fade_out);
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		MMLog.i("onTextChanged||||||||||||"+s.toString());
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		MMLog.i("onTextChanged)))))))))"+s.toString());
		
	}
	@Override
	public void afterTextChanged(Editable s) {
		Map<String, List<VideoSearchEntity>> map = instance.getMap();
		if(map.containsKey(s.toString().trim())){
			et_text = s.toString().trim();
			list.clear();
			List<VideoSearchEntity> listeEntities = map.get(s.toString().trim());
			for (int i = 0; i < listeEntities.size(); i++) {
				list.add(listeEntities.get(i));
			}
			setAdapter();
		}else {
			
		}
		MMLog.i("afterTextChanged==="+s.toString());
	}
	private List<VideoSearchEntity> list = new ArrayList<VideoSearchEntity>();
	private static final int ZOO = 0;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				Map<String, List<VideoSearchEntity>> map = (Map<String, List<VideoSearchEntity>>) msg.obj;
				list.clear();
				instance.setMap(map);
				for (String key : map.keySet()) {
					List<VideoSearchEntity> listenEntities = map.get(key);
					for (int i = 0; i < listenEntities.size(); i++) {
						list.add(listenEntities.get(i));
					}
				}
//				List<VideoSearchEntity> listenEntities = (List<VideoSearchEntity>) msg.obj;
				setAdapter();
				break;
			default:
				break;
			}
		}

	};
	private ZhaoYaoAdapter<VideoSearchEntity> adapter;
	private void setAdapter() {
		if(adapter==null){
			adapter = new ZhaoYaoAdapter<VideoSearchEntity>(this, list, R.layout.souhu_item_video_search_activity_listview) {
				@Override
				public void convert(ViewHolder helper, VideoSearchEntity item) {
					helper.setImageByUrl(R.id.iv_item_souhu_f_entertainment_pic, item.getVer_big_pic());
					helper.setText(R.id.tv_item_souhu_f_entertainment_title, item.getVideo_name());
//				helper.setText(R.id.tv_item_souhu_f_entertainment_content, item.getAlbumTitle());
				}
			};
			lv_video_search_activity_main_search.setAdapter(adapter);
		}else {
			adapter.notifyDataSetChanged();
		}
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(event.getAction()==MotionEvent.ACTION_DOWN)
//		{
			et_video_activity_main.setEnabled(false);//不可编辑
			if(event.getAction()==MotionEvent.ACTION_UP)
				et_video_activity_main.setEnabled(true);//可编辑
//			et_video_activity_main.setFocusable(true);
//			et_video_activity_main.requestFocus();
//			InputMethodManager immm = (InputMethodManager) et_video_activity_main.getContext().getSystemService(INPUT_METHOD_SERVICE);   
//			immm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS); 
//		}
//		if(IsActive){
//			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);  
//			boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开
//			if(isOpen){
//				imm.hideSoftInputFromWindow(et_video_activity_main.getWindowToken(), 0);
//				IsActive = false;
//			}
//		}
		return false;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		VideoSearchEntity entity = (VideoSearchEntity) parent.getItemAtPosition(position);
		PlayVideoHelper.playSohuOnlineVideo(this, Long.parseLong(entity.getAid()), Long.parseLong(entity.getVid()), Integer.parseInt(entity.getSite()), 0);
	}
//	private void setOnEditorActionListener(){
//			et_video_activity_main.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//			
//			@Override
//			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//				/*判断是否是“GO”键*/
//				if(actionId == EditorInfo.IME_ACTION_GO){
//					/*隐藏软键盘*/
//					InputMethodManager imm = (InputMethodManager) v
//							.getContext().getSystemService(
//									Context.INPUT_METHOD_SERVICE);
//					if (imm.isActive()) {
//						imm.hideSoftInputFromWindow(
//								v.getApplicationWindowToken(), 0);
//					}
//					return true;
//				}
//				return false;
//			}
//		});
//	}
}
