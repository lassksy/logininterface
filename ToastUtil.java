package com.example.test1.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mTosat;

    public static void showMsg(Context context, String msg) {
        if (mTosat ==  null){
            mTosat = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            mTosat.setText(msg);
        }
        mTosat.show();
    }
}
