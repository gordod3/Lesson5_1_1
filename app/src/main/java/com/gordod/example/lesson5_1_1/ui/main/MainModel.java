package com.gordod.example.lesson5_1_1.ui.main;

import android.util.Log;

import com.gordod.example.lesson5_1_1.App;
import com.gordod.example.lesson5_1_1.Tags;
import com.gordod.example.lesson5_1_1.data.Repo;
import com.gordod.example.lesson5_1_1.data.model.Book;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import com.gordod.example.lesson5_1_1.data.network.GhibliService;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements MainContract.Model {
    @Override
    public Book getBookById(int id) {
        return Repo.getBookById(id);
    }

    @Override
    public List<Book> getListBook() {
        return Repo.getBookList();
    }

    @Override
    public List<FilmModel> getFilmList() {
        return Repo.getFilmList();
    }
}
