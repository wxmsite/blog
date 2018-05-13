package com.blog.Mapper;

import com.blog.model.blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogMapper {
    List<blog> findAllblog();
    List<blog> findblogByClass(String className);
    List<blog> findblogByTag(int tid);
    boolean addArticle(blog blog);
}
