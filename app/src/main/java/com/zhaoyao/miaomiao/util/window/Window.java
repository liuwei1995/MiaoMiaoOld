package com.zhaoyao.miaomiao.util.window;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.zhaoyao.miaomiao.App;

import java.lang.reflect.Method;
/**
 * 
 * @author 窗口  虚拟键隐藏
 *
 */
public class Window {
	private View view;
	private Context mActivity;
	private int mVisibleHeight;
	private int height;

	public Window(View view, Context context) {
		this.view = view;
		mActivity = context;
		WindowManager manager = (WindowManager) mActivity
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		height = dm.heightPixels;
		virtualButtonsShowHidden();
	}

	public void virtualButtonsShowHidden() {
		boolean bar = checkDeviceHasNavigationBar(App.getApplication());
		if (bar)
			view.getViewTreeObserver().addOnGlobalLayoutListener(
					new ViewTreeObserver.OnGlobalLayoutListener() {
						@Override
						public void onGlobalLayout() {
							Rect r = new Rect();
							view.getWindowVisibleDisplayFrame(r);

							int screenHeight = view.getRootView().getHeight();
							int heightDifference = screenHeight
									- (r.bottom - r.top);
							int resourceId = mActivity.getResources()
									.getIdentifier("status_bar_height",
											"dimen", "android");
							if (resourceId > 0) {
								heightDifference -= mActivity.getResources()
										.getDimensionPixelSize(resourceId);
							}
							view.setPadding(0, r.top, 0, heightDifference);
//							view.setPadding(0, 0, 0, heightDifference);//activity不能删
							view.invalidate();
						}
					});
	}


	/**
	 * 获取NavigationBar的高度：
	 * 
	 * @param context
	 * @return
	 */
	private static int getNavigationBarHeight(Context context) {
		int navigationBarHeight = 0;
		Resources rs = context.getResources();
		int id = rs.getIdentifier("navigation_bar_height", "dimen", "android");
		if (id > 0 && checkDeviceHasNavigationBar(context)) {
			navigationBarHeight = rs.getDimensionPixelSize(id);
		}
		return navigationBarHeight;
	}

	protected void getKeyboardHeight() {
		Rect r = new Rect();
		view.getWindowVisibleDisplayFrame(r);
		int visibleHeight = r.height();// 1134//1130
		if (mVisibleHeight == 0) {
			mVisibleHeight = visibleHeight;
			gethi(0);
			return;
		}

		if (mVisibleHeight == visibleHeight) {
			return;
		}
		gethi(2);
		mVisibleHeight = visibleHeight;
	}

	private void gethi(int i) {
		boolean bar = checkDeviceHasNavigationBar(mActivity);
		if (bar) {
			int barHeight = getNavigationBarHeight(mActivity);
			System.out.println(barHeight);
			if (i == 0) {
				view.setPadding(0, 0, 0, 0);
				view.invalidate();
			} else {
				view.setPadding(0, 0, 0, barHeight);
				view.invalidate();
			}
		}
	}

	/**
	 * 获取是否存在NavigationBar：
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkDeviceHasNavigationBar(Context context) {
		boolean hasNavigationBar = false;
		Resources rs = context.getResources();
		int id = rs
				.getIdentifier("config_showNavigationBar", "bool", "android");
		if (id > 0) {
			hasNavigationBar = rs.getBoolean(id);
		}
		try {
			Class systemPropertiesClass = Class
					.forName("android.os.SystemProperties");
			Method m = systemPropertiesClass.getMethod("get", String.class);
			String navBarOverride = (String) m.invoke(systemPropertiesClass,
					"qemu.hw.mainkeys");
			if ("1".equals(navBarOverride)) {
				hasNavigationBar = false;
			} else if ("0".equals(navBarOverride)) {
				hasNavigationBar = true;
			}
		} catch (Exception e) {
			// Log.w(TAG, e);
		}

		return hasNavigationBar;

	}

}
