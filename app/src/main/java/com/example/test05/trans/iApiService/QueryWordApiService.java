package com.example.test05.trans.iApiService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.test05.util.StaticQuality.QUERY_WORD;

/**
 * 查找单词网络访问retrofit的辅助接口
 */

public interface QueryWordApiService {
    //需要一个参数，查找的key
    @GET(QUERY_WORD)
    Call<Response> queryWord(@Query("w")String key);
}
