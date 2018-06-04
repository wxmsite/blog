package com.blog.model;
/**
 * author bebetter159
 * date  2018/5/15 17:04
 */

/**
 * 用来保存每篇博客的内容
 */
public class BlogDetail {
    private String blogUrl;
    private String title;
    private String content;
    private String date;
    private int readNum;
    private int commentNum;

    public BlogDetail() {
    }

    public BlogDetail(String blogUrl, String tile, String content, String date, int readNum, int commentNum) {


        this.blogUrl = blogUrl;
        this.title = tile;
        this.content = content;
        this.date = date;
        this.readNum = readNum;
        this.commentNum = commentNum;
    }

    public BlogDetail(String tile, String content, String date, int readNum, int commentNum) {
        this.title = tile;
        this.content = content;
        this.date = date;
        this.readNum = readNum;
        this.commentNum = commentNum;
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


    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "BlogDetail{" +
                "blogUrl='" + blogUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", readNum=" + readNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
