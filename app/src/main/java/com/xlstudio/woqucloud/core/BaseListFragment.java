package com.xlstudio.woqucloud.core;

import android.widget.AbsListView;

/**
 * Created by superyxw on 16/8/4.
 */
public abstract class BaseListFragment extends BaseFragment{

    private int lastItem, totalCount = 0;

    public boolean isFinish = false;// 是否加载完成,true加载完

    public boolean isLoad = false; // 表示是否加载数据,false不加载

    public int page = 1;

    public AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (lastItem == totalCount
                    && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {

                if(!isLoad&&!isFinish){
                    scrollOver();
                }

            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            lastItem = firstVisibleItem + visibleItemCount;
            totalCount = totalItemCount;
        }
    };

    public abstract void scrollOver();
}
