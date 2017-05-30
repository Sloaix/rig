package com.lsxiao.loki.demo;

import android.os.Bundle;
import android.util.Log;

import com.lsxiao.loki.core.Loki;
import com.lsxiao.loki.core.annotation.Rule;

public class MainActivity extends BaseActivity {
    @Rule(value = "int|between:10,30", name = "age")
    public String age = "20";

    @Rule("notnull|min:3|when_eq:age,18")
    public String name;
//
//    @Rule("filled")
//    public String getCity() {
//        return "NewYork";
//    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "Loki.check(this):" + Loki.check(this));
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}