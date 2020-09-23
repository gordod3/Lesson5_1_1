package com.gordod.example.lesson5_1_1.data;

import com.gordod.example.lesson5_1_1.data.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private static ArrayList<Book> books = new ArrayList<>();

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
