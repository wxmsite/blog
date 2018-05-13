package com.blog.service;

import com.blog.model.blog;

import java.util.List;

public interface BlogService {
    List<blog> findAllblog();
    List<blog> findblogByClass(String className);
    List<blog> findblogByTag(int tid);
    boolean addArticle(blog blog);
}
