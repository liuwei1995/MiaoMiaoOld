package com.zhaoyao.miaomiao.util.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * view inect by id
 * 
 * @author liuwei
 * 
 */
@Target(ElementType.FIELD)
// 表示用在字段上
@Retention(RetentionPolicy.RUNTIME)
// 表示在生命周期是运行时
public @interface ViewInject {
	/**view 的id    与OnClick  一起用*/
	int value() default 0;
	
	/**view 的id    与click(  一起用*/
	public int id() default 0;

	/** view 的 layout*/
	public int layout() default 0;

	/**view 在其他view view需要在 类中注入*/ 
	public String inView() default "";
	/**点击事件   传入方法名字*/
	public String click() default "";

	/**长按*/ 
	public String longClick() default "";

	/**adapterview 的单个item的点击事件*/ 
	public String itemClick() default "";

	/**adapterview 的单个对象的长点击*/ 
	public String itemLongClick() default "";
}
