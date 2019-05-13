package com.lyh.learnwanandroid.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.lyh.learnwanandroid.Model.EntityModel.Home_Artice_List;
import com.lyh.learnwanandroid.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainRvAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {
    List<Home_Artice_List.DataBean.DatasBean> data;
    public MainRvAdapter(List<Home_Artice_List.DataBean.DatasBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_rv_item,viewGroup,false);
            return new MainViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

                            MainViewHolder mainViewHolder = (MainViewHolder) viewHolder;
                            mainViewHolder.item_title.setText(data.get(position).getTitle());
                            mainViewHolder.item_user.setText("作者："+data.get(position).getAuthor());
                            mainViewHolder.item_class.setText("分类："+data.get(position).getChapterName());
                            mainViewHolder.item_src.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(mainViewHolder.item_class.getContext(),"收藏点击",Toast.LENGTH_SHORT).show();
                                }
                            });
                            mainViewHolder.item_layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(mainViewHolder.item_class.getContext(),"item点击",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }




    @Override
    public int getItemViewType(int position) {

            return position;

    }




    @Override
    public int getItemCount() {

        return data == null ? 0 :data.size();
    }

    public void setData( List<Home_Artice_List.DataBean.DatasBean> loanddata){
        this.data.addAll(loanddata);
        notifyDataSetChanged();
    }
    public void setnewData( List<Home_Artice_List.DataBean.DatasBean> loanddata){
        this.data.clear();
        this.data.addAll(loanddata);
        notifyDataSetChanged();
    }

}


class MainViewHolder extends  RecyclerView.ViewHolder{
     @BindView(R.id.item_layout)
    CardView item_layout;
    @BindView(R.id.item_src)
    ImageView item_src;
    @BindView(R.id.item_title)
    TextView item_title;
    @BindView(R.id.item_user)
    TextView item_user;
    @BindView(R.id.item_class)
    TextView item_class;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}



