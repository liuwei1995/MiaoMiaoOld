package com.zhaoyao.miaomiao.fragment.video;

import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.activity.video.VideoWebViewPlayer;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.controller.video.VideoController;
import com.zhaoyao.miaomiao.controller.video.VideoController.VideoListener;
import com.zhaoyao.miaomiao.entity.video.VideoEntity;
import com.zhaoyao.miaomiao.entity.video.VideoNewsEntity;
import com.zhaoyao.miaomiao.util.ListViewHeightUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

public class VideoNewsFragment  extends Fragment implements OnClickListener{
	private Context mContext;
	public VideoNewsFragment(Context context) {
		mContext = context;
	}
	private ZhaoYaoAdapter<VideoNewsEntity> listpositiveAdapter;
	@ViewInject(id = R.id.ll_video_fragment_tv)
	private LinearLayout ll_video_fragment_tv;
	@ViewInject(id = R.id.rl_video_fragment_tv_ProgressBar)
	private RelativeLayout rl_video_fragment_tv_ProgressBar;
	private ZhaoYaoAdapter<VideoEntity> listMicroFilmAdapter;
	private static final int ZOO = 0;
	private static final int TWO = 2;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				ll_video_fragment_tv.setVisibility(View.VISIBLE);
				rl_video_fragment_tv_ProgressBar.setVisibility(View.GONE);
				List<VideoNewsEntity> listpositive = (List<VideoNewsEntity>) msg.obj;
				setlistpositiveAdapter(listpositive);
				break;
			case TWO:
				break;
			default:
				break;
			}
		}
	};
	private ListView lv_souhu_listview;
	private View lv_souhu_listview_positive;
	private void setlistpositiveAdapter(List<VideoNewsEntity> listpositive) {
		listpositiveAdapter = new ZhaoYaoAdapter<VideoNewsEntity>(mContext, listpositive,  R.layout.video_shouhu_item_fragment_entertainment) {
			@Override
			public void convert(ViewHolder helper, final VideoNewsEntity item) {
				helper.setImageByUrl(R.id.iv_item_souhu_f_entertainment_pic, item.getBigPic());
				helper.setText(R.id.tv_item_souhu_f_entertainment_title, item.getTitle());
				helper.setText(R.id.tv_item_souhu_f_entertainment_content, item.getAlbumTitle());
				helper.getView(R.id.button1).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					Intent intent = new Intent();
					intent.setClass(mContext, VideoWebViewPlayer.class);
					Bundle bundle = new Bundle();
					bundle.putParcelable("VideoNewsEntity", item);
					intent.putExtras(bundle);
					startActivity(intent);
					}
				});
				helper.getView(R.id.button2).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						
					}
				});
			}
		};
		lv_souhu_listview.setAdapter(listpositiveAdapter);
		ListViewHeightUtil.setListViewHeightBasedOnChildren(lv_souhu_listview);
		ll_video_fragment_tv.addView(lv_souhu_listview_positive);
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.video_fragment_tv, null);
		lv_souhu_listview_positive = LayoutInflater.from(mContext).inflate(R.layout.souhu_listview, null);
		lv_souhu_listview = (ListView) lv_souhu_listview_positive.findViewById(R.id.lv_souhu_listview); 
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
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
		controller.getVideoData("122", p, s, 0, 0, new VideoListener() {
			@Override
			public void getData(boolean istrue, String s) {
				if(!istrue)return;
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				List<VideoNewsEntity> list = UserJSON.parsUser(VideoNewsEntity.class, jsonObject, "r");
				Message msg = new Message();
				msg.obj = list;
				msg.what = ZOO;
				handler.handleMessage(msg);
			}
		});
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			break;
		case R.id.button2:
			
			break;

		default:
			break;
		}
	}

}
