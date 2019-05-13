package com.lyh.learnwanandroid.Model;

import android.util.Log;

import com.lyh.learnwanandroid.Error.ExceptionHandle;
import com.lyh.learnwanandroid.Model.EntityModel.Home_Artice_List;
import com.lyh.learnwanandroid.Retrofit.HttpManger;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class  MainModel implements Model {
    private Home_Artice_List mHome_artice_list;
    public MainModel() {


    }

   public Home_Artice_List getmHome_artice_list(){
        return  mHome_artice_list;
   }


    public void stopRequest() {
        Log.i("MainModelImpl", "stop request...");
    }
}
