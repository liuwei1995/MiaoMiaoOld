package com.zhaoyao.miaomiao.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatUtil {
	public static String DateYMD() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return format.format(date);
	}
	public static String DateYM() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date date = new Date();
		return format.format(date);
	}
	public static String DateY() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();
		return format.format(date);
	}
}
