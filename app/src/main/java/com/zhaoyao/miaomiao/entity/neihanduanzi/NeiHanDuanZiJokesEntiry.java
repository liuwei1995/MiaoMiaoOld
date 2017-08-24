package com.zhaoyao.miaomiao.entity.neihanduanzi;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * group  段子
 * @author lw
 *
 */
public class NeiHanDuanZiJokesEntiry implements Parcelable{

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	
//	 private String group;//  {"
	private String text;//  "\u5973\u513f\u7761\u9192\u54ed\u4e86\uff0c\u6211\u600e\u4e48\u54c4\u90fd\u4e0d\u884c\uff0c\u80af\u5b9a\u662f\u997f\u4e86\uff0c\u53ef\u662f\u5ab3\u5987\u8fd8\u505a\u6c99\u53d1\u4e0a\uff0c\u8ddf\u6ca1\u4e8b\u4eba\u4f3c\u7684\u3002\u6211\u62b1\u7740\u5b69\u5b50\u8fc7\u53bb\u521a\u8981\u5f00\u9a82\uff0c\u53ea\u89c1\u8001\u5a46\u4ece\u80f8\u524d\u638f\u51fa\u4e2a\u70ed\u6c34\u888b\u8bf4\u201c\u9012\u8fc7\u6765\u5427\u201d\u3002\n\u539f\u6765\u662f\u5728\u201c\u70ed\u5976\u201d\uff0c\u8fd9\u4e48\u51b7\u7684\u5929\u3002\u3002\u8fd9\u4e48\u662f\u96be\u4e3a\u5979\u4e86\u3002" 
	private String neihan_hot_start_time;//  "00-00-00" 
	private String dislike_reason;//  
//	 [{"type;//  1 private String id;//  440 private String title;//  "\u5185\u6db5"}, 
//	 {"type;//  2 private String id;//  1 private String title;//  "\u5427:\u5185\u6db5\u6bb5\u5b50"}, 
//	 {"type;//  4 private String id;//  0 private String title;//  "\u5185\u5bb9\u91cd\u590d"}, 
//	 {"type;//  3 private String id;//  5746460895 private String title;//  "\u4f5c\u8005:\u6709\u5996\u6c14de\u80c6\u5c0f\u9b3c"}] 
	 
	 
	 private String create_time;//  1453659456 
	 private String id;//  5947731401 
	 private String favorite_count;//  1215 
	 private String go_detail_count;//  14495 
	 private String user_favorite;//  0 
	 private String share_type;//  1 
	 private String is_can_share;//  1 
	 private String category_type;//  1 
	 private String share_url;//  "http://m.neihanshequ.com/share/group/5947731401/?iid=4035845517&app=joke_essay" 
	 private String label;//  1 
	 private String content;//  "\u5973\u513f\u7761\u9192\u54ed\u4e86\uff0c\u6211\u600e\u4e48\u54c4\u90fd\u4e0d\u884c\uff0c\u80af\u5b9a\u662f\u997f\u4e86\uff0c\u53ef\u662f\u5ab3\u5987\u8fd8\u505a\u6c99\u53d1\u4e0a\uff0c\u8ddf\u6ca1\u4e8b\u4eba\u4f3c\u7684\u3002\u6211\u62b1\u7740\u5b69\u5b50\u8fc7\u53bb\u521a\u8981\u5f00\u9a82\uff0c\u53ea\u89c1\u8001\u5a46\u4ece\u80f8\u524d\u638f\u51fa\u4e2a\u70ed\u6c34\u888b\u8bf4\u201c\u9012\u8fc7\u6765\u5427\u201d\u3002\n\u539f\u6765\u662f\u5728\u201c\u70ed\u5976\u201d\uff0c\u8fd9\u4e48\u51b7\u7684\u5929\u3002\u3002\u8fd9\u4e48\u662f\u96be\u4e3a\u5979\u4e86\u3002" 
	 private String comment_count;//  1615 
	 private String id_str;//  "5947731401" 
	 private String media_type;//  0 
	 private String share_count;//  1454 
	 private String type;//  3 
	 private String status;//  112 
	 private String has_comments;//  0 
	 private String user_bury;//  0 
	 private String status_desc;//  "\u70ed\u95e8\u6295\u7a3f" 
	 private String quick_comment;//  false 
	 private String user;//  
	 
//	 {"user_id;//  5746460895 
	 
//	 private String name;//  "\u6709\u5996\u6c14de\u80c6\u5c0f\u9b3c" 
//	 private String followings;//  6 
//	 private String ugc_count;//  275 
//	 private String avatar_url;//  "http://p2.pstatp.com/thumb/12292/4171285398" 
//	 private String followers;//  118 
//	 private String is_following;//  false 
//	 private String user_verified;//  false
//	 } 
	 private String neihan_hot_end_time;//  "00-00-00" 
	 private String user_digg;//  0 
	 private String online_time;//  1453659456 
	 private String category_name;//  "\u5185\u6db5\u6bb5\u5b50" 
	 private String category_visible;//  true 
	 private String bury_count;//  2138 
	 private String is_anonymous;//  false 
	 private String repin_count;//  1215 
	 private String is_neihan_hot;//  false 
	 private String digg_count;//  16657 
	 private String has_hot_comments;//  1 
	 private String allow_dislike;//  true 
	 private String user_repin;//  0 
	 private String group_id;//  5947731401 
	 private String category_id;//  1} 
//	 private String display_time;//  1460085584 
//	 private String online_time;//  1460085584},
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNeihan_hot_start_time() {
		return neihan_hot_start_time;
	}

	public void setNeihan_hot_start_time(String neihan_hot_start_time) {
		this.neihan_hot_start_time = neihan_hot_start_time;
	}

	public String getDislike_reason() {
		return dislike_reason;
	}

	public void setDislike_reason(String dislike_reason) {
		this.dislike_reason = dislike_reason;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(String favorite_count) {
		this.favorite_count = favorite_count;
	}

	public String getGo_detail_count() {
		return go_detail_count;
	}

	public void setGo_detail_count(String go_detail_count) {
		this.go_detail_count = go_detail_count;
	}

	public String getUser_favorite() {
		return user_favorite;
	}

	public void setUser_favorite(String user_favorite) {
		this.user_favorite = user_favorite;
	}

	public String getShare_type() {
		return share_type;
	}

	public void setShare_type(String share_type) {
		this.share_type = share_type;
	}

	public String getIs_can_share() {
		return is_can_share;
	}

	public void setIs_can_share(String is_can_share) {
		this.is_can_share = is_can_share;
	}

	public String getCategory_type() {
		return category_type;
	}

	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}

	public String getShare_url() {
		return share_url;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment_count() {
		return comment_count;
	}

	public void setComment_count(String comment_count) {
		this.comment_count = comment_count;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getShare_count() {
		return share_count;
	}

	public void setShare_count(String share_count) {
		this.share_count = share_count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHas_comments() {
		return has_comments;
	}

	public void setHas_comments(String has_comments) {
		this.has_comments = has_comments;
	}

	public String getUser_bury() {
		return user_bury;
	}

	public void setUser_bury(String user_bury) {
		this.user_bury = user_bury;
	}

	public String getStatus_desc() {
		return status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}

	public String getQuick_comment() {
		return quick_comment;
	}

	public void setQuick_comment(String quick_comment) {
		this.quick_comment = quick_comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNeihan_hot_end_time() {
		return neihan_hot_end_time;
	}

	public void setNeihan_hot_end_time(String neihan_hot_end_time) {
		this.neihan_hot_end_time = neihan_hot_end_time;
	}

	public String getUser_digg() {
		return user_digg;
	}

	public void setUser_digg(String user_digg) {
		this.user_digg = user_digg;
	}

	public String getOnline_time() {
		return online_time;
	}

	public void setOnline_time(String online_time) {
		this.online_time = online_time;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_visible() {
		return category_visible;
	}

	public void setCategory_visible(String category_visible) {
		this.category_visible = category_visible;
	}

	public String getBury_count() {
		return bury_count;
	}

	public void setBury_count(String bury_count) {
		this.bury_count = bury_count;
	}

	public String getIs_anonymous() {
		return is_anonymous;
	}

	public void setIs_anonymous(String is_anonymous) {
		this.is_anonymous = is_anonymous;
	}

	public String getRepin_count() {
		return repin_count;
	}

	public void setRepin_count(String repin_count) {
		this.repin_count = repin_count;
	}

	public String getIs_neihan_hot() {
		return is_neihan_hot;
	}

	public void setIs_neihan_hot(String is_neihan_hot) {
		this.is_neihan_hot = is_neihan_hot;
	}

	public String getDigg_count() {
		return digg_count;
	}

	public void setDigg_count(String digg_count) {
		this.digg_count = digg_count;
	}

	public String getHas_hot_comments() {
		return has_hot_comments;
	}

	public void setHas_hot_comments(String has_hot_comments) {
		this.has_hot_comments = has_hot_comments;
	}

	public String getAllow_dislike() {
		return allow_dislike;
	}

	public void setAllow_dislike(String allow_dislike) {
		this.allow_dislike = allow_dislike;
	}

	public String getUser_repin() {
		return user_repin;
	}

	public void setUser_repin(String user_repin) {
		this.user_repin = user_repin;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	 
	 
}
