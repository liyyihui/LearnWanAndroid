package com.lyh.learnwanandroid.Ui;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lyh.learnwanandroid.BroadcastReceiver.NetBroadcastReceiver;
import com.lyh.learnwanandroid.BroadcastReceiver.NetChangeListener;
import com.lyh.learnwanandroid.Model.Model;
import com.lyh.learnwanandroid.Presenter.BaseMvp;
import com.lyh.learnwanandroid.Presenter.Presenter;
import com.lyh.learnwanandroid.R;
import com.lyh.learnwanandroid.Util.NetUtil;
import com.lyh.learnwanandroid.Util.Utils;
import com.lyh.learnwanandroid.View.View;

public abstract class BaseActivity <M extends Model,V extends View,P extends Presenter> extends AppCompatActivity implements BaseMvp<M,V,P>,NetChangeListener {
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();
         if(presenter!=null){
             presenter.registerModel(createModel());
             presenter.registerView(createView());
         }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            NetBroadcastReceiver  netBroadcastReceiver = new NetBroadcastReceiver(this);
            //注册广播接收
            registerReceiver(netBroadcastReceiver, filter);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //Activity销毁时的调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
    }
    @Override
    public void onChangeListener(int status) {
        if(status == NetUtil.NETWORK_NONE){
            Utils.init().mToast(BaseActivity.this,"请检查网络");
        }else {
          //  Utils.init().mToast(BaseActivity.this,"网络已恢复正常");
        }
    }
}
