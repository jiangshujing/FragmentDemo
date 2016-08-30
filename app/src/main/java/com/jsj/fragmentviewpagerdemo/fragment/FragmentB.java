package com.jsj.fragmentviewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.base.BaseFragment;

/**
 * Created by jsj on 16/8/18.
 */
public class FragmentB extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_b, container, false);
        Log.d(this.getClass().getSimpleName(),"onCreateView");
        return view;
    }

    @Override
    protected void lazyLoad() {
        if (isVisible){
            Log.d(this.getClass().getSimpleName(),"请求数据");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "onCreate");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(this.getClass().getSimpleName(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getSimpleName(), "onDestroy");
    }
}
