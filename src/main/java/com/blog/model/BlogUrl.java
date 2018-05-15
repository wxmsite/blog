package com.blog.model;

public class BlogUrl {
    private int uid;
    private String blogUrl;
    private String avatarUrl;
    private String name;
    private String place;
    private String work;
    private long readNum;
    private int articleNum;

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
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
