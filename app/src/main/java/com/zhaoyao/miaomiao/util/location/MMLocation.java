package com.zhaoyao.miaomiao.util.location;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.zhaoyao.miaomiao.log.MMLog;

/**
 * 
 * 
* @author  作者 lw: 
* @version 创建时间：2016年4月10日上午10:03:18 
* 		        类说明   :  获取经度纬度
 */
public class MMLocation {
	private final static String TAG = MMLocation.class.getSimpleName();
	private MMLocation() {
	}
	/**间隔变化时间刷新一次*/
	private long time = 10*60*1000;
	private static MMLocation mmlocation;
	/**地理位置管理器  */
	private LocationManager locationManager;
	/**可用的位置提供器   名字*/
	private String locationProvider;
	/**获得对象*/
	public static MMLocation getMMLocation(){
		if(mmlocation==null)
		  mmlocation = new MMLocation();
		return mmlocation;
	}
	/**初始化定位器
	 * 用完之后记得调 
	 * {@link MMLocation#removeLocationListener()}  
	 * @param context  
	 */
	public void getLocation(Context context) {
		if(locationManager==null)
		//获取地理位置管理器  
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);  
        //获取所有可用的位置提供器  
        List<String> providers = locationManager.getProviders(true);  
        if(providers.contains(LocationManager.GPS_PROVIDER)){  
            //如果是GPS  
            locationProvider = LocationManager.GPS_PROVIDER;  
        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){  
            //如果是Network  
            locationProvider = LocationManager.NETWORK_PROVIDER;  
        }else{  
            MMLog.i(TAG, "----------没有可用的位置提供器");
            return ;  
        }  
        //获取Location  
        Location location = locationManager.getLastKnownLocation(locationProvider);  
        if(location!=null){  
            //不为空,显示地理位置经纬度  
            showLocation(location);  
        }  
        //监视地理位置变化  
        locationManager.requestLocationUpdates(locationProvider, time, 1, inItLocationListener());  
	}
	private static double am_latitude = 30.535486;
	private static double am_longitude = 103.973115;
	public static double getam_latitude() {
		return am_latitude;
	}
	public static double getam_longitude() {
		return am_longitude;
	}
	/** 
     * 显示地理位置经度和纬度信息 
     * @param location 
     */  
    private void showLocation(Location location){  
    	am_latitude = location.getLatitude();
    	am_longitude = location.getLongitude();
        String locationStr = "维度：" + location.getLatitude() +"\n"   
                + "经度：" + location.getLongitude();  
        MMLog.i(TAG, locationStr);
    }  
    private LocationListener locationListener;
    private LocationListener inItLocationListener(){
    	if(locationListener==null)
    	/** 
         * LocationListern监听器 
         * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器 
         */  
         locationListener =  new LocationListener() {  
              
            @Override  
            public void onStatusChanged(String provider, int status, Bundle arg2) {  
                  
            }  
              
            @Override  
            public void onProviderEnabled(String provider) {  
                  
            }  
              
            @Override  
            public void onProviderDisabled(String provider) {  
                  
            }  
              
            @Override  
            public void onLocationChanged(Location location) {  
                //如果位置发生变化,重新显示  
                showLocation(location);  
                  
            }  
        };
		return locationListener;  
    }
    
    /**
     * 移除监听器 
     */
    public void removeLocationListener() {
    	if(locationManager!=null&&locationListener!=null){  
            //移除监听器  
            locationManager.removeUpdates(locationListener);  
        }  
	}
}
