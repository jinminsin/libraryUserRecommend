package com.slave_mk14.libraryuserrecommendation;

public class Community {
    private String name;//커뮤니티 명
    private String detail;//커뮤니티 정보
    private String owner;//커뮤니티 장
    private String createDate;//커뮤니티 생성일

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
