package com.gordod.example.lesson5_1_1.ui.login;

import com.gordod.example.lesson5_1_1.data.local.PreferenceUtils;

public class LoginPresenter implements LoginContract.LoginPresenter {
    LoginActivity lActivity;

    public LoginPresenter(LoginActivity lActivity) {
        this.lActivity = lActivity;
    }

    @Override
    public void login(String nickname, String password) {
        if (!nickname.trim().isEmpty() && !password.trim().isEmpty()){
            PreferenceUtils.saveUserData(nickname, password); // Мне надо создать отдельно новый активити
            // как это было с MainPresenter => MainModel? Но как его назвать если он кидает данные в базу данных?
            lActivity.startMainActivity();
        } else lActivity.makeErrorLogin();
    }
}
