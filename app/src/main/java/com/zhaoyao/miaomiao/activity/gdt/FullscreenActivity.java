package com.zhaoyao.miaomiao.activity.gdt;//package com.zhaoyao.miaomiao.activity.gdt;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.widget.FrameLayout;
//import android.widget.Toast;
//
//import com.qq.e.ads.splash.SplashAD;
//import com.qq.e.ads.splash.SplashADListener;
//import com.qq.e.union.demo.Constants;
//import com.zhaoyao.miaomiao.R;
//
//public class FullscreenActivity extends Activity {
//    protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_fullscreen);
//    //准备展示开屏广告的容器
//    FrameLayout container = (FrameLayout) this
//            .findViewById(R.id.splashcontainer);      
//    new SplashAD(this, container, Constants.APPID, Constants.SplashPosId, new SplashADListener() {
//		@Override
//		public void onNoAD(int arg0) {
//			
//		}
//		
//		@Override
//		public void onADTick(long arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void onADPresent() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void onADDismissed() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void onADClicked() {
//			// TODO Auto-generated method stub
//			
//		}
//	});
//    //创建开屏广告，广告拉取成功后会自动展示在container中。Container会首先被清空
//    new SplashAD(this, container, Constants.APPID, Constants.SplashPosId,
//            new SplashAdListener() {
//                //广告拉取成功开始展示时调用
//                public void onAdPresent() {
//                    Log.i("test", "present");
//                    Toast.makeText(FullscreenActivity.this,
//                            "SplashPresent", Toast.LENGTH_LONG).show();
//                }
//                //广告拉取超时（3s）或者没有广告时调用，errCode参见SplashAd类的常量声明
//                public void onAdFailed(int errCode) {
//                    Toast.makeText(FullscreenActivity.this,
//                            "SplashFail"+errCode, Toast.LENGTH_LONG).show();
//                    FullscreenActivity.this.finish();
//                }
//                //广告展示时间结束（5s）或者用户点击关闭时调用。
//                public void onAdDismissed() {
//                    Toast.makeText(FullscreenActivity.this,
//                            "SplashDismissed", Toast.LENGTH_LONG).show();
//                    FullscreenActivity.this.finish();
//                }
//            });
//    }
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//    //阻止用户在展示过程中点击手机返回键，推荐开发者使用
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//}
