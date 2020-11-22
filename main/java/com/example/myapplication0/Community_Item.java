package com.example.myapplication0;

class Community_Item {
    private String name;
    private String detail;
    private String owner;
    private String createDate;

    Community_Item(String name, String detail, String owner, String createDate) {
        this.name = name;
        this.detail = detail;
        this.owner = owner;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
