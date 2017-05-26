package com.lsxiao.loki.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lsxiao.loki.core.Loki;
import com.lsxiao.loki.core.annotation.Group;
import com.lsxiao.loki.core.annotation.Rule;

public class MainActivity extends AppCompatActivity {
    private static final int GROUP_1 = 1;
    private static final int GROUP_2 = 2;

    @Group(GROUP_1)
    @Rule("empty|filled|min:2|required_if:test,2")
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loki.validate(this);
    }
}
