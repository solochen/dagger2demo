package com.mydagger.demo.di.module;

import android.app.Application;

import com.mydagger.demo.R;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenshaolong on 2019/9/25.
 */

@Module
public class ActivityModule {


    @Provides
    public String provideIsGood(Application app){
        return app.getResources().getString(R.string.app_title_test);
    }

}
