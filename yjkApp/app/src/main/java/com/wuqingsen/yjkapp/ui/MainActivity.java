package com.wuqingsen.yjkapp.ui;

import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.hjq.toast.ToastUtils;
import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.base.BaseActivity;
import com.wuqingsen.yjkapp.common.manage.Constant;
import com.wuqingsen.yjkapp.ui.find.FindFragment;
import com.wuqingsen.yjkapp.ui.home.HomeFragment;
import com.wuqingsen.yjkapp.ui.message.MessageFragment;
import com.wuqingsen.yjkapp.ui.mine.MineFragment;
import com.wuqingsen.yjkapp.utils.common.PermissionsChecker;
import com.wuqingsen.yjkapp.utils.eventbus.Event;

import butterknife.BindView;
public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ll_main)
    LinearLayout ll_main;
    @BindView(R.id.ll_find)
    LinearLayout ll_find;
    @BindView(R.id.ll_message)
    LinearLayout ll_message;
    @BindView(R.id.ll_mine)
    LinearLayout ll_mine;
    @BindView(R.id.tv_main)
    TextView tv_main;
    @BindView(R.id.tv_find)
    TextView tv_find;
    @BindView(R.id.tv_message)
    TextView tv_message;
    @BindView(R.id.tv_mine)
    TextView tv_mine;
    @BindView(R.id.tv_main_icon)
    TextView tv_main_icon;
    @BindView(R.id.tv_find_icon)
    TextView tv_find_icon;
    @BindView(R.id.tv_message_icon)
    TextView tv_message_icon;
    @BindView(R.id.tv_mine_icon)
    TextView tv_mine_icon;
    @BindView(R.id.rl_right)
    RelativeLayout rl_right;

    private HomeFragment fg1;
    private FindFragment fg2;
    private MessageFragment fg3;
    private MineFragment fg4;

    String[] permsLocation = {"android.permission.READ_PHONE_STATE",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    private PermissionsChecker mPermissionsChecker; // 权限检测器

    //注册广播
    protected boolean isRegisterEventBus() {
        return true;
    }

    //接受广播
    @Override
    protected void receiveEvent(Event event) {
        switch (event.getCode()) {
            case Constant.EventCode.EventPlayMusic:

                break;
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setTitleBar() {
        //禁止滑动退出app
        setSwipeBackEnable(false);
    }

    @Override
    protected void setData() {
        setView();
        getPermissions();
    }

    private void getPermissions() {
        mPermissionsChecker = new PermissionsChecker(mContext);
        if (mPermissionsChecker.lacksPermissions(permsLocation)) {
            ActivityCompat.requestPermissions(this, permsLocation, Constant.Permission.RESULT_CODE_LOCATION);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()) {
            //首页
            case R.id.ll_main:
                if (fg1 == null) {
                    fg1 = new HomeFragment();
                    fTransaction.add(R.id.fl_context, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                //设置选中的点击效果,1为首页
                setClick("1");
                break;
            //发现
            case R.id.ll_find:
                if (fg2 == null) {
                    fg2 = new FindFragment();
                    fTransaction.add(R.id.fl_context, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                //设置选中的点击效果,2为发现
                setClick("2");
                break;
            //消息
            case R.id.ll_message:
                if (fg3 == null) {
                    fg3 = new MessageFragment();
                    fTransaction.add(R.id.fl_context, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                //设置选中的点击效果,3为消息
                setClick("3");
                break;
            //我的
            case R.id.ll_mine:
                if (fg4 == null) {
                    fg4 = new MineFragment();
                    fTransaction.add(R.id.fl_context, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                //设置选中的点击效果,4为我的
                setClick("4");
                break;
        }
        //提交事务
        fTransaction.commitAllowingStateLoss();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    //查找控件模拟第一次点击等操作
    private void setView() {
        ll_main.setOnClickListener(this);
        ll_find.setOnClickListener(this);
        ll_message.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
        //模拟一次点击，既进去后选择第一项
        ll_main.performClick();
    }

    //设置选中的点击效果
    private void setClick(String type) {
        tv_main.setTextColor(getResources().getColor(R.color.black_f8));
        tv_find.setTextColor(getResources().getColor(R.color.black_f8));
        tv_message.setTextColor(getResources().getColor(R.color.black_f8));
        tv_mine.setTextColor(getResources().getColor(R.color.black_f8));

        tv_main_icon.setTextColor(getResources().getColor(R.color.black_f8));
        tv_find_icon.setTextColor(getResources().getColor(R.color.black_f8));
        tv_message_icon.setTextColor(getResources().getColor(R.color.black_f8));
        tv_mine_icon.setTextColor(getResources().getColor(R.color.black_f8));

        if (type.equals("1")) {
            //选中首页，设置字体颜色、大小、加粗；
            tv_main.setTextColor(getResources().getColor(R.color.black_f3));
            tv_main.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tv_main_icon.setTextColor(getResources().getColor(R.color.blue_e2));
        } else if (type.equals("2")) {
            //选中发现，设置字体颜色、大小、加粗；
            tv_find.setTextColor(getResources().getColor(R.color.black_f3));
            tv_find.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tv_find_icon.setTextColor(getResources().getColor(R.color.blue_e2));
        } else if (type.equals("3")) {
            //选中消息，设置字体颜色、大小、加粗；
            tv_message.setTextColor(getResources().getColor(R.color.black_f3));
            tv_message.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tv_message_icon.setTextColor(getResources().getColor(R.color.blue_e2));
        } else {
            //选中我的，设置字体颜色、大小、加粗；
            tv_mine.setTextColor(getResources().getColor(R.color.black_f3));
            tv_mine.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tv_mine_icon.setTextColor(getResources().getColor(R.color.blue_e2));
        }
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case Constant.Permission.RESULT_CODE_LOCATION:
                boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if (cameraAccepted) {
                    //权限通过

                } else {
                    //用户授权拒绝之后，提示一下
                    ToastUtils.show("权限没有开启");
                }
                break;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                moveTaskToBack(true);
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
