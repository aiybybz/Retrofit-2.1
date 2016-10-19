package com.demon.retrofit2_1.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Demon
 * @version V1.0
 * @Description: OkHttpClient 授权拦截器
 * @date 2016年10月13日11:22:43
 */
public class OAuthInterceptor implements Interceptor {

    static String PHONE;
    static String TOKEN;

    public OAuthInterceptor(String phone, String token) {
        PHONE = phone;
        TOKEN = token;
    }

    /**
     * 1.仅添加请求头
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (PHONE == null || TOKEN == null) {
            Request request = chain.request();
            return chain.proceed(request);
        } else {
            // 凭证
            String credentials = PHONE + "&" + TOKEN;
            Request authorised = chain.request().newBuilder()
                    // 请求头添加验证
                    .header("Authorization", credentials)
                    .build();
            // 继续进行这个请求
            return chain.proceed(authorised);
        }
    }

    /**
     * 2.添加请求头+请求体 / 请求体
    @Override
    public Response intercept(Chain chain) throws IOException {
        // 获取构建的请求
        Request.Builder builder = chain.request().newBuilder();
        // 添加请求头内容
        builder.addHeader("Authorization", "demon");

        // 创建一个新的请求体
        RequestBody formBody = new FormBody.Builder()
        .add("validateCode", "aiybybz@163.com")
        .build();

        // 请求添加请求体
        builder.put(formBody);

        // 继续进行这个请求
        return chain.proceed(builder.build());
    }
     */
}