package cn.gdcp.newsdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.gdcp.newsdemo.R;

/**
 * Created by Administrator on 2017/5/18.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView title;
    View view;


    public NewsViewHolder(View itemView) {
        super(itemView);
        view=itemView;
        imageView= (ImageView) itemView.findViewById(R.id.imgView);
        title= (TextView) itemView.findViewById(R.id.titleView);
    }
}
