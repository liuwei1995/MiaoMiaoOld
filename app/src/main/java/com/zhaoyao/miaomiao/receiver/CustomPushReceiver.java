package com.zhaoyao.miaomiao.receiver;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.xg.XGNotification;

public class CustomPushReceiver extends XGPushBaseReceiver {
	public static final String LogTag = "TPushReceiver"+CustomPushReceiver.class.getSimpleName();

	@Override
	public void onDeleteTagResult(Context context, int errorCode, String tagName) {
		if (context == null) {
			return;
		}
		String text = "";
		if (errorCode == XGPushBaseReceiver.SUCCESS) {
			text = "\"" + tagName + "\"删除成功";
		} else {
			text = "\"" + tagName + "\"删除失败,错误码：" + errorCode;
		}
		MMLog.d(LogTag, text);
//		show(context, text);

	}

		/**点击了通知栏*/
	// 通知点击回调 actionType=1为该消息被清除，actionType=0为该消息被点击
		@Override
		public void onNotifactionClickedResult(Context context,
				XGPushClickedResult message) {
			if (context == null || message == null) {
				return;
			}
			String text = "";
			if (message.getActionType() == XGPushClickedResult.NOTIFACTION_CLICKED_TYPE) {
				// 通知在通知栏被点击啦。。。。。
				// APP自己处理点击的相关动作
				// 这个动作可以在activity的onResume也能监听，请看第3点相关内容
				text = "通知被打开 :" + message;
			} else if (message.getActionType() == XGPushClickedResult.NOTIFACTION_DELETED_TYPE) {
				// 通知被清除啦。。。。
				// APP自己处理通知被清除后的相关动作
				text = "通知被清除 :" + message;
			}
//			Toast.makeText(context, "广播接收到通知被点击:" + message.toString(),
//					Toast.LENGTH_SHORT).show();
			// 获取自定义key-value
			String customContent = message.getCustomContent();
			if (customContent != null && customContent.length() != 0) {
				try {
					JSONObject obj = new JSONObject(customContent);
					// key1为前台配置的key
					if (!obj.isNull("key")) {
						String value = obj.getString("key");
						MMLog.d(LogTag, "get custom value:" + value);
					}
					// ...
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			// APP自主处理的过程。。。
			MMLog.d(LogTag, text);
//			show(context, text);
		}

	// 通知展示
		@Override
		public void onNotifactionShowedResult(Context context,
				XGPushShowedResult notifiShowedRlt) {
			if (context == null || notifiShowedRlt == null) {
				return;
			}
			XGNotification notific = new XGNotification();
			notific.setMsg_id(notifiShowedRlt.getMsgId());
			notific.setTitle(notifiShowedRlt.getTitle());
			notific.setContent(notifiShowedRlt.getContent());
			int notificationActionType = notifiShowedRlt.getNotificationActionType();
			if(notificationActionType==1){//Activity
				notific.setNotificationActionType(notifiShowedRlt
						.getNotificationActionType());
				// Activity,url,intent都可以通过getActivity()获得
				notific.setActivity(notifiShowedRlt.getActivity());
				notific.setUpdate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime()));
			}
			else if (notificationActionType==2) {//url
			}
			else if (notificationActionType==3) {//intent
				
			}
			// notificationActionType==1为Activity，2为url，3为intent
//			NotificationService.getInstance(context).save(notific);
//			context.sendBroadcast(intent);
//			show(context, "您有1条新消息, " + "通知被展示 ， " + notifiShowedRlt.toString());
		}

		@Override
		public void onRegisterResult(Context context, int errorCode,
				XGPushRegisterResult message) {
			// TODO Auto-generated method stub
			if (context == null || message == null) {
				return;
			}
			String text = "";
			if (errorCode == XGPushBaseReceiver.SUCCESS) {
				text = message + "注册成功";
				// 在这里拿token
				String token = message.getToken();
			} else {
				text = message + "注册失败，错误码：" + errorCode;
			}
			MMLog.d(LogTag, text);
//			show(context, text);
		}

	@Override
	public void onSetTagResult(Context context, int errorCode, String tagName) {
		if (context == null) {
			return;
		}
		String text = "";
		if (errorCode == XGPushBaseReceiver.SUCCESS) {
			text = "\"" + tagName + "\"设置成功";
		} else {
			text = "\"" + tagName + "\"设置失败,错误码：" + errorCode;
		}
		MMLog.d(LogTag, text);
//		show(context, text);

	}
	/**消息命令*/
	// 消息透传
		@Override
		public void onTextMessage(Context context, XGPushTextMessage message) {
			// TODO Auto-generated method stub
			String text = "收到消息:" + message.toString();
			// 获取自定义key-value
			String customContent = message.getCustomContent();
			if (customContent != null && customContent.length() != 0) {
				try {
					JSONObject obj = new JSONObject(customContent);
					// key1为前台配置的key
					if (!obj.isNull("key")) {
						String value = obj.getString("key");
						MMLog.d(LogTag, "get custom value:" + value);
					}
					// ...
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			// APP自主处理消息的过程...
			MMLog.d(LogTag, text);
//			show(context, text);
		}

	@Override
	public void onUnregisterResult(Context context, int errorCode) {
		if (context == null) {
			return;
		}
		String text = "";
		if (errorCode == XGPushBaseReceiver.SUCCESS) {
			text = "反注册成功";
		} else {
			text = "反注册失败" + errorCode;
		}
		MMLog.d(LogTag, text);
//		show(context, text);
	}
}

