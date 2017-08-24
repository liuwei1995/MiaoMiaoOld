package com.zhaoyao.miaomiao.fragment.video;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.controller.video.VideoController;
import com.zhaoyao.miaomiao.entity.video.souhu.MusicEntity;
import com.zhaoyao.miaomiao.helper.PlayVideoHelper;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
import com.zhaoyao.miaomiao.util.time.SimpleDateFormatUtil;

public class VideoMusicFragment  extends Fragment implements OnItemClickListener{
	private Context mContext;
	private GridView gridViewpositive;
	private View item_positive;
	public VideoMusicFragment(Context context) {
		mContext = context;
	}
	private ZhaoYaoAdapter<MusicEntity> listpositiveAdapter;
	@ViewInject(id = R.id.ll_video_fragment_tv)
	private LinearLayout ll_video_fragment_tv;
	@ViewInject(id = R.id.rl_video_fragment_tv_ProgressBar)
	private RelativeLayout rl_video_fragment_tv_ProgressBar;
	private List<MusicEntity> list = new ArrayList<MusicEntity>();
	private static final int ZOO = 0;
	private static final int ONE = 1;//anime
	private static final int TWO = 2;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				ll_video_fragment_tv.setVisibility(View.VISIBLE);
				rl_video_fragment_tv_ProgressBar.setVisibility(View.GONE);
				List<MusicEntity> listpositive = (List<MusicEntity>) msg.obj;
				if(listpositive==null||listpositive.size()==0)return;
				list.clear();
				for (int i = 0; i < listpositive.size(); i++) {
					list.add(listpositive.get(i));
				}
				setlistpositiveAdapter();
				break;
			case ONE:
				
				break;
			case TWO:
				break;
			default:
				break;
			}
		}
	};
	private View textView2;
	private View pb;
	private void setlistpositiveAdapter() {
		if(listpositiveAdapter==null){
		listpositiveAdapter = new ZhaoYaoAdapter<MusicEntity>(mContext, list,  R.layout.video_item_fragment_tv) {
			@Override
			public void convert(ViewHolder helper, MusicEntity item) {
				helper.setImageByUrl(R.id.iv_video_item_fragment_tv_url, item.getVer_high_pic());
				helper.setText(R.id.tv_video_item_fragment_tv_title, item.getAlbum_name());
				helper.setText(R.id.tv_video_item_fragment_tv_content, item.getSearch_name());						
			}
		};
		gridViewpositive.setAdapter(listpositiveAdapter);
		ListViewHeightUtil.setListViewHeightBasedOnChildren(gridViewpositive);
		ll_video_fragment_tv.addView(item_positive);
		}else {
			listpositiveAdapter.notifyDataSetChanged();
			gridViewpositive.setSelection(0);
		}
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.video_fragment_tv, null);
		item_positive = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_positive, null);
		gridViewpositive = (GridView) item_positive.findViewById(R.id.gV_video_fragment_positive); 
		 textView2 = item_positive.findViewById(R.id.textView2);
			pb = item_positive.findViewById(R.id.pb);
			pb.setVisibility(View.GONE);
			textView2.setVisibility(View.VISIBLE);
			textView2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					pb.setVisibility(View.VISIBLE);
					textView2.setVisibility(View.GONE);
					get(2);
				}
			});
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		gridViewpositive.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}
	private int frist = 0 ;
	public void fristClick() {
		if (frist==0) {
		get(1);
		}
		++frist;
	}
	private VideoController controller;
	private void get(final int i) {
		if(controller==null)
		 controller = new VideoController();
		String page = SharedPreferencesUtil.getString(mContext, "24.json", ""+SimpleDateFormatUtil.DateYMD());
		if(page!=null&&!TextUtils.isEmpty(page)){
			Integer valueOf = Integer.valueOf(page);
			if(i==2)
			++valueOf;
			page = ""+valueOf;
			SharedPreferencesUtil.saveString(mContext, page, "24.json", SimpleDateFormatUtil.DateYMD());
		}else {
			page = 1+"";
			SharedPreferencesUtil.saveString(mContext, page, "24.json", SimpleDateFormatUtil.DateYMD());
		}
		AsyncHttpClient client = HttpClientUtils.getClient();
		client.get("http://open.mb.hd.sohu.com/v4/category/channel/24.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page="+page+"&is_pgc=1", new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				pb.setVisibility(View.GONE);
				textView2.setVisibility(View.VISIBLE);
				String s = new String(b);
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				JSONObject object = UserJSON.getJSONObject(jsonObject, "data");
				List<MusicEntity> list = UserJSON.parsUser(MusicEntity.class, object, "videos");Message msg = new Message();
				msg.obj = list;
				msg.what = ZOO;
				handler.handleMessage(msg);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				pb.setVisibility(View.GONE);
				textView2.setVisibility(View.VISIBLE);
				String page = SharedPreferencesUtil.getString(mContext, "24.json", ""+SimpleDateFormatUtil.DateYMD());
				if(page!=null||!TextUtils.isEmpty(page)){
					Integer valueOf = Integer.valueOf(page);
					if(valueOf>=2)
					--valueOf;
					page = ""+valueOf;
					SharedPreferencesUtil.saveString(mContext, page, "24.json", SimpleDateFormatUtil.DateYMD());
				}else {
					page = 1+"";
					SharedPreferencesUtil.saveString(mContext, page, "24.json", SimpleDateFormatUtil.DateYMD());
				}
			}
		});
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		MusicEntity entity = (MusicEntity) parent.getItemAtPosition(position);
		long aid = entity.getAid();
		long vid = entity.getVid();
		int site = entity.getSite();
		PlayVideoHelper.playSohuOnlineVideo(mContext, aid, vid, site, 0);
	}
}
