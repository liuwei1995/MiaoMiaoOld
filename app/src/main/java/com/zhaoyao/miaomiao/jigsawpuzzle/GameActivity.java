package com.zhaoyao.miaomiao.jigsawpuzzle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.jigsawpuzzle.view.GamePintuLayout;
import com.zhaoyao.miaomiao.jigsawpuzzle.view.GamePintuLayout.GamePintuListener;

public class GameActivity extends Activity {

	private GamePintuLayout mGamePintuLayout;
	private TextView mLevel;
	private TextView mTime;
	private TextView id_nandu;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置没有标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_main);
        mTime = (TextView) findViewById(R.id.id_time);
        mLevel = (TextView) findViewById(R.id.id_level);
        id_nandu = (TextView) findViewById(R.id.id_nandu);
        id_nandu.setText("简单");
        id_nandu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				id_nandu.setFocusable(false);
				String trim = id_nandu.getText().toString().trim();
				int number = 2;
				if("简单".equals(trim)){
					id_nandu.setText("中级");number=3;
				}else if ("中级".equals(trim)) {
					id_nandu.setText("高级");number=4;
				}else if ("高级".equals(trim)) {
					id_nandu.setText("牛逼");number=5;
				}else if ("牛逼".equals(trim)) {
					id_nandu.setText("简单");number=2;
				}
				mGamePintuLayout.mColumn = number;
				mGamePintuLayout.nextLevel();
//				mGamePintuLayout.nanDu(number);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						id_nandu.setFocusable(true);
					}
				}, 1000);
			}
		});
        mGamePintuLayout = (GamePintuLayout) findViewById(R.id.id_game_pintu);
        mGamePintuLayout.setTimeEabled(true);
        mGamePintuLayout.setOnGamePintuListener(new GamePintuListener() {
			
			@Override
			public void timeChanged(int currentTime) {
				if(currentTime>=999){
					mTime.setTextSize(25);
					mTime.setText("" + currentTime+"+");
				}else {
					mTime.setText("" + currentTime);
				}
			}
			
			@Override
			public void nextLevel(final int nextLevel) {
				switch (nextLevel) {
				case 2:
					Toast.makeText(GameActivity.this, "笨蛋渣渣哒~", Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(GameActivity.this, "笨蛋萌萌哒~", Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(GameActivity.this, "笨蛋么么哒~", Toast.LENGTH_SHORT).show();
					break;
				default:
					Toast.makeText(GameActivity.this, "笨蛋棒棒哒~", Toast.LENGTH_SHORT).show();
					break;
				}
				new AlertDialog.Builder(GameActivity.this)
				.setTitle("游戏提示信息").setMessage("成功过关！！！")
				.setIcon(R.drawable.icon)
				.setPositiveButton("进入第 " + nextLevel +" 关", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mGamePintuLayout.nextLevel();
						mLevel.setText("" + nextLevel);
					}
				}).setNegativeButton("放弃闯关", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						System.exit(0);
					}
				}).show();
			}
			
			@Override
			public void gameOver() {
				new AlertDialog.Builder(GameActivity.this)
				.setTitle("游戏提示信息").setMessage("游戏结束！！！")
				.setIcon(R.drawable.icon)
				.setPositiveButton("再玩一次", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mGamePintuLayout.reStart();
					}
				}).setNegativeButton("退出游戏", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						System.exit(0);						
					}
				}).show();
			}
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		mGamePintuLayout.pause();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	@Override
	protected void onResume() {
		super.onResume();
		mGamePintuLayout.reSume();
	}
}
