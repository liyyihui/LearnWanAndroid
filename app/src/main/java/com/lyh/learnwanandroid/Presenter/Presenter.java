package com.lyh.learnwanandroid.Presenter;

import com.lyh.learnwanandroid.BroadcastReceiver.NetChangeListener;
import com.lyh.learnwanandroid.Model.Model;
import com.lyh.learnwanandroid.View.View;

public interface Presenter < V extends View,M extends Model>  {

    /**
     * 注册Model层
     *
     * @param BaseModel
     */
    void registerModel(M BaseModel);
    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Activity、Fragment的卸载）
     */
    void destroy();
}
