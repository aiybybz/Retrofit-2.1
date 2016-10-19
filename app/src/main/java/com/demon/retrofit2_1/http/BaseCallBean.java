package com.demon.retrofit2_1.http;

/**
 * @author Demon
 * @version V1.0
 * @Description: 请求返回基类
 * @date 2016年10月18日16:17:35
 */
public class BaseCallBean<T> {

    public boolean success;
    public String code;
    public T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}