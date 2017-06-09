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

public class SimpleRuleActivity extends BaseActivity {

    @Rule("min_length:2")
    @BindView(R.id.et_name)
    public EditText mEtName;

    @Rule("integer|length:11")
    @BindView(R.id.mobile)
    public EditText mMobile;

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Override
    int getLayoutId() {
        return R.layout.activity_simple_rule;
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("简单表单");
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
