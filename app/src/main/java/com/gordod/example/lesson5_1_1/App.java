package com.gordod.example.lesson5_1_1;

import android.app.Application;

import com.gordod.example.lesson5_1_1.data.local.PreferenceUtils;
import com.gordod.example.lesson5_1_1.data.network.GhibliService;

public class App extends Application {

    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceUtils.init(this);
        ghibliService = new GhibliService();
    }
}
