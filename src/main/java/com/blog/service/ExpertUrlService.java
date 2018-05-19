package com.blog.service;


import com.blog.model.BlogUrl;
import com.blog.model.ExpertUrl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * author bebetter159
 * date  时间未详
 */
/**
 * 管理所有博客专家的主页
 */
@Service
public interface ExpertUrlService {
     List<ExpertUrl> getAllExpertUrl();
     void updateBlogUrl(String blogUrl, String title, String time, int read, int comment);
     boolean insertExpertUrl(ExpertUrl expertUrl);
     boolean insertBlogUrl(BlogUrl blogUrl);


}
