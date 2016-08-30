package com.jsj.fragmentviewpagerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.fragment.Fragment1;
import com.jsj.fragmentviewpagerdemo.fragment.Fragment2;

/**
 * Created by jsj on 16/8/19.
 */
public class ReplaceFragmentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hide_fragment);
        RadioGroup radio_group = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton rb_fragment1 = (RadioButton)findViewById(R.id.rb_fragment1);

//        fragment1 = new Fragment1();
//        fragment2 = new Fragment2();
        radio_group.setOnCheckedChangeListener(this);
//        rb_fragment1.setChecked(true);
        rb_fragment1.performClick();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();//每次切换Fragment 都需要获取一次新的，transaction不能重复调用，要重新实例transaction
        switch (checkedId) {
            case R.id.rb_fragment1:
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                }
                mFragmentTransaction.replace(R.id.rl_content, fragment1);
//                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                break;
            case R.id.rb_fragment2:
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                }
                mFragmentTransaction.replace(R.id.rl_content, fragment2);
//                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                break;
        }
        mFragmentTransaction.commit();
    }

    /**
     * 隐藏界面
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
//        if (mStatisticsPollingFragment != null) {
//            transaction.hide(mStatisticsPollingFragment);
//        }
    }
}
