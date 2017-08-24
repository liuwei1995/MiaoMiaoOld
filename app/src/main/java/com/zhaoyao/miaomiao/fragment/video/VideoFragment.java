package com.zhaoyao.miaomiao.fragment.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.zhaoyao.miaomiao.MainActivity;
import com.zhaoyao.miaomiao.R;
import com.zhaoyao.miaomiao.fragment.dt.DTLatestOnFragment;
import com.zhaoyao.miaomiao.fragment.show.PicFragment;
import com.zhaoyao.miaomiao.fragment.video.souhu.VideoFunnyFragment;
import com.zhaoyao.miaomiao.util.inject.InjectView;
import com.zhaoyao.miaomiao.util.inject.ViewInject;

import java.util.ArrayList;
import java.util.List;
/**
 * http://connect.qq.com/sdk/webtools/index.html分享的接口文档
 * @author dell
 *
 */
@SuppressLint("Recycle")
public class VideoFragment extends Fragment {
	private MainActivity context;
	public VideoFragment(Context context) {
		this.context = (MainActivity) context;
	}
	@ViewInject(id = R.id.et_video_activity_main,click = "doClick")
	private EditText et_video_activity_main;
	@ViewInject(id = R.id.rl_entertainment)
	private RelativeLayout rl_entertainment;
	private static final int ZOO = 0;
	private static final int ONE = 1;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
		};
	};
	private List<Fragment> list = new ArrayList<Fragment>();
	private VideoTvFragment tv;
	private VideoAnimeFragment Anime;
	private VideoMusicFragment Music;
	private VideoVarietyFragment Variety;
	private VideoNewsFragment News;
	private VideoEntertainmentFragment Entertainment;
	private VideoFunnyFragment Funny;
	private PicFragment pic;
	private DTLatestOnFragment DTLatestOn;
//	private JokesFragment Jokes;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.video_activity_main, null);
//		Jokes = new JokesFragment(context);
		pic = PicFragment.newInstance();
		DTLatestOn = DTLatestOnFragment.newInstance(context);
		 tv = new VideoTvFragment(context);
		 Funny = new VideoFunnyFragment(context);
		 Anime = new VideoAnimeFragment(context);
		 Variety = new VideoVarietyFragment(context);
		 Music = new VideoMusicFragment(context);
		 News = new VideoNewsFragment(context);
		 Entertainment = new VideoEntertainmentFragment(context);
//		 list.add(Jokes);
		 list.add(pic);
		 list.add(DTLatestOn);
		list.add(tv);
		list.add(Funny);
		list.add(Anime);
		list.add(Variety);
		list.add(Music);
		list.add(News);
		list.add(Entertainment);
		getFragmentManager().beginTransaction()
//		.add(R.id.rl_entertainment, Jokes).show(Jokes)
		.add(R.id.rl_entertainment, pic).show(pic)
		.add(R.id.rl_entertainment, DTLatestOn).hide(DTLatestOn)
		.add(R.id.rl_entertainment, tv).hide(tv)
		.add(R.id.rl_entertainment, Funny).hide(Funny)
		.add(R.id.rl_entertainment, Anime).hide(Anime)
		.add(R.id.rl_entertainment, Variety).hide(Variety)
		.add(R.id.rl_entertainment, Music).hide(Music)
		.add(R.id.rl_entertainment, News).hide(News)
		.add(R.id.rl_entertainment, Entertainment).hide(Entertainment)
		.commit();
		return inflate;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		InjectView.Inject(this);
		super.onActivityCreated(savedInstanceState);
	}
	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.et_video_activity_main:
			context.onClick();
			break;
		default:
			break;
		}
	}
	public void fristClick(View view) {
		int i = 0;
		switch (view.getId()) {
		case R.id.textView8://段子
			i=0;
//			Jokes.fristClick(); 
			pic.fristClick(); 
			break;
		case R.id.textView9://段子
			i=1;
//			Jokes.fristClick(); 
			DTLatestOn.fristClick(); 
			break;
		case R.id.textView1://电视
			tv.fristClick();
			i=2;
			break;
		case R.id.textView7://娱乐
			i=3;
			Funny.fristClick(); 
			break;
		case R.id.textView2://动漫
			Anime.fristClick();
			i=4;
			break;
		case R.id.textView3://综艺
			i=5;
			Variety.fristClick();
			break;
		case R.id.textView4://音乐
			i=6;
			Music.fristClick();
			break;
		case R.id.textView5://新闻
			i=7;
			News.fristClick();
			break;
		case R.id.textView6://娱乐
			i = 8;
			Entertainment.fristClick(); 
			break;
		default:
			break;
		}
		setColor(i);
	}
	private void setColor(int i) {
		FragmentTransaction trx = ((FragmentActivity)context).getSupportFragmentManager()
				.beginTransaction();
		for (int j = 0; j < list.size(); j++) {
			if(i==j){
				trx.show(list.get(j));continue;
			}
			trx.hide(list.get(j));
		}
		trx.commit();
	}
	@Override
	public void onStart() {
		super.onStart();
	}
	@Override
	public void onPause() {
		super.onPause();
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

    @Override
    public void onDestroyView() {
    	super.onDestroyView();
    }
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}
