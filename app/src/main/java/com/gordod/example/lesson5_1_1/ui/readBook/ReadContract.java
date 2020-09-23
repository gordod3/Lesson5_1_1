package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.model.Book;

public interface ReadContract {
    // Надо делать Contract для всех важных активити?
    interface Presenter{
        Book loadBook(int id);
    }

    interface Model {
        Book getBookById(int id);
    }
}
