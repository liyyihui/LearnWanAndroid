package com.lyh.learnwanandroid.Ui;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.lyh.learnwanandroid.Adapter.MainRvAdapter;
import com.lyh.learnwanandroid.Model.EntityModel.Banner;
import com.lyh.learnwanandroid.Model.EntityModel.Home_Artice_List;
import com.lyh.learnwanandroid.Model.MainModel;
import com.lyh.learnwanandroid.Presenter.MainPresenter;
import com.lyh.learnwanandroid.R;
import com.lyh.learnwanandroid.View.MainView;
import com.scu.miomin.shswiperefresh.core.SHSwipeRefreshLayout;
import com.wenjian.loopbanner.LoopAdapter;
import com.wenjian.loopbanner.LoopBanner;
import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends BaseActivity<MainModel,MainView,MainPresenter> implements MainView {

    LoopBanner banner_tv;

   public RecyclerView rv;

    SHSwipeRefreshLayout refresh;
   MainRvAdapter adapter;
   @BindView(R.id.main_viewpager)
    ViewPager viewPager;
   @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        if (presenter != null) {
           // presenter.getData();
        }
      //  refresh.setOnRefreshListener(this);
    }


    @Override
    public MainModel createModel() {
        return new MainModel();
    }

    @Override
    public MainView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void setData(Object data) {
  if(data instanceof Home_Artice_List){
      Home_Artice_List mdata = (Home_Artice_List) data;
        if(adapter==null){
            adapter = new MainRvAdapter(mdata.getData().getDatas());
        }
      LinearLayoutManager layoutManager = new LinearLayoutManager(this );
      //设置布局管理器
      rv.setLayoutManager(layoutManager);
      //设置为垂直布局，这也是默认的
      layoutManager.setOrientation(OrientationHelper. VERTICAL);
      //设置Adapter
      rv.setAdapter(adapter);
      //设置分隔线
      // rv.addItemDecoration( new DividerGridItemDecoration(this ));
      //设置增加或删除条目的动画
      rv.setItemAnimator( new DefaultItemAnimator());

  }

    }

    @Override
    public void serBanner(Object obj) {
        if(banner_tv == null){
            Log.e("LYH","banner_tv == null");
            return;
        }
          if(obj instanceof Banner){
              Banner data = (Banner) obj;

            banner_tv.setAdapter(new LoopAdapter<Banner.DataBean>(data.getData()) {
                @Override
                protected void onBindView(ViewHolder holder, Banner.DataBean data, int position) {
                 Glide.with(holder.getContext()).load(data.getImagePath()).into((ImageView) holder.itemView);
                 holder.itemView.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Toast.makeText(holder.getContext(),"点击"+position,Toast.LENGTH_SHORT).show();
                     }
                 });
                }
            });
          }
    }

    @Override
    public void loandData(Object obj) {
             if(obj instanceof Home_Artice_List){
                 adapter.setData(((Home_Artice_List) obj).getData().getDatas());
                 refresh.finishLoadmore();
             }
    }



    @Override
    public void refreshData(Object obj) {
        if(obj instanceof Home_Artice_List){
            adapter.setnewData(((Home_Artice_List) obj).getData().getDatas());
            refresh.finishRefresh();
        }
    }


    @Override
    public void onRefresh() {

        if(presenter!=null){
            presenter.Refresh();
        }
    }

    @Override
    public void onLoading() {

          if(presenter!=null){
              presenter.onLoadMore();
          }
    }

    @Override
    public void onRefreshPulStateChange(float v, int i) {

    }

    @Override
    public void onLoadmorePullStateChange(float v, int i) {

    }



}
