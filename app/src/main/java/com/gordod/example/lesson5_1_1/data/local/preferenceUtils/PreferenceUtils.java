package com.gordod.example.lesson5_1_1.data.local.preferenceUtils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private static SharedPreferences mPreference;
    private final static String
            APP_PREF_NAME = "com.gordod.example.lesson5_1_1",
            APP_PREF_DATA_USER_NICKNAME = "nickname",
            APP_PREF_DATA_USER_PASSWORD = "password";
    public final static String
            PREF_NICKNAME_NOT_FOUND = "Nickname not found",
            PREF_PASSWORD_NOT_FOUND = "Password not found";

    public static void init(Context context){
        mPreference = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE);
    }
    public static void saveUserData(String nickname, String password) {
        mPreference.edit().putString(APP_PREF_DATA_USER_NICKNAME, nickname).apply();
        mPreference.edit().putString(APP_PREF_DATA_USER_PASSWORD, password).apply();
    }

 public static void deleteUserData() {
        mPreference.edit().putString(APP_PREF_DATA_USER_NICKNAME, null).apply();
        mPreference.edit().putString(APP_PREF_DATA_USER_PASSWORD, null).apply();
    }

    public static String getNickname() {
        return mPreference.getString(APP_PREF_DATA_USER_NICKNAME, PREF_NICKNAME_NOT_FOUND);
    }

    public static String getPassword() {
        return mPreference.getString(APP_PREF_DATA_USER_PASSWORD, PREF_PASSWORD_NOT_FOUND);
    }


}
