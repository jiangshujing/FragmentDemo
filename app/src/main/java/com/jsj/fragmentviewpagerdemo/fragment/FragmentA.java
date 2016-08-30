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
public class FragmentA extends BaseFragment {

    /**
     * 标志位，标志已经初始化完成
     */
    private boolean isPrepared;


    /**
     * 第一个fragemnt要做处理，调用第一个fragment setUserVisibleHint(true); 方法，因为setUserVisibleHint(true);方法只有切换的时候才会调用，所以初始化时，要让第一个先显示，
     * 但是setUserVisibleHint会优先onCreate 方法只想，这样会有空指针问题，所以使用标记记住是否初始化完成，完成后再请求数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        setUserVisibleHint(true);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_a, container, false);
        isPrepared = true;//已经初始化
        Log.d(this.getClass().getSimpleName(), "onCreateView");
        return view;
    }

    @Override
    protected void lazyLoad() {
        if (isPrepared && isVisible) {//可见的并且是初始化之后才加载
            Log.d(this.getClass().getSimpleName(), "请求数据");
        }
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
