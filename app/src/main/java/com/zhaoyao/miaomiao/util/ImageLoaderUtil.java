/**
 * 文件名：ImageLoaderUtils.java
 * 全路径：com.smartgame.android.utils.ImageLoaderUtils
 */
package com.zhaoyao.miaomiao.util;

import android.app.Application;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedVignetteBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.zhaoyao.miaomiao.R;
/**
 * 
 * @author lw
 *
 */
public class ImageLoaderUtil {
	private static ImageLoader imageLoader = ImageLoader.getInstance();
	public static DisplayImageOptions options = new DisplayImageOptions.Builder()
	.showImageForEmptyUri(R.drawable.ic_launcher)
	.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
	.cacheOnDisc(true).build();
	public static void init(Application application) {
		setImageLoader(application);
	}
	public static  void setImageLoader(Application application) {// 初始化ImageLoader
		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.icon_stub) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.icon_empty) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.icon_error) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				// .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
				.build(); // 创建配置过得DisplayImageOption对象

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(application).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);}
	public static ImageLoader getImageLoader() {
		
		return imageLoader;
	}

	public static boolean checkImageLoader() {
		return imageLoader.isInited();
	}

	public static void disPlay(String uri, ImageAware imageAware, int defaultPic) {
		setOptions(defaultPic, new SimpleBitmapDisplayer());
		imageLoader.displayImage(uri, imageAware, options);
	}

	public static void disPlay(String uri, ImageView imageView, int defaultPic,
			ImageLoadingListener listener) {
		setOptions(defaultPic, new SimpleBitmapDisplayer());
		imageLoader.displayImage(uri, imageView, options, listener);
	}

	public static void disPlayRounded(String uri, ImageView imageView,
			int defaultPic, int cornerRadiusPixels,
			ImageLoadingListener listener) {
		setOptions(defaultPic, new RoundedVignetteBitmapDisplayer(
				cornerRadiusPixels, 2));
		imageLoader.displayImage(uri, imageView, options, listener);
	}

	public static void disPlay(String uri, ImageView imageView) {
		setOptions(0, new SimpleBitmapDisplayer());
		imageLoader.displayImage(uri, imageView, options);
	}

	/**
	 * 根据uri获取图片的bitmap
	 * 
	 * @param uri
	 *            图片的uri地址
	 * @param width
	 *            指定图片的最大宽度
	 * @param height
	 *            指定图片的最大高度
	 * @return
	 */
	public static Bitmap getImageBitmap(String uri, int width, int height) {
		setOptions(0, new SimpleBitmapDisplayer());
		ImageSize targetSize = new ImageSize(width, height); // result Bitmap
		return imageLoader.loadImageSync(uri, targetSize, options);
	}

	private static void setOptions(int defaultPic, BitmapDisplayer displayer) {
		options = new DisplayImageOptions.Builder()
				// .showImageOnLoading(defaultPic)
				.showImageOnLoading(R.drawable.touxiang)//正在加载时
				.showImageForEmptyUri(defaultPic).showImageOnFail(defaultPic)
				.cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.imageScaleType(ImageScaleType.EXACTLY).displayer(displayer)
				.build();
	}
	/***
	 * 
	 * @param defaultPic    0
	 * @return
	 */
	public static DisplayImageOptions getOptions(int defaultPic) {
		SimpleBitmapDisplayer displayer = new SimpleBitmapDisplayer();
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// .showImageOnLoading(defaultPic)
		.showImageOnLoading(R.drawable.touxiang)//正在加载时
		.showImageForEmptyUri(defaultPic).showImageOnFail(defaultPic)
		.cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.imageScaleType(ImageScaleType.EXACTLY).displayer(displayer)
		.build();
		return options;
	}
	/**
	 * DisplayImageOptions   options = new DisplayImageOptions.Builder()    
            .showStubImage(R.drawable.ic_stub)          // 设置图片下载期间显示的图片    
            .showImageForEmptyUri(R.drawable.ic_empty)  // 设置图片Uri为空或是错误的时候显示的图片    
            .showImageOnFail(R.drawable.ic_error)       // 设置图片加载或解码过程中发生错误显示的图片        
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中    
            .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中    
            .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片    
            .build();                                   // 创建配置过得DisplayImageOption对象   
  
    ImageLoader.getInstance().displayImage(url, imageView, options);  
    
     String imageUri = "http://site.com/image.png"; // 网络图片  
String imageUri = "file:///mnt/sdcard/image.png"; //SD卡图片  
String imageUri = "content://media/external/audio/albumart/13"; // 媒体文件夹  
String imageUri = "assets://image.png"; // assets  
String imageUri = "drawable://" + R.drawable.image; //  drawable文件  
     
	 */
	 /**{@link #init(ImageLoaderConfiguration)} method must be called before this method call  
     *  
     * @param uri       Image URI (i.e. "http://site.com/image.png", "file:///mnt/sdcard/image.png")  
     * @param imageView {@link ImageView} which should display image  
     * @param options   {@linkplain DisplayImageOptions Options} for image
     *                  decoding and displaying. If <b>null</b> - default display image options  
     *                  {@linkplain ImageLoaderConfiguration.Builder#defaultDisplayImageOptions(DisplayImageOptions)  
     *                  from configuration} will be used.  
     * @throws IllegalStateException    if {@link #init(ImageLoaderConfiguration)} method wasn't called before  
     * @throws IllegalArgumentException if passed <b>imageView</b> is null  
     */  
	public static void clear() {
		imageLoader.clearMemoryCache();
		imageLoader.clearDiskCache();
	}

	public static void clearAll() {
		clear();
	}

	public static void resume() {
		imageLoader.resume();
	}

	/**
	 * 暂停加载
	 */
	public static void pause() {
		imageLoader.pause();
	}

	/**
	 * 停止加载
	 */
	public static void stop() {
		imageLoader.stop();
	}

	/**
	 * 销毁加载
	 */
	public static void destroy() {
		imageLoader.destroy();
	}
	/**
	 * String imageUri = "http://site.com/image.png"; // 网络图片  
		String imageUri = "file:///mnt/sdcard/image.png"; //SD卡图片  
		String imageUri = "content://media/external/audio/albumart/13"; // 媒体文件夹  
		String imageUri = "assets://image.png"; // assets  
		String imageUri = "drawable://" + R.drawable.image; //  drawable文件
	 */
}
