package com.mydagger.demo.feature.news.di.module;

import com.mydagger.demo.feature.news.contract.NewsContract;
import com.mydagger.demo.feature.news.model.NewsModel;
import com.mydagger.demo.entity.News;
import com.mydagger.demo.feature.news.ui.adapter.NewsAdapter;
import com.solomvp.frame.di.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by chenshaolong on 2019/10/17.
 */

@Module
public abstract class NewsModule {

    /**
     * @Binds 注入一个接口的实现（UserModule 类需要声明 abstract），类似以下写法：
     *  @Provides
        public UserContract.Model provideModel(UserModel model) {
            return model;
        }
     * @param model
     * @return
     */
    @Binds
    abstract NewsContract.Model bindNewsModel(NewsModel model);


    @ActivityScope
    @Provides
    static List<News> provideNewsList(){
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    static NewsAdapter provideAdapter(List<News> news){
        return new NewsAdapter(news);
    }
}
