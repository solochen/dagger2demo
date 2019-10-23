package com.mydagger.demo.aframe.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.mydagger.demo.application.App;
import com.mydagger.demo.aframe.di.module.AppModule;
import com.mydagger.demo.aframe.di.module.GlobalConfigModule;
import com.mydagger.demo.aframe.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by chenshaolong on 2019/8/29.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class, GlobalConfigModule.class})
public interface AppComponent {

    void inject(App app);

    Application application();

    Retrofit retrofit();

    Gson gson();

    /**
     * 通过Component.Builder 和 @BindsInstance 方式来替换 使用Moudle 构造函数传递参数方式来提供 application参数
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();

        Builder globalConfigModule(GlobalConfigModule globalConfigModule);
    }

}
