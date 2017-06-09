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

public class RelyRuleActivity extends BaseActivity {

    
    @Rule(value = "min_length:6", name = "用户密码")
    @BindView(R.id.password)
    public EditText mPassword;

    @Rule(value = "filled|same_as:用户密码", name = "确认密码")
    @BindView(R.id.password_confirm)
    public EditText mPasswordConfirm;

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Override
    int getLayoutId() {
        return R.layout.activity_rely_rule;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("依赖表单");
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
