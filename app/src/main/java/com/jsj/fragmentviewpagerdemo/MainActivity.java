package com.jsj.fragmentviewpagerdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jsj.fragmentviewpagerdemo.activity.AddHideFragmentActivity;
import com.jsj.fragmentviewpagerdemo.activity.FragmentViewPagerActivity;
import com.jsj.fragmentviewpagerdemo.activity.ReplaceFragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_fragment_viewpager, bt_fragment_add_hide,bt_fragment_replace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_fragment_viewpager = (Button) findViewById(R.id.bt_fragment_viewpager);
        bt_fragment_add_hide = (Button) findViewById(R.id.bt_fragment_add_hide);
        bt_fragment_replace = (Button) findViewById(R.id.bt_fragment_replace);

        bt_fragment_viewpager.setOnClickListener(this);
        bt_fragment_add_hide.setOnClickListener(this);
        bt_fragment_replace.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fragment_viewpager://fragment + viewPager
                startActivity(new Intent(this, FragmentViewPagerActivity.class));
                break;
            case R.id.bt_fragment_add_hide://使用add添加, hide隐藏来切换Fragment
                startActivity(new Intent(this,AddHideFragmentActivity.class));
                break;
            case R.id.bt_fragment_replace://使用Replace来切换Fragment
                startActivity(new Intent(this,ReplaceFragmentActivity.class));
                break;
        }
    }
}
