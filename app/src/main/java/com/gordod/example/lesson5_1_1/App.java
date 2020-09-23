package com.gordod.example.lesson5_1_1;

import android.app.Application;

import com.gordod.example.lesson5_1_1.data.local.PreferenceUtils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceUtils.init(this);
    }
}
