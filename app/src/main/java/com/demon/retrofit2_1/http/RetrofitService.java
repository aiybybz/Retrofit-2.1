package com.demon.retrofit2_1.http;

import com.demon.retrofit2_1.bean.Price;
import com.demon.retrofit2_1.bean.UserBean;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @author Demon
 * @version 1.0
 * @Description Retrofit 2.0 网络请求API
 * @date 2016年10月13日13:54:01
 */
public interface RetrofitService {

    /**
     * 个人信息（改造后）
     * @param   userId 用户Id
     * @return  UserBean
     */
    @POST("bOurOperatorInfo")
    Call<BaseCallBean<UserBean>> userInfo(@Query("bUserId") String userId);

    /**
     * 价目表（改造后）
     * @return  String
     */
    @POST("bPriceTarget")
    Call<BaseCallBean<List<Price>>> bPriceTarget();

    /**
     * 上传文件（改造后）
     * @param makeThum String
     * @param file MultipartBody.Part
     * @return ResponseBody
     */
    @Multipart
    @POST("http://192.168.1.1/recycleImgServer/uploadFile")
    Call<BaseCallBean<String>> uploadFile(@Query("makeThum") String makeThum, @Part MultipartBody.Part file);

    /**
     * 个人信息（改造前）
     * @param 	userId 用户Id
     * @return 	ResponseBody
     */
    @POST("userInfo")
    Call<ResponseBody> userInfoB(@Query("userId") String userId);

    /**
     * 上传文件（改造前）
     * @param makeThum String
     * @param file MultipartBody.Part
     * @return ResponseBody
     */
    @Multipart
    @POST("http://192.168.1.1/recycleImgServer/uploadFile")
    Call<ResponseBody> uploadFileB(@Query("makeThum") String makeThum, @Part MultipartBody.Part file);



    /**
     retrofit注解：
     1.方法注解：@GET、@POST、@PUT、@DELETE、@PATH、@HEAD、@OPTIONS、@HTTP。
     2.标记注解：@FormUrlEncoded、@Multipart、@Streaming。
     3.参数注解：@Query,@QueryMap、@Body、@Field、@FieldMap、@Part、@PartMap。
     4.其他注解：@Path、@Header、@Headers、@Url
     */
    /*--------------------------- 一、几个特殊的注解 ------------------------*/


    // @HTTP：可以替代其他方法的任意一种
    @HTTP(method = "get", path = "users/{user}", hasBody = false)
    Call<UserBean> getFirstBlog(@Path("user") String user);
    /**
     * method   请求方法，不区分大小写
     * path     请求路径
     * hasBody  是否有请求体
     */


    // @Url：使用全路径复写baseUrl，适用于非统一baseUrl的场景。
    @GET
    Call<ResponseBody> v3(@Url String url);
    /**
     * @GET     GET请求
     * @Url     使用全路径复写baseUrl
     */


    // @Streaming:用于下载大文件
    @Streaming
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlAsync(@Url String fileUrl);
    /**
     * @Streaming   用于下载大文件
     *
     接收后写法
     ResponseBody body = response.body();
     long fileSize = body.contentLength();
     InputStream inputStream = body.byteStream();
     */


    /*--------------------------- 二、常用注解------------------------*/
    // @Path：URL占位符，用于替换和动态更新,相应的参数必须使用相同的字符串被@Path进行注释
    @GET("group/{id}/users")
    Call<List<UserBean>> groupList(@Path("id") int groupId);
    /**
     * @GET("group/{id}/users")     id为占位符
     * @Path                        URL占位符
     * 请求地址等同于 http://baseurl/group/groupId/users
     */


    // @Query,@QueryMap:查询参数，用于GET查询,需要注意的是@QueryMap可以约定是否需要encode
    @GET("group/users")
    Call<List<UserBean>> groupListT(@Query("id") int groupId);
    //--> http://baseurl/group/users?id=groupId
    @GET("group/users")
    Call<List<UserBean>> getNews(@QueryMap(encoded = true) Map<String, String> options);
    /**
     * @Query       查询参数
     * @QueryMap    查询参数 可以约定是否需要encode
     */


    // @Body:POST请求体，将实例对象根据转换方式转换为对应的json字符串参数，这个转化方式是GsonConverterFactory定义的。
    @POST("add")
    Call<List<UserBean>> addUser(@Body UserBean user);
    /**
     * @Body    POST请求体
     */


    // @Field，@FieldMap:Post方式传递简单的键值对,
    // 需要添加@FormUrlEncoded表示表单提交
    // Content-Type:application/x-www-form-urlencoded
    @FormUrlEncoded
    @POST("user/edit")
    Call<UserBean> updateUser(@Field("first_name") String first, @Field("last_name") String last);
    /**
     * @Field           Post方式传递简单的键值对
     * @FieldMap        键值对集合
     * @FormUrlEncoded  表单提交
     */


    // @Part，@PartMap：用于POST文件上传
    // 其中@Part MultipartBody.Part代表文件，@Part(“key”) RequestBody代表参数
    // 需要添加@Multipart表示支持文件上传的表单，Content-Type: multipart/form-data
    @Multipart
    @POST("upload")
    Call<ResponseBody> upload(@Part("description") RequestBody description, @Part MultipartBody.Part file);
    /**
        File file = new File("");
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        String descriptionString = "hello, this is description speaking";
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
     */
    /**
     * @Multipart       支持文件上传的表单
     * @Part            用于POST文件上传
     * @PartMap
     */


    // @Header：header处理，不能被互相覆盖，用于修饰参数
    //动态设置Header值
    @GET("user")
    Call<ResponseBody> getUser(@Header("Authorization") String authorization);
    // 等同于静态设置Header值
    @Headers("Authorization: authorization")//这里authorization就是上面方法里传进来变量的值
    @GET("widget/list")
    Call<ResponseBody> getUser();
    /**
     * @Header      修饰header
     */


    // @Headers 用于修饰方法,用于设置多个Header值：
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("users/{username}")
    Call<ResponseBody> getUserT(@Path("username") String username);
    /**
     * @Headers     修饰header
     */


    // 乱码解决方式
    // String name =  URLEncoder.encode("111","UTF-8");

    /****************** 未探索内容 ******************/
    // 1.自定义Converter
    // 2.缓存策略
    // 3.与RxJava 结合
}