package com.zhaoyao.miaomiao.activity.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.zhaoyao.miaomiao.util.webview.cache;
/**
 * 别忘记调: setWebView(WebView web)--------防止回退finish整个界面
 * @author liuwei
 *
 */
public  class WebViewActivity extends Activity {
	private WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	public WebViewActivity setWebView(WebView web,ProgressBar progressBar) {
		cache cache = new cache(this);
		cache.findView(web,progressBar);
		this.web = web;
		return this;
	}
	public void loadUrl(String url) {
		web.loadUrl(url);
	}
	@Override
    // 设置回退
    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (web!=null&&(keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
        	web.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }else {
			finish();
		}
        return super.onKeyDown(keyCode,event);
    }
}
