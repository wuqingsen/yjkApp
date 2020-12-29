package com.wuqingsen.yjkapp.ui.home;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.base.BaseFragment;
import com.wuqingsen.yjkapp.ui.adapter.HomeAdapter;
import com.wuqingsen.yjkapp.utils.common.viewpagercursor.ViewPagerCursor;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Name: 吴庆森
 * Date: 2019/8/26
 * Mailbox: 1243411677@qq.com
 * Describe:首页
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.magic_indicator)
    MagicIndicator magic_indicator;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    private List<String> mList;
    private List<Fragment> fragments;
    private HomeAdapter homeAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setData() {
        setTitle();
    }


    /**
     * 设置标题
     */
    private void setTitle() {
        fragments = new ArrayList<>();
        mList = new ArrayList<>();
        mList.add("关注");
        mList.add("推荐");
        mList.add("同城");
        mList.add("视频");
        mList.add("动图");
        mList.add("图片");
        fragments.add(new GZFragment());
        fragments.add(new TJFragment());
        fragments.add(new TCFragment());
        fragments.add(new SPFragment());
        fragments.add(new DTFragment());
        fragments.add(new TPFragment());
        homeAdapter = new HomeAdapter(getActivity().getSupportFragmentManager(), fragments);
        view_pager.setAdapter(homeAdapter);
        //设置导航条以及文字的样式
        ViewPagerCursor.initTitleHome(getActivity(), magic_indicator, view_pager, mList);
        view_pager.setCurrentItem(1);//默认热门
    }


}
