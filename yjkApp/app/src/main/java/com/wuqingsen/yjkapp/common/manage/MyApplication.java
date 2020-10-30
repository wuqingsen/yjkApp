package com.wuqingsen.yjkapp.common.manage;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.multidex.MultiDex;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wuqingsen.yjkapp.R;

import cn.bmob.v3.Bmob;

/**
 * Name: 吴庆森
 * Date: 2019/8/29
 * Mailbox: 1243411677@qq.com
 * Describe:MyApplication
 */

public class MyApplication extends Application {
    private static Context mContext;
    public static MyApplication instances;

    /**
     * 已经没有后台进程(内存可用极低)
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //内存低的时候清除glide缓存
        Glide.get(this).clearMemory();
    }

    /**
     * 内存低的不同状态状态
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        instances = this;
        // 初始化MultiDex
        MultiDex.install(this);
        //初始化SDK
        initSdk();
    }

    private void initSdk() {
        //bmob
        Bmob.initialize(this, "51929439b71935f1fa0fb8825b8c7a8c");
    }

    public static MyApplication getInstances() {
        return instances;
    }

    public static Context getContext() {
        return mContext;
    }

    public boolean isMainProcess() {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return getApplicationInfo().packageName.equals(appProcess.processName);
            }
        }
        return false;
    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
}


