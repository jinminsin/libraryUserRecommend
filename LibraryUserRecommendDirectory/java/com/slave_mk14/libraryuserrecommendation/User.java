package com.slave_mk14.libraryuserrecommendation;

public class User {
    private int seedid;//시드 아이디
    private String id; //아이디
    private String likeBookCode;//특징
    private String siblingLikeBookCode;

    public User(int seedid, String id, String likeBookCode, String siblingLikeBookCode){
        this.seedid=seedid;
        this.id=id;
        this.likeBookCode=likeBookCode;
        this.siblingLikeBookCode=siblingLikeBookCode;
    }

    public void saveLikeBookCode(String likeBookCode,String siblingLikeBookCode){
        this.likeBookCode=likeBookCode;
        this.siblingLikeBookCode=siblingLikeBookCode;
    }

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

    public String getSiblingLikeBookCode(){
        return siblingLikeBookCode;
    }

    public void setSiblingLikeBookCode(String siblingLikeBookCode){
        this.siblingLikeBookCode = siblingLikeBookCode;
    }
}