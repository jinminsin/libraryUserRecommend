package com.slave_mk14.libraryuserrecommendation;

import java.util.ArrayList;

public class LikeBook {
    public String title;
    public ArrayList<Book> book;

    public LikeBook(String title, ArrayList book){
        this.title = title;
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Book> getBook() {
        return book;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }
}