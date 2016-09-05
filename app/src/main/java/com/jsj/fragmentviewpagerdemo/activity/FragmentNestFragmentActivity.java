package com.jsj.fragmentviewpagerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jsj.fragmentviewpagerdemo.R;
import com.jsj.fragmentviewpagerdemo.fragment.Fragment1;
import com.jsj.fragmentviewpagerdemo.fragment.Fragment2;
import com.jsj.fragmentviewpagerdemo.fragment.FragmentNestFragment;

/**
 * Created by jsj on 16/9/5.
 */
public class FragmentNestFragmentActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_nest_fragment);
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.rl_content, new FragmentNestFragment());
        mFragmentTransaction.commit();
    }
}
