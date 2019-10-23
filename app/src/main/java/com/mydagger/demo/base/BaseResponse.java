package com.mydagger.demo.base;

/**
 * Created by chenshaolong on 2019/10/21.
 */

public class BaseResponse<T> {

    private int code;
    private String msg;
    private T data;

    public boolean isSuccess(){
        return code == 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
