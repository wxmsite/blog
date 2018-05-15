package com.blog.service;

import com.blog.model.BlogUrl;


import java.util.List;

public interface BlogService {
    List<BlogUrl> findAllblog();
    List<BlogUrl> findblogByClass(String className);
    List<BlogUrl> findblogByTag(int tid);


}
