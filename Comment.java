package com.slave_mk14.libraryuserrecommendation;

class Comment {
    private int seedid;
    private int pid;//게시판 아이디
    private int id;
    private String subtitle;//댓글 내용
    private String owner;//댓글 아이디
    private String createDate;//생성일

    public Comment(int seedid, int pid, String subtitle, String owner, String createDate) {
        this.seedid = seedid;
        this.pid = pid;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
    }

    public Comment(int seedid, int pid, int id, String subtitle, String owner, String createDate) {
        this.seedid = seedid;
        this.pid = pid;
        this.id = id;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeedid() {
        return seedid;
    }

    public void setSeedid(int seedid) {
        this.seedid = seedid;
    }
}
