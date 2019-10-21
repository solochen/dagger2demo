package com.mydagger.demo.feature.user.presenter;

import com.mydagger.demo.base.BasePresenter;
import com.mydagger.demo.base.NObserver;
import com.mydagger.demo.di.scope.ActivityScope;
import com.mydagger.demo.feature.user.contract.UserContract;
import com.mydagger.demo.feature.user.model.entity.Self;
import com.mydagger.demo.http.RetryWithDelay;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by chenshaolong on 2019/10/17.
 */

@ActivityScope
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {


    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View rootView) {
        super(model, rootView);
    }


    public void getUser() {
        mModel.getUsers("a123456")
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2)) //重试（参数1 重试几次，参数2 重试间隔单位s）
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .subscribe(new NObserver<Self>() {

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onNext(Self self) {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
