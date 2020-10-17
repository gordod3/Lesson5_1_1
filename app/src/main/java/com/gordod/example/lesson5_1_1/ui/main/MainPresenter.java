package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.model.FilmModel;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Model mModel;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public FilmModel getFilmListByID(int id) {
        return mModel.getFilmByID(id);
    }

    @Override
    public void loadFilmList(List<FilmModel> filmList) {
        mModel.loadFilmList(filmList);
    }

    @Override
    public void filmOnClick(int id) {
        mView.showFilmInfo(id);
    }
}
