package com.zhaoyao.miaomiao.fragment.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.MainActivity;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.activity.video.VideoWebViewPlayer;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.entity.video.VideoEntity;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.List;
@SuppressLint("ValidFragment")
public class VideoTvFragment extends Fragment implements OnItemClickListener{
	private static final String TAG = MainActivity.class.getName();
	@ViewInject(id = R.id.ll_video_fragment_tv)
	private LinearLayout ll_video_fragment_tv;
	@ViewInject(id = R.id.rl_video_fragment_tv_ProgressBar)
	private RelativeLayout rl_video_fragment_tv_ProgressBar;
	private Context mContext;
	private static final int ZOO = 0;
	private static final int ONE = 1;//anime
	private static final int TWO = 2;
	private int number = 0 ;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				ll_video_fragment_tv.setVisibility(View.VISIBLE);
				rl_video_fragment_tv_ProgressBar.setVisibility(View.GONE);
				List<VideoEntity> listpositive = (List<VideoEntity>) msg.obj;
				listpositiveAdapter = new ZhaoYaoAdapter<VideoEntity>(mContext, listpositive,  R.layout.video_item_fragment_tv) {
					@Override
					public void convert(ViewHolder helper, VideoEntity item) {
						helper.setImageByUrl(R.id.iv_video_item_fragment_tv_url, item.getBigPic());
						helper.setText(R.id.tv_video_item_fragment_tv_title, item.getTitle());
						helper.setText(R.id.tv_video_item_fragment_tv_content, item.getDesc());						
					}
				};
				gridViewpositive.setAdapter(listpositiveAdapter);
				ListViewHeightUtil.setListViewHeightBasedOnChildren(gridViewMicro_film);
				ll_video_fragment_tv.addView(item_positive);
				if (number==0) {
					++number;
					getMicroFilmData("101", p, s, 0, 1);
				}
				break;
			case ONE:
				
				break;
			case TWO:
				List<VideoEntity> listMicroFilm = (List<VideoEntity>) msg.obj;
				listMicroFilmAdapter = new ZhaoYaoAdapter<VideoEntity>(mContext, listMicroFilm,  R.layout.video_item_fragment_tv) {
					@Override
					public void convert(ViewHolder helper, VideoEntity item) {
						helper.setImageByUrl(R.id.iv_video_item_fragment_tv_url, item.getBigPic());
						helper.setText(R.id.tv_video_item_fragment_tv_title, item.getTitle());
						helper.setText(R.id.tv_video_item_fragment_tv_content, item.getDesc());						
					}
				};
				gridViewMicro_film.setAdapter(listMicroFilmAdapter);
				ListViewHeightUtil.setListViewHeightBasedOnChildren(gridViewMicro_film);
				ll_video_fragment_tv.addView(item_micro_film);
				break;
			default:
				break;
			}
		};
	};
	public VideoTvFragment(Context context) {
		mContext = context;
	}
	private int s = 20;
	private int p = 1;
//	@ViewInject(id = R.id.gV_video_fragment_positive)
	private GridView gridViewpositive;
//	@ViewInject(id = R.id.gV_video_fragment_Micro_film)
	private GridView gridViewMicro_film;
	private View item_positive;
	private View item_micro_film;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.video_fragment_tv, null);
		item_positive = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_positive, null);
		item_positive.findViewById(R.id.textView2).setVisibility(View.GONE);
		item_positive.findViewById(R.id.pb).setVisibility(View.GONE);
		gridViewpositive = (GridView) item_positive.findViewById(R.id.gV_video_fragment_positive); 
		 item_micro_film = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_micro_film, null);
		 gridViewMicro_film = (GridView) item_micro_film.findViewById(R.id.gV_video_fragment_Micro_film);
		 item_micro_film.findViewById(R.id.textView3).setVisibility(View.GONE);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		gridViewpositive.setOnItemClickListener(this);
		gridViewMicro_film.setOnItemClickListener(this);
//		getPositiveData("101", p, s, 0, 0);
		super.onActivityCreated(savedInstanceState);
	}
	private int frist = 0 ;
	public void fristClick() {
		if (frist==0) {
			setupBannerAd();
			getPositiveData("101", p, s, 0, 0);
		}
		++frist;
	}
	/**
	  * http://info.lm.tv.sohu.com/a.do?qd=18805&c=101&p=1&s=20&inc=1
	    @param qd	Int	是		主渠道用主渠道号，子渠道用子渠道号
		@param c	Int	否		电视101 动漫115 综艺106 音乐121 新闻122 娱乐112
		@param p	Int	否	1	分页用，页码
		@param s	Int	否	20	每页取回条数
		@param inc	Int	否	1	是否增量获取。1：增量获取；0：全部视频。建议：第一次获取全量，以后增量获取，速度更快
		@param tp	String	否	json	数据格式。json xml
		@param tvt	int	否	0	0是正片；1是非正片；2是微电影
	 */
	private synchronized void getPositiveData(
			final String c,
			final int p,
			final int s,
			final int inc,
			final int tvt) {
		final AsyncHttpClient client = HttpClientUtils.getClient();
		final RequestParams params = new RequestParams();
		params.put("qd", "18805");
		params.put("c", c);
		params.put("p", p);
		params.put("s", s);
		params.put("inc", inc);
		params.put("tp", "json");
		params.put("tvt", tvt);
		client.get("http://info.lm.tv.sohu.com/a.do",params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				int int1 = UserJSON.getInt(jsonObject, "c");
				List<VideoEntity> videoEntities = UserJSON.parsUser(VideoEntity.class, jsonObject, "r");
				Message msg = new Message();
				msg.obj = videoEntities;
				msg.what = ZOO;
				msg.arg1 = tvt;
				handler.handleMessage(msg);
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] b, Throwable arg3) {
				
			}
		});
	}
	/**
	 * http://info.lm.tv.sohu.com/a.do?qd=18805&c=101&p=1&s=20&inc=1
	    @param qd	Int	是		主渠道用主渠道号，子渠道用子渠道号
		@param c	Int	否		电视101 动漫115 综艺106 音乐121 新闻122 娱乐112
		@param p	Int	否	1	分页用，页码
		@param s	Int	否	20	每页取回条数
		@param inc	Int	否	1	是否增量获取。1：增量获取；0：全部视频。建议：第一次获取全量，以后增量获取，速度更快
		@param tp	String	否	json	数据格式。json xml
		@param tvt	int	否	0	0是正片；1是非正片；2是微电影
	 */
	private synchronized void getMicroFilmData(
			final String c,
			final int p,
			final int s,
			final int inc,
			final int tvt) {
		final AsyncHttpClient client = HttpClientUtils.getClient();
		final RequestParams params = new RequestParams();
		params.put("qd", "18805");
		params.put("c", c);
		params.put("p", p);
		params.put("s", s);
		params.put("inc", inc);
		params.put("tp", "json");
		params.put("tvt", tvt);
		client.get("http://info.lm.tv.sohu.com/a.do",params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				int int1 = UserJSON.getInt(jsonObject, "c");
				List<VideoEntity> videoEntities = UserJSON.parsUser(VideoEntity.class, jsonObject, "r");
				Message msg = new Message();
				msg.obj = videoEntities;
				msg.what = TWO;
				msg.arg1 = tvt;
				handler.handleMessage(msg);
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] b, Throwable arg3) {
				
			}
		});
	}
	private ZhaoYaoAdapter<VideoEntity> listMicroFilmAdapter;
	private ZhaoYaoAdapter<VideoEntity> listpositiveAdapter;
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		VideoEntity entity = (VideoEntity) parent.getItemAtPosition(position);
		Intent intent = new Intent();
		intent.setClass(mContext, VideoWebViewPlayer.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable("VideoEntity", entity);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	/**有米广告
	 * 设置广告条广告
	 */
	private void setupBannerAd() {
		
		
//		ll_video_fragment_tv.addView(adView);
//		ll_video_fragment_tv.removeView(adView);
//		ll_video_fragment_tv.addView(getAdView());
//		ll_video_fragment_tv.addView(adView, ll_video_fragment_tv.getChildCount());
	}
}
