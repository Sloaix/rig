package com.lsxiao.rig.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.lsxiao.rig.core.Rig;
import com.lsxiao.rig.core.annotation.Rule;

public class MainActivity extends BaseActivity {
    @Rule(value = "int|between:10,30", name = "age")
    public String age = "5";

    @Rule("notnull|min:3|when_eq:age,18")
    public String name = "abdc";

    @Rule("filled")
    public String getCity() {
        return "NewYork";
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "Rig.check(this):" + Rig.check(this));
        if (Rig.check(this).isPass()) {
            ((TextView) findViewById(R.id.tv_message)).setText("校验通过");
        } else {
            ((TextView) findViewById(R.id.tv_message)).setText(String.format("校验未通过\n%s", Rig.check(this)));
        }

    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}