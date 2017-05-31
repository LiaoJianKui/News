package cn.gdcp.newsdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.gdcp.newsdemo.R;

import static cn.gdcp.newsdemo.R.layout.activity_main;

/**
 * Created by Administrator on 2017/5/27 0027.
 */

public class MainFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList;
    private ArrayList<String> mTitleList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFragmentArrayList();
        initTitleList();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(activity_main,container,false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        if(mPagerAdapter==null){
            mPagerAdapter=new cn.gdcp.newsdemo.Adapter.PagerAdapter(getFragmentManager(), mFragmentArrayList, mTitleList);
        }

        mPagerAdapter=new cn.gdcp.newsdemo.Adapter.PagerAdapter(getFragmentManager(),mFragmentArrayList,mTitleList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void initTitleList() {
        if(mTitleList==null){
            mTitleList = new ArrayList<String>();
        }
        mTitleList.add("头条");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("科技");
    }

    private void initFragmentArrayList() {
        if(mFragmentArrayList==null){
            mFragmentArrayList = new ArrayList<NewsFragment>();
        }
        NewsFragment top=new NewsFragment();
        Bundle bundle1=new Bundle();
        bundle1.putInt("NEWSTYPE",1);
        top.setArguments(bundle1);
        mFragmentArrayList.add(top);

        NewsFragment yule=new NewsFragment();
        Bundle bundle2=new Bundle();
        bundle2.putInt("NEWSTYPE",2);
        yule.setArguments(bundle2);
        mFragmentArrayList.add(yule);

        NewsFragment tiyu=new NewsFragment();
        Bundle bundle3=new Bundle();
        bundle3.putInt("NEWSTYPE",3);
        tiyu.setArguments(bundle3);
        mFragmentArrayList.add(tiyu);

        NewsFragment keji=new NewsFragment();
        Bundle bundle4=new Bundle();
        bundle4.putInt("NEWSTYPE",4);
        keji.setArguments(bundle4);
        mFragmentArrayList.add(keji);

    }

}
