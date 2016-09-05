package com.jsj.fragmentviewpagerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jsj.fragmentviewpagerdemo.base.BaseFragment;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private String[] tabTitle;
    private ArrayList<BaseFragment> mFragmmentList = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm,ArrayList<BaseFragment> mFragmmentList,String[] tabTitle) {
        super(fm);
        this.tabTitle = tabTitle;
        this.mFragmmentList = mFragmmentList;
    }

    @Override
    public int getCount() {
        return mFragmmentList.size();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mFragmmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}