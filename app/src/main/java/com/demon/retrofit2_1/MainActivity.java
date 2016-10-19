package com.demon.retrofit2_1;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.demon.retrofit2_1.bean.Price;
import com.demon.retrofit2_1.bean.UserBean;
import com.demon.retrofit2_1.http.BaseCallBean;
import com.demon.retrofit2_1.http.CusCallback;
import com.demon.retrofit2_1.http.RetrofitManage;
import com.demon.retrofit2_1.http.RetrofitService;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    /**
     * 网络请求API对象
     */
    private RetrofitService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHttp();
    }

    private void initHttp() {
        api = RetrofitManage.getInstance().getApi();
    }


    public void dOnClick(View v) {
        switch (v.getId()) {
            // HTTP请求
            case R.id.btnHttp:
                // bOurOperatorInfo();
                // bPriceTarget();
                // uploadFileB();
                bPriceTarget();
                //  userInfo();
                break;
        }
    }

    /**
     * 获取个人信息（改造前）
     */
    private void userInfoB() {
        // 调用接口方法
        Call<ResponseBody> call = api.userInfoB("103");
        // 异步请求
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // 关闭请求
        // call.clone();
        // call只能调用一次。否则会抛 IllegalStateException

        // 取消
        // call.cancel();
    }

    /**
     * 上传文件（改造前）
     */
    private void uploadFileB() {
        String APP_PATH = Environment.getExternalStorageDirectory() + "/APK/1111.png";
        File file = new File(APP_PATH);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("picture", "111111.png", requestFile);

        Call<ResponseBody> call = api.uploadFileB("0", body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 获取个人信息（改造后）
     */
    private void userInfo() {
        // 调用接口方法
        Call<BaseCallBean<UserBean>> call = api.userInfo("103");
        // 异步请求
        call.enqueue(new CusCallback<BaseCallBean<UserBean>>() {
            @Override
            public void onSuccess(Response<BaseCallBean<UserBean>> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 价目表（改造后）
     */
    private void bPriceTarget() {
        // 调用接口方法
        Call<BaseCallBean<List<Price>>> call = api.bPriceTarget();
        // 异步请求
        call.enqueue(new CusCallback<BaseCallBean<List<Price>>>() {
            @Override
            public void onSuccess(Response<BaseCallBean<List<Price>>> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
