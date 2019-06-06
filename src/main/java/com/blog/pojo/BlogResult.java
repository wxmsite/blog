package com.blog.pojo;

public class BlogResult {

    //响应业务状态
    private int status;
    //相应消息
    private String msg;
    //相应中的数据
    private Object data;

    public BlogResult() {

    }

    public BlogResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public BlogResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static BlogResult wrong() {
        return new BlogResult(200, "NO", null);

    }


    public static BlogResult build(Integer status, String msg, Object data) {
        return new BlogResult(status, msg, data);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "BlogResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
