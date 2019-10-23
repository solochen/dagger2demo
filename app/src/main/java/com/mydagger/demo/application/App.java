package com.mydagger.demo.application;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.mydagger.demo.base.Urls;
import com.solomvp.frame.di.component.DaggerAppComponent;
import com.mydagger.demo.base.GlobalHttpHandlerImpl;
import com.solomvp.frame.di.component.AppComponent;
import com.solomvp.frame.di.module.GlobalConfigModule;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


/**
 * Created by chenshaolong on 2019/8/15.
 */

public class App extends MultiDexApplication {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .application(this)
                .globalConfigModule(GlobalConfigModule.builder()
                        .baseurl(Urls.MAIN_HOST)
                        .globalHttpHandler(new GlobalHttpHandlerImpl(this))
                        .gsonConfiguration(((context, builder) -> {

                        }))
                        .retrofitConfiguration((context1, builder1) -> {
                            Log.e("solo", "app-retrofitConfiguration-----");

                        }).okhttpConfiguration((context1, builder1) -> {

                        }).build())
                .build();
        mAppComponent.inject(this);

        configMultiUrl();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private void configMultiUrl() {
        RetrofitUrlManager.getInstance().putDomain("wangyi163", Urls.WY163_HOST);
    }
}
