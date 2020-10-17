package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.model.FilmModel;

public interface ReadContract {
    interface Presenter{
        FilmModel loadFilm(int id);
    }

    interface Model {
        FilmModel getFilmById(int id);
    }
}
