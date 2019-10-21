package com.mydagger.demo.di.module;


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
    static User provideUser() {
        return User.getUser();
    }


}
