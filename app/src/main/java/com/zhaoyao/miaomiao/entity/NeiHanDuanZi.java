package com.zhaoyao.miaomiao.entity;
/**
 * 
 * 
* @author  作者 lw: 
* @version 创建时间：2016年4月10日上午10:48:05 
* 		        类说明 :
* {"message": "success",
*  "data": {"has_more": false, "tip": "30\u6761\u65b0\u5185\u5bb9", "has_new_message": true, "max_time": 1460247108, "min_time": 1460255808,
*  "data": [{"display_time": 1460255808, "group":"",  "online_time": 1460255808, "comments": [], "type": 1}]
 */
public class NeiHanDuanZi {
	/**data:{data:[display_time : 1460255808,online_time : 1460255808,group{},comments[]]}
	 * display_time : 1460255808
	 */
	
//	{"group;//  
//	{"text;//  ""
	private String neihan_hot_start_time;//  "00-00-00"
	
	
//  集合data{}-data[{group{},type=1,comments[]},{}]
//	--------3==category_name : "爆笑GIF  "media_type : 2，
//	media_type : 0 ，category_name : "内涵段子"   只有：content : "经常光顾的一家理发店，三天两头去洗头，时间久了就熟了，周年庆店里有充值活动，我主动要求办卡他们各种理由说办不了，后来发现别人办都给办，有点生气，就没在去，再后来听说那家理发店关门跑路了……"
//	group{type=3,dislike_reason,[],large_image{url_list[],},user{,,,},gifvideo{,,,},neihan_hot_link{null},middle_image{url_list[{}],}}-
//	gifvideo()--mp4_url : "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=480p&line=0&is_gif=1.mp4"
//	middle_image-- url_list[{url : "http://pb3.pstatp.com/w360/42700055c8d851c575a.webp"}]
//	large_image-- url_list[{url : "http://pb3.pstatp.com/w360/42700055c8d851c575a.webp"}]

//	comments[{status : 5}]
	
//  集合data{}-data[{group{},type=1,comments[null]},{}]--------4
//	group{type=4,thumb_list[],large_image{url_list[],},user{,,,},,middle_image{url_list[{}],}}-
//	gifvideo()--mp4_url : "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=480p&line=0&is_gif=1.mp4"
//	middle_image-- url_list[{url : "http://pb3.pstatp.com/w360/42700055c8d851c575a.webp"}]
//	group{title : "每日逗比视频：你猜我是谁家的啊！"}
//	comments[null]
	
	private String dislike_reason;
//	[
//	{"type;//  1private String id;//  308private String title;//  "\u513f\u7ae5"}, 
//	{"type;//  2private String id;//  10private String title;//  "\u5427:\u7206\u7b11GIF"}, 
//	{"type;//  4private String id;//  0private String title;//  "\u5185\u5bb9\u91cd\u590d"}, 
//	{"type;//  3private String id;//  6264696787private String title;//  "\u4f5c\u8005:\u8428\u74e6\u8fea\u5361\u4e36\u4e36"}
//	]
	
	private String create_time;//  1460110809
	private String id;//  6271006237
	private String favorite_count;//  3303
	private String go_detail_count;//  124653
	private String user_favorite;//  0
	private String share_type;//  1
	private String max_screen_width_percent;//  0.6
	private String is_can_share;//  1
	private String comment_count;//  2952
	private String share_url;//  "http://m.neihanshequ.com/share/group/6271006237/?iid=4035845517&app=joke_essay"
	private String label;//  1
	private String content;//  ""
	private String category_type;//  1
	private String id_str;//  "6271006237"
	private String media_type;//  2
	private String share_count;//  10849
	private String type;//  3
	private String status;//  112
	private String has_comments;//  1
	
	private String large_image;//  
//	{"width;//  360private String r_height;//  360private String r_width;//  360
//	private String url_list;//  
//	[{"url;//  "http://p10.pstatp.com/large/42700055c8d851c575a"}, 
//	{"url;//  "http://pb3.pstatp.com/large/42700055c8d851c575a"}, 
//	{"url;//  "http://pb3.pstatp.com/large/42700055c8d851c575a"}]
	
//	private String uri;//  "large/42700055c8d851c575a"
//	private String height;//  360}
	
	private String user_bury;//  0
	
	private String activity;//  {}
	
	private String status_desc;//  "\u70ed\u95e8\u6295\u7a3f"
	private String quick_comment;//  false
	
//	private String user;//  
//	{"user_id;//  6264696787private String name;//  "\u8428\u74e6\u8fea\u5361\u4e36\u4e36"
//	private String followings;//  0
//	private String ugc_count;//  19
//	private String avatar_url;//  "http://p2.pstatp.com/thumb/4110003304c84059312"
//	private String followers;//  80
//	private String is_following;//  false
//	private String user_verified;//  false}
	
	
	private String neihan_hot_end_time;//  "00-00-00"
	private String is_gif;//  1
	private String user_digg;//  0
	private String online_time;//  1460110809
	private String category_name;//  "\u7206\u7b11GIF"
	private String category_visible;//  true
	private String bury_count;//  1088
	private String is_anonymous;//  false
	private String repin_count;//  3303
	private String min_screen_width_percent;//  0.167
	private String is_neihan_hot;//  false
	private String digg_count;//  28163
	
	private String gifvideo;//  
	
//	{"360p_video;//  
//	{"width;//  360
//	private String url_list;//  
//	[{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=360p&line=0&is_gif=1"}, 
//	{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=360p&line=1&is_gif=1"}]
//	private String uri;//  "360p/326e6e6405754170aaa6c3c6bed230dc"
//	private String height;//  360}
	
	private String origin_video;//  
//	{"width;//  360
//	private String url_list;//  
//	[{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=origin&line=0&is_gif=1"}, 
//	{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=origin&line=1&is_gif=1"}]
//	private String uri;//  "origin/326e6e6405754170aaa6c3c6bed230dc"
//	private String height;//  360}
	
//	private String 720p_video;//  
//	{"width;//  360private String url_list;//  
//	[{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=720p&line=0&is_gif=1"}, 
//	{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=720p&line=1&is_gif=1"}]
//	private String uri;//  "720p/326e6e6405754170aaa6c3c6bed230dc"
//	private String height;//  360}
	
//	private String mp4_url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=480p&line=0&is_gif=1.mp4"
//	private String video_height;//  360
	
//	private String 480p_video;//  
//	{"width;//  360
//	private String url_list;//  
//	[{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=480p&line=0&is_gif=1"}, 
//	{"url;//  "http://i.snssdk.com/neihan/video/playback/?video_id=326e6e6405754170aaa6c3c6bed230dc&quality=480p&line=1&is_gif=1"}]
//	private String uri;//  "480p/326e6e6405754170aaa6c3c6bed230dc"
//	private String height;//  360}
//	private String cover_image_uri;//  "3e2000aa5622695c544"
//	private String duration;//  22.5
//	private String video_width;//  360}
	
	private String has_hot_comments;//  1
	private String allow_dislike;//  true
	private String image_status;//  1
	private String user_repin;//  0
	
	private String neihan_hot_link;//  {}
	
	private String group_id;//  6271006237
	
	private String middle_image;//  
//	{"width;//  360
//	private String r_height;//  360
//	private String r_width;//  360
//	private String url_list;//  
//	[{"url;//  "http://p10.pstatp.com/w360/42700055c8d851c575a.webp"},
//	{"url;//  "http://pb3.pstatp.com/w360/42700055c8d851c575a.webp"}, 
//	{"url;//  "http://pb3.pstatp.com/w360/42700055c8d851c575a.webp"}]
	private String uri;//  "w360/42700055c8d851c575a"
	private String height;//  360}
	private String category_id;//  10}
	
	
	private String comments;//  
//	[{"status;//  5private String user_profile_url;//  ""
//	private String is_digg;//  0private String user_id;//  5866887607
//	private String description;//  "\u5bc2\u5bde\u5982\u521d"
//	private String bury_count;//  0
//	private String avatar_url;//  "http://p2.pstatp.com/thumb/2b60010910cbdd168dd"
//	private String text;//  "\u963f\u59e8\uff0c\u4f60\u5e72\u561b\uff1f\u554a\u2026\u2026\u554a\u2026\u2026\u554a\uff0c\u6211\u6068\u6b7b\u4f60\u4e86"
//	private String user_verified;//  false
//	private String digg_count;//  4463
//	private String user_profile_image_url;//  "http://p2.pstatp.com/thumb/2b60010910cbdd168dd"
//	private String platform_id;//  "feifei"
//	private String platform;//  "feifei"
//	private String create_time;//  1460193243
//	private String user_digg;//  0
//	private String group_id;//  6271006237
//	private String user_name;//  "\u9633\u5149\u4e0e\u535c\u9e70"
//	private String id;//  6276403696
//	private String user_bury;//  0}]
	
	
//	private String type;//  1
//	private String display_time;//  1460255208
//	private String online_time;//  1460255208}, 
	 
}
