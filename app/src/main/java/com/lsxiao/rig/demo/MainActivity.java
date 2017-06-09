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

    @OnClick(R.id.btn_rely_form_1)
    void nav2Rely1Form() {
        Intent intent = new Intent(this, RelyRuleActivity1.class);
        startActivity(intent);
    }


    @OnClick(R.id.btn_rely_form_2)
    void nav2Rely2Form() {
        Intent intent = new Intent(this, RelyRuleActivity2.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_group_form)
    void nav2GroupForm() {
        Intent intent = new Intent(this, GroupRuleActivity.class);
        startActivity(intent);
    }
}