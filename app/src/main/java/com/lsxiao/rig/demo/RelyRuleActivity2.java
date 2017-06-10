package com.lsxiao.rig.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lsxiao.rig.core.Rig;
import com.lsxiao.rig.core.ValidateResult;
import com.lsxiao.rig.core.annotation.Rule;

import butterknife.BindView;
import butterknife.OnClick;

public class RelyRuleActivity2 extends BaseActivity {


    @Rule(value = "filled|min_length:2", name = "真实姓名")
    @BindView(R.id.name)
    public EditText mName;

    @Rule(value = "notnull", name = "期望职位")
    @BindView(R.id.expect_work)
    public EditText mExpectWork;

    @Rule(value = "when_filled:期望职位|filled", name = "期望城市")
    @BindView(R.id.expect_city)
    public EditText mExpectCity;

    @Rule(value = "when_filled:期望职位|url", name = "github")
    @BindView(R.id.github)
    public EditText mGithub;

    @Rule(value = "when_filled:期望职位|email", name = "邮箱")
    @BindView(R.id.et_email)
    public EditText mEtEmail;

    @Rule(value = "when_filled:期望职位|url", name = "知乎个页")
    @BindView(R.id.et_zhihu)
    public EditText mEtZhihu;

    @BindView(R.id.tv_content)
    public TextView mTvContent;


    @Override
    int getLayoutId() {
        return R.layout.activity_rely_rule_2;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("依赖表单2");
    }

    @OnClick(R.id.btn_validate)
    public void onClick() {
        ValidateResult result = Rig.check(this);
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
