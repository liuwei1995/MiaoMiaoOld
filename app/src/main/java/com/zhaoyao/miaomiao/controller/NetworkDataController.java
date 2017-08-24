package com.zhaoyao.miaomiao.controller;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;

import com.zhaoyao.miaomiao.util.inject.TotalInterface;

public class NetworkDataController extends TotalInterface{
	private WebView web;
	public void initView(WebView web) {
		this.web = web;
		loadPage("http://www.linxins.com/");
	}
	private Activity context;
	public NetworkDataController(Context context) {
		this.context = (Activity) context;
	}
	@Override
	public void onClick(View v) {
		context.finish();
	}
	/**
     * 加载链接
     *
     * @param url 链接, 推荐不要使用短链接(多一次重定向)
     */
    private void loadPage(String url) {
        if (web != null && !TextUtils.isEmpty(url)) {
            web.loadUrl(url);
        }
    }
}
