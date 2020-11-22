package com.example.myapplication0;

class Comment_Item {
    private int pid;//게시판 아이디
    private int id;
    private String subtitle;//댓글 내용
    private String owner;//댓글 아이디
    private String createDate;//생성일
    private String password;//댓글 비밀번호

    Comment_Item(int pid, String subtitle, String owner, String createDate ,String password) {
        this.pid = pid;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
        this.password = password;

    }

    Comment_Item(int pid,int id, String subtitle, String owner, String createDate ,String password) {
        this.pid = pid;
        this.id = id;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
        this.password = password;

    }

    public int getPid() {
        return pid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getOwner() {
        return owner;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}