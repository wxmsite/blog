package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.BlogDetail;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/27 17:46
 */
public interface BlogService {


    List<Blog> getAllExpertblog();
    boolean savePersonalBlog(BlogDetail blogDetail);
    int getCount();
    BlogDetail getPersonalBlog(int id);
    List<BlogDetail>getAllPersonalBlog(int pn,int pageSize);
    List<BlogDetail>getBlogTitle();

}
