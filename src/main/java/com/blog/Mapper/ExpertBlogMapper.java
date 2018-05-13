package com.blog.Mapper;

import com.blog.model.ExpertBlog;
import com.blog.model.ExpertUrl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpertBlogMapper {
    boolean insertUrl(ExpertUrl expertUrl);
    boolean deleteUrl(String blogUrl);
    boolean insertBlog(ExpertBlog expertBlog);
    boolean deleteBlog(int id);
}
