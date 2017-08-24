package com.zhaoyao.miaomiao.util;

public class GlobalConstantUtil {
	private GlobalConstantUtil() {
	}
	private static GlobalConstantUtil util;
	public static GlobalConstantUtil getGlobalConstantUtil() {
		if(util==null)
		util = new GlobalConstantUtil();
		return util;
	}
	/**APP_ID*/
	public static final String WANDOUJIA_APP_ID = "100038288";
	/**key*/
	public static final String WANDOUJIA_SECRET_KEY = "7c9ee3d640ea86f11e6e5257da269038";
	/**banner */
	public static final String WANDOUJIA_BANNER = "0bceb08e99cc5d26e92b1bfa93a293bc";//banner 
	/**插屏广告*/
	public static final String WANDOUJIA_INTERSTITIAL = "9cb4c5c83f68d3417d6cf65f8d73fd14";//插屏广告
	/**广告墙*/
	public static final String WANDOUJIA_APP_WALL = "f6b1a6a9b22f863c7cd8238918325773";//广告墙
	/** 百度笑话连接 */
	public static final String baidu_joke_httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
	/** 阿凡达   笑话连接 */
	public static final String Dt_joke_httpUrl = "http://api.avatardata.cn/Joke/NewstImg";
	/** 百度身份证查询 */
	public static final String baidu_Id_query_httpUrl = "http://apis.baidu.com/apistore/idservice/id";
	/** 翻译 */
	public static final String baidu_translation_httpUrl = "http://apis.baidu.com/apistore/tranlateservice/translate";
	/** 实时新闻 */
	public static final String MusicService = "MusicService";
	public static final String baidu_Real_time_news_httpUrl = "http://apis.baidu.com/songshuxiansheng/news/news";
	public static final String Click_on_the_play_list = "Click_on_the_play_list";
	public static final String The_current_click_play = "The_current_click_play";
	public static final String Click_on_a_song_list = "Click_on_a_song_list";
	public static final String Click_on_the_next_song_list = "Click_on_the_next_song_list";
	public static final String Click_on_the_playlist = "Click_on_the_playlist";
	
	
	
	/**快退*/
	public static final int MUSIC_RETREAT_QUICKLY = 3;
	/**上一曲*/
	public static final int MUSIC_IN_A_SONG = 4;
	/**暂停*/
	public static final int MUSIC_SUSPENDED = 5;
	/**播放*/
	public static final int MUSIC_PLAY = 6;
	/**停止*/
	public static final int MUSIC_STOP = 7;
	/**下一曲*/
	public static final int MUSIC_THE_NEXT_SONG = 8;
	/**快进*/
	public static final int MUSIC_FAST_FORWARD = 9;
	public static final String ACTION_RECEIVER = "com.zhaoyao.miaomiao.service.PlayMusicService.PlayMusicReceiver";
}
