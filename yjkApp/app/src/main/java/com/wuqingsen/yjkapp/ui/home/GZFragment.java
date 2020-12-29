package com.wuqingsen.yjkapp.ui.home;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.base.BaseAdapter;
import com.wuqingsen.yjkapp.common.base.BaseLazyFragment;
import com.wuqingsen.yjkapp.ui.adapter.GZAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * wuqingsen on 2020-12-04
 * Mailbox:1243411677@qq.com
 * annotation:
 */
public class GZFragment extends BaseLazyFragment {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<String> mDatas;
    private GZAdapter gzAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_gz;
    }

    @Override
    protected void setData() {
        setAdapter();
    }

    private void setAdapter() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mDatas.add("" + i);
        }
        gzAdapter = new GZAdapter(mContext, mDatas);
        recyclerView.setAdapter(gzAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        gzAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, int position, String model) {

            }

            @Override
            public void onItemLongClick(View view, int position, String model) {

            }
        });
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });

    }

}
