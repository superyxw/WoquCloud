package com.xlstudio.woqucloud.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xlstudio.woqucloud.R;
import com.xlstudio.woqucloud.core.BaseFragment;
import com.xlstudio.woqucloud.core.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {

    }
}
