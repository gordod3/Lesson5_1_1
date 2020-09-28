package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.model.Book;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;

public interface ReadContract {
    // Надо делать Contract для всех важных активити?
    interface Presenter{
        Book loadBook(int id);
        FilmModel loadFilm(int id);
    }

    interface Model {
        Book getBookById(int id);
        FilmModel getFilmById(int id);
    }
}
