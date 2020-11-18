package com.slave_mk14.libraryuserrecommendation;

class Post_Item {
    private String cid;
    private String id;
    private String title;
    private String subtitle;
    private String owner;
    private String createDate;
    private String password;

    Post_Item(String cid, String title, String subtitle, String owner, String createDate, String password){
        this.cid = cid;
        this.title = title;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
        this.password = password;
    }

    Post_Item(String cid, String id, String title, String subtitle, String owner, String createDate, String password){
        this.cid = cid;
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.owner = owner;
        this.createDate = createDate;
        this.password = password;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
