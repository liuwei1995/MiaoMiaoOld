package com.zhaoyao.miaomiao.adapter.Android;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.video.FullVideoActivity;
import com.android.video.widget.MediaHelp;
import com.android.video.widget.VideoSuperPlayer;
import com.android.video.widget.VideoSuperPlayer.VideoPlayCallbackImpl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.entity.neihanduanzi.NeiHanDuanZiRecommendedEntiry;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.ImageLoaderUtil;
import com.zhaoyao.miaomiao.util.UserJSON;

public class MAdapter extends BaseAdapter {
	private Context context;
	LayoutInflater inflater;
	private int indexPostion;
	private List<NeiHanDuanZiRecommendedEntiry> mList;
	public MAdapter(Context context,List<NeiHanDuanZiRecommendedEntiry> mList) {
		this.context = context;
		this.mList = mList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public NeiHanDuanZiRecommendedEntiry getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		GameVideoViewHolder holder = null;
		if (v == null) {
			holder = new GameVideoViewHolder();
			v = inflater.inflate(R.layout.list_video_item, parent, false);
			holder.mVideoViewLayout = (VideoSuperPlayer) v
					.findViewById(R.id.video);
			holder.mPlayBtnView = (ImageView) v.findViewById(R.id.play_btn);
			holder.iv_neihanduanzi = (ImageView) v.findViewById(R.id.iv_neihanduanzi);
			holder.info_title = (TextView) v.findViewById(R.id.info_title);
			v.setTag(holder);
		} else {
			holder = (GameVideoViewHolder) v.getTag();
		}
		holder.mPlayBtnView.setOnClickListener(new MyOnclick(
				holder.mPlayBtnView, holder.mVideoViewLayout, position));
		NeiHanDuanZiRecommendedEntiry item = mList.get(position);
		String type = item.getType();
		if("2".equals(type)){
			if (indexPostion == position) {
				holder.mVideoViewLayout.setVisibility(View.VISIBLE);
				holder.iv_neihanduanzi.setVisibility(View.GONE);
			} else {
				holder.mVideoViewLayout.setVisibility(View.GONE);
				holder.mVideoViewLayout.close();
			}
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
			ImageLoaderUtil.disPlay(url, holder.iv_neihanduanzi);
			holder.info_title.setText(item.getContent());
		}else{
			holder.mVideoViewLayout.setVisibility(View.GONE);
			holder.iv_neihanduanzi.setVisibility(View.VISIBLE);
			holder.mPlayBtnView.setVisibility(View.GONE);
			if("3".equals(type)){
				String media_type = item.getMedia_type();
				if("0".equals(media_type)){
					holder.iv_neihanduanzi.setVisibility(View.GONE);
					holder.info_title.setText(item.getContent());
				}else if ("1".equals(media_type)) {
					String large_image = item.getLarge_image();
					JSONObject jsonObject = UserJSON.getJSONObject(large_image);
					JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
					String url = "";
					for (int i = 0; i < jsonArray.length(); i++) {
						url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
						break;
					}
					ImageLoaderUtil.disPlay(url, holder.iv_neihanduanzi);
					holder.info_title.setText(item.getContent());
				}else if ("2".equals(media_type)) {

					String middle_image = item.getMiddle_image();
					JSONObject jsonObject = UserJSON.getJSONObject(middle_image);
					JSONArray jsonArray = UserJSON.getJSONArray(jsonObject, "url_list");
					String url = "";
					for (int i = 0; i < jsonArray.length(); i++) {
						url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
						break;
					}
					Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).placeholder(R.drawable.b_bgpic).into(holder.iv_neihanduanzi);
					holder.info_title.setText(item.getContent());
				}
			}else if ("4".equals(type)) {
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
					Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).placeholder(R.drawable.b_bgpic).into(holder.iv_neihanduanzi);
					holder.info_title.setText(item.getContent());
				}
			}else if ("5".equals(type)) {
				//二次元
				String media_type = item.getMedia_type();
				if("4".equals(media_type)){//奇葩卖家的二三事
					String large_image_list = item.getLarge_image_list();
					JSONArray jsonArray = UserJSON.getJSONArray(large_image_list);
					String url = "";
					for (int i = 0; i < jsonArray.length(); i++) {
						url = UserJSON.getString(UserJSON.getJSONObject(jsonArray, i), "url");
						break;
					}
					ImageLoaderUtil.disPlay(url, holder.iv_neihanduanzi);
					holder.info_title.setText(item.getContent());
				}else if ("5".equals(media_type)) {
					MMLog.i(media_type);
				}
			}
		}
		
		return v;
	}
	private boolean isPlaying;
	class MyOnclick implements OnClickListener {
		VideoSuperPlayer mSuperVideoPlayer;
		ImageView mPlayBtnView;
		int position;

		public MyOnclick(ImageView mPlayBtnView,
				VideoSuperPlayer mSuperVideoPlayer, int position) {
			this.position = position;
			this.mSuperVideoPlayer = mSuperVideoPlayer;
			this.mPlayBtnView = mPlayBtnView;
		}

		@Override
		public void onClick(View v) {
			MediaHelp.release();
			click.isClick(position, true);
			indexPostion = position;
			isPlaying = true;
			mSuperVideoPlayer.setVisibility(View.VISIBLE);
			mSuperVideoPlayer.loadAndPlay(MediaHelp.getInstance(), mList
					.get(position).getMp4_url(), 0, false);
			mSuperVideoPlayer.setVideoPlayCallback(new MyVideoPlayCallback(
					mPlayBtnView, mSuperVideoPlayer, mList.get(position)));
//			mSuperVideoPlayer.loadAndPlay(MediaHelp.getInstance(), mList
//					.get(position).getUrl(), 0, false);
//			mSuperVideoPlayer.setVideoPlayCallback(new MyVideoPlayCallback(
//					mPlayBtnView, mSuperVideoPlayer, mList.get(position)));
			notifyDataSetChanged();
		}
	}
	private click click;
	
public click getClick() {
		return click;
	}

	public void setClick(click click) {
		this.click = click;
	}

public interface click{
	void isClick(int position, boolean isPlaying);
}
	class MyVideoPlayCallback implements VideoPlayCallbackImpl {
		ImageView mPlayBtnView;
		VideoSuperPlayer mSuperVideoPlayer;
		NeiHanDuanZiRecommendedEntiry info;

		public MyVideoPlayCallback(ImageView mPlayBtnView,
				VideoSuperPlayer mSuperVideoPlayer, NeiHanDuanZiRecommendedEntiry info) {
			this.mPlayBtnView = mPlayBtnView;
			this.info = info;
			this.mSuperVideoPlayer = mSuperVideoPlayer;
		}

		@Override
		public void onCloseVideo() {
			closeVideo();
		}

		@Override
		public void onSwitchPageType() {
			if (((Activity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
				Intent intent = new Intent(new Intent(context,
						FullVideoActivity.class));
//				intent.putExtra("video", info);
				Bundle bundle = new Bundle();
				bundle.putParcelable("video", info);
				intent.putExtra("position",
						mSuperVideoPlayer.getCurrentPosition());
				((Activity) context).startActivityForResult(intent, 1);
			}
		}

		@Override
		public void onPlayFinish() {
			closeVideo();
		}

		private void closeVideo() {
			isPlaying = false;
			indexPostion = -1;
			mSuperVideoPlayer.close();
			MediaHelp.release();
			mPlayBtnView.setVisibility(View.VISIBLE);
			mSuperVideoPlayer.setVisibility(View.GONE);
		}

	}

	class GameVideoViewHolder {

		private VideoSuperPlayer mVideoViewLayout;
		private ImageView mPlayBtnView;
		private ImageView iv_neihanduanzi;
		private TextView info_title;

	}

}
