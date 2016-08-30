package com.jsj.fragmentviewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.base.BaseFragment;

/**
 * Created by jsj on 16/8/18.
 */
public class Fragment1 extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass().getSimpleName(), "onResume");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "onCreate");
    }

    /**
     * 使用add加载Fragment 当切换的时候 什么什么周期都不走，只走onHiddenChanged，用这种方法切换，Fragment在隐藏时并不会走onDestoryView，所以显示时也不会走onCreateView，所有View都一直保存在内存中
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            Log.d(this.getClass().getSimpleName(), "onHiddenChanged");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(this.getClass().getSimpleName(), "onStart");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_a, container, false);
        Log.d(this.getClass().getSimpleName(), "onCreateView");
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getSimpleName(), "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(this.getClass().getSimpleName(), "onDestroyView");
    }
}
