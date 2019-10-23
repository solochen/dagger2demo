package com.mydagger.demo.di.component;

import com.solomvp.frame.di.component.AppComponent;
import com.mydagger.demo.di.module.UserModule;
import com.solomvp.frame.di.scope.ActivityScope;
import com.mydagger.demo.feature.user.contract.UserContract;
import com.mydagger.demo.feature.user.ui.activity.LoginActivity;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by chenshaolong on 2019/10/17.
 */

@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {

    void inject(LoginActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        UserComponent.Builder view(UserContract.View view);
        UserComponent.Builder appComponent(AppComponent appComponent);
        UserComponent build();
    }
}
