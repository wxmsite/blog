package com.blog.service;

/**
 * author bebetter159
 * date  2018/5/30 23:04
 */
public interface WordService {
    boolean updateFile(String keyword,String FileId);
    String selectFile(String keyword);
    boolean saveFile(String keyword,String fileId);

}
