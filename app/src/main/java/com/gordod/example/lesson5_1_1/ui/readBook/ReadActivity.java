package com.gordod.example.lesson5_1_1.ui.readBook;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.ui.main.MainActivity;

public class ReadActivity extends AppCompatActivity {
    private TextView title, desc;
    private int idBook;
    private static final int ERROR_BOOK_ID = -1;
    private ReadContract.Presenter rPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rPresenter = new ReadPresenter();
        setContentView(R.layout.activity_read);
        title = findViewById(R.id.activity_read_text_title);
        desc = findViewById(R.id.activity_read_text_desc);
        if (getIntent() != null) idBook = getIntent().getIntExtra(MainActivity.APP_MAIN_ID, ERROR_BOOK_ID);
        if (idBook != ERROR_BOOK_ID) {
            title.setText(rPresenter.loadBook(idBook).getTitle());
            desc.setText(rPresenter.loadBook(idBook).getDesc());
        } else Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("olol", "da");
    }
}