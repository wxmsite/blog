package com.blog.model;

public class ExpertUrl {

    private String avatarUrl;
    private String blogUrl;
    private String name;
    private String place;
    private String work;
    private int articleNum;
    private int readNum;

    public ExpertUrl(String avatarUrl, String blogUrl, String name, String place, String work, int articleNum, int readNum) {
        this.avatarUrl = avatarUrl;
        this.blogUrl = blogUrl;
        this.name = name;
        this.place = place;
        this.work = work;
        this.articleNum = articleNum;
        this.readNum = readNum;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
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

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getReadNum() {
        return readNum;
    }

    @Override
    public String toString() {
        return "ExpertUrl{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", work='" + work + '\'' +
                ", articleNum=" + articleNum +
                ", readNum=" + readNum +
                '}';
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }
}
