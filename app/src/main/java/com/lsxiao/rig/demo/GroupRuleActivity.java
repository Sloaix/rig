package com.lsxiao.rig.demo;

import android.os.Bundle;

public class GroupRuleActivity extends BaseActivity {

    @Override
    int getLayoutId() {
        return R.layout.activity_rely_rule;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("复杂表单");
    }
}
