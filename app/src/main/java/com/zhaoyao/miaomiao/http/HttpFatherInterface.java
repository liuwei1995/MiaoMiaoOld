package com.zhaoyao.miaomiao.http;

import com.zhaoyao.miaomiao.http.kugou.ResultKuGou;

public interface HttpFatherInterface {
	void completeResult(boolean istrue, Result result);
	void completeNeiHanDuanZiResult(boolean istrue, ResultNeiHanDuanZi result);
	void completeKuGouResultResult(boolean istrue, ResultKuGou result);;
	void complete(boolean istrue, String s);
}
