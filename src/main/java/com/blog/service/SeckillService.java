package com.blog.service;

import com.blog.Exception.RepeatKillException;
import com.blog.Exception.SeckillCloseException;
import com.blog.Exception.SeckillException;
import com.blog.pojo.Exposer;
import com.blog.pojo.SeckillExecution;

/**
 * author bebetter159
 * date  2018/6/7 22:09
 */
public interface SeckillService {
    Exposer exportSeckillUrl();
    SeckillExecution executeSeckill( int userId, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;
}
