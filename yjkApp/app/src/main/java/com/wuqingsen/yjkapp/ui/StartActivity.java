package com.wuqingsen.yjkapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wuqingsen.yjkapp.common.base.BaseActivity;

/**
 * wuqingsen on 2020-12-04
 * Mailbox:1243411677@qq.com
 * annotation:
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
