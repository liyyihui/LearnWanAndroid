package com.lyh.learnwanandroid.View;

import com.scu.miomin.shswiperefresh.core.SHSwipeRefreshLayout;

public interface MainView extends View ,SHSwipeRefreshLayout.SHSOnRefreshListener{
    /**
     * 设置数据
     *
     * @param obj
     */
    void setData(Object obj);
    /**
     * 设置Banner数据
     *
     * @param obj
     */
    void  serBanner(Object obj);
      /**
       * 加载更多
       * */
    void  loandData(Object obj);

    /**
     * 下拉刷新数据跟新
     * */
    void refreshData(Object obj);
}
