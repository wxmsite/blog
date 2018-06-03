package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.BlogDetail;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 21:53
 */
public interface SearchService {
    void searchByCategories(String category);
    //通过solr搜索
    List<BlogDetail> searchBlogSolr(String keyword , int pn);
    //通过lucene方式搜索
    List<BlogDetail>searchBlogLucene(String keyword,int pn);
    long getCount();

}
