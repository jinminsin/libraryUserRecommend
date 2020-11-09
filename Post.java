package com.slave_mk14.libraryuserrecommendation;

public class Post {
    private int cid;
    private String title;
    private String subtitle;
    private String owner;
    private String createDate;
    private String password;

    public int getCid() {
        return cid;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getOwner() {
        return owner;
    }

    public String getPassword() {
        return password;
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

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
