package com.example.writelistviewtest;

public class Board_Item {

    private int id;
    private String title;
    private String owner;
    private String pwd;
    private String subtitle;
    private String writer;

    //data class
    public Board_Item(int id, String title, String owner, String pwd, String subtitle, String writer){
        this.id = id;
        this.owner = owner;
        this.pwd = pwd;
        this.subtitle = subtitle;
        this.title = title;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
