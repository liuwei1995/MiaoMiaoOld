package com.zhaoyao.miaomiao.testActivitytest;
/**
 * 
* @author 作者 lw: 
* @version 创建时间：2016年4月9日 下午2:50:10 
* 类说明
 */
public class NeiHanDuanZiApi {
	private String name;
//https://github.com/waynell/VideoListPlayer
//	http://blog.csdn.net/jdsjlzx/article/category/1261130
	/**
	 * 
	 * @author 作者 lw: 
	 * @version 创建时间：2016年4月9日 下午2:47:33 
	 * 方法说明 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author 作者 lw: 
	 * @version 创建时间：2016年4月9日 下午2:47:33 
	 * 方法说明 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
/**推荐
 * http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-101&message_cursor=-1&longitude=103.97046307765&latitude=30.537909252575&bd_longitude=103.972881&bd_latitude=30.535335&bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973592&am_latitude=30.535797&am_city=成都市&am_loc_time=1460079951686&count=30&min_time=1460080033&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500 
 */
	/**
	 * http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-101&message_cursor=-1&longitude=103.9706489469&latitude=30.538027797579&bd_longitude=103.972854&bd_latitude=30.535304&bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973115&am_latitude=30.535486&am_city=成都市&am_loc_time=1460083812652&count=30&min_time=1460080239&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500
	 * http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-101&message_cursor=-1&am_loc_time=1460083812652&count=30&min_time=1460080239&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500
	 */
	
	
	
	/**
	 * http://mon.snssdk.com/monitor/settings/?latitude=30.537909252575&longitude=103.97046307765&city=成都市&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500
	 */
	/**
	 * {
  "message": "success",
  "data": {
    "dns_report_interval": 86400,
    "dns_report_list": [
      "a0.pstatp.com",
      "ib.snssdk.com",
      "log.snssdk.com"
    ],
    "api_report": [
      {
        "error_interval": 90,
        "pattern": "is.snssdk.com/2/article/v31/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "is.snssdk.com/2/article/v30/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "is.snssdk.com/2/article/v29/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "is.snssdk.com/2/article/v28/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "io.snssdk.com/2/article/v31/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "io.snssdk.com/2/article/v30/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "io.snssdk.com/2/article/v29/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "io.snssdk.com/2/article/v28/stream",
        "sample_ratio": 0.5,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/2/article/v31/stream",
        "sample_ratio": 0.01,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/2/article/v30/stream",
        "sample_ratio": 0.01,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/2/article/v29/stream",
        "sample_ratio": 0.01,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/2/article/v28/stream",
        "sample_ratio": 0.01,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "a0.pstatp.com/2/article",
        "sample_ratio": 0.0005,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "a2.pstatp.com/2/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a2.pstatp.com/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a1.pstatp.com/2/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a1.pstatp.com/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a3.pstatp.com/2/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a3.pstatp.com/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a6.pstatp.com/article",
        "sample_ratio": 0.0005,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a9.pstatp.com/article",
        "sample_ratio": 0.01,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "a5.pstatp.com/article",
        "sample_ratio": 0.01,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/service/2/app_log/",
        "sample_ratio": 0.0005,
        "report_server_error": 0
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/ttdiscuss/v1/commit/publish",
        "sample_ratio": 0.5,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/2/data/upload_image",
        "sample_ratio": 0.5,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "ichannel.snssdk.com/service/2/app_alert/",
        "sample_ratio": 0.5,
        "report_server_error": 1
      },
      {
        "error_interval": 90,
        "pattern": "snssdk.com/video/urls",
        "sample_ratio": 0.0005,
        "report_server_error": 1
       }
    ]
  }
}
	 */
	
	
	
	
	/**
	 * 视频

http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-103&message_cursor=-1&longitude=103.9706489469&latitude=30.538027797579&bd_longitude=103.972854&bd_latitude=30.535304&bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973115&am_latitude=30.535486&am_city=%E6%88%90%E9%83%BD%E5%B8%82&am_loc_time=1460083812652&count=30&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500


推荐:


http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-101&message_cursor=-1&longitude=103.97046307765&latitude=30.537909252575&bd_longitude=103.972881&bd_latitude=30.535335&bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973592&am_latitude=30.535797&am_city=成都市&am_loc_time=1460079951686&count=30&min_time=1460080033&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500

图片:
http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&longitude=103.9706489469&latitude=30.538027797579&bd_longitude=103.972854&bd_latitude=30.535304&bd_city=成都市&am_longitude=103.973115&am_latitude=30.535486&am_city=成都市&am_loc_time=1460083812652&count=30&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500

段子:
http://ic.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&longitude=103.97070974177&latitude=30.538032866568&bd_longitude=103.97288&bd_latitude=30.535317&bd_city=%E6%88%90%E9%83%BD%E5%B8%82&am_longitude=103.973115&am_latitude=30.535486&am_city=%E6%88%90%E9%83%BD%E5%B8%82&am_loc_time=1460083812652&count=30&min_time=1460084450&screen_width=720&iid=4035845517&device_id=12601379593&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=500&version_name=5.0.0&device_platform=android&ssmix=a&device_type=SCL-CL00&os_api=22&os_version=5.1.1&uuid=A0000055DDB626&openudid=7ea1d246a46f1b6e&manifest_version_code=500


http://aos.gw.youmi.net/banner/v4/di?s=000003e121845f890c17b1Uzq0N6afvzg-HboI1GUX-Bv3BqcfdDvGCeYms6kr3eITu337MGDnKzCzGL7OZjkOLbDLw24v4WUiy7k3xKobKYPTNuDGsDQuFcnHv2-y2hD2C8LbmXsWJUjOJHIL-DSGDaEuf3LuU_s3USQnWLnb_U3KAMT32CCvWdrKfvkv4_TvbOQaq-9TYywuozT25m4TrcTmi,iHUdk50CeW_lE-oh47OY2bKZYX8QUWT4AWM0XHYFc3VH3mzQQOzuwCrrDenHPOrgwujhMuDsEDok3usl0WZcM62U7ja8z2g1v2010mQLrL_UonGw4rFOb2wKISyEofkAfWldwbc9o3c54fSuz1hARBgphHWFxsnit4UMvO0EHOWUUv_NnAG1zI7WAsR8gEoQgujhMidt7vorPq3l-6j


http://track.dmp.youmi.net/v1/android/packages?rt=1460090862032&sign=fa3e799d234247c36d61b262661586d5

	 */
}
