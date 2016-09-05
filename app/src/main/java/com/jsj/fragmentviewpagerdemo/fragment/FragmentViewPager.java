package com.jsj.fragmentviewpagerdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.adapter.MyPagerAdapter;
import com.jsj.fragmentviewpagerdemo.base.BaseFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;

/**
 * Created by jsj on 16/9/5.
 */
public class FragmentViewPager extends Fragment {

    private ArrayList<BaseFragment> mFragmmentList = new ArrayList<>();
    private String[] mTabTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewpager, container, false);
        mTabTitle = getResources().getStringArray(R.array.street_tab_title);//设置tob 的标题
        ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();
        FragmentC fragmentC = new FragmentC();
        mFragmmentList.add(fragmentA);
        mFragmmentList.add(fragmentB);
        mFragmmentList.add(fragmentC);
        viewpager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager(),mFragmmentList, mTabTitle));
        viewpager.setOffscreenPageLimit(3);
        final TabPageIndicator mTabPageIndicator = (TabPageIndicator) view.findViewById(R.id.tabPageindicator);
        mTabPageIndicator.setViewPager(viewpager, 0);//给tob 设置viewpager
        UnderlinePageIndicator underlinePageindicator = (UnderlinePageIndicator)view.findViewById(R.id.underlinePageindicator);//滑动线
        underlinePageindicator.setFades(false);
        underlinePageindicator.setViewPager(viewpager);
        underlinePageindicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                final int itemIndex = i;
                mTabPageIndicator.setCurrentItem(itemIndex);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        return view;
    }
}
