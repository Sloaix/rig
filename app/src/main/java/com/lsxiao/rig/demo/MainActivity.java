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

    @OnClick(R.id.btn_simple_form)
    void nav2SimpleForm() {
        Intent intent = new Intent(this, SimpleRuleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_rely_form)
    void nav2RelyForm() {
        Intent intent = new Intent(this, RelyRuleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_group_form)
    void nav2GroupForm() {
        Intent intent = new Intent(this, GroupRuleActivity.class);
        startActivity(intent);
    }
}