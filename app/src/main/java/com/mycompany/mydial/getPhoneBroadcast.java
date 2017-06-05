package com.mycompany.mydial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/6/4.
 */

public class getPhoneBroadcast extends BroadcastReceiver {

    public String phonenumber = null;

    @Override
    public void onReceive(Context context, Intent intent) {
         phonenumber = getResultData();
    }
}
