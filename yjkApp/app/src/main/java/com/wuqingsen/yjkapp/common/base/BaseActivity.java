package com.wuqingsen.yjkapp.common.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.manage.AppManager;
import com.wuqingsen.yjkapp.common.manage.MyApplication;
import com.wuqingsen.yjkapp.utils.common.titlebar.Eyes;
import com.wuqingsen.yjkapp.utils.eventbus.Event;
import com.wuqingsen.yjkapp.utils.eventbus.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Name: 吴庆森
 * Date: 2019/7/29
 * Mailbox: 1243411677@qq.com
 * Describe:BaseActivity
 */

public abstract class BaseActivity extends SwipeBackActivity {
    protected Context mContext;
    public MyApplication application;

    /**
     * 对context进行初始化，并将当前的Activity加入到堆栈中，便于管理
     */
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        mContext = this;
        // 设置不能横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        setActivityAnimation();
        //设置布局
        if (setLayout() != 0) setContentView(setLayout());
        //设置状态栏
        setInit();
        setTitleBar();
        //ButterKnife
        ButterKnife.bind(this);
        //注册EventBus
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
        application = (MyApplication) getApplication();
        setData();
    }

    //设置顶部标题栏适配
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setInit() {
        //设置标题栏
        Eyes.setStatusBarColor(this, ContextCompat.getColor(this, R.color.blue_e2));

        // 可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);

        SwipeBackLayout mSwipeBackLayout = getSwipeBackLayout();

        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        // 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        mSwipeBackLayout.setEdgeSize(50);
    }

    protected void toolBar(Boolean isBlack, Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);
        if (isBlack) {
            toolbar.setNavigationIcon(R.mipmap.icon_back_white);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        TextView toolbarTitle = toolbar.findViewById(R.id.tv_toolbar_title);
        if (toolbarTitle != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbarTitle.setText(title);
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    //发送事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    //发送粘性事件
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

    protected void setActivityAnimation() {
    }

    protected void setTitleBar() {
    }

    protected abstract int setLayout();

    protected abstract void setData();

    public void jumpToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    //清空所有activity
    public void jumpToActivityAndClearTask(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void jumpToActivityAndClearTop(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        //注销EventBus
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }
}
