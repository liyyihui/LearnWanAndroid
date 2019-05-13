package com.lyh.learnwanandroid.Util;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    private static  Utils utils;

    private Utils() {

    }
    public static Utils init(){
        synchronized(Utils.class){
            if(utils == null){
                utils = new Utils();
            }
        }
        return utils;
    }

    public void mToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();

    }
}
