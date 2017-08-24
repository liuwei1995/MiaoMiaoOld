package com.zhaoyao.miaomiao.util.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/**
 * Activity
 * @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		InjectObject.Inject(this);
	}
 * Fragment
 * @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		InjectObject.Inject(this);
	}
 * @author lw
 *
 */

public class InjectView{
	
	@Target(ElementType.FIELD)
	// 表示用在字段上
	@Retention(RetentionPolicy.RUNTIME)
	// 表示在生命周期是运行时
	public static @interface OnClick{
		/** view 的 id*/
		public int[] id() default 0;
		/**点击事件   传入方法名字*/
		public String click() default "";
	}
	public static void Inject(Object object) {
		if(object == null)return;
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();// 获得Activity中声明的字段
		if (object instanceof Activity || object instanceof FragmentActivity) {
			InjectActivity(fields, object);
		}else if (object instanceof Fragment) {
			InjectFragment(fields, object);
		}else if (object instanceof LinearLayout||object instanceof RelativeLayout) {
			inView(fields, object);
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			boolean present = methods[i].isAnnotationPresent(OnClick.class);
			if(present){
				OnClick onClick = methods[i].getAnnotation(OnClick.class);
				int[] id = onClick.id();
				String clickMethod = methods[i].getName();
				if(id != null && clickMethod != null && !clickMethod.trim().equals("")){
					if(object instanceof Activity){
						for (int j = 0; j < id.length; j++) {
							
							((Activity)object).findViewById(id[j]).setOnClickListener(new EventListener(object)
							.click(clickMethod));
						}
					}else if (object instanceof Fragment) {
						Fragment fragment = (Fragment) object;
						View view = fragment.getView();
						for (int j = 0; j < id.length; j++) {
							view.findViewById(id[j]).setOnClickListener(new EventListener(object)
							.click(clickMethod));
						}
					}else if (object instanceof LinearLayout||object instanceof RelativeLayout) {
						for (int j = 0; j < id.length; j++) {
							
							((View)object).findViewById(id[j]).setOnClickListener(new EventListener(object)
							.click(clickMethod));
						}
					}
				}
			}
		}
	}
	public  <T extends TotalInterface> InjectView Inject(View view) {
		viewInject(view);
		return this;
	}
	public  <T extends TotalInterface> InjectView Inject(View view,T click) {
		viewInject(view);
		setListener(click);
		return this;
	}
	private InjectView viewInject(View view) {
		if(view == null)return this;
		list = new ArrayList<Map<String, View>>();
		Class<?> clazz = view.getClass();
		Field[] fields = clazz.getDeclaredFields();// 获得Activity中声明的字段
		for (Field field : fields) {
			try {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(ViewInject.class)) {
					ViewInject inject = field.getAnnotation(ViewInject.class);
					int id = inject.id();
					field.setAccessible(true);
					View v = null;
					if(id == 0){
						id = inject.value();
					}if(id != 0){
						 v = view.findViewById(id);
						field.set(view, v);
					}
					Map<String, View> map = new HashMap<String, View>();
					String clickMethod = inject.click();
					if (!TextUtils.isEmpty(clickMethod))
						map.put("OnClickListener", v);
					String longClick = inject.longClick();
					if (!TextUtils.isEmpty(longClick))
						map.put("OnLongClickListener", v);
					String itemClickMethod = inject.itemClick();
					if (!TextUtils.isEmpty(itemClickMethod))
						map.put("OnItemClickListener", v);
					String itemLongClickMethod = inject.itemLongClick();
					if (!TextUtils.isEmpty(itemLongClickMethod))
						map.put("OnItemLongClickListener", v);
					list.add(map);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	private static List<Map<String, View>> list;
	public <T extends TotalInterface> InjectView setListener(T object) {
		if (!(object instanceof TotalInterface))return this;
		TotalInterface totalInterface = object;
		if(list==null||object==null)return this;
		for (int i = 0; i < list.size(); i++) {
			Map<String, View> map = list.get(i);
			for (String click : map.keySet()) {
				if ("OnClickListener".equals(click)) {
					map.get(click).setOnClickListener(totalInterface);continue;
				}
				if ("OnLongClickListener".equals(click)) {
					map.get(click).setOnLongClickListener(totalInterface);continue;
				}
				if ("OnItemClickListener".equals(click)) {
					if(map.get(click) instanceof AbsListView){
						((AbsListView)map.get(click)).setOnItemClickListener(totalInterface);
					}if (map.get(click) instanceof AdapterView) {
						AdapterView adapterView = (AdapterView) map.get(click);
						adapterView.setOnItemClickListener(totalInterface);
					}continue;
				}
				if ("OnItemLongClickListener".equals(click)) {
					if(map.get(click) instanceof AbsListView){
						AbsListView absListView = (AbsListView) map.get(click);
						absListView.setOnItemLongClickListener(totalInterface);
					}if (map.get(click) instanceof AdapterView) {
						AdapterView adapterView = (AdapterView) map.get(click);
						adapterView.setOnItemLongClickListener(totalInterface);
					}continue;
				}
			}
		}
		return this;
	}	
	private static View InjectFragment(Field[] fields,Object object){
		Fragment fragment = (Fragment) object;
		View view = fragment.getView();
		if(view==null)return null;
		set(fields, object, view);
		return view;
	}
	private static View inView(Field[] fields, Object object) {
		if(object==null)return null;
		View view = (View) object;
		set(fields, object, view);
		return view;
	}
	private static void set(Field[] fields, Object object, View view) {
		for (Field field : fields) {
			try {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(ViewInject.class)) {
					ViewInject inject = field.getAnnotation(ViewInject.class);
					int id = inject.id();
					field.setAccessible(true);
					if(id == 0){
						id = inject.value();
					}if(id != 0){
						View v = view.findViewById(id);
						field.set(object, v);
					}
					setListener(object, field, inject);
				}else if (field.isAnnotationPresent(OnClick.class)) {
					OnClick click = field.getAnnotation(OnClick.class);
					int[] id = click.id();
					String clickMethod = click.click();
					if(id != null && clickMethod != null && !clickMethod.trim().equals(""))
					for (int i = 0; i < id.length; i++) {
						view.findViewById(id[i]).setOnClickListener(new EventListener(object)
						.click(clickMethod));
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	private static void InjectActivity(Field[] fields,Object object){
		Activity activity = (Activity) object;
		for (Field field : fields) {
			try {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(ViewInject.class)) {
					ViewInject inject = field.getAnnotation(ViewInject.class);
					int id = inject.id();
					field.setAccessible(true);
					if(id == 0){
						id = inject.value();
					}if(id != 0){
						View v = activity.findViewById(id);
						field.set(object, v);
					}
					setListener(object, field, inject);
				}else if (field.isAnnotationPresent(OnClick.class)) {
					OnClick click = field.getAnnotation(OnClick.class);
					int[] id = click.id();
					String clickMethod = click.click();
					if(id != null && clickMethod != null && !clickMethod.trim().equals(""))
					for (int i = 0; i < id.length; i++) {
						activity.findViewById(id[i]).setOnClickListener(new EventListener(activity)
						.click(clickMethod));
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	private static <T extends TotalInterface> void setListener(View object, Field field, ViewInject inject,T click) {
		String clickMethod = inject.click();
		if (!TextUtils.isEmpty(clickMethod))
			if (click instanceof OnClickListener) {
				object.setOnClickListener(click);
			}
		
		String longClickMethod = inject.longClick();
		if (!TextUtils.isEmpty(longClickMethod))
		if (click instanceof OnLongClickListener) {
			object.setOnLongClickListener(click);
		}
		String itemClickMethod = inject.itemClick();
		if (!TextUtils.isEmpty(itemClickMethod))
			if (click instanceof OnItemClickListener) {
				if(object instanceof AbsListView){
					AbsListView absListView = (AbsListView) object;
					absListView.setOnItemClickListener(click);
				}if (object instanceof AdapterView) {
					AdapterView adapterView = (AdapterView) object;
					adapterView.setOnItemClickListener(click);
				}
			}
		String itemLongClickMethod = inject.itemLongClick();
		if (!TextUtils.isEmpty(itemLongClickMethod))
			if (click instanceof OnItemLongClickListener) {
				if(object instanceof AbsListView){
					AbsListView absListView = (AbsListView) object;
					absListView.setOnItemLongClickListener(click);
				}if (object instanceof AdapterView) {
					AdapterView adapterView = (AdapterView) object;
					adapterView.setOnItemLongClickListener(click);
				}
			}
	}
	private static void setListener(Object object, Field field, ViewInject inject) {
		String clickMethod = inject.click();
		if (!TextUtils.isEmpty(clickMethod))
			setViewClickListener(object, field, clickMethod);

		String longClickMethod = inject.longClick();
		if (!TextUtils.isEmpty(longClickMethod))
			setViewLongClickListener(object, field, longClickMethod);

		String itemClickMethod = inject.itemClick();
		if (!TextUtils.isEmpty(itemClickMethod))
			setItemClickListener(object, field, itemClickMethod);

		String itemLongClickMethod = inject.itemLongClick();
		if (!TextUtils.isEmpty(itemLongClickMethod))
			setItemLongClickListener(object, field, itemLongClickMethod);
	}
	private static void setViewClickListener(Object activity, Field field,
			String clickMethod) {
		try {
			Object obj = field.get(activity);
			if (obj instanceof View) {
				((View) obj).setOnClickListener(new EventListener(activity)
						.click(clickMethod));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setViewLongClickListener(Object activity, Field field,
			String clickMethod) {
		try {
			Object obj = field.get(activity);
			if (obj instanceof View) {
				((View) obj).setOnLongClickListener(new EventListener(activity)
						.longClick(clickMethod));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setItemClickListener(Object activity, Field field,
			String itemClickMethod) {
		try {
			Object obj = field.get(activity);
			if (obj instanceof AdapterView) {
				((AdapterView) obj).setOnItemClickListener(new EventListener(
						activity).itemClick(itemClickMethod));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setItemLongClickListener(Object activity, Field field,
			String itemClickMethod) {
		try {
			Object obj = field.get(activity);
			if (obj instanceof AdapterView) {
				((AdapterView) obj)
						.setOnItemLongClickListener(new EventListener(activity)
								.itemLongClick(itemClickMethod));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
