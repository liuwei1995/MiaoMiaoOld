package com.zhaoyao.miaomiao.fragment.video.souhu;

import android.annotation.SuppressLint;
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
import com.zhaoyao.miaomiao.entity.video.VideoEntity;
import com.zhaoyao.miaomiao.entity.video.souhu.FunnyEntity;
import com.zhaoyao.miaomiao.helper.PlayVideoHelper;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
import com.zhaoyao.miaomiao.util.time.SimpleDateFormatUtil;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**
 * 搞笑
 * @author lw
 *
 */
@SuppressLint("ValidFragment")
public class VideoFunnyFragment  extends Fragment implements OnItemClickListener{
	private Context mContext;
	private GridView gridViewpositive;
//	private GridView gridViewMicro_film;
	private View item_positive;
//	private View item_micro_film;
	private List<FunnyEntity> list = new ArrayList<FunnyEntity>();
	public VideoFunnyFragment(Context context) {
		mContext = context;
	}
	private ZhaoYaoAdapter<FunnyEntity> listpositiveAdapter;
	@ViewInject(id = R.id.ll_video_fragment_tv)
	private LinearLayout ll_video_fragment_tv;
	@ViewInject(id = R.id.rl_video_fragment_tv_ProgressBar)
	private RelativeLayout rl_video_fragment_tv_ProgressBar;
	private ZhaoYaoAdapter<VideoEntity> listMicroFilmAdapter;
	private static final int ZOO = 0;
	private static final int ONE = 1;//anime
	private static final int TWO = 2;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				ll_video_fragment_tv.setVisibility(View.VISIBLE);
				rl_video_fragment_tv_ProgressBar.setVisibility(View.GONE);
				List<FunnyEntity> listpositive = (List<FunnyEntity>) msg.obj;
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
//				List<VideoEntity> listMicroFilm = (List<VideoEntity>) msg.obj;
//				setlistMicroFilmAdapter(listMicroFilm);
				break;
			default:
				break;
			}
		}

//		private void setlistMicroFilmAdapter(List<VideoEntity> listMicroFilm) {
//			listMicroFilmAdapter = new ZhaoYaoAdapter<VideoEntity>(mContext, listMicroFilm,  R.layout.video_item_fragment_tv) {
//				@Override
//				public void convert(ViewHolder helper, VideoEntity item) {
//					helper.setImageByUrl(R.id.iv_video_item_fragment_tv_url, item.getBigPic());
//					helper.setText(R.id.tv_video_item_fragment_tv_title, item.getTitle());
//					helper.setText(R.id.tv_video_item_fragment_tv_content, item.getDesc());						
//				}
//			};
//			gridViewMicro_film.setAdapter(listMicroFilmAdapter);
//			ListViewHeightUtil.setListViewHeightBasedOnChildren(gridViewMicro_film);
//			ll_video_fragment_tv.addView(item_micro_film);
//		}

	};
	private View textView2;
	private View pb;
	private void setlistpositiveAdapter() {
		if(listpositiveAdapter==null){
			listpositiveAdapter = new ZhaoYaoAdapter<FunnyEntity>(mContext, list,  R.layout.video_item_fragment_tv) {
				@Override
				public void convert(ViewHolder helper, FunnyEntity item) {
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
//		 item_micro_film = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_micro_film, null);
//		 gridViewMicro_film = (GridView) item_micro_film.findViewById(R.id.gV_video_fragment_Micro_film); 
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		gridViewpositive.setOnItemClickListener(this);
//		gridViewMicro_film.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}
	private int frist = 0 ;
	private int p = 1;
	private int s = 20;
	public void fristClick() {
		if (frist==0) {
		get(1);
		}
		++frist;
	}
	private VideoController controller;
	private synchronized void get(final int i) {
		if(controller==null)
		 controller = new VideoController();
		String page = SharedPreferencesUtil.getString(mContext, "36.json", ""+SimpleDateFormatUtil.DateYMD());
		if(page!=null&&!TextUtils.isEmpty(page)){
			Integer valueOf = Integer.valueOf(page);
			if(i==2)
			++valueOf;
			page = ""+valueOf;
			SharedPreferencesUtil.saveString(mContext, page, "36.json", SimpleDateFormatUtil.DateYMD());
		}else {
			page = 1+"";
			SharedPreferencesUtil.saveString(mContext, page, "36.json", SimpleDateFormatUtil.DateYMD());
		}
		AsyncHttpClient client = HttpClientUtils.getClient();
		client.get("http://open.mb.hd.sohu.com/v4/category/channel/36.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page="+page+"&page_size=30&is_pgc=1", new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				pb.setVisibility(View.GONE);
				textView2.setVisibility(View.VISIBLE);
				String s = new String(b);
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				JSONObject object = UserJSON.getJSONObject(jsonObject, "data");
				List<FunnyEntity> list = UserJSON.parsUser(FunnyEntity.class, object, "videos");Message msg = new Message();
				msg.obj = list;
				msg.what = ZOO;
				handler.handleMessage(msg);
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				pb.setVisibility(View.GONE);
				textView2.setVisibility(View.VISIBLE);
				String page = SharedPreferencesUtil.getString(mContext, "36.json", ""+SimpleDateFormatUtil.DateYMD());
				if(page!=null||!TextUtils.isEmpty(page)){
					Integer valueOf = Integer.valueOf(page);
					if(valueOf>=2)
					--valueOf;
					page = ""+valueOf;
					SharedPreferencesUtil.saveString(mContext, page, "36.json", SimpleDateFormatUtil.DateYMD());
				}else {
					page = 1+"";
					SharedPreferencesUtil.saveString(mContext, page, "36.json", SimpleDateFormatUtil.DateYMD());
				}
			}
		});
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		FunnyEntity entity = (FunnyEntity) parent.getItemAtPosition(position);
		long aid = entity.getAid();
		long vid = entity.getVid();
		int site = entity.getSite();
		PlayVideoHelper.playSohuOnlineVideo(mContext, aid, vid, site, 0);
	}
}
