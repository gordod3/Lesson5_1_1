package com.gordod.example.lesson5_1_1.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.data.local.PreferenceUtils;
import com.gordod.example.lesson5_1_1.ui.login.LoginActivity;
import com.gordod.example.lesson5_1_1.ui.recyclerView.BookOnClick;
import com.gordod.example.lesson5_1_1.ui.recyclerView.MainAdapter;
import com.gordod.example.lesson5_1_1.ui.readBook.ReadActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View, BookOnClick {
    public static final String APP_MAIN_ID = "id";
    private MainContract.Presenter mPresenter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Это нормально что у меня проверка за экран вышла? Не знаю как сделать ее короче.
        if (PreferenceUtils.getNickname().equals(PreferenceUtils.PREF_NICKNAME_NOT_FOUND) || PreferenceUtils.getPassword().equals(PreferenceUtils.PREF_PASSWORD_NOT_FOUND)){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return; // Честно не помню зачем он тут нужен, но он нужен.
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPresenter = new MainPresenter(this);
        recyclerView = findViewById(R.id.activity_main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(mPresenter.loadListBook(), this);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "Hello " + PreferenceUtils.getNickname(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showBook(int id) {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra(APP_MAIN_ID, id);
        startActivity(intent);
    }

    @Override
    public void bookOnClick(int id) {
        //Я уже 10 минут ломаю голову и не знаю как правильнее:
        //Переписать этот метод в точности как в "showBook" и удалить его или
        //удалить "showBook" и переписать "bookOnClick" под него... Пока оставлю как есть.
        mPresenter.bookOnClick(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void menuOnClick(MenuItem item) {
        PreferenceUtils.deleteUserData();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}