package com.slave_mk14.libraryuserrecommendation;

public class Post {
    private int cid;//커뮤니티 아이디
    private String title;//게시물 제목
    private String subtitle;//게시물 내용
    private String owner;//작성자
    private String createDate;//생성일
    private String password;//게시물 비밀번호

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
