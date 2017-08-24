package com.zhaoyao.miaomiao.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.zhaoyao.miaomiao.App;
/**
 * 
* @author 作者 lw: 
* @version 创建时间：2016年4月9日 下午3:36:09 
* 类说明 :  图片加载   支持gif
 */
public class GlideUtil {
	private static GlideUtil glideUtil;
	private GlideUtil() {
	}
//	
	private static RequestManager with;
	@SuppressWarnings("static-access")
	public void Init(Context context) {
//		 MyGlideModule module = new MyGlideModule();
			Glide glide = Glide.get(context);
//			module.registerComponents(context, glide);
			with = glide.with(context);
//			with.load(url).asGif().into((ImageView) getView(viewId));
	}
	public static GlideUtil getGlideUtil() {
		if(glideUtil==null)
			glideUtil = new GlideUtil();
		return glideUtil;
	}
	public static RequestManager getRequestManager() {
		return with;
	}
	public static void disPlay(String imageUrl,ImageView imageView) {
//		第一种写法     推荐使用
		DrawableRequestBuilder<?> requestBuilder = Glide.with(App.getApplication()).load(
				imageUrl);
		requestBuilder.into(imageView);
//		第二种写法
//		Glide.with(context)
//	    .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
//	    .into(ivImg);
	}
}
