package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import java.util.List;

public interface MainContract {
    interface View{
        void showFilmInfo(int id);
    }

    interface Presenter {
        FilmModel getFilmListByID(int id);
        void loadFilmList(List<FilmModel> filmList);
        void filmOnClick(int id);
    }

    interface Model {
        void loadFilmList(List<FilmModel> filmList);
        FilmModel getFilmByID(int id);
    }

}
