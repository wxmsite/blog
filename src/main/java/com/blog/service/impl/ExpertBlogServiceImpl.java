package com.blog.service.impl;

import com.blog.Mapper.ExpertBlogMapper;
import com.blog.model.ExpertBlog;
import com.blog.model.ExpertUrl;
import com.blog.service.ExpertBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertBlogServiceImpl implements ExpertBlogService {
    private final ExpertBlogMapper expertBlogMapper;

    @Autowired
    public ExpertBlogServiceImpl(ExpertBlogMapper expertBlogMapper) {
        this.expertBlogMapper = expertBlogMapper;
    }


    @Override
    public boolean insertUrl(ExpertUrl expertUrl) {
        return expertBlogMapper.insertUrl(expertUrl);
    }

    @Override
    public boolean insertBlog(ExpertBlog expertBlog) {
        return expertBlogMapper.insertBlog(expertBlog);
    }

    @Override
    public boolean deleteBlog(int id) {
        return expertBlogMapper.deleteBlog(id);
    }

    @Override
    public boolean deleteUrl(String blogUrl) {
        return expertBlogMapper.deleteUrl(blogUrl);
    }
}
