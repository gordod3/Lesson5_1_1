package com.gordod.example.lesson5_1_1;

import android.app.Application;
import com.gordod.example.lesson5_1_1.data.local.preferenceUtils.PreferenceUtils;
import com.gordod.example.lesson5_1_1.data.network.GhibliService;

public class App extends Application {

    public static GhibliService ghibliService;
    public static  App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        PreferenceUtils.init(this);
        ghibliService = new GhibliService();
    }

    public static App getInstance() {
        return instance;
    }
}
