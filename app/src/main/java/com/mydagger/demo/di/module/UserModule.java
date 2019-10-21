package com.mydagger.demo.di.module;

import com.mydagger.demo.feature.user.contract.UserContract;
import com.mydagger.demo.feature.user.model.UserModel;

import dagger.Binds;
import dagger.Module;

/**
 * Created by chenshaolong on 2019/10/17.
 */

@Module
public abstract class UserModule {

    /**
     * @Binds 注入一个接口的实现（UserModule 类需要声明 abstract），类似以下写法：
     *  @Provides
        public UserContract.Model provideModel(UserModel model) {
            return model;
        }
     * @param model
     * @return
     */
    @Binds
    abstract UserContract.Model bindUserModel(UserModel model);
}
