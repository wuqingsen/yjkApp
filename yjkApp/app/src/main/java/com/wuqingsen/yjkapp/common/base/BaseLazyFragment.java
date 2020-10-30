package com.wuqingsen.yjkapp.common.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wuqingsen.yjkapp.common.manage.MyApplication;
import com.wuqingsen.yjkapp.utils.eventbus.Event;
import com.wuqingsen.yjkapp.utils.eventbus.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.ButterKnife;
/**
 * Name: 吴庆森
 * Date: 2019/7/29
 * Mailbox: 1243411677@qq.com
 * Describe:BaseFragment懒加载
 */
public abstract class BaseLazyFragment extends Fragment {
    protected Context mContext;
    public MyApplication application;
    private View view;
    public Typeface font;

    //是否可见
    public boolean isVisible = false;
    //是否初始化完成
    public boolean isInit = false;
    //是否已经加载过
    public boolean isLoadOver = false;
    public HashMap hashMapHttp;

    //界面可见时再加载数据(该方法在onCreate()方法之前执行。)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisible = isVisibleToUser;
        setParam();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        application = (MyApplication) mContext.getApplicationContext();
        hashMapHttp = new HashMap();
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = View.inflate(getActivity(), setLayout(), null);
            ButterKnife.bind(this, view);
            isInit = true;
            setParam();
        }
        return view;
    }

    /**
     * 初始化一些参数，完成懒加载和数据只加载一次的效果
     * isInit = true：此Fragment初始化完成
     * isLoadOver = false：此Fragment没有加载过
     * isVisible = true：此Fragment可见
     */
    private void setParam() {
        if (isInit && !isLoadOver && isVisible) {
            isLoadOver = true;
            font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
            setData();
        }
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }

    protected abstract int setLayout();

    protected abstract void setData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
