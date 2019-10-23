package com.mydagger.demo.di.module;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mydagger.demo.base.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenshaolong on 2019/9/24.
 */

@Module
public class AppModule {

    @Singleton
    @Provides
    static Gson provideGson(Application application, @Nullable GsonConfiguration configuration) {
        GsonBuilder builder = new GsonBuilder();
        if (configuration != null)
            configuration.configGson(application, builder);
        return builder.create();
    }

    @Singleton
    @Provides
    static User provideUser() {
        return User.getUser();
    }


    public interface GsonConfiguration {
        void configGson(@NonNull Context context, @NonNull GsonBuilder builder);
    }

}
