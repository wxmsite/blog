package com.blog.service.impl;

import com.blog.Enums.SeckillStateEnum;
import com.blog.Exception.RepeatKillException;
import com.blog.Exception.SeckillCloseException;
import com.blog.Exception.SeckillException;
import com.blog.JedisDao.impl.JedisClientSingle;
import com.blog.Mapper.SeckillMapper;
import com.blog.Mapper.SeckillSucceedMapper;
import com.blog.model.SuccessKilled;
import com.blog.pojo.Exposer;
import com.blog.pojo.SeckillExecution;
import com.blog.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;


/**
 * author bebetter159
 * date  2018/6/7 22:21
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);
    private final String key = "seckill";
    private final String salt = "qem1.";
    @Autowired
    JedisClientSingle jedisClientSingle;
    @Autowired
    SeckillMapper seckillMapper;
    @Autowired
    SeckillSucceedMapper seckillSucceedMapper;


    @Override
    public Exposer exportSeckillUrl() {
        Long endTime = jedisClientSingle.getSeckillTime();
        //系统当前时间
        Date nowTime = new Date();
        if (endTime < nowTime.getTime()) {
            return new Exposer(false, nowTime.getTime(), endTime);
        }

        //秒杀开启，返回秒杀商品的id、用给接口加密的md5
        /*String salt = UUID.randomUUID().toString().substring(0, 5);
        String md5 = MD5Util.getMD5(key + salt);*/
        String md5 = getMD5(key);
        return new Exposer(true, md5);
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(int userId, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {

        if (md5 == null || !md5.equals(getMD5(key))) {
            //秒杀数据被重写了
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑:减库存+增加购买明细

        try {
            //否则更新了库存，秒杀成功,增加明细
            int insertCount = seckillSucceedMapper.insertId(userId);
            //看是否该明细被重复插入，即用户是否重复秒杀
            if (insertCount <= 0) {
                throw new RepeatKillException("seckill repeated");
            } else {
                //减库存,热点商品竞争
                int updateCount = seckillMapper.reduceNumber();
                if (updateCount <= 0) {
                    //没有更新库存记录，说明秒杀结束 rollback
                    throw new SeckillCloseException("seckill is closed");
                } else {
                    //秒杀成功,得到成功插入的明细记录,并返回成功秒杀的信息 commit
                    SuccessKilled successKilled = seckillSucceedMapper.queryByIdWithSeckill(userId);
                    return new SeckillExecution(SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException | RepeatKillException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所以编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :" + e.getMessage());
        }

    }

    private String getMD5(String key) {
        String base = key + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
