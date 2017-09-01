package com.zhaoyao.miaomiao.fragment.video.neihanduanzi;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.loopj.android.http.RequestParams;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.adapter.Android.MAdapter;
import com.zhaoyao.miaomiao.adapter.Android.MAdapter.click;
import com.zhaoyao.miaomiao.entity.neihanduanzi.NeiHanDuanZiRecommendedEntiry;
import com.zhaoyao.miaomiao.helper.PlayVideoHelper;
import com.zhaoyao.miaomiao.http.HttpChildInterface;
import com.zhaoyao.miaomiao.http.ResultNeiHanDuanZi;
import com.zhaoyao.miaomiao.http.UserRequest;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.ToastUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
/**
 * 
* @author 作者 lw: 
* @version 创建时间：2016年4月9日 下午3:01:19 
* 类说明 : 推荐
 */

@SuppressLint({"ResourceAsColor", "ValidFragment"})
public class JokesFragment extends Fragment implements OnScrollListener,OnItemClickListener,SwipyRefreshLayout.OnRefreshListener{
	private Context mContext;
	public JokesFragment(Context context) {
		mContext = context;
	}
	private ZhaoYaoAdapter<NeiHanDuanZiRecommendedEntiry> listMicroFilmAdapter;
	private static final int ZOO = 0;
	private static final int ONE = 1;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				rl_video_fragment_jokes_ProgressBar.setVisibility(View.GONE);
				List<NeiHanDuanZiRecommendedEntiry> list = (List<NeiHanDuanZiRecommendedEntiry>) msg.obj;
				listpositive.clear();
				for (int i = 0; i < list.size(); i++) {
					listpositive.add(list.get(i));
				}
				setlistpositiveAdapter();
				break;
			case ONE:
				rl_video_fragment_jokes_ProgressBar.setVisibility(View.GONE);
				ToastUtil.show(mContext, "网络连接失败");
				break;
			default:
				break;
			}
		}
	};
	public void doClick(View v) {
		get();
	}
	private List<NeiHanDuanZiRecommendedEntiry> listpositive = new ArrayList<NeiHanDuanZiRecommendedEntiry>();
	private void setlistpositiveAdapter() {
		MAdapter mAdapter = new MAdapter(mContext, listpositive);
		mAdapter.setClick(new click() {
			@Override
			public void isClick(int position, boolean isPlaying) {
				
			}
		});
		if(listMicroFilmAdapter==null){
			listMicroFilmAdapter = new ZhaoYaoAdapter<NeiHanDuanZiRecommendedEntiry>(mContext, listpositive,  R.layout.neihanduanzi_jokes_fragment_item) {
				@Override//搞笑囧图2//爆笑GIF//花美男28
				public void convert(ViewHolder helper, NeiHanDuanZiRecommendedEntiry item) {
					String type = item.getType();
					if("3".equals(type)){
						String media_type = item.getMedia_type();
						if("0".equals(media_type)){
							helper.getView(R.id.iv_neihanduanzi).setVisibility(View.GONE);
							helper.setText(R.id.tv, item.getContent());
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
							helper.setImageByUrl(R.id.iv_neihanduanzi, url);
						helper.setText(R.id.tv, item.getContent());
						}else if ("2".equals(media_type)) {
							String middle_image = item.getMiddle_image();
							JSONObject jsonObject = UserJSON.getJSONObject(middle_image);
							JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
							String url = "";
							for (int i = 0; i < jsonArray.length(); i++) {
								url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
								break;
							}
							helper.setImageByUrlGlideUtil(R.id.iv_neihanduanzi, url);
							helper.setText(R.id.tv, item.getContent());
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
							helper.setImageByUrlGlideUtil(R.id.iv_neihanduanzi, url);
							helper.setText(R.id.tv, item.getTitle());
						}
					}else if ("2".equals(type)) {//搞笑视频65
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
						helper.setText(R.id.tv, item.getContent());
					}else if ("5".equals(type)) {//二次元
						String media_type = item.getMedia_type();
						if("4".equals(media_type)){//奇葩卖家的二三事
							String large_image_list = item.getLarge_image_list();
							JSONArray jsonArray = UserJSON.getJSONArray(large_image_list);
							String url = "";
							for (int i = 0; i < jsonArray.length(); i++) {
								url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
								break;
							}
							helper.setImageByUrl(R.id.iv_neihanduanzi, url);
							helper.setText(R.id.tv, item.getContent());
						}else if ("5".equals(media_type)) {
							MMLog.i(media_type);
						}
					}
				}
			};
		listview.setAdapter(listMicroFilmAdapter);
		ListViewHeightUtil.setListViewHeightBasedOnChildren(listview);
		}else {
			listMicroFilmAdapter.notifyDataSetChanged();
		}
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.video_fragment_jokes, null);
		return view;
		}
	@ViewInject(id = R.id.swipyrefreshlayout)
	private SwipyRefreshLayout mSwipyRefreshLayout;
	@ViewInject(id = R.id.rl_video_fragment_jokes_ProgressBar)
	private RelativeLayout rl_video_fragment_jokes_ProgressBar;
	@ViewInject(id = R.id.listview)
	private ListView listview;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		mSwipyRefreshLayout.setOnRefreshListener(this);
		listview.setOnItemClickListener(this);
		listview.setOnScrollListener(this);
		rl_video_fragment_jokes_ProgressBar.setVisibility(View.VISIBLE);
		if (frist==0) {
			get();
			}
			++frist;
		super.onActivityCreated(savedInstanceState);
	}
	private int frist = 0 ;
	public void fristClick() {
		if (frist==0) {
		get();
		}
		++frist;
	}
	private void get() {
		RequestParams params = UserRequest.getRequestParams();
		UserRequest.neiHanDuanZiVideo(params, new HttpChildInterface(){
			@Override
			public void completeNeiHanDuanZiResult(boolean istrue,
					ResultNeiHanDuanZi result) {
				if(istrue){
					String data = result.getData();
					List<NeiHanDuanZiRecommendedEntiry> list = new ArrayList<NeiHanDuanZiRecommendedEntiry>();
					JSONArray jsonArray = UserJSON.getJSONArray(data);
					 for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject object = UserJSON.getJSONObject(jsonArray, i);
							String type = UserJSON.getString(object, "type");
							if(!"1".equals(type))continue;
							JSONObject group = UserJSON.getJSONObject(object, "group");
							NeiHanDuanZiRecommendedEntiry entiry = UserJSON.parseObject(NeiHanDuanZiRecommendedEntiry.class, group);
							list.add(entiry);
						}
					Message msg = new Message();
					msg.obj = list;
					msg.what = ZOO;
					handler.handleMessage(msg);
				}else {
					Message msg = new Message();
					msg.what = ONE;
					handler.handleMessage(msg);
				}
			}
		});
	}
    
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {//美食晒粗来47
		NeiHanDuanZiRecommendedEntiry item = (NeiHanDuanZiRecommendedEntiry) parent.getItemAtPosition(position);
		String type = item.getType();
		if("2".equals(type)){
			String mp4_url = item.getMp4_url();
			PlayVideoHelper.playLocalVideo(mContext, mp4_url, 0);
			
		}else if ("3".equals(type)) {
			if("爆笑GIF".equals(item.getCategory_name())){
				
			}
		}
	}
	@Override
	public void onRefresh(SwipyRefreshLayoutDirection direction) {
		mSwipyRefreshLayout.setRefreshing(false);
		if(direction==SwipyRefreshLayoutDirection.TOP){
			get();
			mSwipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
		}else if (direction==SwipyRefreshLayoutDirection.BOTTOM) {
			ToastUtil.show(mContext, "没有更多,刷新试试");
			mSwipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.TOP);
		}else if (direction==SwipyRefreshLayoutDirection.BOTH) {
			MMLog.i("");
		}
//         mSwipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.TOP);
//         mSwipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTTOM);
//         mSwipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
		SwipyRefreshLayoutDirection swipyRefreshLayoutDirection = mSwipyRefreshLayout.getDirection();
		MMLog.i("swipyRefreshLayoutDirection========="+swipyRefreshLayoutDirection);
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
	}  
}
