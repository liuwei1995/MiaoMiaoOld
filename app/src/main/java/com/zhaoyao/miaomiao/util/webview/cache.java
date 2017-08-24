package com.zhaoyao.miaomiao.util.webview;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zhaoyao.miaomiao.util.net;
/**
 * LOAD_CACHE_ONLY:  不使用网络，只读取本地缓存数据
LOAD_DEFAULT:  根据cache-control决定是否从网络上取数据。
LOAD_CACHE_NORMAL: API level 17中已经废弃, 从API level 11开始作用同LOAD_DEFAULT模式
LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
如：www.taobao.com的cache-control为no-cache，在模式LOAD_DEFAULT下，无论如何都会从网络上取数据，如果没有网络，就会出现错误页面；在LOAD_CACHE_ELSE_NETWORK模式下，无论是否有网络，只要本地有缓存，都使用缓存。本地没有缓存时才从网络上获取。
www.360.com.cn的cache-control为max-age=60，在两种模式下都使用本地缓存数据。


总结：根据以上两种模式，建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT，无网络时，使用LOAD_CACHE_ELSE_NETWORK。


 * @author liuwei
 *
 */
public class cache {
	private Context mContext;
	public cache(Context context) {
		mContext =context;
	}
	private load load;
	
	public load getLoad() {
		return load;
	}
	public void setLoad(load load) {
		this.load = load;
	}

	public interface load{
		public void onLoadResource(WebView view, String url);
		/**开始加载网页*/
		public	void shouldOverrideUrlLoading();
		public boolean loadUrl();
		/**显示加载界面 */
		public	void onPageStarted();
		/**隐藏加载界面  */
		public	void onPageFinished();
		/**隐藏加载界面 */
		public	void onReceivedError();
		public	void onJsAlert(WebView view, String url, String message, JsResult result);
	}
//	private WebView mWebView;
	public cache findView(WebView mWebView,final ProgressBar progressBar) { 
//        tv_topbar_title = (TextView) findViewById(R.id.tv_topbar_title); 
//           
//        rl_loading = (RelativeLayout) findViewById(R.id.rl_loading); 
//           
//        mWebView = (WebView) findViewById(R.id.mWebView); 
           
		 mWebView = initWebView(mWebView); 
        mWebView.setWebViewClient(new WebViewClient() { 
            @Override 
            public void onLoadResource(WebView view, String url) { 
                super.onLoadResource(view, url); 
                if(load!=null)
                	load.onLoadResource(view, url);
            } 
   
            @Override 
            public boolean shouldOverrideUrlLoading(WebView webview, String url) { 
                webview.loadUrl(url); 
                if(load!=null)
                	load.shouldOverrideUrlLoading();
                return true; 
            } 
   
            @Override 
            public void onPageStarted(WebView view, String url, Bitmap favicon) { 
            	if(load!=null)
            	load.onPageStarted();
                progressBar.setVisibility(View.VISIBLE); // 显示加载界面 
            } 
   
            @Override 
            public void onPageFinished(WebView view, String url) { 
            	if(load!=null)
            		load.onPageFinished();
//                String title = view.getTitle(); 
//                System.out.println(title);
   
//                tv_topbar_title.setText(title); 
//                tv_topbar_title.setVisibility(View.VISIBLE); 
//   
                progressBar.setVisibility(View.GONE); // 隐藏加载界面 
            } 
   
            @Override 
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) { 
                progressBar.setVisibility(View.GONE); // 隐藏加载界面 
            		if(load!=null)
            			load.onReceivedError();
//                Toast.makeText(App.getApplication(), "", 
//                        Toast.LENGTH_LONG).show(); 
            } 
        }); 
   
        mWebView.setWebChromeClient(new WebChromeClient() { 
   
            @Override 
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) { 
            	if(load!=null)
            		load.onJsAlert(view, url, message, result);
   
//                Toast.makeText(App.getApplication(), message, Toast.LENGTH_SHORT).show(); 
   
                result.confirm(); 
   
                return true; 
            } 
   
            @Override 
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) { 
   
   
                return super.onJsConfirm(view, url, message, result); 
            } 
   
            @Override 
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) { 
   
   
                return super.onJsPrompt(view, url, message, defaultValue, result); 
            } 
        });
		return this; 
//        mWebView.loadUrl("http://www.baidu.com/"); 
//        mWebView.loadUrl("http://www.linxins.com/"); 
    } 
	/**
	 * http://www.linxins.com/
	 * <--->加载的网址
	 * @param url
	 * @return
	 */
//	public cache loadUrl(String url) {
//		if (mWebView==null) {
//			mWebView = new WebView(mContext);
//			mWebView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
//			findView(mWebView);
//		}
//		mWebView.loadUrl(url);
//		return this; 
//	}
	public WebView initWebView(WebView mWebView) { 
        mWebView.getSettings().setJavaScriptEnabled(true); 
        mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
        if (net.isNetworkAvailable(mContext)) {
        	mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);  //设置 缓存模式 
		}else {
			mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //设置 缓存模式 
		}
        // 开启 DOM storage API 功能 
        mWebView.getSettings().setDomStorageEnabled(true); 
        //开启 database storage API 功能 
        mWebView.getSettings().setDatabaseEnabled(true);  
        String cacheDirPath = mContext.getFilesDir().getAbsolutePath()+"store"; 
//      String cacheDirPath = getCacheDir().getAbsolutePath()+Constant.APP_DB_DIRNAME; 
        //设置数据库缓存路径 
        mWebView.getSettings().setDatabasePath(cacheDirPath); 
        //设置  Application Caches 缓存目录 
        mWebView.getSettings().setAppCachePath(cacheDirPath); 
        //开启 Application Caches 功能 
        mWebView.getSettings().setAppCacheEnabled(true);
        //可不要------------------------------------
        mWebView.setInitialScale(25);//为25%，最小缩放等级 
        // 设置可以支持缩放 
        mWebView.getSettings().setSupportZoom(true); 
        // 设置出现缩放工具 
//        mWebView.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        mWebView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.getSettings().setLoadWithOverviewMode(true);
		return mWebView; 
    }
       
    /**
     * 清除WebView缓存
     */ 
    public void clearWebViewCache(){ 
           
        //清理Webview缓存数据库 
//        try { 
//            deleteDatabase("webview.db");  
//            deleteDatabase("webviewCache.db"); 
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
           
        //WebView 缓存文件 
        File appCacheDir = new File(mContext.getFilesDir().getAbsolutePath()+"store"); 
           
        File webviewCacheDir = new File(mContext.getCacheDir().getAbsolutePath()+"/webviewCache"); 
           
        //删除webview 缓存目录 
        if(webviewCacheDir.exists()){ 
            deleteFile(webviewCacheDir); 
        } 
        //删除webview 缓存 缓存目录 
        if(appCacheDir.exists()){ 
            deleteFile(appCacheDir); 
        } 
    } 
       
    /**
     * 递归删除 文件/文件夹
     * 
     * @param file
     */ 
    public void deleteFile(File file) { 
        if (file.exists()) { 
            if (file.isFile()) { 
                file.delete(); 
            } else if (file.isDirectory()) { 
                File files[] = file.listFiles(); 
                for (int i = 0; i < files.length; i++) { 
                    deleteFile(files[i]); 
                } 
            } 
            file.delete(); 
        } else { 
        } 
    } 
   
}
