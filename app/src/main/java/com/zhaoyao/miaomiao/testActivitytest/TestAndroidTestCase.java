
package com.zhaoyao.miaomiao.testActivitytest;

import java.util.List;

import org.apache.http.Header;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.test.ActivityInstrumentationTestCase2;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhaoyao.miaomiao.http.UserRequest;
import com.zhaoyao.miaomiao.log.MMLog;
import com.zhaoyao.miaomiao.testActivitytest.http.JavaHttp;
import com.zhaoyao.miaomiao.testActivitytest.http.JavaHttp.HT;
import com.zhaoyao.miaomiao.util.HttpClientUtils;
/**<uses-permission android:name="android.permission.READ_PHONE_STATE"/> */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TestAndroidTestCase extends ActivityInstrumentationTestCase2<TestActivity> {
	public TestAndroidTestCase()
    {
        super(TestActivity.class); 
    }
	public void testnaa() {
//		MMTestAndroid android = new MMTestAndroid();
//		android.testgetdata(getActivity());
//		String url = "http://s.go.sohu.com/adgtr/?callback=sohu_moblie_callback13832286279648546595776714384&itemspaceid=13703&adps=30000001&adsrc=13&apt=4&turn=1&newschn=1393&_time_=1460439657013";
//		JavaHttp.httpGet(url, new HT() {
//			@Override
//			public void getData(String object) {
//				System.out.println(object);
//			}
//		});
//		String macFromWifi = getMacFromWifi(getActivity());
//		MMLog.i(macFromWifi);
//		String url = "http://api.budejie.com/api";
		String url = "http://api.budejie.com/api/api_open.php";
		AsyncHttpClient client = HttpClientUtils.getClient();
		RequestParams params = UserRequest.getRequestParams();
		params.put("a", "rate");
		params.put("ver", "6.3.7");
		params.put("visiting", "18034557");
		params.put("c", "topic");
		params.put("os", "5.1.1");
		params.put("mac", "d4%3A40%3Af0%3Ad0%3A3d%3A91");
		params.put("tid", "18025957");
		params.put("market", "taobao");
		params.put("uid", "18034557");
		params.put("appname", "baisibudejie");
		params.put("client", "18034557");
		params.put("uid", "android");
		params.put("action", "3");
		params.put("udid", "A0000055DDB626");
		client.post(url,params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] b) {
				String s = new String(b);
				System.out.println(s);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				System.out.println();
			}
		});
	}
	/**
	 * 设备开通WiFi连接，通过wifiManager获取Mac地址
	 *
	 * @author 高焕杰
	 */
	public static String getMacFromWifi(Context context){
	    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
	    if(wifiState == State.CONNECTED){//判断当前是否使用wifi连接
	        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);  
	        if (!wifiManager.isWifiEnabled()) { //如果当前wifi不可用 
	            wifiManager.setWifiEnabled(true);
	        }
	        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
	        return wifiInfo.getMacAddress();
	    }
	    return null;
	}
	
//	public void testname() throws Exception {
//		String phoneInfo = "Product: " + android.os.Build.PRODUCT;
//        phoneInfo += "\n CPU_ABI: " + android.os.Build.CPU_ABI;
//        phoneInfo += "\n TAGS: " + android.os.Build.TAGS;
//        phoneInfo += "\n VERSION_CODES.BASE: " + android.os.Build.VERSION_CODES.BASE;
//        phoneInfo += "\n MODEL: " + android.os.Build.MODEL;
//        phoneInfo += "\n SDK: " + android.os.Build.VERSION.SDK;
//        phoneInfo += "\n VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE;
//        phoneInfo += "\n DEVICE: " + android.os.Build.DEVICE;
//        phoneInfo += "\n DISPLAY: " + android.os.Build.DISPLAY;
//        phoneInfo += "\n BRAND: " + android.os.Build.BRAND;
//        phoneInfo += "\n BOARD: " + android.os.Build.BOARD;
//        phoneInfo += "\n FINGERPRINT: " + android.os.Build.FINGERPRINT;
//        phoneInfo += "\n ID: " + android.os.Build.ID;
//        phoneInfo += "\n MANUFACTURER: " + android.os.Build.MANUFACTURER;
//        phoneInfo += "\n USER: " + android.os.Build.USER;
//        System.out.println(phoneInfo);
//        String t=android.provider.Settings.System.getString(getActivity().getContentResolver(), "android_id"); 
//        System.out.println(t);//7ea1d246a46f1b6e
//	}
//    public void testSum()
//    {
//        assertEquals(5, getActivity().add(2, 3));
//    }
//	public void test() {
////		Intent intent = new Intent(getContext(),TestActivity.class);
////		getContext().startActivity(intent);
//		System.out.println("===========");
//	}
	public void t1estTelephonyManager() {
		TelephonyManager tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        StringBuilder sb = new StringBuilder();
        sb.append("\nDeviceId(IMEI) = " + tm.getDeviceId());
        int dataState = tm.getDataState();
        sb.append("\ndataState = " + dataState);
        sb.append("\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion());
        sb.append("\nLine1Number = " + tm.getLine1Number());
        sb.append("\nNetworkCountryIso = " + tm.getNetworkCountryIso());
        sb.append("\nNetworkOperator = " + tm.getNetworkOperator());
        sb.append("\nNetworkOperatorName = " + tm.getNetworkOperatorName());
        sb.append("\nNetworkType = " + tm.getNetworkType());
        sb.append("\nPhoneType = " + tm.getPhoneType());
        sb.append("\nSimCountryIso = " + tm.getSimCountryIso());
        sb.append("\nSimOperator = " + tm.getSimOperator());
        sb.append("\nSimOperatorName = " + tm.getSimOperatorName());
        sb.append("\nSimSerialNumber = " + tm.getSimSerialNumber());
        sb.append("\nSimState = " + tm.getSimState());
        sb.append("\nSubscriberId(IMSI) = " + tm.getSubscriberId());
        sb.append("\nVoiceMailNumber = " + tm.getVoiceMailNumber());
        List<CellInfo> allCellInfo = tm.getAllCellInfo();
        sb.append("\nallCellInfo = " + allCellInfo);
        String simSerialNumber = tm.getSimSerialNumber();
        sb.append("\nsimSerialNumber = " + simSerialNumber);
        int callState = tm.getCallState();
        sb.append("\ncallState = " + callState);
        CellLocation cellLocation = tm.getCellLocation();
        sb.append("\ncellLocation = " + cellLocation);
        int dataActivity = tm.getDataActivity();
        sb.append("\ndataActivity = " + dataActivity);
        String groupIdLevel1 = tm.getGroupIdLevel1();
        sb.append("\ngroupIdLevel1 = " + groupIdLevel1);
        MMLog.i("", sb.toString());
        String openudid = android.provider.Settings.System.getString(getActivity().getContentResolver(), "android_id");;
        String uuid = tm.getDeviceId();//A0000055DDB626
        String os_version = Build.VERSION.RELEASE;//5.1.1
        String os_api= Build.VERSION.SDK;//22
        String device_type= Build.PRODUCT;//SCL-CL00
	}
	/**
	 * 
DeviceId(IMEI) = A0000055DDB626
dataState = 0
DeviceSoftwareVersion = 5A
Line1Number = 
NetworkCountryIso = cn
NetworkOperator = 46011
NetworkOperatorName = 中国电信
NetworkType = 13
PhoneType = 2
SimCountryIso = cn
SimOperator = 46003
SimOperatorName = 中国电信
SimSerialNumber = 89860315940283959334
SimState = 5
SubscriberId(IMSI) = 460031278868920
VoiceMailNumber = *86
allCellInfo = [CellInfoCdma:{mRegistered=YES mTimeStampType=oem_ril mTimeStamp=1018913241157603ns CellIdentityCdma:{ mNetworkId=11 mSystemId=13898 mBasestationId=8474 mLongitude=1497176 mLatitude=439746} CellSignalStrengthCdma: cdmaDbm=-73 cdmaEcio=-70 evdoDbm=-2147483647 evdoEcio=-2147483647 evdoSnr=2147483647}, CellInfoLte:{mRegistered=YES mTimeStampType=oem_ril mTimeStamp=1018913241157603ns CellIdentityLte:{ mMcc=460 mMnc=11 mCi=163100977 mPci=66 mTac=39695} CellSignalStrengthLte: ss=20 rsrp=-100 rsrq=-7 rssnr=2147483647 cqi=2147483647 ta=2147483647}, CellInfoLte:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913241157603ns CellIdentityLte:{ mMcc=2147483647 mMnc=2147483647 mCi=2147483647 mPci=68 mTac=2147483647} CellSignalStrengthLte: ss=16 rsrp=-104 rsrq=-12 rssnr=2147483647 cqi=2147483647 ta=2147483647}, CellInfoLte:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913241157603ns CellIdentityLte:{ mMcc=2147483647 mMnc=2147483647 mCi=2147483647 mPci=5 mTac=2147483647} CellSignalStrengthLte: ss=12 rsrp=-112 rsrq=-13 rssnr=2147483647 cqi=2147483647 ta=2147483647}, CellInfoLte:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913241157603ns CellIdentityLte:{ mMcc=2147483647 mMnc=2147483647 mCi=2147483647 mPci=179 mTac=2147483647} CellSignalStrengthLte: ss=16 rsrp=-108 rsrq=-16 rssnr=2147483647 cqi=2147483647 ta=2147483647}, CellInfoGsm:{mRegistered=YES mTimeStampType=oem_ril mTimeStamp=1018913250951405ns CellIdentityGsm:{ mMcc=460 mMnc=1 mLac=33028 mCid=27924} CellSignalStrengthGsm: ss=29 ber=99}, CellInfoGsm:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913250951405ns CellIdentityGsm:{ mMcc=460 mMnc=1 mLac=33028 mCid=35235} CellSignalStrengthGsm: ss=15 ber=99}, CellInfoGsm:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913250951405ns CellIdentityGsm:{ mMcc=460 mMnc=1 mLac=33028 mCid=35234} CellSignalStrengthGsm: ss=15 ber=99}, CellInfoGsm:{mRegistered=NO mTimeStampType=oem_ril mTimeStamp=1018913250951405ns CellIdentityGsm:{ mMcc=460 mMnc=1 mLac=33028 mCid=33246} CellSignalStrengthGsm: ss=8 ber=99}]
simSerialNumber = 89860315940283959334
callState = 0
cellLocation = [8474,439746,1497176,13898,11]
dataActivity = 0
groupIdLevel1 = null



Product: SCL-CL00
 CPU_ABI: armeabi-v7a
 TAGS: release-keys
 VERSION_CODES.BASE: 1
 MODEL: SCL-CL00
 SDK: 22
 VERSION.RELEASE: 5.1.1
 DEVICE: hnSCL-Q
 DISPLAY: SCL-CL00C92B190
 BRAND: Honor
 BOARD: SCL-CL00
 FINGERPRINT: Honor/SCL-CL00/hnSCL-Q:5.1.1/HonorSCL-CL00/C92B190:user/release-keys
 ID: HonorSCL-CL00
 MANUFACTURER: HUAWEI
 USER: huawei
 
	 */
}
