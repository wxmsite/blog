package com.blog.model;

import java.sql.Date;

public class ExpertBlog {

    private int uid;
    private String blogUrl;


    private String title;
    private String content;
    private Date date;
    private int readNum;
    private int commentNum;

    public ExpertBlog( int uid,String blogUrl, String tile, String content, Date date, int readNum, int commentNum) {

        this.uid=uid;
        this.blogUrl = blogUrl;
        this.title = tile;
        this.content = content;
        this.date = date;
        this.readNum = readNum;
        this.commentNum = commentNum;
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

    public String getTitle() {
        return title;
    }

    public void setTile(String tile) {
        this.title = tile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
