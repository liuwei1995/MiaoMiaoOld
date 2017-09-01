package com.zhaoyao.miaomiao.fragment.show;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mediav.ads.sdk.adcore.Mvad;
import com.mediav.ads.sdk.interfaces.IMvBannerAd;
import com.mediav.ads.sdk.interfaces.IMvFloatbannerAd;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.showapi.PicAdapter;
import com.zhaoyao.miaomiao.constant.Ad360Constant;
import com.zhaoyao.miaomiao.entity.showapi.PicModel;
import com.zhaoyao.miaomiao.http.showapi.BudejieManager;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.ToastUtil;
import com.zhaoyao.miaomiao.util.showapi.Constant;
import com.zhaoyao.miaomiao.util.showapi.NetworkDetector;
import com.zhaoyao.miaomiao.view.showapi.CircularProgress;
import com.zhaoyao.miaomiao.view.showapi.XListView;
import com.zhaoyao.miaomiao.view.showapi.XListView.IXListViewListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * type=10 图片
 * 
 * @author lenovo
 *
 */
@SuppressLint("ValidFragment")
public class PicFragment extends Fragment implements IXListViewListener,
		OnClickListener {

	private LinearLayout netexceptionLayout, nodataLayout;
	private CircularProgress showprogressLayout;
	private boolean network = false;
	private XListView lv_common;
	public final String TAG = "----PicFragment----";
	private int operation_type = -1;
	private int page = 1;
	private PicAdapter adapter;
	private List<PicModel.ContentlistBean> tempItems;
	private int allPages = 0;
	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.budejie_pic_llist,
				container, false);
		initView(fragmentView);
		if (frist == 0) {
			checknetworkAndshowData();
		}
		++frist;
		return fragmentView;
	}

	private int frist = 0;
	private IMvFloatbannerAd floatBanner;
	private IMvBannerAd showBanner;

	public void fristClick() {
		if (frist == 0) {
			checknetworkAndshowData();
		}
		++frist;
	}

	private void initView(View view) {
		lv_common = (XListView) view.findViewById(R.id.listView);
		showprogressLayout = (CircularProgress) view
				.findViewById(R.id.progressbar);
		netexceptionLayout = (LinearLayout) view
				.findViewById(R.id.netexception);
		nodataLayout = (LinearLayout) view.findViewById(R.id.nodata);
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
	}

	private void checknetworkAndshowData() {
		network = NetworkDetector.detect(getActivity());
		String ctime = formatter.format(new Date());
		if (network) {
			PicLoadTask task = new PicLoadTask();
			task.execute(Constant.BUDEJIE_URL, page + "", Constant.TYPE_PIC,
					Constant.APP_ID, Constant.APP_SECRET, ctime);
		} else {
			netexceptionLayout.setVisibility(View.VISIBLE);
		}
	}

	private class PicLoadTask extends AsyncTask<String, Object, PicModel> {

		@Override
		protected PicModel doInBackground(String... params) {
			return BudejieManager.requestLifeHealth(params[0], params[1],
					params[2], params[3], params[4], params[5]);
		}

		@Override
		protected void onPostExecute(PicModel listItems) {
			showprogressLayout.setVisibility(View.GONE);
			if (listItems != null && listItems.getContentlist() != null && listItems.getContentlist().size() != 0) {
				allPages = listItems.getAllPages();
				if (operation_type == Constant.OPERATION_TYPE_LOAD
						|| operation_type == Constant.OPERATION_TYPE_REFRESH) {
					tempItems = listItems.getContentlist();
				} else if (operation_type == Constant.OPERATION_TYPE_LOAD_MORE) {
					if (tempItems != null) {
						tempItems.addAll(tempItems.size(), listItems.getContentlist());
						if (page >= allPages) {
							ToastUtil.show(getActivity(), R.string.nodatashow);
						}
					}
				}
				if (getActivity() != null) {
					if (tempItems != null && tempItems.size() != 0) {
						adapter = new PicAdapter(getActivity(), tempItems);
						lv_common.setAdapter(adapter);
						lv_common.setSelection(tempItems.size()
								- listItems.getContentlist().size());
					}
				}
			} else {
				if (operation_type == Constant.OPERATION_TYPE_LOAD_MORE
						|| operation_type == Constant.OPERATION_TYPE_REFRESH) {
					ToastUtil.show(getActivity(), R.string.nodatashow);
				} else {
					nodataLayout.setVisibility(View.VISIBLE);
				}
			}
		}

		@Override
		protected void onPreExecute() {
			nodataLayout.setVisibility(View.GONE);
			showprogressLayout.setVisibility(View.VISIBLE);
			netexceptionLayout.setVisibility(View.GONE);
		}
	}

	public static PicFragment newInstance() {
		PicFragment fragment = new PicFragment();
		return fragment;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
			  floatBanner = Mvad.showFloatbannerAd(getActivity(),Ad360Constant.adSpaceid_floatBanner_MainActivity,false,Mvad.FLOAT_BANNER_SIZE.SIZE_DEFAULT,Mvad.FLOAT_LOCATION.BOTTOM);
	}

	// 刷新完 停止下拉刷新
	private void onLoad() {
		lv_common.stopRefresh();
		lv_common.stopLoadMore();
		if (getActivity() != null) {
			lv_common.setRefreshTime(getActivity().getResources().getString(
					R.string.ganggangstr));
		}
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
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
		MMLog.i(TAG, "刷新最新");
		page = 1;
		operation_type = Constant.OPERATION_TYPE_REFRESH;
		checknetworkAndshowData();
		onLoad();
	}

	// 下拉加载
	@Override
	public void onLoadMore() {
		MMLog.i(TAG, "加载更多");
		page += 1;
		operation_type = Constant.OPERATION_TYPE_LOAD_MORE;
		checknetworkAndshowData();
		onLoad();
	}

	private void setupBannerAd() {
		if(showBanner == null){
			LinearLayout inflate = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.ad_r, null);
			showBanner = Mvad.showBanner(inflate, getActivity(), Ad360Constant.adSpaceid_bannerad_MainActivity, false);
			lv_common.addHeaderView(inflate);
			lv_common.invalidate();
		}
		if(floatBanner == null)
			  floatBanner = Mvad.showFloatbannerAd(getActivity(),Ad360Constant.adSpaceid_floatBanner_MainActivity,false,Mvad.FLOAT_BANNER_SIZE.SIZE_DEFAULT,Mvad.FLOAT_LOCATION.BOTTOM);
	}
}
