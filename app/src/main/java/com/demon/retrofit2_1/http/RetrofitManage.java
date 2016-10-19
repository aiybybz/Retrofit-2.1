package com.demon.retrofit2_1.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Demon
 * @version V1.0
 * @Description: Retrofit2.0 管理类
 * @date 2016年10月13日11:22:43
 */
public class RetrofitManage {

    /**
     * HTTP 请求地址
     **/
    private final String API_URL = "http://192.168.1.100/apiServer/";

    /**
     * 网络请求api
     */
    private RetrofitService api;

    private static RetrofitManage retrofitManage = null;

    /**
     * 静态工厂方法(单例)
     *
     * @return RetrofitManage
     */
    public synchronized static RetrofitManage getInstance() {
        if (retrofitManage == null) {
            retrofitManage = new RetrofitManage();
        }
        return retrofitManage;
    }

    /**
     * 构造方法
     */
    private RetrofitManage() {
        // 实例化授权拦截器
        OAuthInterceptor authInterceptor = new OAuthInterceptor(null, null);

        // OkHttp3 配置
        OkHttpClient client = new OkHttpClient.Builder()
                // 添加拦截器
                .addInterceptor(authInterceptor)
                // 连接超时时间
                .connectTimeout(7676, TimeUnit.SECONDS)
                // 读取时间
                .readTimeout(7676, TimeUnit.SECONDS)
                .build();

        // addInterceptor : 设置应用拦截器，可用于设置公共参数，头信息，日志拦截等
        // connectTimeout : 设置超时时间
        // readTimeout : 设置读取时间

        // 需添加依赖 'com.squareup.retrofit2:retrofit:2.1.0'
        Retrofit retrofit = new Retrofit.Builder()
                // 服务器请求URL
                .baseUrl(API_URL)
                // 添加Gson转换器 需添加依赖 'com.squareup.retrofit2:converter-gson:2.1.0'
                .addConverterFactory(GsonConverterFactory.create())
                // OkHttp3 对象
                .client(client)
                .build();

        // 获取Proxy.newProxyInstance动态代理对象
        api = retrofit.create(RetrofitService.class);
    }

    /**
     * 外部获取 RetrofitService
     * @return
     */
    public RetrofitService getApi() {
        return api;
    }
}