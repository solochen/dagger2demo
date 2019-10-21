package com.mydagger.demo.di.component;

import com.mydagger.demo.feature.MainActivity;
import com.mydagger.demo.di.module.ActivityModule;
import com.mydagger.demo.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by chenshaolong on 2019/9/25.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

}
