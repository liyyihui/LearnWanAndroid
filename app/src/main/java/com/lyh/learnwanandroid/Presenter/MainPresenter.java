package com.lyh.learnwanandroid.Presenter;


import android.util.Log;
import com.lyh.learnwanandroid.Error.ExceptionHandle;
import com.lyh.learnwanandroid.Model.EntityModel.Banner;
import com.lyh.learnwanandroid.Model.EntityModel.Home_Artice_List;
import com.lyh.learnwanandroid.Model.MainModel;
import com.lyh.learnwanandroid.Model.Observer;
import com.lyh.learnwanandroid.Retrofit.HttpManger;
import com.lyh.learnwanandroid.Util.NetUtil;
import com.lyh.learnwanandroid.View.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView,MainModel> {
    boolean isnet = true;
    int next = 1;
    //用来标记是否正在向上滑动
    private boolean isSlidingUpward = false;
    public void getData() {//这里要注意判空（view和model可能为空）
        if (!isnet)return;

        HttpManger.getInstance().init();
         HttpManger.getRequest().HomeApi()
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Home_Artice_List>() {
            @Override
            public void OnSuccess(Home_Artice_List home_artice_list) {
                if(getView()!=null){
                    getView().setData(home_artice_list);
                }
            }
            @Override
            public void OnFail(ExceptionHandle.ResponeThrowable e) {
                Log.e("LYH",e.toString());
            }

            @Override
            public void OnCompleted() {

            }

            @Override
            public void OnDisposable(Disposable d) {

            }
        });

        HttpManger.getRequest().HomeBanner()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Banner>() {
            @Override
            public void OnSuccess(Banner banner) {
                if(getView()!=null){
                    getView().serBanner(banner);

                }
            }

            @Override
            public void OnFail(ExceptionHandle.ResponeThrowable e) {
                Log.e("LYH",e.toString());
            }

            @Override
            public void OnCompleted() {

            }

            @Override
            public void OnDisposable(Disposable d) {

            }
        });


    }



    @Override
    protected void onViewDestroy() {
        if (model != null) {
            model.stopRequest();
        }
    }




    private void onLoadMore(int next) {
        HttpManger.getInstance().init();
        HttpManger.getRequest().HomeApiNextdata("/article/list/"+next+"/json").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Home_Artice_List>() {
            @Override
            public void OnSuccess(Home_Artice_List home_artice_list) {
                  getView().loandData(home_artice_list);
            }

            @Override
            public void OnFail(ExceptionHandle.ResponeThrowable e) {
                Log.e("LYH",e.toString());
            }

            @Override
            public void OnCompleted() {

            }

            @Override
            public void OnDisposable(Disposable d) {

            }
        });
    }

   public  void onLoadMore(){
        if (isnet){
            onLoadMore(next);
        }

   }
   public void Refresh(){
       if (!isnet)return;
       HttpManger.getInstance().init();
       HttpManger.getRequest().HomeApi()
               .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Home_Artice_List>() {
           @Override
           public void OnSuccess(Home_Artice_List home_artice_list) {
               if(getView()!=null){
                   getView().refreshData(home_artice_list);
               }
           }
           @Override
           public void OnFail(ExceptionHandle.ResponeThrowable e) {
               Log.e("LYH",e.toString());
           }

           @Override
           public void OnCompleted() {

           }

           @Override
           public void OnDisposable(Disposable d) {

           }
       });

   }


}
