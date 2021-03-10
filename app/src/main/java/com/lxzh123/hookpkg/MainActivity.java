package com.lxzh123.hookpkg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.lxzh123.library.SignUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HookTest", "real pkgName:" + this.getPackageName());
        Log.d("HookTest", "hook pkgName:" + SignUtils.getPkgName(this));
    }
}