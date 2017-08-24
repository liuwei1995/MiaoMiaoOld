
package com.zhaoyao.miaomiao.util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
/**
 * 
* @author 作者 lw: 
* @version 创建时间：2016年4月9日 下午4:24:46 
* 类说明 :  Glide 配置
 */
public class MyGlideModule implements GlideModule {
    @Override public void applyOptions(Context context, GlideBuilder builder) {
        // Apply options to the builder here.
    }

    @Override public void registerComponents(Context context, Glide glide) {
        // register ModelLoaders here.
    }
}
