package com.gordod.example.lesson5_1_1.ui.main;

import com.gordod.example.lesson5_1_1.data.model.Book;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Model mModel;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public Book loadBook() {
        return mModel.getBookById(2);
    }

    @Override
    public List<Book> loadListBook() {
        return mModel.getListBook();
    }

    @Override
    public void bookOnClick(int id) {
        mView.showBook(id);
    }
}
