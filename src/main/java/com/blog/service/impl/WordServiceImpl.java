package com.blog.service.impl;

import com.blog.Mapper.WordMapper;
import com.blog.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author bebetter159
 * date  2018/5/30 23:12
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    WordMapper wordMapper;

    public WordServiceImpl() {
    }
    public WordServiceImpl(WordMapper wordMapper){
        this.wordMapper=wordMapper;
    }

    @Override
    public boolean updateFile(String keyword, String FileId) {
        return wordMapper.updateFile(keyword,FileId);
    }

    @Override
    public String selectFile(String keyword) {
        return wordMapper.selectFile(keyword);
    }

    @Override
    public boolean saveFile(String keyword, String fileId) {
        return wordMapper.saveFile(keyword,fileId);
    }
}
