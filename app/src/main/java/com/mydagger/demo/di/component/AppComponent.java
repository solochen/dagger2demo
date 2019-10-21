package com.mydagger.demo.di.component;

import android.app.Application;

import com.mydagger.demo.base.App;
import com.mydagger.demo.base.User;
import com.mydagger.demo.di.module.AppModule;
import com.mydagger.demo.di.module.GlobalConfigModule;
import com.mydagger.demo.di.module.HttpModule;

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

    @Deprecated
    User getUser();


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
