package com.zhaoyao.miaomiao;


import org.apache.http.Header;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mediav.ads.sdk.adcore.Mvad;
import com.mediav.ads.sdk.interfaces.IMvFloatbannerAd;
import com.sohuvideo.api.SohuPlayerSDK;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zhaoyao.miaomiao.activity.joke.Joke;
import com.zhaoyao.miaomiao.activity.video.VideoSearchActivity;
import com.zhaoyao.miaomiao.activity.webview.NetworkSearch;
import com.zhaoyao.miaomiao.constant.Ad360Constant;
import com.zhaoyao.miaomiao.entity.qq.QQUserEntity;
import com.zhaoyao.miaomiao.fragment.slidingmenu.LeftFragment;
import com.zhaoyao.miaomiao.fragment.video.VideoFragment;
import com.zhaoyao.miaomiao.jigsawpuzzle.GameActivity;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.net;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.InjectView.OnClick;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

/**
 * http://user.qzone.qq.com/1281659061/infocenter?ptsig=sHjXGQizQCd8JIFMzLyCyWvNlIhFCN9N7pjjux85LJk_
 * @date 2014/11/14
 * @author lw
 * @description miaomiao主界面
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MainActivity extends SlidingFragmentActivity implements OnTouchListener{
	
//	@OnClick(id = R.id.topButton,click = "topButton")
//	private int id;
	
	
	private VideoFragment mContent;
	
//	@ViewInject(id = R.id.topButton,click ="topButton")
//	private ImageView topButton;
	
	private Tencent mTencent;
	@ViewInject(id = R.id.ll)
	private	LinearLayout mYourView;
	@ViewInject(id = R.id.ll_activity_main_title)
	private	LinearLayout ll_activity_main_title;
	private MyTextView[] teViews= null;
	@ViewInject(id = R.id.textView1,click = "doClick")
	private TextView textView1;
	@ViewInject(id = R.id.textView2,click = "doClick")
	private TextView textView2;
	@ViewInject(id = R.id.textView3,click = "doClick")
	private TextView textView3;
	@ViewInject(id = R.id.textView4,click = "doClick")
	private TextView textView4;
	@ViewInject(id = R.id.textView5,click = "doClick")
	private TextView textView5;
	@ViewInject(id = R.id.textView6,click = "doClick")
	private TextView textView6;
	@ViewInject(id = R.id.textView7,click = "doClick")
	private TextView textView7;//搞笑
	@ViewInject(id = R.id.textView8,click = "doClick")
	private TextView textView8;//搞笑
	@ViewInject(id = R.id.textView9,click = "doClick")
	private TextView textView9;//趣图
	@ViewInject(id = R.id.hs_activity_main)
	private HorizontalScrollView hs_activity_main;
	private float height;
	private Dialog customDialog;
	private Dialog customDialoglogin;
	private static final int ZOO = 0;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ZOO:
				String open = SharedPreferencesUtil.getString(MainActivity.this, "openid", "openid");
				String openid = (String) msg.obj;
				if(open==null||TextUtils.isEmpty(open)){
					// 注册应用（必须调用本接口，否则APP将无法接收到通知和消息）
					// 使用绑定账号的注册接口（可针对账号下发通知和消息）
					// 可以重复注册，以最后一次注册为准104FD21A27CDD70182740EFCC2D9C237
//					XGPushManager.registerPush(MainActivity.this,openid);
					XGPushManager.registerPush(MainActivity.this, openid, xg);
					XGPushManager.setTag(getApplicationContext(),"login");
					SharedPreferencesUtil.saveString(MainActivity.this, openid, "openid", "openid");
				}else if (!open.equals(openid)) {
					// 注册应用（必须调用本接口，否则APP将无法接收到通知和消息）
					// 使用绑定账号的注册接口（可针对账号下发通知和消息）
					// 可以重复注册，以最后一次注册为准A9B98728C06715E02D3AD3FB739EAEE2
//					XGPushManager.registerPush(MainActivity.this,openid);
					XGPushManager.registerPush(MainActivity.this, openid, xg);
					XGPushManager.setTag(getApplicationContext(),"login");
					SharedPreferencesUtil.saveString(MainActivity.this, openid, "openid", "openid");
				}
				break;

			default:
				break;
			}
		};
	};


	private IMvFloatbannerAd floatBanner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		SwipeBackHelper.onCreate(this);
		 SwipeBackHelper.getCurrentPage(this)//获取当前页面
	        .setSwipeBackEnable(true)//设置是否可滑动
	        .setSwipeEdge(200)//可滑动的范围。px。200表示为左边200px的屏幕
	        .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
	        .setSwipeSensitivity(0.5f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
//	        .setScrimColor(Color.BLUE)//底层阴影颜色
	        .setClosePercent(0.8f)//触发关闭Activity百分比
	        .setSwipeRelateEnable(true)//是否与下一级activity联动(微信效果)。默认关
	        .setSwipeRelateOffset(500)//activity联动时的偏移量。默认500px。
	        .setDisallowInterceptTouchEvent(true)//不抢占事件，默认关（事件将先由子View处理再由滑动关闭处理）
//	        .addListener(new SwipeListener() {//滑动监听
//
//	            @Override
//	            public void onScroll(float percent, int px) {//滑动的百分比与距离
//	            }
//
//	            @Override
//	            public void onEdgeTouch() {//当开始滑动
//	            }
//
//	            @Override
//	            public void onScrollToClose() {//当滑动关闭
//	            }
//	        })
	        ;
		
		
		
		
		
		
		
		
		
		
		AppManager.getAppManager().addActivity(this);
		if(savedInstanceState!=null){
			
		}else {}
			InjectView.Inject(this);
			initSlidingMenu(savedInstanceState);
			teViews = new MyTextView[]{
					(MyTextView) textView8,
					(MyTextView) textView9,
					(MyTextView) textView1,
					(MyTextView) textView7,
					(MyTextView) textView2,
					(MyTextView) textView3,
					(MyTextView) textView4,
					(MyTextView) textView5,
					(MyTextView) textView6,
			};
			initColor(0);
			hs_activity_main.setOnTouchListener(this);
			new com.zhaoyao.miaomiao.util.window.Window(mYourView, this);
			getSupportFragmentManager().beginTransaction()
			.replace(R.id.content_frame, mContent).commit();
			mTencent = App.getTencent();
			 startService();
		}
//	}

    private void initColor(int i){
		for (int j = 0; j < teViews.length; j++) {
			if(j==i){
				teViews[j].setTextColor(getResources().getColor(R.color.text_color_red));
			}else {
				teViews[j].setTextColor(getResources().getColor(R.color.text_color_blue));
			}
		}
	}
	private void nitColor(){
		for (int j = 0; j < teViews.length; j++) {
			teViews[j].setTextColor(getResources().getColor(R.color.text_color_blue));
		}
		teViews[0].setTextColor(getResources().getColor(R.color.text_color_red));
	}
	public void doClick(View view) {
		mContent.fristClick(view);
		int i = 0;
		switch (view.getId()) {
		case R.id.textView8://搞笑
			i=0;
			textView8.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView9://趣图
			i=1;
			textView9.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView1://电视
			i=2;
			textView1.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView7://搞笑
			i=3;
			textView7.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView2://动漫
			textView2.setTextColor(getResources().getColor(R.color.text_color_red));
			i=4;
			break;
		case R.id.textView3://综艺
			i=5;
			textView3.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView4://音乐
			i=6;
			textView4.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView5://新闻
			i=7;
			textView5.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		case R.id.textView6://娱乐
			i=8;
			textView6.setTextColor(getResources().getColor(R.color.text_color_red));
			break;
		
		
		default:
			break;
		}
		setColor(i);
	}
	public void topButton() {
		getSlidingMenu().showMenu();
	}
	private void setColor(int i) {
		initColor(i);
	}
	public void login()
	{
	if (mTencent!=null&&!mTencent.isSessionValid())
	{
		/**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限 
        官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”  
        第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
	mTencent.login(this,"all", new BaseUiListener());
	}
	}
	/**
	 * 初始化侧边栏
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
		if (savedInstanceState != null) {
			mContent = (VideoFragment) getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		}

		if (mContent == null) {
			mContent = new VideoFragment(this);
		}

		// 设置左侧滑动菜单
		setBehindContentView(R.layout.menu_frame_left);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new LeftFragment(this)).commit();

		// 实例化滑动菜单对象
		SlidingMenu sm = getSlidingMenu();
		// 设置可以左右滑动的菜单
		sm.setMode(SlidingMenu.LEFT);
		// 设置滑动阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);
		// 设置滑动菜单阴影的图像资源
		sm.setShadowDrawable(null);
		// 设置滑动菜单视图的宽度
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置渐入渐出效果的值
		sm.setFadeDegree(0.5f);
		// 设置触摸屏幕的模式,这里设置为全屏
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置下方视图的在滚动时的缩放比例
		sm.setBehindScrollScale(0.5f);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable("teViews", teViews);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		teViews = (MyTextView[]) savedInstanceState.getSerializable("teViews");
		System.out.println(teViews.toString());
	};
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onRestoreInstanceState(savedInstanceState, persistentState);
		teViews = (MyTextView[]) savedInstanceState.getSerializable("teViews");
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	if(requestCode == 100){
		/** 设置透明度渐变动画 */ 
//		final AlphaAnimation anima = new AlphaAnimation(0, 1); 
//		anima.setDuration(500);//设置动画持续时间 
//		mYourView.startAnimation(anima);
		TranslateAnimation animation = new TranslateAnimation(0, 0, -height, 0);
		animation.setDuration(500);
		animation.setFillAfter(true);
		mYourView.startAnimation(animation);
	}else {
		Tencent.onActivityResultData(requestCode,resultCode,data,new BaseUiListener());
	}
	}
	public void onClick() {
		height = ll_activity_main_title.getHeight();
		startAnimation();
	}
	/**
	 * 切换Fragment
	 * 
	 * @param fragment
	 */
	public void switchConent(android.support.v4.app.Fragment fragment, String title) {
//		getSlidingMenu().showContent(); 
			if (getResources().getString(R.string.Logistics_query).equals(title)) {
//			Intent intent = new Intent();
//			intent.setClass(this, MyLogisticsActivity.class);
//			startActivity(intent);
//			overridePendingTransition(R.anim.activity_fade_out, R.anim.activity_fade_in);// 淡出淡入动画效果
		}else if ("积分墙".equals(title)) {
//			Intent intent = new Intent();
//			intent.setClass(this, Integral.class);
//			startActivity(intent);
		}
			else if ("login".equals(title)) {
			if(!net.isNetworkAvailable(this))return;
			if(customDialoglogin==null){
			LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
			View voiceView = inflater.inflate(R.layout.login, null);
			final View tv = voiceView.findViewById(R.id.tv_login);
			final View pb = voiceView.findViewById(R.id.pb_login);
			final View cancel = voiceView.findViewById(R.id.tv_login_cancel);
			cancel.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(pb.getVisibility()==View.VISIBLE)return;
					customDialoglogin.dismiss();
				}
			});
			tv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					tv.setVisibility(View.GONE);
					pb.setVisibility(View.VISIBLE);
					login();
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							tv.setVisibility(View.VISIBLE);
							pb.setVisibility(View.GONE);
						}
					}, 5000);
				}
			});
			customDialoglogin=new Dialog(MainActivity.this, R.style.CustomDialog);
			Window window = customDialoglogin.getWindow();
			window.setWindowAnimations(R.style.dialogWindowAnimone);  //添加动画	
			customDialoglogin.setContentView(voiceView);
			customDialoglogin.setOnKeyListener(keylistener);
			customDialoglogin.setCancelable(false);
			customDialoglogin.setCanceledOnTouchOutside(false);
			}
			customDialoglogin.show();
			return;
		}else if ("搜索".equals(title)) {
			if(!net.isNetworkAvailable(this))return;
			if (!net.isWifi(this))return;
			Intent intent = new Intent();
			intent.setClass(this, NetworkSearch.class);
			startActivity(intent);
			overridePendingTransition(R.anim.anim_enter_from_bottom,R.anim.anim_exit_from_bottom);
		}else if ("笑话".equals(title)) {
			Intent intent = new Intent();
			intent.setClass(this, Joke.class);
			startActivity(intent);
			overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
		}else if ("设置收入账号".equals(title)) {
			if(customDialog==null){
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View voiceView = inflater.inflate(R.layout.income_account, null);
				final EditText et = (EditText) voiceView.findViewById(R.id.editText1);
				voiceView.findViewById(R.id.textView1).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						customDialog.dismiss();
					}
				});
				final TextView bt = (TextView) voiceView.findViewById(R.id.textView2);
				bt.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if(bt.getText().toString().equals("检查账号"))return;
						String replace = et.getText().toString().trim().replace(" ", "");
						if(TextUtils.isEmpty(replace))return;
						if(replace.length()<=4){
							bt.setText("检查账号");
							new Handler().postDelayed(new Runnable() {
								@Override
								public void run() {
									bt.setText("修改");
								}
							}, 2000);
							return;
						}
						customDialog.dismiss();
					}
				});
				customDialog=new Dialog(MainActivity.this, R.style.CustomDialog);
				Window window = customDialog.getWindow();
				window.setWindowAnimations(R.style.dialogWindowAnimone);  //添加动画	
				customDialog.setContentView(voiceView);
				customDialog.setOnKeyListener(keylistener);
				customDialog.setCancelable(false);
				customDialog.setCanceledOnTouchOutside(false);
			}
			customDialog.show();
		}
		else if ("拼图".equals(title)) {
			Intent intent = new Intent();
			intent.setClass(this, GameActivity.class);
			startActivity(intent);
		}
		getSlidingMenu().showMenu();
	}
	private final String adSpaceid_cps_3="com.zhaoyao.miaomiao||cps||3";  
	public void getUserInfo(JSONObject values){
		/**
		 * https://graph.qq.com/user/get_user_info? 
		access_token=*************&
		oauth_consumer_key=12345& 
		openid=****************&
		format=json
		 */
		AsyncHttpClient client = HttpClientUtils.getClient();
		RequestParams params = new RequestParams();
		String access_token = UserJSON.getString(values, "access_token");
//		String query_authority_cost = UserJSON.getString(values, "query_authority_cost");
		final String openid = UserJSON.getString(values, "openid");
		params.put("access_token", access_token);
		params.put("oauth_consumer_key", "1105184875");
		params.put("openid", openid);
		params.put("format", "json");
		client.get("https://graph.qq.com/user/get_user_info", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				Message msg = new Message();
				msg.what = ZOO;
				msg.obj = openid;
				handler.handleMessage(msg);
				String s = new String(b);
				JSONObject jsonObject = UserJSON.getJSONObject(s);
				QQUserEntity userEntity = UserJSON.parseObject(QQUserEntity.class, jsonObject);
				Intent intent = new Intent(LeftFragment.qq);
				Bundle bundle = new Bundle();
				bundle.putParcelable("QQUserEntity", userEntity);
				intent.putExtras(bundle);
				sendBroadcast(intent);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
			}
		});
	}
	@Override
	protected void onResume() {
		super.onResume();
		XGPushManager.onActivityStarted(this);
	}
	@Override
	protected void onPause() {
		if(customDialoglogin!=null)
			customDialoglogin.cancel();
		XGPushManager.onActivityStoped(this);
		super.onPause();
	}
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(false);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 直接进入后台
	 * @param intent
	 */
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//			ActivityInfo ai = homeInfo.activityInfo;
//			Intent startIntent = new Intent(Intent.ACTION_MAIN);
//			startIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//			startIntent.setComponent(new ComponentName(ai.packageName,
//					ai.name));
//			startActivitySafely(startIntent);
//			return true;
//		} else
//			return super.onKeyDown(keyCode, event);
//	}
//	void startActivitySafely(Intent intent) {
//		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		try {
//			startActivity(intent);
//		} catch (ActivityNotFoundException e) {
////			Toast.makeText(this, R.string.unabletoopensoftware,
////					Toast.LENGTH_SHORT).show();
//		} catch (SecurityException e) {
////			Toast.makeText(this, R.string.unabletoopensoftware,
////					Toast.LENGTH_SHORT).show();
//		}
//	}
	
class BaseUiListener implements IUiListener {

			protected void doComplete(JSONObject values) {
		         getUserInfo(values);
			}
			@Override
			public void onError(UiError e) {
			}

			@Override
			public void onCancel() {
			}

			@Override
			public void onComplete(Object response) {
				doComplete(UserJSON.getJSONObject(response.toString()));		
			}
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState,
			PersistableBundle persistentState) {
		super.onPostCreate(savedInstanceState, persistentState);
		 SwipeBackHelper.onPostCreate(this);
	}
	@Override
	protected void onDestroy() {
		 //与之对应关闭SohuVideoSDK：
		 SohuPlayerSDK.close();
		super.onDestroy();
		  SwipeBackHelper.onDestroy(this);
	}
	@Override
	protected void onStart() {
		super.onStart();
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int id = v.getId();
		MMLog.i("onTouch=========", "onTouch========="+id);
		return false;
	}
	int m = 0 ;
	private void startAnimation() {
		/** 设置透明度渐变动画 */ 
//		final AlphaAnimation anima = new AlphaAnimation(1, 0); 
//		anima.setDuration(500);//设置动画持续时间 
//		mYourView.startAnimation(anima);
		/** 常用方法 */ 
		//animation.setRepeatCount(int repeatCount);//设置重复次数 
		//animation.setFillAfter(boolean);//动画执行完后是否停留在执行完的状态 
		//animation.setStartOffset(long startOffset);//执行前的等待时间 
		
		
		TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -height);
		animation.setDuration(500);
		animation.setFillAfter(true);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), VideoSearchActivity.class);
				startActivityForResult(intent, 100);
				overridePendingTransition(R.anim.activity_fade_in,R.anim.activity_fade_out);
			}
		});
		mYourView.startAnimation(animation);
	}
	OnKeyListener keylistener = new OnKeyListener(){
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0)
            {
             return true;
            }
            else
            {
             return false;
            }
        }
    } ;
    private void startService(){
    	String XGPushService = SharedPreferencesUtil.getString(this, "XGPushService", "XGPushService");
    	if(XGPushService==null||TextUtils.isEmpty(XGPushService)){
    		XGPushService = android.provider.Settings.System.getString(getContentResolver(), "android_id"); 
    	XGPushManager.registerPush(this, XGPushService, xg);
    	SharedPreferencesUtil.saveString(MainActivity.this, XGPushService, "XGPushService", "XGPushService");
    	}
    }
    private XGIOperateCallback xg = new XGIOperateCallback() {
		
		@Override
		public void onSuccess(Object arg0, int arg1) {
			MMLog.i(arg0);
		}//59f456eb3e3c474649cb8144a79f59c630b5a738
		@Override
		public void onFail(Object arg0, int arg1, String arg2) {
			MMLog.i(arg0);
		}
	};
}
