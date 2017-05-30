package com.lsxiao.rig.demo;

import android.os.Bundle;
import android.util.Log;

import com.lsxiao.rig.core.Rig;
import com.lsxiao.rig.core.annotation.Rule;

public class MainActivity extends BaseActivity {
    @Rule(value = "int|between:10,30", name = "age")
    public String age = "5";

    @Rule("notnull|min:3|when_eq:age,18")
    public String name="abdc";

    @Rule("filled")
    public String getCity() {
        return "NewYork";
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "Rig.check(this):" + Rig.check(this));
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}