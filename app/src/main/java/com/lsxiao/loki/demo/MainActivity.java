package com.lsxiao.loki.demo;

import android.os.Bundle;
import android.util.Log;

import com.lsxiao.loki.core.Loki;
import com.lsxiao.loki.core.ValidateResult;
import com.lsxiao.loki.core.annotation.Rule;

public class MainActivity extends BaseActivity {
    @Rule(value = "integer|between:10,30", name = "age")
    public String age;

    @Rule("notnull|min:3|required_when:age,=,18")
    public String name;

    @Rule("filled")
    public String getCity() {
        return "NewYork";
    }

    @Override
    void afterCreate(Bundle savedInstanceState) {

        ValidateResult result = Loki.validate(this);
        if (result.isFail()) {
            Log.d("MainActivity", result.toString());
        }

    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

}