package com.zhaoyao.miaomiao.activity.video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.fragment.slidingmenu.TodayFragment;
import com.zhaoyao.miaomiao.fragment.video.VideoFragment;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

public class VideoMainActivity extends SlidingFragmentActivity {
	private Fragment mContent;
	@ViewInject(id = R.id.topButton,click ="doClick")
	private ImageView topButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_activity_joke_main);
		InjectView.Inject(this);
		initSlidingMenu(savedInstanceState);
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame, mContent).commit();
	}
	public void doClick() {
		getSlidingMenu().showMenu();
	}
	/**
	 * 初始化侧边栏
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
		if (savedInstanceState != null) {
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		}

		if (mContent == null) {
			mContent = new VideoFragment(this);
		}

		// 设置左侧滑动菜单
		setBehindContentView(R.layout.menu_frame_left);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new TodayFragment(this)).commit();

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
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
}
