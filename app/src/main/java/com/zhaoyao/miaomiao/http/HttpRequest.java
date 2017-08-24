package com.zhaoyao.miaomiao.http;

import java.util.Map;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.os.Build;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.util.HttpClientUtils;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class HttpRequest {
	public static final char POST = 'p';
	public static final char GET = 'g';
	private HttpChildInterface httpRequestInterface;
	
	public HttpChildInterface getHttpRequestInterface() {
		return httpRequestInterface;
	}

	public void setHttpRequestInterface(HttpChildInterface httpRequestInterface2) {
		this.httpRequestInterface = httpRequestInterface2;
	}

	public void startRequest(char i,final int type,String url,AsyncHttpClient client) {
		client.get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				try {
					JSONObject jsonObject = new JSONObject(s);
					Result result = null;
					if(type==1){
					 result = Result.resultFromJSON(jsonObject,1,"showapi_res_body");
					}else if (type==2) {
						result = Result.resultFromJSON(jsonObject,2,"retData");
					}
					httpRequestInterface.completeResult(true,result);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				httpRequestInterface.completeResult(false,null);
			}
		});
	}
	/**所有的网络请求
	 * 
	 * @param i  {@link #POST}{@link #GET}
	 * @param url   {@linkplain# GlobalConstantUtil()}
	 * @param httpRequestInterface  {@linkplain# HttpChildInterface()}
	 * @param client {@linkplain# HttpChildInterface()}}
	 */
	public void startRequest(char i,final String url,final HttpChildInterface httpRequestInterface,final AsyncHttpClient client) {
		startRequest(i, url, UserRequest.getRequestParams(), httpRequestInterface, client);
	}
	
	/**
	 * *所有的网络请求
	 * @param i  {@link #POST}{@link #GET}
	 * @param url   {@linkplain# GlobalConstantUtil()}
	 * @param params {@linkplain# UserRequest()}
	 * @param httpRequestInterface  {@linkplain# HttpChildInterface()}
	 * @param client {@linkplain# AsyncHttpClient()}}
	 */
	public void startRequest(final char i,final String url,final RequestParams params,final HttpChildInterface httpRequestInterface,final AsyncHttpClient client) {
		if(i==GET)
		client.get(url,params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				httpRequestInterface.complete(true, new String(b));
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] b, Throwable arg3) {
				httpRequestInterface.complete(false, new String(b));
			}
		});
		if(i==POST)
			client.post(url, params, new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int arg0, Header[] arg1, byte[] b) {
					httpRequestInterface.complete(true, new String(b));
				}
				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] b, Throwable arg3) {
					httpRequestInterface.complete(false, new String(b));
				}
			});
	}
}
