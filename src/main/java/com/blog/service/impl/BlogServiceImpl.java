package com.blog.service.impl;

import com.blog.Mapper.BlogMapper;
import com.blog.model.Blog;
import com.blog.model.BlogDetail;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/27 17:46
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public BlogServiceImpl() {
    }

    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public List<Blog> getAllExpertblog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public boolean savePersonalBlog(BlogDetail blogDetail) {
        return blogMapper.savePersonalBlog(blogDetail);
    }

    @Override
    public int getCount() {
        return blogMapper.getCount();
    }

    @Override
    public BlogDetail getPersonalBlog(int id) {
        return blogMapper.getPersonalBlog(id);
    }


    @Override
    public List<BlogDetail> getAllPersonalBlog(int pn, int pageSize) {
        int startOffset=(pn-1)*pageSize;
        return blogMapper.getAllPersonalBlog(startOffset, pageSize);
    }

    @Override
    public List<BlogDetail> getBlogTitle() {
        return blogMapper.getBlogTitle();
    }
}
