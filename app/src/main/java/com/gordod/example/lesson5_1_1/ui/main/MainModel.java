package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.Repo;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import java.util.List;

public class MainModel implements MainContract.Model {
    @Override
    public void loadFilmList(List<FilmModel> filmList) {
        Repo.loadFilmList(filmList);
    }

    @Override
    public FilmModel getFilmByID(int id) {
        return Repo.getFilmById(id);
    }
}
