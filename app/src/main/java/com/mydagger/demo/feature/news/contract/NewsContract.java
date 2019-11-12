package com.mydagger.demo.feature.news.contract;

import android.app.Activity;

import com.mydagger.demo.entity.News;
import com.mydagger.demo.entity.NewsBaseEntity;
import com.solomvp.frame.mvp.IModel;
import com.solomvp.frame.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public interface NewsContract {

    interface View extends IView {
        Activity getActivity();
        void startLoadMore();
        void endLoadMore();
        void updateUI(List<News> list);
    }


    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface Model extends IModel{
        Observable<NewsBaseEntity<List<News>>> getNews();
    }
}
