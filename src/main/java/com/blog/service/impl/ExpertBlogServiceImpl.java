package com.blog.service.impl;


import com.blog.Mapper.ExpertBlogMapper;

import com.blog.model.ExpertBlog;
import com.blog.service.ExpertBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertBlogServiceImpl implements ExpertBlogService {
    public ExpertBlogServiceImpl() {
    }

    @Autowired
    ExpertBlogMapper expertBlogMapper;


    @Override
    public List<ExpertBlog> getAllblog() {
        return expertBlogMapper.getAllBlog();
    }
}

