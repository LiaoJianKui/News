package cn.gdcp.newsdemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.gdcp.newsdemo.Adapter.NewsAdapter;
import cn.gdcp.newsdemo.Bean.NewsData;
import cn.gdcp.newsdemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/5/17.
 */

public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<NewsData.ResultBean.DataBean> mNewDataList=new ArrayList<>();
    private NewsAdapter mNewsAdapter;
    private static final int MSG_GET_NEWS = 1001;
    private final String URL_TOP = "http://v.juhe.cn/toutiao/index?type=top&key=d189a4c3af5e703aa385a9b86cc0660c";
    private final String URL_YULE = "http://v.juhe.cn/toutiao/index?type=yule&key=d189a4c3af5e703aa385a9b86cc0660c";
    private final String URL_TIYU = "http://v.juhe.cn/toutiao/index?type=tiyu&key=d189a4c3af5e703aa385a9b86cc0660c";
    private final String URL_KEJI = "http://v.juhe.cn/toutiao/index?type=keji&key=d189a4c3af5e703aa385a9b86cc0660c";
    private android.os.Handler mHandler;
    private  int mType;
    static final   int TOP=1;
    static final  int YULE=2;
    static final  int TIYU=3;
    static final  int KEJI=4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.news_fragment,container,false);
       mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        mNewsAdapter=new NewsAdapter(mNewDataList);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType=getArguments().getInt("NEWSTYPE");
        initHandler();
        getNewsFromJuhe();
    }

    private void initHandler() {
        mHandler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_GET_NEWS){
                    mNewsAdapter.changData(mNewDataList);
                    return  true;
                }
                return false;
            }
        });
    }

    private void getNewsFromJuhe() {
        OkHttpClient client=new OkHttpClient();
        Request request;
        switch (mType){
            case TOP:
                request=new Request.Builder().url(URL_TOP).build();
                break;
            case YULE:
                request=new Request.Builder().url(URL_YULE).build();
                break;
            case KEJI:
                request=new Request.Builder().url(URL_KEJI).build();
                break;
            case TIYU:
                request=new Request.Builder().url(URL_TIYU).build();
                break;
            default:
                request=new Request.Builder().url(URL_TOP).build();
                break;
        }

        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AAAA","Get data fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson  gson=new Gson();
                NewsData newsData=gson.fromJson(response.body().string(),NewsData.class);
                mNewDataList=newsData.getResult().getData();
                mHandler.sendEmptyMessage(MSG_GET_NEWS);

            }
        });
    }




}
