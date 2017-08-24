package com.zhaoyao.miaomiao.fragment.slidingmenu;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.tauth.Tencent;
import com.zhaoyao.miaomiao.MainActivity;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.entity.qq.QQUserEntity;
import com.zhaoyao.miaomiao.listener.BaseUiListener;
import com.zhaoyao.miaomiao.util.ImageLoaderUtil;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
/**
 * @date 
 * @description 侧边栏菜单	
 */
public class LeftFragment extends Fragment{
	@ViewInject(id = R.id.tv_lay_menu_name)
	private TextView tv_lay_menu_name;
	@ViewInject(id = R.id.tvToday,click ="doClick")
	private View todayView;
	@ViewInject(id = R.id.tvJoke,click ="doClick")
	private View tvJoke;
	@ViewInject(id = R.id.tvMobile_address_book,click ="doClick")
	private View tvMobile_address_book;
	@ViewInject(id = R.id.tvDrug_query,click ="doClick")
	private View tvDrug_query;
	@ViewInject(id = R.id.tvMyFavorites,click ="doClick")
	private View favoritesView;
	@ViewInject(id = R.id.tvMyComments,click ="doClick")
	private View commentsView;
	@ViewInject(id = R.id.tvIdCard,click ="doClick")
	private View IdCard;
	@ViewInject(id = R.id.tvDating_interface,click ="doClick")
	private View tvDating_interface;
	@ViewInject(id = R.id.tvTranslation,click ="doClick")
	private View tvTranslation;
	@ViewInject(id = R.id.tvGuang_gao,click ="doClick")
	private View tvGuang_gao;
	@ViewInject(id = R.id.tvMusic,click ="doClick")
	private View tvMusic;
	@ViewInject(id = R.id.tvMySettings,click ="doClick")
	private View settingsView;
	@ViewInject(id = R.id.tvMobile_game,click ="doClick")
	private View tvMobile_game;
	@ViewInject(id = R.id.profile_image,click ="doClick")
	private ImageView profile_image;
	private Tencent mTencent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	private Context context;
	private MyReceiver receiver;
	public LeftFragment(Context context) {
		this.context = context;
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	public static final String qq = "ACTION_QQ_GETUSER_ENTITY_RECEIVER";
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		// Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
		// 其中APP_ID是分配给第三方应用的appid，类型为String。
//		mTencent = Tencent.createInstance("1105184875", context);
		// 1.4版本:此处需新增参数，传入应用程序的全局context，可通过activity的getApplicationContext方法获取
		// 初始化视图
		super.onActivityCreated(savedInstanceState);
		QQUserEntity userEntity = SharedPreferencesUtil.getObject(context, QQUserEntity.class, "QQUserEntity", "QQUserEntity");
		 IntentFilter filter = new IntentFilter();
		 filter.addAction(qq);
		 receiver = new MyReceiver();
		context.registerReceiver(receiver, filter);
		if (userEntity!=null&&userEntity.getNickname()!=null) {
			ImageLoaderUtil.disPlay(userEntity.getFigureurl(), profile_image);
			tv_lay_menu_name.setText(userEntity.getNickname());
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);
//		Window window = new Window(view.findViewById(R.id.ll), context);
		return view;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		context.unregisterReceiver(receiver);
		super.onDestroy();
	}
	public void login()
	{
//	mTencent = Tencent.createInstance("1105184875", App.getApplication());
	if (mTencent!=null&&!mTencent.isSessionValid())
	{
		/**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限 
        官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”  
        第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
	mTencent.login((Activity) context,"all", new BaseUiListener());
	}
	}
	public void doClick(View v) {
		Fragment newContent = null;
		switch (v.getId()) {
		case R.id.profile_image: // 头像
			switchFragment(newContent, "login");
//			login();
			break;
		case R.id.tvToday: // 今日
			switchFragment(newContent, "搜索");
			break;
		case R.id.tvJoke: // 今日
			switchFragment(newContent, "笑话");
			break;
		case R.id.tvMobile_address_book:// 手机通讯录//积分墙
			switchFragment(newContent, "积分墙");
//			switchFragment(newContent, getResources().getString(R.string.Mobile_address_book));
			break;
		case R.id.tvDrug_query: // 药品查询
			switchFragment(newContent, getResources().getString(R.string.Drug_query));
			break;
		case R.id.tvMyFavorites: // 我的收藏
			switchFragment(newContent, getResources().getString(R.string.Logistics_query));
			break;
		case R.id.tvMyComments: // 我的评论
//			Real_time_news
			switchFragment(newContent, getResources().getString(R.string.Real_time_news));
			break;
		case R.id.tvIdCard: // 身份证查询
			switchFragment(newContent, "身份证查询");
			break;
		case R.id.tvDating_interface: // 交友
			switchFragment(newContent, "交友");
			break;
		case R.id.tvMobile_game: // 手游
			switchFragment(newContent, "手游");
			break;
		case R.id.tvTranslation: // 翻译
			switchFragment(newContent, getResources().getString(R.string.Translation));
			break;
		case R.id.tvGuang_gao: // 设置收入账号
			switchFragment(newContent, "设置收入账号");
			break;
		case R.id.tvMusic: // 音乐
			switchFragment(newContent, getResources().getString(R.string.Music));
			break;
		case R.id.tvMySettings: // 拼图
			switchFragment(newContent, "拼图");
			break;
		default:
			break;
		}
	}
	
	/**
	 * 切换fragment
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchConent(fragment, title);
		}
	}
	class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (qq.equals(action)) {
				Bundle bundle = intent.getExtras();
				if (bundle!=null) {
					QQUserEntity userEntity = bundle.getParcelable("QQUserEntity");
					ImageLoaderUtil.disPlay(userEntity.getFigureurl(), profile_image);
					tv_lay_menu_name.setText(userEntity.getNickname());
					SharedPreferencesUtil.saveObject(userEntity, "QQUserEntity", "QQUserEntity", context);
				}
			}
		}
		
	}
}
