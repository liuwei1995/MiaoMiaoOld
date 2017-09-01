package com.zhaoyao.miaomiao.fragment.video;

import java.util.List;

import org.json.JSONObject;

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

import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.activity.video.VideoWebViewPlayer;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.controller.video.VideoController;
import com.zhaoyao.miaomiao.controller.video.VideoController.VideoListener;
import com.zhaoyao.miaomiao.entity.video.VideoEntertainmentEntity;
import com.zhaoyao.miaomiao.entity.video.VideoEntity;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

@SuppressLint("ValidFragment")
public class VideoEntertainmentFragment  extends Fragment implements OnItemClickListener{
	private Context mContext;
	private GridView gridViewpositive;
	private GridView gridViewMicro_film;
	private View item_positive;
	private View item_micro_film;
	public VideoEntertainmentFragment(Context context) {
		mContext = context;
	}
	private ZhaoYaoAdapter<VideoEntertainmentEntity> listpositiveAdapter;
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
				List<VideoEntertainmentEntity> listpositive = (List<VideoEntertainmentEntity>) msg.obj;
				setlistpositiveAdapter(listpositive);
				break;
			case ONE:
				
				break;
			case TWO:
				List<VideoEntity> listMicroFilm = (List<VideoEntity>) msg.obj;
				setlistMicroFilmAdapter(listMicroFilm);
				break;
			default:
				break;
			}
		}

		private void setlistMicroFilmAdapter(List<VideoEntity> listMicroFilm) {
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
		}

	};
	private void setlistpositiveAdapter(List<VideoEntertainmentEntity> listpositive) {
		listpositiveAdapter = new ZhaoYaoAdapter<VideoEntertainmentEntity>(mContext, listpositive,  R.layout.video_item_fragment_tv) {
			@Override
			public void convert(ViewHolder helper, VideoEntertainmentEntity item) {
				helper.setImageByUrl(R.id.iv_video_item_fragment_tv_url, item.getBigPic());
				helper.setText(R.id.tv_video_item_fragment_tv_title, item.getTitle());
				helper.setText(R.id.tv_video_item_fragment_tv_content, item.getDesc());						
			}
		};
		gridViewpositive.setAdapter(listpositiveAdapter);
		ListViewHeightUtil.setListViewHeightBasedOnChildren(gridViewMicro_film);
		ll_video_fragment_tv.addView(item_positive);
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.video_fragment_tv, null);
		item_positive = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_positive, null);
		gridViewpositive = (GridView) item_positive.findViewById(R.id.gV_video_fragment_positive); 
		 item_micro_film = LayoutInflater.from(mContext).inflate(R.layout.video_item_fragment_micro_film, null);
		 gridViewMicro_film = (GridView) item_micro_film.findViewById(R.id.gV_video_fragment_Micro_film); 
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		gridViewpositive.setOnItemClickListener(this);
		gridViewMicro_film.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}
	private int frist = 0 ;
	private int p = 1;
	private int s = 20;
	public void fristClick() {
		if (frist==0) {
		get(p, s, 0, 0);
		}
		++frist;
	}
	private VideoController controller;
	private void get(final int p,
			final int s,final int inc,
			final int tvt) {
		if(controller==null)
		 controller = new VideoController();
		controller.getVideoData("112", p, s, 0, 0, new VideoListener() {
			@Override
			public void getData(boolean istrue, String s) {
				if(!istrue)return;
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				List<VideoEntertainmentEntity> list = UserJSON.parsUser(VideoEntertainmentEntity.class, jsonObject, "r");
				Message msg = new Message();
				msg.obj = list;
				msg.what = ZOO;
				handler.handleMessage(msg);
			}
		});
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		VideoEntertainmentEntity entity = (VideoEntertainmentEntity) parent.getItemAtPosition(position);
		Intent intent = new Intent();
		intent.setClass(mContext, VideoWebViewPlayer.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable("VideoEntertainmentEntity", entity);
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
