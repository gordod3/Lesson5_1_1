package com.gordod.example.lesson5_1_1.ui.readBook;

import com.gordod.example.lesson5_1_1.data.model.Book;

public class ReadPresenter implements ReadContract.Presenter {
    ReadContract.Model rModel;

    public ReadPresenter() {
        rModel = new ReadModel();
    }

    @Override
    public Book loadBook(int id) {
        return rModel.getBookById(id);
    }
}
