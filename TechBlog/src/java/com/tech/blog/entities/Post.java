package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
private int pId;
private String pTitle;
private String pContent;
private String pCode;
private String pPic;
private Timestamp pDate;
private int c_Id;
private int u_Id;

    public Post() {
    }

    public Post(int pId, String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int c_Id, int u_Id) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.c_Id = c_Id;
        this.u_Id = u_Id;
    }

    public Post(String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int c_Id, int u_Id) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.c_Id = c_Id;
        this.u_Id = u_Id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public Timestamp getpDate() {
        return pDate;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public int getC_Id() {
        return c_Id;
    }

    public void setC_Id(int c_Id) {
        this.c_Id = c_Id;
    }

    public int getU_Id() {
        return u_Id;
    }

    public void setU_Id(int u_Id) {
        this.u_Id = u_Id;
    }
    
}
