package com.tgb.lk.ahibernate.dialog;
//package com.zhaoyao.miaomiao.dialog;
//
//import java.util.List;
//
//import android.annotation.TargetApi;
//import android.app.Activity;
//import android.content.Context;
//import android.os.Build;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup.LayoutParams;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//
//import com.zhaoyao.miaomiao.R;
//import com.zhaoyao.miaomiao.adapter.ViewHolder;
//import com.zhaoyao.miaomiao.adapter.ZhaoYaoAdapter;
//
//@TargetApi(Build.VERSION_CODES.KITKAT)
//public class MorePopDialog {
//private  PopupWindow window;
//private  PopupWindow searchwindow;
//private MorePopDialoginterface dialoginterface;
//public MorePopDialoginterface getDialoginterface() {
//	return dialoginterface;
//}
//public void setDialoginterface(MorePopDialoginterface dialoginterface) {
//	this.dialoginterface = dialoginterface;
//}
//public interface MorePopDialoginterface{
//	/***
//	 * 取消收藏    0   
//	 * 点击收藏     1  
//	 * 搜索药品     2  
//	 * @param i
//	 */
//	void up(int i);
//}
//
//private  ZhaoYaoAdapter<String> adapter;
//	private View inflate;
//	public MorePopDialog(Context context , int LayoutId) {
//		this.inflate = LayoutInflater.from(context).inflate(LayoutId, null);
//	}
//	public  void showPopUp(final Context context,List<String> list , View v) {
//	if (window==null) {
//		ListView lview = (ListView)inflate.findViewById(R.id.listView1); 
//		window = new PopupWindow(inflate,160,LayoutParams.WRAP_CONTENT);
//		window.setAnimationStyle(R.style.AnimationPreview);
////		window.setFocusable(true);  
////		window.setOutsideTouchable(true);  
////		window.setBackgroundDrawable(new BitmapDrawable());
//		int[] location = new int[2];
//		v.getLocationOnScreen(location);
//			adapter = new ZhaoYaoAdapter<String>(context, list, R.layout.item_more_pop_dialog) {
//				@Override
//				public void convert(ViewHolder helper, String item) {
//					helper.setText(R.id.tv_item_more_pop_dialog, item);
//				}
//			};
//			lview.setOnItemClickListener(new OnItemClickListener() {
//				@Override
//				public void onItemClick(AdapterView<?> parent, View view,
//						int position, long id) {
//					if(dialoginterface==null)return;
//					if(!net.isNetworkAvailable(context))return;
//					String trim = (String) parent.getItemAtPosition(position);
//					if ("取消收藏".equals(trim)) {
//						dialoginterface.up(0);
//					}
//					else if ("点击收藏".equals(trim)) {
//						dialoginterface.up(1);
//					}
//					else if ("搜索药品".equals(trim)) {
//						dialoginterface.up(2);
//					}
//					window.dismiss();
//				}
//			});
//			lview.setAdapter(adapter);
//	}else {
//		adapter.notifyDataSetChanged();
//	}
//	showPopuPwindow(context, v);
//}
//	private void showPopuPwindow(Context context, View parent) {
//		//设置整个popupwindow的样式。  
//        window.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.popup_bg));
//        //使窗口里面的空间显示其相应的效果，比较点击button时背景颜色改变。  
//        //如果为false点击相关的空间表面上没有反应，但事件是可以监听到的。  
//        //listview的话就没有了作用。  
//		backgroundAlpha(20f, context);  
//        window.setFocusable(true);//如果不设置setFocusable为true，popupwindow里面是获取不到焦点的，那么如果popupwindow里面有输入框等的话就无法输入。  
//        window.setOutsideTouchable(true);  
//        window.setAnimationStyle(android.R.style.Animation_Dialog);
//        window.update();  
////        window.showAsDropDown(parent);
////        window.showAtLocation(parent, Gravity.CENTER, 0, 0);
//        window.showAsDropDown(parent);
//	}  
//	/**
//	 * 设置添加屏幕的背景透明度
//	 * @param bgAlpha
//	 */
//	public void backgroundAlpha(float bgAlpha,Context context)
//	{
//		WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
//		lp.alpha = bgAlpha; //0.0-1.0
//		((Activity) context).getWindow().setAttributes(lp);
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	private void showsearchPopuPwindow(Context context, View parent) {
//		//设置整个popupwindow的样式。  
//		searchwindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.popup_bg));  
//        //使窗口里面的空间显示其相应的效果，比较点击button时背景颜色改变。  
//        //如果为false点击相关的空间表面上没有反应，但事件是可以监听到的。  
//        //listview的话就没有了作用。  
//		backgroundAlpha(20f, context);  
//		searchwindow.setFocusable(true);//如果不设置setFocusable为true，popupwindow里面是获取不到焦点的，那么如果popupwindow里面有输入框等的话就无法输入。  
//        searchwindow.setOutsideTouchable(true);  
//        searchwindow.setAnimationStyle(android.R.style.Animation_Dialog);
//        searchwindow.update();  
////        searchwindow.showAsDropDown(parent);
//        searchwindow.showAtLocation(parent, Gravity.CENTER, 0, 0);
//	}  
//	private int type = 0;
//
//}
