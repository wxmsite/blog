package com.blog.Mapper;
import com.blog.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * author bebetter159
 * date  时间未详
 */
@Mapper
public interface ExpertBlogMapper {
    List<Blog> getAllBlog();




}
