package com.mydagger.demo.feature.user.model.service;

import com.mydagger.demo.feature.user.model.entity.Self;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public interface UserService {

    @GET("/api/pi/public/common_config/1.0/version")
    Observable<Self> getUser(@Query("token") String token);

}
