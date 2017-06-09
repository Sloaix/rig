package com.lsxiao.rig.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lsxiao.rig.core.Rig;
import com.lsxiao.rig.core.ValidateResult;
import com.lsxiao.rig.core.annotation.Group;
import com.lsxiao.rig.core.annotation.Rule;

import butterknife.BindView;
import butterknife.OnClick;

public class GroupRuleActivity extends BaseActivity {

    public static final int GROUP_1 = 1;
    public static final int GROUP_2 = 2;

    @Group(GROUP_1)
    @Rule("min_length:6|letter")
    @BindView(R.id.et_username)
    public EditText mEtUsername;

    @Group(GROUP_1)
    @Rule("min_length:2|han")
    @BindView(R.id.et_name)
    public EditText mEtName;

    @Group(GROUP_1)
    @Rule("mobile")
    @BindView(R.id.mobile)
    public EditText mMobile;

    @Group(GROUP_1)
    @Rule("email")
    @BindView(R.id.email)
    public EditText mEmail;


    @Group(GROUP_2)
    @Rule(value = "min_length:6", name = "用户密码")
    @BindView(R.id.password)
    public EditText mPassword;

    @Group(GROUP_2)
    @Rule(value = "filled|same_as:用户密码", name = "确认密码")
    @BindView(R.id.password_confirm)
    public EditText mPasswordConfirm;

    @BindView(R.id.tv_content)
    public TextView mTvContent;

    @Override
    int getLayoutId() {
        return R.layout.activity_group_rule;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("分组表单");
    }

    @OnClick(R.id.btn_group_1)
    public void onClick1() {
        ValidateResult result = Rig.check(this, GROUP_1);
        mTvContent.setText("");
        if (result.isFail()) {
            mTvContent.setTextColor(Color.RED);
            mTvContent.setText(result.formatErrors());
        } else {
            mTvContent.setTextColor(Color.BLACK);
            Toast.makeText(this, "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_group_2)
    public void onClick2() {
        ValidateResult result = Rig.check(this, GROUP_2);
        mTvContent.setText("");
        if (result.isFail()) {
            mTvContent.setTextColor(Color.RED);
            mTvContent.setText(result.formatErrors());
        } else {
            mTvContent.setTextColor(Color.BLACK);
            Toast.makeText(this, "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

}
