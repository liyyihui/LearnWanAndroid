package com.lyh.learnwanandroid.Presenter;

import com.lyh.learnwanandroid.Model.Model;
import com.lyh.learnwanandroid.View.View;

import java.lang.ref.WeakReference;

public abstract class BasePresenter < V extends View,M extends Model> implements Presenter<V,M> {

    /**
     * 使用弱引用来防止内存泄漏
     */
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<V>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    /**
     * 在Activity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();
}
