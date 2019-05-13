package com.lyh.learnwanandroid.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManger {

      private static final String baseUrl = "https://www.wanandroid.com";
    private static HttpManger mInstance;
    private static Retrofit retrofit;
    private static volatile Api request = null;

    public static HttpManger getInstance() {
        if (mInstance == null) {
            synchronized (HttpManger.class) {
                if (mInstance == null) {
                    mInstance = new HttpManger();
                }
            }
        }
        return mInstance;
    }

    private HttpManger() {
        init();
    }

    /**
     * 初始化必要对象和参数
     */
    public void init() {
        // 初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Api getRequest() {
        if (request == null) {
            synchronized (Api.class) {
                request = retrofit.create(Api.class);
            }
        }
        return request;
    }
}
