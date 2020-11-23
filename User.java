package com.slave_mk14.libraryuserrecommendation;

public class User {
    int seedid;//시드 아이디
    String id; //아이디
    String likeBookCode;//특징

    public int getSeedid() {
        return seedid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeedid(int seedid) {
        this.seedid = seedid;
    }

    public String getLikeBookCode(){
        return likeBookCode;
    }

    public void setLikeBookCode(String likeBookCode){
        this.likeBookCode = likeBookCode;
    }
}
