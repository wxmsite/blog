package com.blog.Mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * author bebetter159
 * date  2018/5/18 21:54
 */
@Mapper
public interface SearchMapper {
    void searchByCategories(String category);
}
