package com.blog.service.impl;

import com.blog.Mapper.BlogMapper;
import com.blog.model.BlogUrl;
import com.blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service()
public class BlogServiceImpl implements BlogService {
    public BlogServiceImpl() {
    }

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<BlogUrl> findAllblog() {
        return blogMapper.findAllblog();
    }

    @Override
    public List<BlogUrl> findblogByClass(String className) {
        return blogMapper.findblogByClass(className);
    }

    @Override
    public List<BlogUrl> findblogByTag(int tid) {
        return blogMapper.findblogByTag(tid);
    }


}

