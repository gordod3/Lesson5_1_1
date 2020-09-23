package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.Repo;
import com.gordod.example.lesson5_1_1.data.model.Book;

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
}
