package com.zhaoyao.miaomiao.util;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.cookie.Cookie;

import android.app.Application;
import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.zhaoyao.miaomiao.App;

public class HttpClientUtils {
	    private static AsyncHttpClient client = new AsyncHttpClient();
	    static {
	        // 设置链接超时，如果不设置，默认为10s
	        client.setTimeout(20*1000);
	    }

	    public static void get(String url, AsyncHttpResponseHandler responseHandler) {
	        client.get(url, responseHandler);

	    }

	    public static void get(Context context,String url,ResponseHandlerInterface responseHandler) {
	        client.get(context, url, responseHandler);

	    }

	    public static void get(String url,RequestParams params, ResponseHandlerInterface responseHandler) {
	        client.get(url, params, responseHandler);

	    }

	    public static void get(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
	        client.get(context, url, params, responseHandler);

	    }

	    public static void get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
	        client.get(context, url, headers, params, responseHandler);

	    }
	    public static void post(String url,RequestParams params, ResponseHandlerInterface responseHandler){
	        client.post(url, params, responseHandler);
	    }
	    public static void init(Application application) {
		}
	    public static AsyncHttpClient getClient(){
	        return client;
	    }
	    public static List<Cookie> getCookies(){
	    	return getCookieStore().getCookies();
	    }

	    public static void clearCookieStore() {
	    	new PersistentCookieStore(App.getApplication()).clear();
	    }
	    public static PersistentCookieStore getCookieStore() {
	    	return new PersistentCookieStore(App.getApplication());
	    }
	    public static void setCookieStore(PersistentCookieStore cookieStore) {
	        client.setCookieStore(cookieStore);
	    }
}
