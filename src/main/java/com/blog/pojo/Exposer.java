package com.blog.pojo;

/**
 * author bebetter159
 * date  2018/6/7 22:05
 */
public class Exposer {
    private boolean exposed;
    private String md5;
    private long nowTime;
    private long seckillTime;

    public Exposer() {
    }

    public Exposer(boolean exposed, String md5) {
        this.exposed = exposed;
        this.md5 = md5;
    }

    public Exposer(boolean exposed, long nowTime, long seckillTime) {
        this.exposed = exposed;

        this.nowTime = nowTime;
        this.seckillTime = seckillTime;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }


    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public long getSeckillTime() {
        return seckillTime;
    }

    public void setSeckillTime(long seckillTime) {
        this.seckillTime = seckillTime;
    }
}
