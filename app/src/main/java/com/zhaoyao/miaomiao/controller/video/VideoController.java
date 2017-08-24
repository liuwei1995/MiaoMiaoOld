package com.zhaoyao.miaomiao.controller.video;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.util.HttpClientUtils;

public class VideoController {
	public interface VideoListener{
		void getData(boolean istrue, String s);
	}
	/**
	  * http://info.lm.tv.sohu.com/a.do?qd=18805&c=101&p=1&s=20&inc=1
	    @param qd	Int	是		主渠道用主渠道号，子渠道用子渠道号
		@param c	Int	否		电视101 动漫115 综艺106 音乐121 新闻122 娱乐112
		@param p	Int	否	1	分页用，页码
		@param s	Int	否	20	每页取回条数
		@param inc	Int	否	1	是否增量获取。1：增量获取；0：全部视频。建议：第一次获取全量，以后增量获取，速度更快
		@param tp	String	否	json	数据格式。json xml
		@param tvt	int	否	0	0是正片；1是非正片；2是微电影
	 */
	public synchronized void getVideoData(
			final String c,
			final int p,
			final int s,
			final int inc,
			final int tvt,
			final VideoListener VideoListener) {
		final AsyncHttpClient client = HttpClientUtils.getClient();
		final RequestParams params = new RequestParams();
		params.put("qd", "18805");
		params.put("c", c);
		params.put("p", p);
		params.put("s", s);
		params.put("inc", inc);
		params.put("tp", "json");
		params.put("tvt", tvt);
		client.get("http://info.lm.tv.sohu.com/a.do",params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
//				JSONObject jsonObject = UserJSON.getJSONObject(s);
//				int int1 = UserJSON.getInt(jsonObject, "c");
//				List<VideoEntity> videoEntities = UserJSON.parsUser(VideoEntity.class, jsonObject, "r");
				VideoListener.getData(true, s);
			}
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] b, Throwable arg3) {
				VideoListener.getData(false, null);
			}
		});
	}
}
