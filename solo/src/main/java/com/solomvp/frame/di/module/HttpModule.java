package com.solomvp.frame.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.solomvp.frame.http.GlobalHttpHandler;
import com.solomvp.frame.http.log.RequestInterceptor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供网络请求的module
 * 使用Okhttp、Retrofit 网络框架
 *
 * Created by chenshaolong on 2019/9/25.
 */

@Module
public abstract class HttpModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit(Application app,
                                    Retrofit.Builder builder,
                                    OkHttpClient client,
                                    HttpUrl httpUrl,
                                    Gson gson,
                                    RetrofitConfiguration retrofitConfiguration) {

        builder.baseUrl(httpUrl).client(client);
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create(gson));

        if (retrofitConfiguration != null)
            retrofitConfiguration.configRetrofit(app, builder);

        Log.e("solo", "provideRetrofit------");
        return builder.build();
    }

    @Singleton
    @Provides
    static OkHttpClient provideClient(Application application,
                                      @Nullable OkHttpConfiguration configuration,
                                      OkHttpClient.Builder builder,
                                      Interceptor intercept,
                                      @Nullable List<Interceptor> interceptors,
                                      @Nullable GlobalHttpHandler handler,
                                      ExecutorService executorService) {

        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(intercept);

        if (handler != null)
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(handler.onHttpRequestBefore(chain, chain.request()));
                }
            });

        //如果外部提供了 Interceptor 的集合则遍历添加,外部可配公共header、公共参数等
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }

        //为 OkHttp 设置默认的线程池
        builder.dispatcher(new Dispatcher(executorService));

        if (configuration != null)
            configuration.configOkHttp(application, builder);

        Log.e("solo", "provideClient------");
        return builder.build();
    }

    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder() {
        Log.e("solo", "provideRetrofitBuilder------");
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    static OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }

    @Binds
    abstract Interceptor bindInterceptor(RequestInterceptor interceptor);

    public interface RetrofitConfiguration {
        void configRetrofit(@NonNull Context context, @NonNull Retrofit.Builder builder);
    }

    public interface OkHttpConfiguration {
        void configOkHttp(@NonNull Context context, @NonNull OkHttpClient.Builder builder);
    }
}