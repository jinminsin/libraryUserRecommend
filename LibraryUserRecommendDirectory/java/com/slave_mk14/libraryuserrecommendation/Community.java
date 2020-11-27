package com.slave_mk14.libraryuserrecommendation;

class Community {
    private String name;//커뮤니티 목록 명
    private String detail;//커뮤니티 내용
    private String owner;
    private String createDate;

    public Community(String name, String detail, String owner, String createDate) {
        this.name = name;
        this.detail = detail;
        this.owner = owner;
        this.createDate = createDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName(){
        return name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}