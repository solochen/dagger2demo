package com.mydagger.demo.feature.user.model;

import com.solomvp.frame.di.scope.ActivityScope;
import com.mydagger.demo.feature.user.contract.UserContract;
import com.mydagger.demo.entity.Self;
import com.mydagger.demo.feature.user.model.service.UserService;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by chenshaolong on 2019/10/17.
 */

@ActivityScope
public class UserModel implements UserContract.Model {

    UserService mUserService;

    @Inject
    public UserModel(Retrofit retrofit){
        mUserService = retrofit.create(UserService.class);
    }

    @Override
    public Observable<Self> getUsers(String token) {
        //这里可以做一些缓存，Rxcache等
        return mUserService.getUser(token);
    }


    @Override
    public void onDestroy() {
        mUserService = null;
    }
}
