package com.zhaoyao.miaomiao.entity.showapi;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 图片的model
 * 
 * @author lenovo
 *
 */
public class PicModel implements Parcelable{

	/**
	 * allPages : 198
	 * contentlist : [{"text":"\n        赵本山女儿登纽约时代广场最贵广告牌，靠实力还是赵本山名气？\n    ","hate":"39","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26131449.html/",
	 * "profile_image":"http://tva4.sinaimg.cn/crop.0.0.996.996.50/e7f9e94djw8f6ursgyso3j20ro0rp0wy.jpg","width":"0","cdn_img":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 16:00:03.202","image0":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg",
	 * "id":"26131449","love":"79","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg","image1":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg",
	 * "height":"0","_id":"599e87836e3624e8497fbe54","name":"臭宝蛋蛋","create_time":"2017-08-24 16:00:03"},{"text":"\n        大概这就是专属父亲的片刻幸福吧！\n    ","hate":"54","videotime":"0","voicetime":"0",
	 * "weixin_url":"http://m.budejie.com/detail-26128291.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/06/27/577119b7d372e_mini.jpg","width":"0","cdn_img":"http://wimg
	 * .spriteapp.cn/ugc/2017/08/23/599d9ba69934d.gif","voiceuri":"","type":"10","ct":"2017-08-24 15:30:05.675","image0":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d9ba69934d.gif","id":"26128291",
	 * "love":"414","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d9ba69934d.gif","image1":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d9ba69934d.gif","height":"0",
	 * "_id":"599e807d6e3624e8497fbc6d","name":"黑皮咪咪眼","create_time":"2017-08-24 15:30:05"},{"text":"\n        七夕马上就要到了能帮你们的就这么多了，满满的都是套路\n    ","hate":"15","videotime":"0","voicetime":"0",
	 * "weixin_url":"http://m.budejie.com/detail-26123013.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/09/02/57c938cd5fcac_mini.jpg","width":"0","cdn_img":"http://wimg
	 * .spriteapp.cn/x/640x400/ugc/2017/08/23/599d1cce7a710_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 15:00:07.303","image0":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d1cce7a710_1.jpg","id":"26123013","love":"193","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d1cce7a710_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d1cce7a710_1.jpg","height":"0","_id":"599e79776e3624e8497faabb","name":"小公主梦","create_time":"2017-08-24 15:00:07"},{"text":"\n        给你个机会你最先撂倒哪个？\n    ",
	 * "hate":"32","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26127586.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/03/28/58d9cf7ba2de4_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d8c55c038a.gif","voiceuri":"","type":"10","ct":"2017-08-24 14:40:03.036","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d8c55c038a.gif","id":"26127586","love":"82","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d8c55c038a.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d8c55c038a.gif","height":"0","_id":"599e74c36e3624e8497faa7b","name":"幽默搞笑GIF图","create_time":"2017-08-24 14:40:03"},{"text":"\n        男朋友月薪20000，不肯请我吃哈根达斯，我该不该分手？\n
	 * ","hate":"42","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26125346.html/","profile_image":"http://tva4.sinaimg
	 * .cn/crop.0.0.996.996.50/e7f9e94djw8f6ursgyso3j20ro0rp0wy.jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d5538205ac_1.jpg","voiceuri":"","type":"10",
	 * "ct":"2017-08-24 14:20:03.193","image0":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d5538205ac_1.jpg","id":"26125346","love":"174","image2":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d5538205ac_1.jpg","image1":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d5538205ac_1.jpg","height":"0","_id":"599e70136e3624e8497fa36c","name":"臭宝蛋蛋",
	 * "create_time":"2017-08-24 14:20:03"},{"text":"\n        岛国最好看的10大校服排名！\n    ","hate":"19","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-23645706.html/",
	 * "profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/A11242E10033C510C274DF9E258921D4/100","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/02/13/58a1ac923e4b3_1.jpg","voiceuri":"",
	 * "type":"10","ct":"2017-08-24 14:20:03.236","image0":"http://wimg.spriteapp.cn/ugc/2017/02/13/58a1ac923e4b3_1.jpg","id":"23645706","love":"75","image2":"http://wimg.spriteapp
	 * .cn/ugc/2017/02/13/58a1ac923e4b3_1.jpg","image1":"http://wimg.spriteapp.cn/ugc/2017/02/13/58a1ac923e4b3_1.jpg","height":"0","_id":"599e70136e3624e8497fa36d","name":"§--§",
	 * "create_time":"2017-08-24 14:20:03"},{"text":"\n        台风\u201c天鸽\u201d来了! 今年第13号台风\u201c天鸽\u201d于23日白天在广东惠东到阳江一带沿海登陆，人像纸片被吹飞。\n    ","hate":"24","videotime":"0","voicetime":"0",
	 * "weixin_url":"http://m.budejie.com/detail-26122228.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/01/15/587b657be41a6_mini.jpg","width":"0","cdn_img":"http://wimg
	 * .spriteapp.cn/ugc/2017/08/23/599d0aa87051b.gif","voiceuri":"","type":"10","ct":"2017-08-24 13:50:02.852","image0":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d0aa87051b.gif","id":"26122228",
	 * "love":"81","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d0aa87051b.gif","image1":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d0aa87051b.gif","height":"0",
	 * "_id":"599e690a6e3624e8497f97fe","name":"爱你一次就好","create_time":"2017-08-24 13:50:02"},{"text":"\n        裤裆藏雷，手撕鬼子都是小意思，这部才是最雷人的抗日神剧\n    ","hate":"13","videotime":"0","voicetime":"0",
	 * "weixin_url":"http://m.budejie.com/detail-26122310.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/03/01/58b65d222c9a6_mini.jpg","width":"0","cdn_img":"http://wimg
	 * .spriteapp.cn/x/640x400/ugc/2017/08/23/599d0c8d25d48_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 13:30:06.527","image0":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d0c8d25d48_1.jpg","id":"26122310","love":"85","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d0c8d25d48_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d0c8d25d48_1.jpg","height":"0","_id":"599e645e6e3624e8497f966c","name":"南蛮之地","create_time":"2017-08-24 13:30:06"},{"text":"\n        据说王可可的日常生活是这样子的！\n    ",
	 * "hate":"16","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26124196.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/07/22/5973282f7d0c7_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d3a14817dc.gif","voiceuri":"","type":"10","ct":"2017-08-24 13:00:03.256","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d3a14817dc.gif","id":"26124196","love":"122","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d3a14817dc.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d3a14817dc.gif","height":"0","_id":"599e5d536e3624e8497f85f8","name":"夏小檬","create_time":"2017-08-24 13:00:03"},{"text":"\n        抗日神剧里的日本女间谍名册...竟然华丽丽地开车了\n    ",
	 * "hate":"18","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26093991.html/","profile_image":"http://tva4.sinaimg
	 * .cn/crop.0.0.996.996.50/e7f9e94djw8f6ursgyso3j20ro0rp0wy.jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/20/59995291602be_1.jpg","voiceuri":"","type":"10",
	 * "ct":"2017-08-24 12:30:06.487","image0":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/20/59995291602be_1.jpg","id":"26093991","love":"87","image2":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/20/59995291602be_1.jpg","image1":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/20/59995291602be_1.jpg","height":"0","_id":"599e564e6e3624e8497f8445","name":"臭宝蛋蛋",
	 * "create_time":"2017-08-24 12:30:06"},{"text":"\n        原来美国的烤鸭是这个样子的！哈哈哈哈~确定这不是唐老鸭么。。。\n    ","hate":"10","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie
	 * .com/detail-26122439.html/","profile_image":"http://qzapp.qlogo.cn/qzapp/100336987/A813AC08F9A24D622F36CD5D0FB4C570/100","width":"0","cdn_img":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d0f99cf9f3_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 12:00:04.516","image0":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d0f99cf9f3_1.jpg",
	 * "id":"26122439","love":"138","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d0f99cf9f3_1.jpg","image1":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d0f99cf9f3_1.jpg",
	 * "height":"0","_id":"599e4f446e3624e8497f72a4","name":"我是影阿","create_time":"2017-08-24 12:00:04"},{"text":"\n        如果你回到古代，你会选择哪款发型？ \u200b\u200b\u200b\u200b\n    ","hate":"62",
	 * "videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26124781.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/05/01/572555a248804_mini.jpg",
	 * "width":"0","cdn_img":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d47975edf6_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 11:40:02.052","image0":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d47975edf6_1.jpg","id":"26124781","love":"127","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d47975edf6_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d47975edf6_1.jpg","height":"0","_id":"599e4a926e3624e8497f7261","name":"菊花姐夫","create_time":"2017-08-24 11:40:02"},{"text":"\n        姐夫们好！我是不知火舞的妹妹...不知火奶！\n
	 * ","hate":"32","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26123420.html/","profile_image":"http://qzapp.qlogo
	 * .cn/qzapp/100336987/C41EBBDB0124106EE25437A120D1C334/100","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d27fb99c94.gif","voiceuri":"","type":"10","ct":"2017-08-24
	 * 11:10:03.314","image0":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d27fb99c94.gif","id":"26123420","love":"79","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d27fb99c94.gif",
	 * "image1":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d27fb99c94.gif","height":"0","_id":"599e438b6e3624e8497f6768","name":"求老天给我个妹子","create_time":"2017-08-24 11:10:03"},{"text":"\n
	 * 仙界也挺重口味的。。。\n    ","hate":"20","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-21515420.html/","profile_image":"http://wimg.spriteapp.cn/profile","width":"0",
	 * "cdn_img":"http://wimg.spriteapp.cn/ugc/2016/10/20/5808913d9d34f_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 10:50:03.337","image0":"http://wimg.spriteapp
	 * .cn/ugc/2016/10/20/5808913d9d34f_1.jpg","id":"21515420","love":"64","image2":"http://wimg.spriteapp.cn/ugc/2016/10/20/5808913d9d34f_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/ugc/2016/10/20/5808913d9d34f_1.jpg","height":"0","_id":"599e3edb6e3624e8497f6010","name":"百思小愤青","create_time":"2017-08-24 10:50:03"},{"text":"\n        有这么多钱真不知道该怎么花了，如果是你的话你会怎么用？！\n
	 * ","hate":"16","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26123891.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/12/26/586059118dd30_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d32ea9db50.gif","voiceuri":"","type":"10","ct":"2017-08-24 10:20:03.727","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d32ea9db50.gif","id":"26123891","love":"80","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d32ea9db50.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d32ea9db50.gif","height":"0","_id":"599e37d36e3624e8497f5955","name":"搞笑小村","create_time":"2017-08-24 10:20:03"},{"text":"\n        十五年前的你 VS 现在的你\n    ","hate":"40",
	 * "videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26118775.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2015/07/08/559d0cbd4667e_mini.jpg",
	 * "width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599cad39d6315_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 10:00:06.738","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599cad39d6315_1.jpg","id":"26118775","love":"207","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599cad39d6315_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599cad39d6315_1.jpg","height":"0","_id":"599e33266e3624e8497f4d16","name":"虎子哥08","create_time":"2017-08-24 10:00:06"},{"text":"\n        妹子长得蛮漂亮的，就是感觉少了点什么！\n    ",
	 * "hate":"16","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26127980.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/03/28/58d9cf7ba2de4_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d9535ac035.gif","voiceuri":"","type":"10","ct":"2017-08-24 09:30:08.451","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d9535ac035.gif","id":"26127980","love":"126","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d9535ac035.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d9535ac035.gif","height":"0","_id":"599e2c206e3624e8497f4b3c","name":"幽默搞笑GIF图","create_time":"2017-08-24 09:30:08"},{"text":"\n        当世金莲今尤在，楼下官人何时来？\n    ",
	 * "hate":"19","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26124374.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/03/10/58c2180891031_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d3e0667524.gif","voiceuri":"","type":"10","ct":"2017-08-24 09:10:01.981","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d3e0667524.gif","id":"26124374","love":"127","image2":"http://wimg.spriteapp.cn/ugc/2017/08/23/599d3e0667524.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/23/599d3e0667524.gif","height":"0","_id":"599e27696e3624e8497f41b7","name":"蛮夷阿涂","create_time":"2017-08-24 09:10:01"},{"text":"\n        嘿，骚年快醒醒啦，你好像坐过站了！\n    ","hate":"31",
	 * "videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26128875.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/04/20/58f8444f4074a_mini.jpg",
	 * "width":"0","cdn_img":"http://wimg.spriteapp.cn/ugc/2017/08/24/599da82e49834.gif","voiceuri":"","type":"10","ct":"2017-08-24 08:30:04.278","image0":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/24/599da82e49834.gif","id":"26128875","love":"128","image2":"http://wimg.spriteapp.cn/ugc/2017/08/24/599da82e49834.gif","image1":"http://wimg.spriteapp
	 * .cn/ugc/2017/08/24/599da82e49834.gif","height":"0","_id":"599e1e0c6e3624e8497f387c","name":"hguM","create_time":"2017-08-24 08:30:04"},{"text":"\n        追求8年仍被拒，90后海归男将姑娘一把拎起从19楼扔下\n    ",
	 * "hate":"48","videotime":"0","voicetime":"0","weixin_url":"http://m.budejie.com/detail-26124894.html/","profile_image":"http://wimg.spriteapp.cn/profile/large/2017/05/17/591c49f4775f9_mini
	 * .jpg","width":"0","cdn_img":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d4afa13128_1.jpg","voiceuri":"","type":"10","ct":"2017-08-24 08:30:04.239","image0":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d4afa13128_1.jpg","id":"26124894","love":"164","image2":"http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/23/599d4afa13128_1.jpg","image1":"http://wimg.spriteapp
	 * .cn/x/640x400/ugc/2017/08/23/599d4afa13128_1.jpg","height":"0","_id":"599e1e0c6e3624e8497f387b","name":"摸咪校尉","create_time":"2017-08-24 08:30:04"}]
	 * currentPage : 1
	 * allNum : 3946
	 * maxResult : 20
	 */

	private int allPages;
	private int currentPage;
	private int allNum;
	private int maxResult;
	private List<ContentlistBean> contentlist;

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public List<ContentlistBean> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<ContentlistBean> contentlist) {
		this.contentlist = contentlist;
	}

	public static class ContentlistBean implements Parcelable{

		/**
		 * text :
		 赵本山女儿登纽约时代广场最贵广告牌，靠实力还是赵本山名气？

		 * hate : 39
		 * videotime : 0
		 * voicetime : 0
		 * weixin_url : http://m.budejie.com/detail-26131449.html/
		 * profile_image : http://tva4.sinaimg.cn/crop.0.0.996.996.50/e7f9e94djw8f6ursgyso3j20ro0rp0wy.jpg
		 * width : 0
		 * cdn_img : http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg
		 * voiceuri :
		 * type : 10
		 * ct : 2017-08-24 16:00:03.202
		 * image0 : http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg
		 * id : 26131449
		 * love : 79
		 * image2 : http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg
		 * image1 : http://wimg.spriteapp.cn/x/640x400/ugc/2017/08/24/599e37281be09_1.jpg
		 * height : 0
		 * _id : 599e87836e3624e8497fbe54
		 * name : 臭宝蛋蛋
		 * create_time : 2017-08-24 16:00:03
		 */

		private String text;
		private String hate;
		private String videotime;
		private String voicetime;
		private String weixin_url;
		private String profile_image;
		private String width;
		private String cdn_img;
		private String voiceuri;
		private String type;
		private String ct;
		private String image0;
		private String id;
		private String love;
		private String image2;
		private String image1;
		private String height;
		private String _id;
		private String name;
		private String create_time;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getHate() {
			return hate;
		}

		public void setHate(String hate) {
			this.hate = hate;
		}

		public String getVideotime() {
			return videotime;
		}

		public void setVideotime(String videotime) {
			this.videotime = videotime;
		}

		public String getVoicetime() {
			return voicetime;
		}

		public void setVoicetime(String voicetime) {
			this.voicetime = voicetime;
		}

		public String getWeixin_url() {
			return weixin_url;
		}

		public void setWeixin_url(String weixin_url) {
			this.weixin_url = weixin_url;
		}

		public String getProfile_image() {
			return profile_image;
		}

		public void setProfile_image(String profile_image) {
			this.profile_image = profile_image;
		}

		public String getWidth() {
			return width;
		}

		public void setWidth(String width) {
			this.width = width;
		}

		public String getCdn_img() {
			return cdn_img;
		}

		public void setCdn_img(String cdn_img) {
			this.cdn_img = cdn_img;
		}

		public String getVoiceuri() {
			return voiceuri;
		}

		public void setVoiceuri(String voiceuri) {
			this.voiceuri = voiceuri;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCt() {
			return ct;
		}

		public void setCt(String ct) {
			this.ct = ct;
		}

		public String getImage0() {
			return image0;
		}

		public void setImage0(String image0) {
			this.image0 = image0;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLove() {
			return love;
		}

		public void setLove(String love) {
			this.love = love;
		}

		public String getImage2() {
			return image2;
		}

		public void setImage2(String image2) {
			this.image2 = image2;
		}

		public String getImage1() {
			return image1;
		}

		public void setImage1(String image1) {
			this.image1 = image1;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String get_id() {
			return _id;
		}

		public void set_id(String _id) {
			this._id = _id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCreate_time() {
			return create_time;
		}

		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.text);
			dest.writeString(this.hate);
			dest.writeString(this.videotime);
			dest.writeString(this.voicetime);
			dest.writeString(this.weixin_url);
			dest.writeString(this.profile_image);
			dest.writeString(this.width);
			dest.writeString(this.cdn_img);
			dest.writeString(this.voiceuri);
			dest.writeString(this.type);
			dest.writeString(this.ct);
			dest.writeString(this.image0);
			dest.writeString(this.id);
			dest.writeString(this.love);
			dest.writeString(this.image2);
			dest.writeString(this.image1);
			dest.writeString(this.height);
			dest.writeString(this._id);
			dest.writeString(this.name);
			dest.writeString(this.create_time);
		}

		public ContentlistBean() {
		}

		protected ContentlistBean(Parcel in) {
			this.text = in.readString();
			this.hate = in.readString();
			this.videotime = in.readString();
			this.voicetime = in.readString();
			this.weixin_url = in.readString();
			this.profile_image = in.readString();
			this.width = in.readString();
			this.cdn_img = in.readString();
			this.voiceuri = in.readString();
			this.type = in.readString();
			this.ct = in.readString();
			this.image0 = in.readString();
			this.id = in.readString();
			this.love = in.readString();
			this.image2 = in.readString();
			this.image1 = in.readString();
			this.height = in.readString();
			this._id = in.readString();
			this.name = in.readString();
			this.create_time = in.readString();
		}

		public static final Creator<ContentlistBean> CREATOR = new Creator<ContentlistBean>() {
			@Override
			public ContentlistBean createFromParcel(Parcel source) {
				return new ContentlistBean(source);
			}

			@Override
			public ContentlistBean[] newArray(int size) {
				return new ContentlistBean[size];
			}
		};
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.allPages);
		dest.writeInt(this.currentPage);
		dest.writeInt(this.allNum);
		dest.writeInt(this.maxResult);
		dest.writeTypedList(this.contentlist);
	}

	public PicModel() {
	}

	protected PicModel(Parcel in) {
		this.allPages = in.readInt();
		this.currentPage = in.readInt();
		this.allNum = in.readInt();
		this.maxResult = in.readInt();
		this.contentlist = in.createTypedArrayList(ContentlistBean.CREATOR);
	}

	public static final Creator<PicModel> CREATOR = new Creator<PicModel>() {
		@Override
		public PicModel createFromParcel(Parcel source) {
			return new PicModel(source);
		}

		@Override
		public PicModel[] newArray(int size) {
			return new PicModel[size];
		}
	};

	@Override
	public String toString() {
		return "PicModel{" +
				"allPages=" + allPages +
				", currentPage=" + currentPage +
				", allNum=" + allNum +
				", maxResult=" + maxResult +
				", contentlist=" + contentlist +
				'}';
	}
}
