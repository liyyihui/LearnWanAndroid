package com.lyh.learnwanandroid.Ui.ViewPageFrame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyh.learnwanandroid.Adapter.MainRvAdapter;
import com.lyh.learnwanandroid.R;
import com.scu.miomin.shswiperefresh.core.SHSwipeRefreshLayout;
import com.wenjian.loopbanner.LoopBanner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFrame extends Fragment {
    @BindView(R.id.banner_tv)
    LoopBanner banner_tv;
    @BindView(R.id.main_list)
    public RecyclerView rv;
    @BindView(R.id.swipeRefreshLayout)
    SHSwipeRefreshLayout refresh;
    MainRvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.main_frame,container,false);
        ButterKnife.bind(this,view);
        return  view;
    }
}
