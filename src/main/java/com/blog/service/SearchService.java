package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 21:53
 */
public interface SearchService {
    void searchByCategories(String category);
    List<Blog> searchBlog(String keyword ,int pn);
    long getCount();
    boolean indexBlog(String blog_url, String title);
}
