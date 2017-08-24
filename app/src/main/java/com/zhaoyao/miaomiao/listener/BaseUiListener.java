package com.zhaoyao.miaomiao.listener;

import org.json.JSONObject;

import android.content.Context;

import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zhaoyao.miaomiao.App;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.UserJSON;

public class BaseUiListener implements IUiListener {

	private UserInfo mInfo;
	protected void doComplete(JSONObject values) {
		System.out.println(values);
		Tencent mTencent = Tencent.createInstance("1105184875", App.getApplication());
//		updateUserInfo(App.getApplication(), mTencent);
//		 mInfo = new UserInfo(App.getApplication(), UserJSON.getString(values, ""));
         mInfo.getUserInfo(listener);  
//		getUserInfo();
	}
	public void getUserInfo()
	{
		Tencent mTencent = Tencent.createInstance("1105184875", App.getApplication());
	mTencent.requestAsync(Constants.GRAPH_NICK_TIPS, null,
	Constants.HTTP_GET, new BaseApiListener(null, false),
	null);
	}
	@Override
	public void onError(UiError e) {
		// showResult("onError:", "code:" + e.errorCode + ", msg:"
		// + e.errorMessage + ", detail:" + e.errorDetail);
		 MMLog.i(e);
	}

	@Override
	public void onCancel() {
		// showResult("onCancel", "");
	}

	@Override
	public void onComplete(Object response) {
		doComplete(UserJSON.getJSONObject(response.toString()));		
	}
	  IUiListener listener = new IUiListener() {  
          @Override  
          public void onError(UiError e) {  
          }  

          @Override  
          public void onComplete(final Object response) {  
              JSONObject json = (JSONObject) response;  
              MMLog.i(json);
          }  

          @Override  
          public void onCancel() {  

          }  
      }; 
	private void updateUserInfo(Context context,Tencent mTencent) {  
        if (mTencent != null && mTencent.isSessionValid()) {  
            IUiListener listener = new IUiListener() {  
                @Override  
                public void onError(UiError e) {  
                }  
  
                @Override  
                public void onComplete(final Object response) {  
                    JSONObject json = (JSONObject) response;  
                   MMLog.i(json);
                }  
  
                @Override  
                public void onCancel() {  
  
                }  
            };  
            mInfo = new UserInfo(context, mTencent.getQQToken());
            mInfo.getUserInfo(listener);  
  
        } else {  
        }  
    }  
}
