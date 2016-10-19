package com.demon.retrofit2_1.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Demon
 * @version V1.0
 * @Description: 自定义CallBack
 * @date 2016年10月18日16:19:25
 */
public abstract class CusCallback<T extends BaseCallBean> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        // 请求接收成功的统一处理...
        /*
        if (response.body().code.equals("0")) {
            onSuccess(response);
        } else {
            onFailure(response.body().code);
        }
        */
        onSuccess(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        // 请求接收失败的统一处理...
        /*
        if (t instanceof SocketTimeoutException) {
            // 网络异常
            onNetError();
        } else if (t instanceof ConnectException) {
            // 网络异常
            onNetError();
        } else if (t instanceof RuntimeException) {
            // 系统异常
            onSysError();
        }
        */
        onFailure(t.getMessage());
    }

    /**
     * 请求成功
     * @param response  Response
     */
    public abstract void onSuccess(Response<T> response);

    /**
     * 请求失败
     * @param message   错误消息
     */
    public abstract void onFailure(String message);
}