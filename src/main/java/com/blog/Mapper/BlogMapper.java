package com.blog.Mapper;
import com.blog.model.Blog;
import com.blog.model.BlogDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * author bebetter159
 * date  时间未详
 */
@Mapper
public interface BlogMapper {
    List<Blog> getAllBlog();
    boolean savePersonalBlog(BlogDetail blogDetail);
    int getCount();
    BlogDetail getPersonalBlog(int id);
    List<BlogDetail>getAllPersonalBlog(@Param("startOffset") int startOffset, @Param("pageSize") int pageSize);
    List<BlogDetail>getBlogTitle();




}
