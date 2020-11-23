package com.example.finalproject;

public class Board {

    //게시판 데이터
    private int id;// 게시판 id
    private String title;// 게시판 제목
    private String subtitle; //게시판 내용
    private String owner; // 관리자
    private String pwd; // 패스워드
    //protected String createDate;

    public Board(int id, String title, String owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.pwd = pwd;
        this. subtitle = subtitle;
    }

    public int getId() {
        return id;
    }

    public void setId (int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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
}

