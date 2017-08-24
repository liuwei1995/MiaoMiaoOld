package com.zhaoyao.miaomiao.listener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.tencent.tauth.IRequestListener;
import com.zhaoyao.miaomiao.log.MMLog;

/**
 * http://wiki.open.qq.com/wiki/%E5%88%9B%E5%BB%BA%E5%AE%
 * 9E%E4%BE%8B%E5%B9%B6%E5%AE%9E%E7%8E%B0%E5%9B%9E%E8%B0%83
 * 
 * @author dell
 * @Override protected void onActivityResult(int requestCode, int resultCode,
 *           Intent data) {
 *           Tencent.onActivityResultData(requestCode,resultCode,data,listener);
 *           }
 */
public class BaseApiListener implements IRequestListener {
	public BaseApiListener(String s, boolean is) {
		super();
	}

	@Override
	public void onComplete(JSONObject arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onConnectTimeoutException(ConnectTimeoutException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onHttpStatusException(HttpStatusException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onIOException(IOException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onJSONException(JSONException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onMalformedURLException(MalformedURLException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onNetworkUnavailableException(NetworkUnavailableException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onSocketTimeoutException(SocketTimeoutException arg0) {
		MMLog.i(arg0);
	}

	@Override
	public void onUnknowException(Exception arg0) {
		MMLog.i(arg0);
	}

}
