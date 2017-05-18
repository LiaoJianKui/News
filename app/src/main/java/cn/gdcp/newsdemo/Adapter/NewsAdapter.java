package cn.gdcp.newsdemo.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.gdcp.newsdemo.Bean.NewsData;
import cn.gdcp.newsdemo.R;

/**
 * Created by Administrator on 2017/5/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
   private List<NewsData.ResultBean.DataBean> mNewList;

    public NewsAdapter(List<NewsData.ResultBean.DataBean> newList){
        this.mNewList=newList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        NewsViewHolder viewHolder=new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsData.ResultBean.DataBean news=mNewList.get(position);
        holder.title.setText(news.getTitle());

        Glide.with(holder.imageView.getContext())
                .load(news.getThumbnail_pic_s())
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return mNewList.size();
    }

    public void changData(List<NewsData.ResultBean.DataBean> mNewDataList) {
        notifyDataSetChanged();
    }
}

