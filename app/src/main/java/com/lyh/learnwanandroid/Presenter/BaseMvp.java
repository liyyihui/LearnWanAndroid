package com.lyh.learnwanandroid.Presenter;

import com.lyh.learnwanandroid.Model.Model;
import com.lyh.learnwanandroid.View.View;

public interface BaseMvp <M extends Model,V extends View ,P extends Presenter>  {
    M createModel();

    V createView();

    P createPresenter();
}
