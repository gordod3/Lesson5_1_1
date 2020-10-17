package com.gordod.example.lesson5_1_1.ui.readBook;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.gordod.example.lesson5_1_1.R;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import com.gordod.example.lesson5_1_1.ui.main.MainActivity;

public class ReadActivity extends AppCompatActivity {
    private TextView title, desc;
    private int id;
    private static final int ERROR_BOOK_ID = -1;
    private ReadContract.Presenter rPresenter;
    private FilmModel filmModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rPresenter = new ReadPresenter();
        setContentView(R.layout.activity_read);
        title = findViewById(R.id.activity_read_text_title);
        desc = findViewById(R.id.activity_read_text_desc);
        if (getIntent() != null) id = getIntent().getIntExtra(MainActivity.APP_MAIN_ID, ERROR_BOOK_ID);
        if (id != ERROR_BOOK_ID) {
            filmModel = rPresenter.loadFilm(id);
            title.setText(filmModel.getTitle());
            desc.setText(filmModel.getDescription());
        } else Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

}