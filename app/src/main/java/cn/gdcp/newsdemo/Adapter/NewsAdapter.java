package cn.gdcp.newsdemo.Adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.gdcp.newsdemo.Activity.ReadActivity;
import cn.gdcp.newsdemo.Data.NewsData;
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
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        final NewsData.ResultBean.DataBean news=mNewList.get(position);
        holder.title.setText(news.getTitle());

        Glide.with(holder.imageView.getContext())
                .load(news.getThumbnail_pic_s())
                .into(holder.imageView);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=news.getUrl();
                Intent intent = new Intent(holder.view.getContext(), ReadActivity.class);
                intent.putExtra(ReadActivity.URL_EXTRA, url);
                intent.putExtra(ReadActivity.KEY_EXTRA, news.getUniquekey());
                intent.putExtra(ReadActivity.TITLE_EXTRA, news.getTitle());
                holder.view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mNewList.size();
    }

    public void changData(List<NewsData.ResultBean.DataBean> mNewDataList) {
        this.mNewList=mNewDataList;
        notifyDataSetChanged();
    }
}

