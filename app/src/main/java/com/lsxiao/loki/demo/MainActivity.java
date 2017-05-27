package com.lsxiao.loki.demo;

import android.os.Bundle;

import com.lsxiao.loki.core.Loki;
import com.lsxiao.loki.core.annotation.Rule;

public class MainActivity extends BaseActivity {
    @Rule(value = "int|between:10,30", name = "age")
    public String age;

    @Rule("notnull|min:3|when_eq:age,=,18")
    public String name;

    @Rule("filled")
    public String getCity() {
        return "NewYork";
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {
        Loki.check(this);
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}