package com.zhaoyao.miaomiao.activity.joke;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.mediav.ads.sdk.adcore.Mvad;
import com.mediav.ads.sdk.interfaces.IMvBannerAd;
import com.mediav.ads.sdk.interfaces.IMvFloatbannerAd;
import com.zhaoyao.miaomiao.AppManager;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.adapter.ViewHolder;
import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
import com.zhaoyao.miaomiao.constant.Ad360Constant;
import com.zhaoyao.miaomiao.dao.impl.ShowApiJokeEntityDaoImpl;
import com.zhaoyao.miaomiao.entity.ShowApiJokeEntity;
import com.zhaoyao.miaomiao.http.HttpChildInterface;
import com.zhaoyao.miaomiao.http.Result;
import com.zhaoyao.miaomiao.http.UserRequest;
import com.zhaoyao.miaomiao.util.SharedPreferencesUtil;
import com.zhaoyao.miaomiao.util.UserJSON;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;
public class Joke extends Activity {
	private static final String TAG = Joke.class.getName();
//	public class Joke extends Fragment {
	@ViewInject(id = R.id.rl_joke_fragment_main_load)
	private RelativeLayout rl_joke_fragment_main_load;
	@ViewInject(id = R.id.pb_joke_fragment_main_load)
	private ProgressBar pb_joke_fragment_main_load;
	@ViewInject(id = R.id.tv_joke_fragment_main_load)
	private TextView tv_joke_fragment_main_load;
	@ViewInject(id = R.id.imageView2)
	private ImageView imageView2;
	@ViewInject(id = R.id.lv_a_main)
	private ListView lv_a_main;
//	@ViewInject(id = R.id.ll_a_main)
//	private LinearLayout ll_a_main;
	@ViewInject(id = R.id.ll_joke_fragment)
	private LinearLayout ll_joke_fragment;
	@ViewInject(id = R.id.rl_a_main)
	private RelativeLayout byId;
	private Context context;
	/**正在加载...*/
	private View Being_loaded;
	private View Click_load;
	int i = 0;
	private View inflate;
	private int page = 1;
	private List<ShowApiJokeEntity> Jokelist = new ArrayList<ShowApiJokeEntity>();
	/**
     * 背景图片名称
     */
    private static final String FILE_NAME = "MM-320x480.png";
	private String[] split;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.joke_fragment_main);
			
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
			
			
			
			
			
			
			
			
			
			
			InjectView.Inject(this);
			context = this;
			 inIt();
			 setupBannerAd();
			 AppManager.getAppManager().addActivity(this);
			 String pageAnd = SharedPreferencesUtil.getString(context, "pageAndNumber", "pageAndNumber");
			 if(savedInstanceState!=null){
				 String pageAndNumber = savedInstanceState.getString("pageAndNumber");
				 getContent(pageAndNumber);
			 }else if (pageAnd!=null&&!TextUtils.isEmpty(pageAnd)) {
				 getContent(pageAnd);
				 if(inflate.getVisibility()==View.GONE)
					inflate.setVisibility(View.VISIBLE);
					Being_loaded.setVisibility(View.GONE);
					Click_load.setVisibility(View.VISIBLE);
			}else {
				 getData();
			}
			Click_load.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					++page;
					getData();
				}
			});
			
//			LOnTouchListener.setOnTouchListener(imageView2, context);
//			LOnTouchListener.setOnClickListener(imageView2, new LOnClickListener() {
//				
//				@SuppressWarnings("static-access")
//				@Override
//				public void onClick(View v) {
//					Intent intent = new Intent();
//					intent.setClass(context, BaiduMusicActivity.class);
//					startActivity(intent);
////					WrapView.start(imageView3,imageView2,context);
////					MusicLoader.getMusicList(new Music() {
////						@Override
////						public void interMusic(List<MusicInfo> list) {
////							System.out.println(list);
////						}
////					});
//				}
//			});
		}
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		View inflate = inflater.inflate(R.layout.joke_fragment_main, null);
//		return inflate;
//	}
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		InjectView.Inject(this);
//		 inIt();
//		 String pageAnd = SharedPreferencesUtil.getString(context, "pageAndNumber", "pageAndNumber");
//		 if(savedInstanceState!=null){
//			 String pageAndNumber = savedInstanceState.getString("pageAndNumber");
//			 getContent(pageAndNumber);
//		 }else if (pageAnd!=null&&!TextUtils.isEmpty(pageAnd)) {
//			 getContent(pageAnd);
//			 if(inflate.getVisibility()==View.GONE)
//				inflate.setVisibility(View.VISIBLE);
//				Being_loaded.setVisibility(View.GONE);
//				Click_load.setVisibility(View.VISIBLE);
//		}else {
//			 getData();
//		}
//		Click_load.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				++page;
//				getData();
//			}
//		});
////		LOnTouchListener.setOnTouchListener(imageView2, context);
////		LOnTouchListener.setOnClickListener(imageView2, new LOnClickListener() {
////			
////			@SuppressWarnings("static-access")
////			@Override
////			public void onClick(View v) {
////				Intent intent = new Intent();
////				intent.setClass(context, BaiduMusicActivity.class);
////				startActivity(intent);
//////				WrapView.start(imageView3,imageView2,context);
//////				MusicLoader.getMusicList(new Music() {
//////					@Override
//////					public void interMusic(List<MusicInfo> list) {
//////						System.out.println(list);
//////					}
//////				});
////			}
////		});
//		super.onActivityCreated(savedInstanceState);
//	}
	private void getContent(String pageAndNumber) {
		split = pageAndNumber.split(",");
		 page = Integer.parseInt(split[0]);
		 int Number = Integer.parseInt(split[1]);
		 ShowApiJokeEntityDaoImpl daoImpl = new ShowApiJokeEntityDaoImpl(context);
		 List<ShowApiJokeEntity> find = daoImpl.find();
		 if(find!=null)
		 for (int i = 0; i < find.size(); i++) {
			 Jokelist.add(find.get(i));
		}
		 setAdapter();
		 ++Number;
		 lv_a_main.setSelection(Number);//定位到10行;
		 if(Jokelist==null||Jokelist.size()==0){
				tv_joke_fragment_main_load.setVisibility(View.VISIBLE);
				pb_joke_fragment_main_load.setVisibility(View.GONE);
			}else {
				tv_joke_fragment_main_load.setVisibility(View.GONE);
				pb_joke_fragment_main_load.setVisibility(View.GONE);
			}
	}
	private void inIt() {
		inflate = LayoutInflater.from(this).inflate(R.layout.joke_item_l_ad_wall_listview_footer, null);
		Being_loaded = inflate.findViewById(R.id.tv_i_l_ad__lv_Being_loaded);
		Click_load = inflate.findViewById(R.id.tv_i_l_ad__lv_Click_load);
		lv_a_main.addFooterView(inflate);
		inflate.setVisibility(View.GONE);
		lv_a_main.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				firstVisible = firstVisibleItem;
			}
		});
	}
	private int firstVisible = 0;
	@Override
	public void onStart() {
		super.onStart();
		setBackground();
	}
	@Override
	public void onPause() {
		SharedPreferencesUtil.saveString(context, page+","+firstVisible, "pageAndNumber", "pageAndNumber");
		super.onPause();
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("pageAndNumber", page+","+firstVisible);
		super.onSaveInstanceState(outState);
	}
	@SuppressLint("NewApi")
	private void setBackground() {
		String backgroundUrl = SharedPreferencesUtil.getString(context, "TheLatestJokeFragment", "TheLatestJokeFragment");
		File file = new File(backgroundUrl);
		if(file.exists()&&file.isFile()) {
			if(file.getName().endsWith("jpg")||file.getName().endsWith("JPEG")||file.getName().endsWith("PNG"))
			{
				byId.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(backgroundUrl)));
			}
			else {byId.setBackground(getResources().getDrawable(R.drawable.xin_ai_de_ren));}
		}else
		{
			byId.setBackground(getResources().getDrawable(R.drawable.xin_ai_de_ren));
		}
	}
	private ZhaoYaoAdapter<ShowApiJokeEntity> adapter;
	private IMvBannerAd bannerad;
	private IMvFloatbannerAd floatBanner;
	private void getData() {
		if(Jokelist==null||Jokelist.size()==0){
			tv_joke_fragment_main_load.setVisibility(View.GONE);
			pb_joke_fragment_main_load.setVisibility(View.VISIBLE);
		}
		if(page<=0)page=1;
		Being_loaded.setVisibility(View.VISIBLE);
		Click_load.setVisibility(View.GONE);
		i = 0;
		UserRequest.jokeRequest(page,new HttpChildInterface() {
			@Override
			public void completeResult(boolean istrue,Result result) {
				if(inflate.getVisibility()==View.GONE)
				inflate.setVisibility(View.VISIBLE);
				i = 1;
				Being_loaded.setVisibility(View.GONE);
				Click_load.setVisibility(View.VISIBLE);
				if(istrue){//"Counts":11051,"PageCount":553
					JSONObject data = result.getData();
					if(data!=null){
						Date date = new Date();
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
						String time = format.format(date);
						List<ShowApiJokeEntity> list = UserJSON.parsUser(ShowApiJokeEntity.class, data, "contentlist");
						for (int i = 0; i < list.size(); i++) {
							ShowApiJokeEntity entity = list.get(i);
							entity.setTime(time);
							Jokelist.add(entity);
						}
						setAdapter();
						ShowApiJokeEntityDaoImpl daoImpl = new ShowApiJokeEntityDaoImpl(context);
						for (int i = 0; i < list.size(); i++) {
							ShowApiJokeEntity entity = list.get(i);
							List<ShowApiJokeEntity> rawQuery = daoImpl.rawQuery("select * from t_showApiJokeEntity where createTime= ? and title= ?", new String[]{entity.getCt(),entity.getTitle()});
							if(rawQuery==null||rawQuery.size()==0) {
								long insert = daoImpl.insert(entity);
							}
						}
					}
				}else {
					--page;
				}
				if(Jokelist==null||Jokelist.size()==0){
					tv_joke_fragment_main_load.setVisibility(View.VISIBLE);
					pb_joke_fragment_main_load.setVisibility(View.GONE);
				}else {
					tv_joke_fragment_main_load.setVisibility(View.GONE);
					pb_joke_fragment_main_load.setVisibility(View.GONE);
				}
			}
		});
	}

	private void setAdapter() {
		if(adapter==null){
			adapter = new ZhaoYaoAdapter<ShowApiJokeEntity>(context, Jokelist, R.layout.budejie_text_item) {
				@Override
				public void convert(ViewHolder helper, ShowApiJokeEntity item) {
//					helper.setText(R.id.textView1, item.getTitle());
//					helper.setText(R.id.textView2, item.getText());
					helper.setText(R.id.title, item.getTitle());
					helper.setText(R.id.description, item.getText());
					if(item.getTime()==null||item.getTime().length()<=0){
						helper.setText(R.id.time, item.getCt()+"");
					}else {
						helper.setText(R.id.time, item.getTime()+"");
					}
					final TextView textView = helper.getView(R.id.description);
					textView.setTextIsSelectable(false);
					textView.setOnLongClickListener(new OnLongClickListener() {
						@Override
						public boolean onLongClick(View v) {
							textView.setTextIsSelectable(true);
							return false;
						}
					});
				}
			};
			lv_a_main.setAdapter(adapter);
//			setupBannerAd();
			// 创建LinearLayout对象
//			LinearLayout mLinearLayout = new LinearLayout(this);
//			// 建立布局样式宽和高，对应xml布局中：
//			// android:layout_width="fill_parent"
//			// android:layout_height="fill_parent"
//			mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
//					LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT));
//			// 设置方向，对应xml布局中：
//			// android:orientation="vertical"
//			mLinearLayout.setOrientation(LinearLayout.VERTICAL);
//			ll_a_main.addView(adView);
			setupBannerAd();
		}else {
			adapter.notifyDataSetChanged();
		}
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	@Override
	protected void onStop() {
		super.onStop();
	}
	  @Override
		public void finish() {
			super.finish();
			//关闭窗体动画显示  
		    this.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);  
		}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//4ACTION_DOWN  KeyEvent.KEYCODE_BACK;KeyEvent.ACTION_DOWN
		return super.onKeyDown(keyCode, event);
	}
		@Override
		protected void onDestroy() {
			Mvad.activityDestroy(this);
//			if(bannerad != null)
//				bannerad.closeAds();
//			if(floatBanner != null)
//				floatBanner.closeAds();
		AppManager.getAppManager().finishActivity(this);
		super.onDestroy();
		 SwipeBackHelper.onDestroy(this);
		}
		
		@SuppressLint("NewApi")
		@Override
		public void onPostCreate(Bundle savedInstanceState,
				PersistableBundle persistentState) {
			super.onPostCreate(savedInstanceState, persistentState);
			 SwipeBackHelper.onPostCreate(this);
		}
		
		
//		KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_BACK, scanCode=0, metaState=0, flags=0x48, repeatCount=0, eventTime=691323854, downTime=691323854, deviceId=-1, source=0x101 }
		private void setupBannerAd() {
			if(bannerad==null)
			 bannerad = Mvad.showBanner(ll_joke_fragment, Joke.this, Ad360Constant.adSpaceid_bannerad_joke, false);
//			ll_joke_fragment.addView(adView);
			if(floatBanner == null)
			  floatBanner = Mvad.showFloatbannerAd(this,Ad360Constant.adSpaceid_floatBanner_joke,false,Mvad.FLOAT_BANNER_SIZE.SIZE_DEFAULT,Mvad.FLOAT_LOCATION.TOP);
		}
		
		
	/**
     * 取得SDCard中的背景图片
     */
    private Bitmap getWallpager() {
        // SDCard的路径，也就是“/sdcard/”
        File root = Environment.getExternalStorageDirectory();
        // MM图片
        File wall = new File(root, FILE_NAME);
        // MM图片路径
        String path = wall.getAbsolutePath();
        return BitmapFactory.decodeFile(path);
    }

    /**
     * 设置桌面背景
     */
    private void putWallpaper(Bitmap bitmap,Context context) {
        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
            wallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            String msg = "设置桌面背景发生异常:" + e.getLocalizedMessage();
        }
    }
}
