package com.xlstudio.woqucloud.views;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.xlstudio.woqucloud.R;
import com.xlstudio.woqucloud.core.BaseFragment;
import com.xlstudio.woqucloud.core.BaseFragmentActivity;
import com.xlstudio.woqucloud.utils.ToastUtils;

import butterknife.Bind;

public class MainActivity extends BaseFragmentActivity {


    @Bind(R.id.ll_nav)
    LinearLayout navLl;

    private Fragment printFragment;
    private Fragment uploadFragment;
    private Fragment listFragment;
    private Fragment userFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    private class NavClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            for(int i=0;i<navLl.getChildCount();i++){
               if(v==navLl.getChildAt(i)){
                   navLl.getChildAt(i).setSelected(true);
               }else{
                   navLl.getChildAt(i).setSelected(false);
               }
            }
        }
    }

    @Override
    protected void initListeners() {
        for(int i=0;i<navLl.getChildCount();i++){
            navLl.getChildAt(i).setOnClickListener(new NavClickListener());
        }


    }

    @Override
    protected void initData() {

    }
}
