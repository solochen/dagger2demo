package com.mydagger.demo.feature.news.model;

import com.mydagger.demo.feature.news.contract.NewsContract;
import com.mydagger.demo.entity.News;
import com.mydagger.demo.entity.NewsBaseEntity;
import com.mydagger.demo.feature.news.model.service.NewsService;
import com.solomvp.frame.di.scope.ActivityScope;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by chenshaolong on 2019/10/23.
 */

@ActivityScope
public class NewsModel implements NewsContract.Model {

    NewsService mNewsService;

    @Inject
    public NewsModel(Retrofit retrofit){
        mNewsService = retrofit.create(NewsService.class);
    }


    @Override
    public Observable<NewsBaseEntity<List<News>>> getNews() {
        return mNewsService.getNews();
    }

    @Override
    public void onDestroy() {
        mNewsService = null;
    }
}
