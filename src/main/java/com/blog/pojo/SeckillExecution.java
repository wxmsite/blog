package com.blog.pojo;

import com.blog.Enums.SeckillStateEnum;
import com.blog.model.SuccessKilled;

/**
 * author bebetter159
 * date  2018/6/8 0:05
 */
public class SeckillExecution {
    //秒杀执行结果的状态
    private int state;

    //状态的明文标识
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecution() {
    }

    //秒杀成功，返回秒杀状态、信息和秒杀成功对象
    public SeckillExecution(SeckillStateEnum statEnum, SuccessKilled successKilled) {

        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    //秒杀失败,返回失败状态和失败信息
    public SeckillExecution(SeckillStateEnum statEnum) {
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
