package com.blog.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * author bebetter159
 * date  2018/5/30 23:01
 */
@Mapper
public interface WordMapper {
    boolean updateFile(@Param("keyword") String keyword,@Param("fileId") String fileId);
    String selectFile(String keyword);
    boolean saveFile(@Param("keyword") String keyword,@Param("fileId") String fileId);
}
