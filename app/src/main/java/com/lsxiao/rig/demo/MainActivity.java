package com.lsxiao.rig.demo;

import android.content.Intent;
import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    void afterCreate(Bundle savedInstanceState) {

    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_complex_form)
    void nav2ComplexForm() {
        Intent intent = new Intent(this, SimpleRuleActivity.class);
        startActivity(intent);
    }
}