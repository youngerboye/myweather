package com.example.myweaher.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author: Jackson Young
 * @data: 2020-03-23 12:05
 * @description: http工具类+
 */
public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}


