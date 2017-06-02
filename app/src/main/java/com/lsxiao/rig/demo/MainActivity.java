package com.lsxiao.rig.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.lsxiao.rig.core.Rig;
import com.lsxiao.rig.core.annotation.Rule;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Rule(value = "int|length:6", name = "密码")
    public String password = "123456";

    @BindView(R.id.tv_message)
    public TextView mTvMessage;

    @Rule(value = "when_filled:密码|int|length:6", name = "确认密码")
    @BindView(R.id.edit_address)
    public EditText mEditContent;

    @OnClick(R.id.btn_check)
    public void onClick() {
        Log.d("MainActivity", "Rig.check(this):" + Rig.check(this));
        if (Rig.check(this).isPass()) {
            mTvMessage.setText("校验通过");
        } else {
            mTvMessage.setText(String.format("校验未通过\n%s", Rig.check(this)));
        }
    }

    @Rule("filled")
    public String getCity() {
        return "NewYork";
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {

    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}