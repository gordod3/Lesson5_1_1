package com.gordod.example.lesson5_1_1.ui.login;

public interface LoginContract {

    interface LoginActivity{
        void startMainActivity();
        void makeErrorLogin();
    }

    interface LoginPresenter{
        void login(String nickname, String password);
    }
}
