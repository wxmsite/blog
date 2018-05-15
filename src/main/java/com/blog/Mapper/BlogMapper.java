package com.blog.Mapper;

import com.blog.model.BlogUrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogMapper {
    List<BlogUrl> findAllblog();
    List<BlogUrl> findblogByClass(String className);
    List<BlogUrl> findblogByTag(int tid);
    boolean addArticle(BlogUrl blog);
}
