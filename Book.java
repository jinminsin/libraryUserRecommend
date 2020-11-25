package com.slave_mk14.libraryuserrecommendation;

public class Book {
    String name;
    String publisher;
    String author;

    public Book(String name, String publisher, String author){
        this.name = name;
        this.publisher = publisher;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
