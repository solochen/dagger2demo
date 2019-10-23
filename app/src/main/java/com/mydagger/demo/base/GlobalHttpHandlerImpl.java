package com.mydagger.demo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.mydagger.demo.aframe.http.GlobalHttpHandler;
import com.mydagger.demo.aframe.http.log.RequestInterceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by chenshaolong on 2019/10/16.
 */

public class GlobalHttpHandlerImpl implements GlobalHttpHandler {

    private Context context;
    private Gson mGson;

    public GlobalHttpHandlerImpl(Context context) {
        this.context = context;
        mGson = new GsonBuilder().create();
    }

    @NonNull
    @Override
    public Request onHttpRequestBefore(@NonNull Interceptor.Chain chain, @NonNull Request request) {
        //配置公共header
        return chain.request()
                .newBuilder()
                .header("Token", "4e585caaeaccead0c0a2542c2f01e0604f5a8712040a596fdb21a186db2b274eee6ed134ba5a9ec58471539871ba24c95473defebe280c24")
                .build();
    }

    /**
     * 这里可以先客户端一步拿到每一次 Http 请求的结果, 可以先解析成 Json, 再做一些操作, 如检测到 token 过期后
     * 重新请求 token, 并重新执行请求
     *
     * @param httpResult 服务器返回的结果 (已被框架自动转换为字符串)
     * @param chain      {@link okhttp3.Interceptor.Chain}
     * @param response   {@link Response}
     * @return {@link Response}
     */
    @NonNull
    @Override
    public Response onHttpResultResponse(@Nullable String httpResult, @NonNull Interceptor.Chain chain, @NonNull Response response) {
        if (!TextUtils.isEmpty(httpResult) && RequestInterceptor.isJson(response.body().contentType())) {
            try {
                BaseResponse httpResponse = mGson.fromJson(httpResult, BaseResponse.class);
                if (!httpResponse.isSuccess()) {
                    return response;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return response;
            }
        }

        ResponseBody body = response.body();
        JsonReader jsonReader = new JsonReader(body.charStream());
        String simpleResponse = mGson.fromJson(jsonReader, String.class);
        Log.e("solo", simpleResponse);

        /* 这里如果发现 token 过期, 可以先请求最新的 token, 然后在拿新的 token 放入 Request 里去重新请求
        注意在这个回调之前已经调用过 proceed(), 所以这里必须自己去建立网络请求, 如使用 Okhttp 使用新的 Request 去请求
        create a new request and modify it accordingly using the new token
        Request newRequest = chain.request().newBuilder().header("token", newToken)
                             .build();

        retry the request

        response.body().close();
        如果使用 Okhttp 将新的请求, 请求成功后, 再将 Okhttp 返回的 Response return 出去即可
        如果不需要返回新的结果, 则直接把参数 response 返回出去即可*/
        return response;
    }


}
