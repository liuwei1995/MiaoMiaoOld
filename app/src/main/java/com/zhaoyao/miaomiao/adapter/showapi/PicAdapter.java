package com.zhaoyao.miaomiao.adapter.showapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.entity.showapi.PicModel;
import com.zhaoyao.miaomiao.util.ImageLoaderUtil;

import java.util.List;

public class PicAdapter extends BaseAdapter {
	private List<PicModel.ContentlistBean> listData;
	private Context mContext;
//	private FinalBitmap fb;
	private LayoutInflater mInflater;
	private ImageLoader imageLoader;
	
	public PicAdapter(Context context, List<PicModel.ContentlistBean> mData) {
		this.mInflater = LayoutInflater.from(context);
		this.mContext=context;
		this.listData = mData;
		imageLoader = ImageLoaderUtil.getImageLoader();
//		fb = FinalBitmap.create(context);//初始化FinalBitmap模块
//		fb.configLoadingImage(R.drawable.b_bgpic);
	}
	@Override
	public int getCount() {
		if(listData!=null){
			return listData.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if(listData!=null){
			return listData.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint({ "InflateParams", "ViewHolder" })
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.showapi_budejie_pic_item,null);
			holder.picView=(ImageView)convertView.findViewById(R.id.pic);
//			holder.picView=(ZdpImageView)convertView.findViewById(R.id.pic);
			holder.titleView=(TextView)convertView.findViewById(R.id.title);
			holder.timeView=(TextView)convertView.findViewById(R.id.time);
			holder.descriptionView=(TextView)convertView.findViewById(R.id.description);
			holder.relat=(LinearLayout)convertView.findViewById(R.id.relat);
			convertView.setTag(holder); 
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		Log.v("----lyyo---", mContext.getString(R.string.app_name));
		
		final String picpath = listData.get(position).getCdn_img();
		if(picpath.contains(".gif")){
			Glide.with(mContext).load(listData.get(position).getCdn_img()).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).placeholder(R.drawable.b_bgpic).into(holder.picView);
		}else{
			//Glide.with(mContext).load(listData.get(position).getImage()).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.b_bgpic).into(holder.picView);
//			fb.display(holder.picView, picpath);
			imageLoader.displayImage(picpath, holder.picView);
		}
		holder.titleView.setText(listData.get(position).getName());
		holder.descriptionView.setText(listData.get(position).getText());
		holder.timeView.setText(listData.get(position).getCreate_time()); 
		return convertView;
	}
	
	public final class ViewHolder {
		public ImageView picView;
//		public ZdpImageView picView;
		public TextView titleView;
		public TextView timeView;
		public TextView descriptionView;
		public ProgressBar viewrefresh;
		public LinearLayout relat;
	}
}
