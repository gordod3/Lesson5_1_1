package com.gordod.example.lesson5_1_1.data;

import android.util.Log;

import com.gordod.example.lesson5_1_1.App;
import com.gordod.example.lesson5_1_1.Tags;
import com.gordod.example.lesson5_1_1.data.model.Book;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import com.gordod.example.lesson5_1_1.data.network.GhibliService;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private static List<FilmModel> filmList = new ArrayList<>();

    public static void loadFilmList(List<FilmModel> filmList){
        setFilmList(filmList);
    }

    public static FilmModel getFilmById(int id){
        return getFilmList().get(id);
    }

    public static List<FilmModel> getFilmList() {
        return filmList;
    }

    public static void setFilmList(List<FilmModel> filmList) {
        Repo.filmList = filmList;
    }
}
