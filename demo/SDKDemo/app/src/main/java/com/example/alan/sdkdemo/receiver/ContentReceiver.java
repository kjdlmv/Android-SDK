package com.example.alan.sdkdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.vcrtc.registration.VCService;

import static com.vcrtc.registration.VCService.MSG;


/**
 * Created by ricardo
 * 2019/7/11.
 * @author ricardo
 */
public class ContentReceiver extends BroadcastReceiver {
    private boolean onLine;
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(MSG);
        final String TAG = "ContentReceiver";
        switch (message){
            case VCService.MSG_LOGIN_SUCCESS:
                Log.i(TAG, "登录成功");
                break;
            case VCService.MSG_LOGIN_FAILED:
                String reason = intent.getStringExtra(VCService.DATA_BROADCAST);
                Log.i(TAG, "登录失败" + reason);
                break;
            case VCService.MSG_USER_INFO:
                String userJson = intent.getStringExtra(VCService.DATA_BROADCAST);
                Log.i(TAG, "用户信息" + userJson);
                break;
            case VCService.MSG_SESSION_ID:
                String sessionID = intent.getStringExtra(VCService.DATA_BROADCAST);
                Log.i(TAG, "sessionID:" + sessionID);
                break;
            case VCService.MSG_ONLINE_STATUS:
                onLine = intent.getBooleanExtra(VCService.DATA_BROADCAST, false);
                Log.i(TAG, "在线状态:" + onLine);
                break;
            case VCService.MSG_LOGOUT:
                Log.i(TAG, "账号在别的端登录");
                break;
            case VCService.MSG_INCOMING:
                if (onLine){
                    // 当前处于在线状态，可以去处理收到的消息
                    Log.i(TAG, "收到消息,当前在线");
                }else {
                    Log.i(TAG, "收到消息,当前离线");
                }

                break;
            case VCService.MSG_INCOMING_CANCELLED:
                // 公有云会收到对方取消通话的消息
                break;
            default:
        }
    }
}
