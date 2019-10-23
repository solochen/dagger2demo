package com.mydagger.demo.feature.news.di.component;

import com.mydagger.demo.feature.news.contract.NewsContract;
import com.mydagger.demo.feature.news.di.module.NewsModule;
import com.mydagger.demo.feature.news.ui.activity.NewsActivity;
import com.mydagger.demo.feature.user.ui.activity.LoginActivity;
import com.solomvp.frame.di.component.AppComponent;
import com.solomvp.frame.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by chenshaolong on 2019/10/17.
 */

@ActivityScope
@Component(modules = NewsModule.class, dependencies = AppComponent.class)
public interface NewsComponent {

    void inject(NewsActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        NewsComponent.Builder view(NewsContract.View view);
        NewsComponent.Builder appComponent(AppComponent appComponent);
        NewsComponent build();
    }
}
