package cn.gdcp.newsdemo.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import cn.gdcp.newsdemo.Fragment.NewsFragment;
import cn.gdcp.newsdemo.R;


public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList;
    private ArrayList<String> mTitleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFragmentArrayList();
        initTitleList();
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter=new cn.gdcp.newsdemo.Adapter.PagerAdapter(getSupportFragmentManager(),mFragmentArrayList,mTitleList);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
