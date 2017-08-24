package com.zhaoyao.miaomiao.view.modelview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.controller.NetworkDataController;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
/**
 * 资料界面
 * @author liuwei
 *
 */
public class NetworkDataView extends RelativeLayout{
	@ViewInject(id = R.id.webView1)
	private WebView web;
	@ViewInject(id = R.id.pb_webview)
	private ProgressBar pb_webview;
	@ViewInject(id = R.id.button1,click ="doClick")
	private Button button1;
	private Context mContext;
	public NetworkDataView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext =context;
	}
	public WebView getWebView() {
		return web;
	}
	public ProgressBar getProgressBar() {
		return pb_webview;
	}
	public void init(View view) {
		new InjectView().Inject(view,new NetworkDataController(mContext));
//		cache cache = new cache(mContext);
//		cache.findView(web);
//		cache.loadUrl("http://www.linxins.com/");
	}
}
