package com.lsxiao.rig.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-26 21:56
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public abstract class BaseActivity extends AppCompatActivity {
    abstract int getLayoutId();

    abstract void afterCreate(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        afterCreate(savedInstanceState);
    }
}
