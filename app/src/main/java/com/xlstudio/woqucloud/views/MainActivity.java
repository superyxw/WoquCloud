package com.xlstudio.woqucloud.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.xlstudio.woqucloud.R;
import com.xlstudio.woqucloud.core.BaseFragment;
import com.xlstudio.woqucloud.core.BaseFragmentActivity;
import com.xlstudio.woqucloud.utils.ToastUtils;
import com.xlstudio.woqucloud.views.fragment.ListFragment;
import com.xlstudio.woqucloud.views.fragment.PrintFragment;
import com.xlstudio.woqucloud.views.fragment.UploadFragment;
import com.xlstudio.woqucloud.views.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseFragmentActivity {


    @Bind(R.id.ll_nav)
    LinearLayout navLl;

    private BaseFragment printFragment;
    private BaseFragment uploadFragment;
    private BaseFragment listFragment;
    private BaseFragment userFragment;
    private BaseFragment content;
    private List<BaseFragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        printFragment = new PrintFragment();
        fragments.add(printFragment);
        uploadFragment = new UploadFragment();
        fragments.add(uploadFragment);
        fragments.add(null);
        listFragment = new ListFragment();
        fragments.add(listFragment);
        userFragment = new UserFragment();
        fragments.add(userFragment);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, printFragment).commit();
        content = printFragment;
    }

    private class NavClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            for(int i=0;i<navLl.getChildCount();i++){
               if(v==navLl.getChildAt(i)){
                   navLl.getChildAt(i).setSelected(true);
                   if(fragments.get(i)!=null){
                       switchContent(fragments.get(i));
                   }
               }else{
                   navLl.getChildAt(i).setSelected(false);
               }
            }
        }
    }

    public void switchContent(final BaseFragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        boolean isAdded = fragment.isAdded();

        if (!isAdded) {
            ft.hide(content).add(R.id.content, fragment).commitAllowingStateLoss();
        } else {
            ft.hide(content).show(fragment).commitAllowingStateLoss();
        }
        content = fragment;
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
