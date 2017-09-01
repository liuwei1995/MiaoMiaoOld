package com.zhaoyao.miaomiao.fragment.dt;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;

import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.dt.DTLatestOnAdapter;
import com.zhaoyao.miaomiao.dao.impl.DTLatestOnDaoImpl;
import com.zhaoyao.miaomiao.entity.dt.DTLatestOnEntiry;
import com.zhaoyao.miaomiao.http.HttpChildInterface;
import com.zhaoyao.miaomiao.http.UserRequest;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.ToastUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.showapi.Constant;
import com.zhaoyao.miaomiao.util.showapi.NetworkDetector;
import com.zhaoyao.miaomiao.view.showapi.CircularProgress;
import com.zhaoyao.miaomiao.view.showapi.XListView;
import com.zhaoyao.miaomiao.view.showapi.XListView.IXListViewListener;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author lw
 * 编写时间: 2016年4月13日下午2:01:03
 * 类说明 :  阿凡达最新趣图
 */
@SuppressLint("ValidFragment")
public class DTLatestOnFragment extends Fragment implements IXListViewListener,OnClickListener,OnScrollListener{

	private LinearLayout netexceptionLayout,nodataLayout;
	private CircularProgress showprogressLayout;
	private boolean network=false;
	private XListView lv_common;
	public final String TAG="----DTLatestOnFragment----";
	private int operation_type = -1;
	private int page=1;
	private int rows = 30;
	private DTLatestOnAdapter adapter;
	private List<DTLatestOnEntiry> tempItems = new ArrayList<DTLatestOnEntiry>();
	private int allPages=0;
	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss");
	private MyReceiver receiver;
	private String[] split;
	private View fragmentView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter("");
		filter.addAction("DTLatestOnFragment_onSaveInstanceState");
		filter.addAction("DTLatestOnFragment_onPause");
		getActivity().registerReceiver(receiver, filter);
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onStop() {
		super.onStop();
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("DTJokeFragmentpageAndNumber", page+","+firstVisible);
		super.onSaveInstanceState(outState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		 fragmentView = inflater.inflate(R.layout.budejie_pic_llist,container, false);
//		contentView = (LinearLayout) fragmentView.findViewById(R.id.contentView);
//		contentView.setVisibility(View.GONE);
		initView(fragmentView);
//		String pageAnd = SharedPreferencesUtil.getString(getActivity(), "DTJokeFragmentpageAndNumber", "DTJokeFragmentpageAndNumber");
//		 if(savedInstanceState!=null){
//			 String pageAndNumber = savedInstanceState.getString("DTJokeFragmentpageAndNumber");
//			 getContent(pageAndNumber);
//		 }else if (pageAnd!=null&&!TextUtils.isEmpty(pageAnd)) {
//			 getContent(pageAnd);
//		 }else {
////			getData(page, rows);
//		}
		return fragmentView;
	}
	private void setAdapter() {
		if(adapter==null){
			adapter=new DTLatestOnAdapter(getActivity(), tempItems);
			lv_common.setAdapter(adapter);
		}else {
			adapter.notifyDataSetChanged();
		}
	}
//	private void getContent(String pageAndNumber) {
//		nodataLayout.setVisibility(View.GONE);
//		showprogressLayout.setVisibility(View.VISIBLE);
//		netexceptionLayout.setVisibility(View.GONE);
//		split = pageAndNumber.split(",");
//		 page = Integer.parseInt(split[0]);
//		 int Number = Integer.parseInt(split[1]);
//		 DTLatestOnDaoImpl daoImpl = new DTLatestOnDaoImpl(getActivity());
//		 List<DTLatestOnEntiry> find = daoImpl.find();
//		 if(find!=null)
//		 for (int i = 0; i < find.size(); i++) {
//			 tempItems.add(find.get(i));
//		}++frist;
//		 setAdapter();
//		 ++Number;
//		 lv_common.setSelection(Number);//定位到10行;
//		 showprogressLayout.setVisibility(View.GONE);
//	}
	private int frist = 0 ;
	public void fristClick() {
		if (frist==0) {
			checknetworkAndshowData();
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					
				}
			}, 30*1000);
		}
		++frist;
	}
	private void initView(View view){
		lv_common=(XListView)view.findViewById(R.id.listView);
		showprogressLayout=(CircularProgress)view.findViewById(R.id.progressbar);
		netexceptionLayout=(LinearLayout)view.findViewById(R.id.netexception);
		nodataLayout=(LinearLayout)view.findViewById(R.id.nodata);
		operation_type = Constant.OPERATION_TYPE_LOAD;
		initXListView();
		netexceptionLayout.setOnClickListener(this);
		nodataLayout.setOnClickListener(this);
		setupBannerAd();
	}
	
	// 初始化xListView
    private void initXListView() {
        lv_common.setPullLoadEnable(true);
        lv_common.setPullRefreshEnable(true);
        lv_common.setXListViewListener(this);
        lv_common.setOnScrollListener(this);
    }
    
    private void checknetworkAndshowData(){
    	network=NetworkDetector.detect(getActivity());
    	String ctime = formatter.format(new Date()); 
		if(network){
			getData(page, rows);
		}else{
			netexceptionLayout.setVisibility(View.VISIBLE);
		}
	}
    private synchronized void getData(final int pagepage,final int rows){
    	nodataLayout.setVisibility(View.GONE);
		showprogressLayout.setVisibility(View.VISIBLE);
		netexceptionLayout.setVisibility(View.GONE);
    	RequestParams params = UserRequest.getRequestParams();
    	params.put("page", pagepage);
    	params.put("rows", rows);
    	UserRequest.DTJokeRequest(params, new HttpChildInterface(){
    		@Override
    		public void complete(boolean istrue, String s) {
    			showprogressLayout.setVisibility(View.GONE);
    			if(istrue){
    				JSONObject jsonObject = UserJSON.getJSONObject(s);
        			String reason = UserJSON.getString(jsonObject, "reason");
        			String error_code = UserJSON.getString(jsonObject, "error_code");
        			if("Succes".equals(reason)&&"0".equals(error_code)){
        				List<DTLatestOnEntiry> listItems = UserJSON.parsUser(DTLatestOnEntiry.class, jsonObject, "result");
        				if(listItems!=null&&listItems.size()!=0){
        					if(pagepage==1){if(tempItems!=null)tempItems.clear();
        						tempItems.addAll(tempItems.size(), listItems);
        					}else {
        						tempItems.addAll(tempItems.size(), listItems);
							}
        					if(getActivity()!=null){						
        						if (tempItems != null && tempItems.size() != 0) {
        							setAdapter();
        						}
        					}
        				}else{
        					if(operation_type == Constant.OPERATION_TYPE_LOAD_MORE || operation_type == Constant.OPERATION_TYPE_REFRESH){
        						ToastUtil.show(getActivity(), R.string.nodatashow);
        					}else{
        						nodataLayout.setVisibility(View.VISIBLE);
        					}
        				}
        				DTLatestOnDaoImpl daoImpl = new DTLatestOnDaoImpl(getActivity());
						for (int i = 0; i < listItems.size(); i++) {
							DTLatestOnEntiry entity = listItems.get(i);
							List<DTLatestOnEntiry> rawQuery = daoImpl.rawQuery("select * from t_DTJokeEntiry where updatetime= ? and hashId= ?", new String[]{entity.getUpdatetime(),entity.getHashId()});
							if(rawQuery==null||rawQuery.size()==0) {
								long insert = daoImpl.insert(entity);
							}
						}
        				
        			}
    			}else {
    				if(istrue==true)
    					--page;
				}
    		}
    	});
    }
	private static Context mcontext;
	public static DTLatestOnFragment newInstance(Context context){
		mcontext = context;
		DTLatestOnFragment fragment = new DTLatestOnFragment();
        return fragment;
    }

	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(receiver);
		super.onDestroy();
	}

	@Override
	public void onPause() {
		SharedPreferencesUtil.saveString(getActivity(), page+","+firstVisible, "DTJokeFragmentpageAndNumber", "DTJokeFragmentpageAndNumber");
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}
	
	// 刷新完 停止下拉刷新
	private void onLoad() {
		lv_common.stopRefresh();
		lv_common.stopLoadMore();
		if (getActivity() != null) {
			lv_common.setRefreshTime(getActivity().getResources().getString(R.string.ganggangstr));
		}
	}

	@Override
	public void onClick(View v) {
		int id=v.getId();
		switch (id) {
		case R.id.netexception:
			checknetworkAndshowData();
			break;
		case R.id.nodata:
			checknetworkAndshowData();
			break;
		default:
			break;
		}
	}

	// 下拉刷新
	@Override
	public void onRefresh() {
		isLoad = false;
		MMLog.i(TAG, "刷新最新");
		page = 1;
		operation_type = Constant.OPERATION_TYPE_REFRESH;
		checknetworkAndshowData();
		onLoad();
	}
	private boolean isLoad = false;
	// 下拉加载
	@Override
	public void onLoadMore() {
		MMLog.i(TAG, "加载更多");
		page += 1;
		isLoad = true;
		operation_type = Constant.OPERATION_TYPE_LOAD_MORE;
		checknetworkAndshowData();
		onLoad();
	}
	
	private int firstVisible = 0;
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		firstVisible = firstVisibleItem;
	}
	@Override
	public void onDestroyView() {
		MMLog.i(this.getTag()+"------------------------------onDestroyView");
		super.onDestroyView();
	}
	class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			
		}
		
	}
	/**
	 * 设置广告条广告
	 */
	private void setupBannerAd() {
//		lv_common.addHeaderView(adView);
//		lv_common.removeHeaderView(adView);
//		lv_common.addHeaderView(getAdView());
	}
}
