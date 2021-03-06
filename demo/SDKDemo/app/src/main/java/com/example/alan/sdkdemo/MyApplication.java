package com.example.alan.sdkdemo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.vcrtc.VCRTCPreferences;
import com.vcrtc.utils.LogUtil;
import com.vcrtc.webrtc.RTCManager;

/**
 * Created by ricardo
 * 2019/7/4.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RTCManager.init(this);
        RTCManager.DEVICE_TYPE = "Android";
        RTCManager.OEM = "";
        VCRTCPreferences prefs = new VCRTCPreferences(this);
        prefs.setPrintLogs(true);
        LogUtil.startWriteLog(this);
        CrashReport.initCrashReport(getApplicationContext(), "941e592e23", true);


    }
}
