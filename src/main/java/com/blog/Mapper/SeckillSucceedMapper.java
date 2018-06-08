package com.blog.Mapper;

import com.blog.model.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * author bebetter159
 * date  2018/6/8 0:29
 */
@Mapper
public interface SeckillSucceedMapper {
    /**
     * 插入秒杀成功的用户id
     * @param UserId
     * @return
     */
    int insertId(int UserId);
    SuccessKilled queryByIdWithSeckill(@Param("userId") int userId);
}
