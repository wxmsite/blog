package com.blog.model;

/**
 * author bebetter159
 * date  2018/5/15 19:39
 */
public class BlogUrl {
    private int eid;
    private String title;
    private String blogUrl;

    public BlogUrl() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogUrl(int eid, String blogUrl ) {
        this.eid = eid;
        this.blogUrl = blogUrl;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
}
