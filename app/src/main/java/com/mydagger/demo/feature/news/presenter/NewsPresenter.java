package com.mydagger.demo.feature.news.presenter;

import com.mydagger.demo.feature.news.contract.NewsContract;
import com.mydagger.demo.entity.News;
import com.mydagger.demo.entity.NewsBaseEntity;
import com.solomvp.frame.base.BasePresenter;
import com.solomvp.frame.di.scope.ActivityScope;
import com.solomvp.frame.mvp.NObserver;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenshaolong on 2019/10/23.
 */

@ActivityScope
public class NewsPresenter extends BasePresenter<NewsContract.Model, NewsContract.View> {

    @Inject
    public NewsPresenter(NewsContract.Model model, NewsContract.View rootView) {
        super(model, rootView);
    }

    public void getNews() {
        mModel.getNews()
                .subscribeOn(Schedulers.io())
//                .retryWhen(new RetryWithDelay(3, 2)) //重试（参数1 重试几次，参数2 重试间隔单位s）
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .subscribe(new NObserver<NewsBaseEntity<List<News>>>() {
                    @Override
                    public void onNext(NewsBaseEntity<List<News>> newsEntity) {
                        List<News> list = newsEntity.getT1348647909107();
                        if (list != null && list.size() > 0) {
                            mRootView.updateUI(list);
                        }
                    }
                });
    }

}
