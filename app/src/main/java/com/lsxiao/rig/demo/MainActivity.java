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

    @Rule(value = "int|max:30|min:10", name = "年龄")
    public String age = "20";

    @Rule(value = "when_eq:年龄,20|notnull|min:3", name = "姓名")
    public String name = "fdf";

    @BindView(R.id.tv_message)
    public TextView mTvMessage;

    @Rule(value = "filled|max:2|when_filled:年龄,2", name = "地址")
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