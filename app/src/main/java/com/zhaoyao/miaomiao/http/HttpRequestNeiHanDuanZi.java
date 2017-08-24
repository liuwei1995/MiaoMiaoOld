package com.zhaoyao.miaomiao.http;

import org.apache.http.Header;

import android.annotation.TargetApi;
import android.os.Build;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class HttpRequestNeiHanDuanZi {
	public interface HttpRequestInterface{
		void complete(boolean istrue, Result result);
	}
	private HttpChildInterface httpRequestInterface;
	

	public HttpChildInterface getHttpRequestInterface() {
		return httpRequestInterface;
	}


	public void setHttpRequestInterface(HttpChildInterface httpRequestInterface) {
		this.httpRequestInterface = httpRequestInterface;
	}


	public void startRequest(String url,AsyncHttpClient client) {
		client.get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				ResultNeiHanDuanZi result = ResultNeiHanDuanZi.resultFromString(s);
				httpRequestInterface.completeNeiHanDuanZiResult(true,result);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				httpRequestInterface.completeNeiHanDuanZiResult(false, null);
			}
		});
	}
	public void startRequest(String url,RequestParams params,AsyncHttpClient client) {
		client.get(url, params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				ResultNeiHanDuanZi result = ResultNeiHanDuanZi.resultFromString(s);
				httpRequestInterface.completeNeiHanDuanZiResult(true,result);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				httpRequestInterface.completeNeiHanDuanZiResult(false, null);
			}
		});
	}
}
