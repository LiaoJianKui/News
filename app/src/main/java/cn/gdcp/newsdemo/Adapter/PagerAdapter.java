package cn.gdcp.newsdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import cn.gdcp.newsdemo.Fragment.NewsFragment;

/**
 * Created by Administrator on 2017/5/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<NewsFragment> mFragmentArrayList;
    private ArrayList<String> mTitleList;
    public PagerAdapter(FragmentManager fm, ArrayList<NewsFragment> fragmentArrayList, ArrayList<String> titleList) {
        super(fm);
        this.mFragmentArrayList = fragmentArrayList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        if(position < mFragmentArrayList.size()){
            return mFragmentArrayList.get(position);
        }
        return null;

    }

    @Override
    public int getCount() {
        if(mFragmentArrayList == null){
            return 0;
        }
        return mFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitleList != null && position < mTitleList.size()) {
            return mTitleList.get(position);
        }

        return "notitle";
    }
}
