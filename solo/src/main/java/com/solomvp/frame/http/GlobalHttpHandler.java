package com.solomvp.frame.http;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chenshaolong on 2019/9/25.
 */

public interface GlobalHttpHandler {

    @NonNull
    Response onHttpResultResponse(@Nullable String httpResult, @NonNull Interceptor.Chain chain, @NonNull Response response);

    @NonNull
    Request onHttpRequestBefore(@NonNull Interceptor.Chain chain, @NonNull Request request);
}
