package com.jsj.fragmentviewpagerdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by jsj on 16/9/5.
 */
public class FragmentNestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_fragment_nest_fragment, container, false);
        //注意这里，在Fragment 中获取FragmentManager 要使用getChildFragmentManager（）方法
        FragmentTransaction mFragmentTransaction = getChildFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.rl_content, new FragmentViewPager());
        mFragmentTransaction.commit();
        return view;
    }
}
