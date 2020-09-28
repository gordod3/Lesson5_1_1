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
    private static ArrayList<Book> books = new ArrayList<>();
    public static List<FilmModel> filmModels = new ArrayList<>();

    public static List<FilmModel> getFilmList(){
        App.ghibliService.getFilmList(new GhibliService.GhibliFilmCallback() {
            @Override
            public void onSuccess(List<FilmModel> fMlList) {
                filmModels = fMlList;
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(Tags.ERROR.toString(),
                        "ERROR: " +
                                t.getLocalizedMessage() + "\n" +
                                t.getMessage());
            }
        });
        Log.d(Tags.RESULT.toString(), filmModels.size() + "");
        return filmModels;
    }

    public static FilmModel getFilmById(int id){
        return filmModels.get(id);
    }
    public static List<Book> getBookList() {
        for (int i = 0; i < 31; i++) {
            books.add(new Book("book" + i, "d"));
        }
        return books;
    }

    public static Book getBookById(int id) {
        return books.get(id);
    }
}
