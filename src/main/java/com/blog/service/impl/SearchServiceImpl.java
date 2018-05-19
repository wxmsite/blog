package com.blog.service.impl;

import com.blog.Mapper.SearchMapper;
import com.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author bebetter159
 * date  2018/5/18 21:54
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;

    @Override
    public void searchByCategories(String category) {

    }
}
