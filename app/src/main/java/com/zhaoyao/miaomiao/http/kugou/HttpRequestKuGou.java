package com.zhaoyao.miaomiao.http.kugou;

import org.apache.http.Header;

import android.annotation.TargetApi;
import android.os.Build;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.http.HttpChildInterface;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class HttpRequestKuGou {
	private HttpChildInterface paseResult;

	public HttpChildInterface getPaseResult() {
		return paseResult;
	}

	public void setPaseResult(HttpChildInterface paseResult) {
		this.paseResult = paseResult;
	}

	public void startRequest(String url,RequestParams params,AsyncHttpClient client) {
		client.get(url,params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				ResultKuGou result = ResultKuGou.paseResult(s);
				paseResult.completeKuGouResultResult(true, result);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				paseResult.completeKuGouResultResult(false,null);
			}
		});
	}
	public void startRequest(String url,AsyncHttpClient client) {
		client.get(url,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				ResultKuGou result = ResultKuGou.paseResult(s);
				paseResult.complete(true, s);
//				paseResult.completeKuGouResultResult(true,result);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
//				paseResult.completeKuGouResultResult(false,null);
				paseResult.complete(false,null);
			}
		});
	}
}
