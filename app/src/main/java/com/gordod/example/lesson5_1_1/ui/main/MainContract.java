package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.model.Book;

import java.util.List;

public interface MainContract {
    interface View{
        void showBook(int id);
    }

    interface Presenter {
        Book loadBook();
        List<Book> loadListBook();
        void bookOnClick(int id);
    }

    interface Model {
        Book getBookById(int id);
        List<Book> getListBook();
    }

}
