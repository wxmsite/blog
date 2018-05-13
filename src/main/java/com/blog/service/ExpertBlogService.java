package com.blog.service;

import com.blog.model.ExpertUrl;
import com.blog.model.ExpertBlog;
import org.springframework.stereotype.Service;

@Service
public interface ExpertBlogService {
     boolean insertUrl(ExpertUrl expertUrl);
     boolean deleteUrl(String blogUrl);
     boolean insertBlog(ExpertBlog expertBlog);
     boolean deleteBlog(int id);
}
