package com.lsxiao.rig.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class SimpleRuleActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.mobile)
    EditText mMobile;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.password_confirm)
    EditText mPasswordConfirm;
    @BindView(R.id.btn_validate)
    Button mBtnValidate;

    @Override
    int getLayoutId() {
        return R.layout.activity_simple_rule;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("复杂表单");
    }
}
