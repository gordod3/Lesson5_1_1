package com.gordod.example.lesson5_1_1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.data.local.PreferenceUtils;
import com.gordod.example.lesson5_1_1.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    EditText nickname, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nickname = findViewById(R.id.activity_login_editText_nickname);
        password = findViewById(R.id.activity_login_editText_password);
        login = findViewById(R.id.activity_login_button_login);

    }

    public void onClickLoginButton(View view) {
        if (!nickname.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty()){
            PreferenceUtils.saveUserData(nickname.getText().toString(), password.getText().toString());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            login.setError("Заполните логин/пароль.");
            Toast.makeText(this, "Заполните логин/пароль", Toast.LENGTH_SHORT).show();
        }
    }
}