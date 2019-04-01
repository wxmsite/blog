package com.blog.Mapper;

import com.blog.model.BlogDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 21:54
 */
@Mapper
public interface SearchMapper {
    List<BlogDetail> searchByCategories(@Param("category")String category);
}
