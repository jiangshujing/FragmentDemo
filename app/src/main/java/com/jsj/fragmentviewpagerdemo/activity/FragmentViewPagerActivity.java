package com.jsj.fragmentviewpagerdemo.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.base.BaseFragment;
import com.jsj.fragmentviewpagerdemo.fragment.FragmentA;
import com.jsj.fragmentviewpagerdemo.fragment.FragmentB;
import com.jsj.fragmentviewpagerdemo.fragment.FragmentC;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;

/**
 * Created by jsj on 16/8/18.
 */
public class FragmentViewPagerActivity extends AppCompatActivity {

    private ArrayList<BaseFragment> mFragmmentList = new ArrayList<>();
    private String[] mTabTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_viewpager);
        mTabTitle = getResources().getStringArray(R.array.street_tab_title);//设置tob 的标题
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();
        FragmentC fragmentC = new FragmentC();
        mFragmmentList.add(fragmentA);
        mFragmmentList.add(fragmentB);
        mFragmmentList.add(fragmentC);
        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTabTitle));
        viewpager.setOffscreenPageLimit(3);
        final TabPageIndicator mTabPageIndicator = (TabPageIndicator) findViewById(R.id.tabPageindicator);
        mTabPageIndicator.setViewPager(viewpager, 0);//给tob 设置viewpager
        UnderlinePageIndicator underlinePageindicator = (UnderlinePageIndicator)findViewById(R.id.underlinePageindicator);//滑动线
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
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitle;

        public MyPagerAdapter(FragmentManager fm, String[] tabTitle) {
            super(fm);
            this.tabTitle = tabTitle;
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
}
