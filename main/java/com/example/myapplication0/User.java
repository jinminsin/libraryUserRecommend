package com.example.myapplication0;

public class User {
    String Muser;
    int seedid;//시드 아이디
    String id; //아이디

    public String getMuser(){
        return Muser;
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

    public void setMuser(String Muser){
        this.Muser = Muser;
    }
}
