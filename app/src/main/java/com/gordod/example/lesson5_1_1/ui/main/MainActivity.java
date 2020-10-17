package com.gordod.example.lesson5_1_1.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.gordod.example.lesson5_1_1.App;
import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.Tags;
import com.gordod.example.lesson5_1_1.data.local.preferenceUtils.PreferenceUtils;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import com.gordod.example.lesson5_1_1.data.network.GhibliService;
import com.gordod.example.lesson5_1_1.ui.login.LoginActivity;
import com.gordod.example.lesson5_1_1.ui.recyclerView.BookOnClick;
import com.gordod.example.lesson5_1_1.ui.recyclerView.MainAdapter;
import com.gordod.example.lesson5_1_1.ui.readBook.ReadActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, BookOnClick {
    public static final String APP_MAIN_ID = "id";
    private MainContract.Presenter mPresenter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (PreferenceUtils.getNickname().equals(PreferenceUtils.PREF_NICKNAME_NOT_FOUND) || PreferenceUtils.getPassword().equals(PreferenceUtils.PREF_PASSWORD_NOT_FOUND)){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPresenter = new MainPresenter(this);
        App.ghibliService.getFilmList(new GhibliService.GhibliFilmCallback() {
            @Override
            public void onSuccess(List<FilmModel> filmModelList) {
                mPresenter.loadFilmList(filmModelList);
                createRecyclerView(filmModelList);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(Tags.ERROR.toString(),
                        "ERROR: " +
                                t.getLocalizedMessage() + "\n" +
                                t.getMessage());
            }
        });
        Toast.makeText(this, "Hello " + PreferenceUtils.getNickname(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFilmInfo(int id) {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra(APP_MAIN_ID, id);
        startActivity(intent);
    }

    @Override
    public void filmOnClick(int id) {
        mPresenter.filmOnClick(id);
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

    public void createRecyclerView(List<FilmModel> filmList){
        recyclerView = findViewById(R.id.activity_main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(filmList, this, this);
        recyclerView.setAdapter(adapter);
    }
}