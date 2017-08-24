package com.zhaoyao.miaomiao.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.http.kugou.HttpRequestKuGou;
import com.zhaoyao.miaomiao.util.GlobalConstantUtil;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.location.MMLocation;

/**
 * 
 * @author liuwei
 *
 */
public class UserRequest {
	public static RequestParams getRequestParams() {
		RequestParams params = new RequestParams();
		return params;
	}
	/**
	 * 笑话获取
	 * @param page
	 * @param httpChildInterface
	 */
	public static void jokeRequest(int page,HttpChildInterface httpChildInterface) {
		HttpRequest httpRequest = new HttpRequest();
		httpRequest.setHttpRequestInterface(httpChildInterface);
		String url = GlobalConstantUtil.baidu_joke_httpUrl+"?"+"page="+page;
		AsyncHttpClient client = HttpClientUtils.getClient();
		client.addHeader("apikey", "161f2326254d1ccf4dd78e61b639f26c");
		httpRequest.startRequest(HttpRequest.GET,1,url,client);
	}
	/**
	 * 阿凡达笑话数据
	 * @param page
	 * @param httpChildInterface
	 * key=e6a3099f9ea3461ab831bc69d98ceb9f&page=2&rows=10
	 */
	public static void DTJokeRequest(RequestParams params,HttpChildInterface httpChildInterface) {
		HttpRequest httpRequest = new HttpRequest();
		String url = GlobalConstantUtil.Dt_joke_httpUrl;
		AsyncHttpClient client = HttpClientUtils.getClient();
		params.put("key", "e6a3099f9ea3461ab831bc69d98ceb9f");
		httpRequest.startRequest(HttpRequest.POST, url, params, httpChildInterface, client);
	}
	/**酷狗搜索
	 * http://mobilecdn.kugou.com/api/v3/search/song?format=jsonp&keyword=无语伦比的美丽&page=1&pagesize=30&showtype=1&callback=kgJSONP904378219
	 * http://mobilecdn.kugou.com/api/v3/search/song?format=jsonp&keyword=无语伦比的美丽&page=1&pagesize=30&showtype=1
	 * http://mobilecdn.kugou.com/api/v3/search/song?format=json&keyword=莫&page=2&pagesize=30&showtype=2
	 * @param url
	 * @param httpChildInterface
	 */
	public static synchronized void MusicSearch(final RequestParams params,final HttpChildInterface httpChildInterface) {
		HttpRequestKuGou httpRequest = new HttpRequestKuGou();
		httpRequest.setPaseResult(httpChildInterface);
		AsyncHttpClient client = HttpClientUtils.getClient();
		httpRequest.startRequest("http://mobilecdn.kugou.com/api/v3/search/song",params,client);
	}
	/**
	 * 酷狗歌曲下载地址获取地址
		http://m.kugou.com/app/i/getSongInfo.php?cmd=playInfo&hash=036e5d831c66e47a0d9682038efee224
	 */
	/**
	 * 酷狗搜索歌词API                    
		http://lyrics.kugou.com/search?ver=1&man=yes&client=pc&keyword=歌曲名&duration=歌曲总时长(毫秒)&hash=歌曲Hash值
		http://lyrics.kugou.com/search?ver=1&man=yes&client=pc&keyword=量身定制&hash=a07e3a55badf882e57de929ea53186b5
	 */
	/**
	 * 酷狗下载歌词API(红色参数通过搜索得到)
		http://lyrics.kugou.com/download?ver=1&client=pc&id=10515303&accesskey=3A20F6A1933DE370EBA0187297F5477D&fmt=lrc&charset=utf8 （fmt=lrc 或 krc）
		http://lyrics.kugou.com/download?ver=1&client=pc&id=19676934&accesskey=99C81A9F857344A71E13A8CBAFBD8705&fmt=lrc&charset=utf8 （fmt=lrc 或 krc）
	 */
	
	
	/**
	 * 内涵段子推荐
	 * @param params
	 * @param httpChildInterface
	 * http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&
	 * essence=1
	 * &content_type=-103
	 * &message_cursor=-1
	 * &longitude=103.9706489469&latitude=30.538027797579
	 * &bd_longitude=103.972854&bd_latitude=30.535304
	 * &bd_city=%E6%88%90%E9%83%BD%E5%B8%82
	 * &am_longitude=103.973115&am_latitude=30.535486
	 * &am_city=%E6%88%90%E9%83%BD%E5%B8%82
	 * &am_loc_time=1460083812652
	 * &count=30&screen_width=720&iid=4035845517
	 * &device_id=12601379593&ac=wifi&channel=ucad&aid=7
	 * &app_name=joke_essay&version_code=500
	 * &version_name=5.0.0&device_platform=android
	 * &ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1
	 * &uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500
	 */
	public static synchronized void neiHanDuanZiRecommended(final RequestParams params,final HttpChildInterface httpChildInterface) {
		HttpRequestNeiHanDuanZi duanZi = new HttpRequestNeiHanDuanZi();
		duanZi.setHttpRequestInterface(httpChildInterface);
		AsyncHttpClient client = HttpClientUtils.getClient();
		params.put("mpic", 1);
		params.put("webp", 1);
		params.put("essence", 1);
		params.put("content_type", -103);
		params.put("message_cursor", -1);
		params.put("am_loc_time", System.currentTimeMillis());
		params.put("iid", "4035845517");
		params.put("device_id", "12601379593");
		params.put("ac", "wifi");
		params.put("channel", "ucad");
		params.put("aid", 7);
		params.put("app_name", "joke_essay");
		params.put("version_code", "500");
		params.put("version_name", "5.0.0");
		params.put("device_platform", "android");
		params.put("ssmix", "a");
		params.put("device_type", "SCL-CL00");
		params.put("os_api", "22");
		params.put("os_version", "5.1.1");
		params.put("uuid", "A0000055DDB626");
		params.put("openudid", "7ea1d246a46f1b6e");
		params.put("manifest_version_code", "500");
		duanZi.startRequest("http://ic.snssdk.com/neihan/stream/mix/v1/",params, client);
	}
	/**
	 * 内涵段子视频
	 * http://ic.snssdk.com/neihan/stream/mix/v1/?
	 * mpic=1&webp=1&essence=1&content_type=-103
	 * &message_cursor=-1
	 * &longitude=103.9706489469&latitude=30.538027797579
	 * &bd_longitude=103.972854&bd_latitude=30.535304
	 * &bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973115
	 * &am_latitude=30.535486&am_city=%E6%88%90%E9%83%BD%E5%B8%82
	 * &am_loc_time=1460083812652&count=30
	 * &screen_width=720&iid=4035845517&device_id=12601379593
	 * &ac=wifi&channel=ucad&aid=7&app_name=joke_essay
	 * &version_code=500&version_name=5.0.0
	 * &device_platform=android&ssmix=a
	 * &device_type=SCL-CL00&os_api=22&os_version=5.1.1
	 * &uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e
	 * &manifest_version_code=500
	 * @param params
	 * @param httpChildInterface
	 */
	public static synchronized void neiHanDuanZiVideo(final RequestParams params,final HttpChildInterface httpChildInterface) {
		HttpRequestNeiHanDuanZi duanZi = new HttpRequestNeiHanDuanZi();
		duanZi.setHttpRequestInterface(httpChildInterface);
		AsyncHttpClient client = HttpClientUtils.getClient();
//		params.put("mpic", 1);
//		params.put("webp", 1);
//		params.put("essence", 1);
//		params.put("content_type", -103);
//		params.put("message_cursor", -1);
		params.put("am_loc_time", System.currentTimeMillis());
		params.put("am_latitude", MMLocation.getam_latitude());
		params.put("am_longitude", MMLocation.getam_longitude());
//		params.put("iid", "4035845517");
//		params.put("device_id", "12601379593");
//		params.put("ac", "wifi");
//		params.put("channel", "ucad");
		params.put("aid", 7);
//		params.put("app_name", "joke_essay");
//		params.put("version_code", "500");
//		params.put("version_name", "5.0.0");
//		params.put("device_platform", "android");
//		params.put("ssmix", "a");
//		params.put("device_type", "SCL-CL00");
//		params.put("os_api", "22");
//		params.put("os_version", "5.1.1");
//		params.put("uuid", "A0000055DDB626");
//		params.put("openudid", "7ea1d246a46f1b6e");
//		params.put("manifest_version_code", "500");
		params.put("count", "30");
		duanZi.startRequest("http://ic.snssdk.com/neihan/stream/mix/v1/",params, client);
	}
	/**
	 * http://ic.snssdk.com/neihan/stream/mix/v1/?count=30
	 */
}
