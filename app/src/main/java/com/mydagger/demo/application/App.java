package com.mydagger.demo.application;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.mydagger.demo.aframe.di.component.DaggerAppComponent;
import com.mydagger.demo.base.GlobalHttpHandlerImpl;
import com.mydagger.demo.aframe.di.component.AppComponent;
import com.mydagger.demo.aframe.di.module.GlobalConfigModule;


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
                        .baseurl("http://192.168.2.203:8003")
                        .globalHttpHandler(new GlobalHttpHandlerImpl(this))
                        .gsonConfiguration(((context, builder) -> {

                        }))
                        .retrofitConfiguration((context1, builder1) -> {
                            Log.e("solo", "app-retrofitConfiguration-----");

                        }).okhttpConfiguration((context1, builder1) -> {
                            Log.e("solo", "app-okhttpConfiguration-----");
                        }).build())
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
