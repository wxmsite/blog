package com.blog.service.impl;


import com.blog.Mapper.ExpertUrlMapper;
import com.blog.model.BlogUrl;
import com.blog.model.ExpertUrl;
import com.blog.service.ExpertUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertUrlServiceImpl implements ExpertUrlService {
    private final ExpertUrlMapper expertUrlMapper;

    @Autowired
    public ExpertUrlServiceImpl(ExpertUrlMapper expertUrlMapper) {
        this.expertUrlMapper = expertUrlMapper;
    }

    @Override
    public List<ExpertUrl> getAllExpertUrl() {
        return expertUrlMapper.getAllExpertUrl();
    }

    @Override
    public void updateBlogUrl(String blogUrl, String title, String time, int read, int comment) {
        expertUrlMapper.updateBlogUrl(blogUrl, title, time, read, comment);
    }


    @Override
    public boolean insertExpertUrl(ExpertUrl expertUrl) {
        return expertUrlMapper.insertExpertUrl(expertUrl);
    }

    @Override
    public boolean insertBlogUrl(BlogUrl blogUrl) {
        return expertUrlMapper.insertBlogUrl(blogUrl);
    }


}
