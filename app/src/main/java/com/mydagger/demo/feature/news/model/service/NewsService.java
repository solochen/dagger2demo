package com.mydagger.demo.feature.news.model.service;

import com.mydagger.demo.feature.news.model.entity.News;
import com.mydagger.demo.feature.news.model.entity.NewsBaseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by chenshaolong on 2019/10/23.
 */

public interface NewsService {

    @Headers({"Domain-Name: wangyi163"})
    @GET("/nc/article/headline/T1348647909107/0-20.html")
    Observable<NewsBaseEntity<List<News>>> getNews();
}
