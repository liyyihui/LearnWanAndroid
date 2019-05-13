package com.lyh.learnwanandroid.Retrofit;

import com.lyh.learnwanandroid.Model.EntityModel.Banner;
import com.lyh.learnwanandroid.Model.EntityModel.Home_Artice_List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface Api {
    @GET("/article/list/0/json")
    Observable<Home_Artice_List> HomeApi();

    @GET()
    Observable<Home_Artice_List> HomeApiNextdata(@Url String url );

    @GET("/banner/json")
    Observable<Banner> HomeBanner();
}
