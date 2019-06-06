package com.blog.model;
/**
 * author bebetter159
 * 保存每位博客专家的信息
 */

public class ExpertUrl {
    private int eid;
    private String blogName;
    private String expertUrl;
    private String avatarUrl;
    private String name;
    private String place;
    private String work;
    private long readNum;
    private int articleNum;
    public ExpertUrl(){

    }

    public ExpertUrl(int eid, String blogName,String expertUrl, String avatarUrl, String name, String place, String work, long readNum, int articleNum) {
        this.eid = eid;
        this.blogName=blogName;
        this.expertUrl = expertUrl;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.place = place;
        this.work = work;
        this.readNum = readNum;
        this.articleNum = articleNum;
    }

    public ExpertUrl(String blogName,String avatarUrl, String expertUrl, String name, String place, String work, int articleNum, int readNum) {
       this.blogName=blogName;
        this.avatarUrl = avatarUrl;
        this.expertUrl = expertUrl;
        this.name = name;
        this.place = place;
        this.work = work;
        this.articleNum = articleNum;
        this.readNum = readNum;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
    public long getReadNum() {
        return readNum;
    }
    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }
    public int getArticleNum() {
        return articleNum;
    }
    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }


    public String getExpertUrl() {
        return expertUrl;
    }

    public void setExpertUrl(String expertUrl) {
        this.expertUrl = expertUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }


}
