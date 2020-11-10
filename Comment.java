package com.slave_mk14.libraryuserrecommendation;

public class Comment {
    private int pid;//게시판 아이디
    private String subtitle;//댓글 내용
    private String owner;//댓글 아이디
    private String createDate;//생성일
    private String password;//댓글 비밀번호

    public int getPid() {
        return pid;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
