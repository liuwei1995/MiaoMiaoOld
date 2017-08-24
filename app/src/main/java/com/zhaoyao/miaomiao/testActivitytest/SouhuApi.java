package com.zhaoyao.miaomiao.testActivitytest;


public class SouhuApi {
	/**
	 * 一级分类:http://open.mb.hd.sohu.com/v4/category/pgc.json?partner=18805&api_key=a6719304d387489c3f6b54a56e9f7e87
	 */
	/**
	 * {"status":200,"statusText":"OK","data":[{"cate_id":7,"cate_code":106,"cate_name":"综艺"},{"cate_id":8,"cate_code":107,"cate_name":"纪录片"},{"cate_id":16,"cate_code":115,"cate_name":"动漫"},{"cate_id":21,"cate_code":119,"cate_name":"教育"},{"cate_id":24,"cate_code":121,"cate_name":"音乐"},{"cate_id":27,"cate_code":124,"cate_name":"原创"},{"cate_id":28,"cate_code":125,"cate_name":"运动健身"},{"cate_id":29,"cate_code":126,"cate_name":"汽车"},{"cate_id":30,"cate_code":127,"cate_name":"科技"},{"cate_id":31,"cate_code":128,"cate_name":"游戏"},{"cate_id":32,"cate_code":129,"cate_name":"小知识"},{"cate_id":33,"cate_code":130,"cate_name":"星尚"},{"cate_id":34,"cate_code":131,"cate_name":"旅游"},{"cate_id":35,"cate_code":132,"cate_name":"母婴"},{"cate_id":36,"cate_code":133,"cate_name":"搞笑"},{"cate_id":89,"cate_code":190,"cate_name":"时尚"},{"cate_id":91,"cate_code":192,"cate_name":"其他"},{"cate_id":95,"cate_code":194,"cate_name":"家庭"},{"cate_id":103,"cate_code":202,"cate_name":"娱乐八卦"},{"cate_id":105,"cate_code":204,"cate_name":"公开课"},{"cate_id":106,"cate_code":205,"cate_name":"舞蹈"},{"cate_id":107,"cate_code":206,"cate_name":"时尚美妆"},{"cate_id":109,"cate_code":208,"cate_name":"做饭"},{"cate_id":110,"cate_code":209,"cate_name":"健康养生"},{"cate_id":111,"cate_code":210,"cate_name":"学习考试"}]}
	 */
	
	/**
	* 二级分类:http://open.mb.hd.sohu.com/v4/category/catecode/36.json?api_key=a6719304d387489c3f6b54a56e9f7e87
	/
	 /**
	 *
	 * {"status":200,"statusText":"OK","data":[{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133100","second_cate_name":"疯狂恶搞"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133101","second_cate_name":"自拍"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133102","second_cate_name":"激萌动物"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133103","second_cate_name":"美女"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133104","second_cate_name":"原创综合"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133105","second_cate_name":"分享"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133106","second_cate_name":"猎奇"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133107","second_cate_name":"搞笑综合"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133108","second_cate_name":"囧人糗事"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133109","second_cate_name":"逗乐熊娃"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133110","second_cate_name":"国外搞笑"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133111","second_cate_name":"萌宠"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133113","second_cate_name":"恶搞吐槽"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133122","second_cate_name":"熊娃萌宠"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133126","second_cate_name":"混剪配音/穿帮"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133112","second_cate_name":"原创短剧"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133123","second_cate_name":"奇闻趣事"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133114","second_cate_name":"街头整蛊"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133115","second_cate_name":"单口相声"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133116","second_cate_name":"脱口秀"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133125","second_cate_name":"搞笑动画"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133117","second_cate_name":"对口相声"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133118","second_cate_name":"群口相声"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133119","second_cate_name":"小品"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133120","second_cate_name":"曲艺"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133121","second_cate_name":"其他"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133127","second_cate_name":"街访"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133128","second_cate_name":"音乐歪唱"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133124","second_cate_name":"相声小品"},{"first_cate_code":"36","first_cate_name":"搞笑","second_cate_code":"133129","second_cate_name":"萌宠"}]}
	 */
//	分类内容获取 :http://open.mb.hd.sohu.com/v4/category/channel/36.json?page=1&api_key=a6719304d387489c3f6b54a56e9f7e87
//	is_pgc
// 	除cid=9004外，需要is_pgc=1
//	PlayVideoHelper.playSohuOnlineVideo(MoreTestActivity.this, aid, vid, site, startposition);
	/**
	 * 
	 * 
	 */
	/**
	 *http://open.mb.hd.sohu.com/v4/category/channel/36.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page=1&is_pgc=1

	 */
	//专辑详情:	
//	http://open.mb.hd.sohu.com/v4/album/info/36.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page=1
	//关键字搜索:http://open.mb.hd.sohu.com/v4/search/keyword.json?key=第一次&api_key=a6719304d387489c3f6b54a56e9f7e87&page=1&page_size=1
	//分集列表:
	//http://open.mb.hd.sohu.com/v4/album/videos/1000000561936.json?api_key=a6719304d387489c3f6b54a56e9f7e87&page=1

}
