package com.mydagger.demo.aframe.http;

import android.support.annotation.NonNull;

import okhttp3.HttpUrl;

/**
 * Created by chenshaolong on 2019/10/15.
 */

public interface BaseUrl {
    /**
     * 在调用 Retrofit API 接口之前,使用 Okhttp 或其他方式,请求到正确的 BaseUrl 并通过此方法返回
     *
     * @return
     */
    @NonNull
    HttpUrl url();
}
