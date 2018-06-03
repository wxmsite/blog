package com.blog.model;

/**
 * author bebetter159
 * date  2018/5/21 22:24
 */
public class Blog {
    private String blogUrl;
    private String title;
    private String date;
    private int readNum;
    private int commentNum;

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Override
    public String toString() {
        return "Blog{" +
                "blogUrl='" + blogUrl + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", readNum=" + readNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
