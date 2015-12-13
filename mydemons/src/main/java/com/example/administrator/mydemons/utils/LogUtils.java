package com.example.administrator.mydemons.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/12/13.
 */
public class LogUtils {
   private  static boolean isShowLog=true;

    public static void i(String str){
        if(isShowLog){
            Log.i("",str);
        }

    }
    public static void e(String str){
        if(isShowLog){
            Log.e("",str);
        }

    }

}
