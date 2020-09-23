package com.gordod.example.lesson5_1_1.data.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String title, desc;

    public Book(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
