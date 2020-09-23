package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.Repo;
import com.gordod.example.lesson5_1_1.data.model.Book;

public class ReadModel implements ReadContract.Model {

    @Override
    public Book getBookById(int id) {
        return Repo.getBookById(id);
    }

}
