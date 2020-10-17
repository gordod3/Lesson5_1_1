package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.Repo;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;

public class ReadModel implements ReadContract.Model {

    @Override
    public FilmModel getFilmById(int id) {
        return Repo.getFilmById(id);
    }

}
