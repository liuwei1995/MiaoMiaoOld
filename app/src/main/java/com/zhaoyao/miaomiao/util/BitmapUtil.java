package com.zhaoyao.miaomiao.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

public final class BitmapUtil {
	private static BitmapUtil bitmapUtil;
	
	private BitmapUtil() {
	}
	public static BitmapUtil getInstance() {
		if(bitmapUtil==null)
			bitmapUtil = new BitmapUtil();
		return bitmapUtil;
	}
	/**
	 *取得指定区域的图形
	 * @param source
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public static Bitmap getBitmap(Bitmap source,int x,int y,int width,int height) {
		Bitmap bitmap = Bitmap.createBitmap(source, x, y, width, height);
		return bitmap;
	}

	/**
	 * 从大图中截取小图
	 * @param r
	 * @param resourseId
	 * @param row
	 * @param col
	 * @param rowTotal
	 * @param colTotal
	 * @return
	 */
	public static Bitmap getImage(Context context,Bitmap source,
			int row,
			int col,
			int rowTotal,
			int colTotal,
			float multiple,
			boolean isRecycle) {
		Bitmap temp = getBitmap(source, 
				(col-1)*source.getWidth()/colTotal, 
				(row-1)*source.getHeight()/rowTotal, 
				source.getWidth()/colTotal, 
				source.getHeight()/rowTotal);
		
		if(isRecycle) {
			recycleBitmap(source);
		}
		if(multiple != 1.0) {
			Matrix matrix = new Matrix();
            matrix.postScale(multiple, multiple);
            temp = Bitmap.createBitmap(temp, 0, 0,temp.getWidth(), temp.getHeight(), matrix, true);
		}
		return temp;
	}
	/**
	 * 从大图中截取小图
	 * @param r
	 * @param resourseId
	 * @param row
	 * @param col
	 * @param rowTotal
	 * @param colTotal
	 * @return
	 */
	public static Drawable getDrawableImage(Context context,Bitmap source,int row,int col,int rowTotal,int colTotal,float multiple) {

		Bitmap temp = getBitmap(source, (col-1)*source.getWidth()/colTotal, (row-1)*source.getHeight()/rowTotal, source.getWidth()/colTotal, source.getHeight()/rowTotal);
		if(multiple != 1.0) {
			Matrix matrix = new Matrix();
            matrix.postScale(multiple, multiple);
            temp = Bitmap.createBitmap(temp, 0, 0,temp.getWidth(), temp.getHeight(), matrix, true);
		}
		Drawable d = new BitmapDrawable(context.getResources(),temp);
		return d;
	}

	public static Drawable[] getDrawables(Context context,int resourseId,int row,int col,float multiple) {
		Drawable drawables[] = new Drawable[row*col];
		Bitmap source = decodeResource(context, resourseId);
		int temp = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				drawables[temp] = getDrawableImage(context,source, i, j, row, col,multiple);
				temp ++;
			}
		}
		if(source != null && !source.isRecycled()) {
			source.recycle();
			source = null;
		}
		return drawables;
	}

	public static Drawable[] getDrawables(Context context,String resName,int row,int col,float multiple) {
		Drawable drawables[] = new Drawable[row*col];
		Bitmap source = decodeBitmapFromAssets(resName,context);
		int temp = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				drawables[temp] = getDrawableImage(context,source, i, j, row, col,multiple);
				temp ++;
			}
		}
		if(source != null && !source.isRecycled()) {
			source.recycle();
			source = null;
		}
		return drawables;
	}
	/**
	 * 根据一张大图，返回切割后的图元数组
	 * @param resourseId:资源id
	 * @param row：总行数
	 * @param col：总列数
	 * multiple:图片缩放的倍数1:表示不变，2表示放大为原来的2倍
	 * @return
	 */
	public static Bitmap[] getBitmaps(Context context,int resourseId,int row,int col,float multiple) {
		Bitmap bitmaps[] = new Bitmap[row*col];
		Bitmap source = decodeResource(context, resourseId);
		int temp = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				bitmaps[temp] = getImage(context,source, i, j, row, col,multiple,false);
				temp ++;
			}
		}
		if(source != null && !source.isRecycled()) {
			source.recycle();
			source = null;
		}
		return bitmaps;
	}

	public static Bitmap[] getBitmaps(Context context,String resName,int row,int col,float multiple) {
		Bitmap bitmaps[] = new Bitmap[row*col];
		Bitmap source = decodeBitmapFromAssets(resName,context);
		int temp = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				bitmaps[temp] = getImage(context,source, i, j, row, col,multiple,false);
				temp ++;
			}
		}
		if(source != null && !source.isRecycled()) {
			source.recycle();
			source = null;
		}
		return bitmaps;
	}

	public static Bitmap[] getBitmapsByBitmap(Context context,Bitmap source,int row,int col,float multiple) {
		Bitmap bitmaps[] = new Bitmap[row*col];
		int temp = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				bitmaps[temp] = getImage(context,source, i, j, row, col,multiple,false);
				temp ++;
			}
		}
		return bitmaps;
	}

	public static Bitmap decodeResource(Context context,int resourseId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
	    opt.inPreferredConfig = Config.ARGB_8888;
	    opt.inPurgeable = true;
	    opt.inInputShareable = true; //需把 inPurgeable设置为true，否则被忽略
	       //获取资源图片
	    InputStream is = context.getResources().openRawResource(resourseId);
	    return BitmapFactory.decodeStream(is,null,opt);  //decodeStream直接调用JNI>>nativeDecodeAsset()来完成decode，无需再使用<a href="http://lib.csdn.net/base/17" class="replace_word" title="Java EE知识库" target="_blank" style="color:#df3434; font-weight:bold;">java</a>层的createBitmap，从而节省了java层的空间
	}

	/**
	 * 从assets文件下解析图片
	 * @param resName
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Bitmap decodeBitmapFromAssets(String resName,Context context) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Config.ARGB_8888;
		options.inPurgeable = true;
		options.inInputShareable = true;
		InputStream in = null;
		try {
			//in = AssetsResourcesUtil.openResource(resName);
			in =context.getAssets().open(resName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return BitmapFactory.decodeStream(in, null, options);
	}


	/**
	 * 回收不用的bitmap
	 * @param b
	 */
	public static void recycleBitmap(Bitmap b) {
		if(b != null && !b.isRecycled()) {
			b.recycle();
			b = null;
		}
	}
	/**
	 * 获取某些连在一起的图片的某一个画面（图片为横着排的情况）
	 * @param source
	 * @param frameIndex  从1开始
	 * @param totalCount
	 * @return
	 */
	public static Bitmap getOneFrameImg(Bitmap source, int frameIndex, int totalCount){
		 int singleW = source.getWidth() / totalCount;
		 return Bitmap.createBitmap(source,(frameIndex - 1) * singleW,0, singleW,source.getHeight());
	}

	public static void recycleBitmaps(Bitmap bitmaps[]) {
		if(bitmaps != null){
			for(Bitmap b:bitmaps) {
				recycleBitmap(b);
			}
			bitmaps = null;
		}
	}

	/**
	 * drawable转换成bitmap
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {
		if(drawable instanceof BitmapDrawable) {
			return ((BitmapDrawable)drawable).getBitmap();
		}else if(drawable instanceof NinePatchDrawable) {
			Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != PixelFormat.OPAQUE
										? Config.ARGB_8888 : Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

			drawable.draw(canvas);
			return bitmap;
		}else {
			throw new IllegalArgumentException("can not support this drawable to bitmap now!!!");
		}
	}
	
    /**

     * 由资源id获取图片

     *

     * @param context

     * @param resId

     * @return

     */

    public static Drawable getDrawableById(Context context, int resId) {

              if (context == null) {

                       return null;

              }

              return context.getResources().getDrawable(resId);

    }



    /**

     * 由资源id获取位图

     *

     * @param context

     * @param resId

     * @return

     */

    public static Bitmap getBitmapById(Context context, int resId) {

              if (context == null) {

                       return null;

              }

              return BitmapFactory.decodeResource(context.getResources(), resId);

    }



    /**

     * 将Bitmap转化为字节数组

     *

     * @param bitmap

     * @return

     */

    public static byte[] bitmap2byte(Bitmap bitmap) {

              ByteArrayOutputStream baos = null;

              try {

                       baos = new ByteArrayOutputStream();

                       bitmap.compress(CompressFormat.PNG, 100, baos);

                       byte[] array = baos.toByteArray();

                       baos.flush();

                       baos.close();

                       return array;

              } catch (Exception e) {

                       e.printStackTrace();

              }

              return null;



    }



    /**

     * 将byte数组转化为bitmap

     *

     * @param data

     * @return

     */

    public static Bitmap byte2bitmap(byte[] data) {

              if (null == data) {

                       return null;

              }

              return BitmapFactory.decodeByteArray(data, 0, data.length);

    }



    /**

     * 将Drawable转化为Bitmap

     *

     * @param drawable

     * @return

     */

    public static Bitmap drawable2bitmap(Drawable drawable) {

              if (null == drawable) {

                       return null;

              }

              int width = drawable.getIntrinsicWidth();

              int height = drawable.getIntrinsicHeight();

              Bitmap bitmap = Bitmap.createBitmap(width, height, drawable

                                .getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888

                                : Config.RGB_565);

              Canvas canvas = new Canvas(bitmap);

              drawable.setBounds(0, 0, width, height);

              drawable.draw(canvas);// 重点

              return bitmap;



    }



    /**

     * 将bitmap转化为drawable

     *

     * @param bitmap

     * @return

     */

    public static Drawable bitmap2Drawable(Bitmap bitmap) {

              if (bitmap == null) {

                       return null;

              }

              return new BitmapDrawable(bitmap);

    }



    /**

     * 按指定宽度和高度缩放图片,不保证宽高比例

     *

     * @param bitmap

     * @param w

     * @param h

     * @return

     */

    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {

              if (bitmap == null) {

                       return null;

              }

              int width = bitmap.getWidth();

              int height = bitmap.getHeight();

              Matrix matrix = new Matrix();

              float scaleWidht = ((float) w / width);

              float scaleHeight = ((float) h / height);

              matrix.postScale(scaleWidht, scaleHeight);

              Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,

                                matrix, true);

              return newbmp;

    }



    /**

     * 将bitmap位图保存到path路径下，图片格式为Bitmap.CompressFormat.PNG，质量为100

     *

     * @param bitmap

     * @param path

     */

    public static boolean saveBitmap(Bitmap bitmap, String path) {

              try {

                       File file = new File(path);

                       File parent = file.getParentFile();

                       if (!parent.exists()) {

                                parent.mkdirs();

                       }

                       FileOutputStream fos = new FileOutputStream(file);

                       boolean b = bitmap.compress(CompressFormat.PNG, 100, fos);

                       fos.flush();

                       fos.close();

                       return b;

              } catch (FileNotFoundException e) {

                       e.printStackTrace();

              } catch (IOException e) {

                       e.printStackTrace();

              }

              return false;

    }



    /**

     * 将bitmap位图保存到path路径下

     *

     * @param bitmap

     * @param path

     *            保存路径-Bitmap.CompressFormat.PNG或Bitmap.CompressFormat.JPEG.PNG

     * @param format

     *            格式

     * @param quality

     *            Hint to the compressor, 0-100. 0 meaning compress for small

     *            size, 100 meaning compress for max quality. Some formats, like

     *            PNG which is lossless, will ignore the quality setting

     * @return

     */

    public static boolean saveBitmap(Bitmap bitmap, String path,

                       CompressFormat format, int quality) {

              try {

                       File file = new File(path);

                       File parent = file.getParentFile();

                       if (!parent.exists()) {

                                parent.mkdirs();

                       }

                       FileOutputStream fos = new FileOutputStream(file);

                       boolean b = bitmap.compress(format, quality, fos);

                       fos.flush();

                       fos.close();

                       return b;

              } catch (FileNotFoundException e) {

                       e.printStackTrace();

              } catch (IOException e) {

                       e.printStackTrace();

              }

              return false;

    }



    /**

     * 获得圆角图片

     *

     * @param bitmap

     * @param roundPx

     * @return

     */

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {

              if (bitmap == null) {

                       return null;

              }



              Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),

                                bitmap.getHeight(), Config.ARGB_8888);

              Canvas canvas = new Canvas(output);



              final int color = 0xff424242;

              final Paint paint = new Paint();

              final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

              final RectF rectF = new RectF(rect);



              paint.setAntiAlias(true);

              canvas.drawARGB(0, 0, 0, 0);

              paint.setColor(color);

              canvas.drawRoundRect(rectF, roundPx, roundPx, paint);



              paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));

              canvas.drawBitmap(bitmap, rect, rect, paint);



              return output;

    }



    /**

     * 获得带倒影的图片

     */

    public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {

              if (bitmap == null) {

                       return null;

              }

              final int reflectionGap = 4;

              int width = bitmap.getWidth();

              int height = bitmap.getHeight();



              Matrix matrix = new Matrix();

              matrix.preScale(1, -1);



              Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, height / 2,

                                width, height / 2, matrix, false);



              Bitmap bitmapWithReflection = Bitmap.createBitmap(width,

                                (height + height / 2), Config.ARGB_8888);



              Canvas canvas = new Canvas(bitmapWithReflection);

              canvas.drawBitmap(bitmap, 0, 0, null);

              Paint deafalutPaint = new Paint();

              canvas.drawRect(0, height, width, height + reflectionGap, deafalutPaint);



              canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);



              Paint paint = new Paint();

              LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,

                                bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,

                                0x00ffffff, TileMode.CLAMP);

              paint.setShader(shader);

              // Set the Transfer mode to be porter duff and destination in

              paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));

              // Draw a rectangle using the paint with our linear gradient

              canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()

                                + reflectionGap, paint);



              return bitmapWithReflection;

    }
}
