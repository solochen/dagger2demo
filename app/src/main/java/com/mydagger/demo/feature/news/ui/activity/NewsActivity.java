package com.mydagger.demo.feature.news.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mydagger.demo.R;
import com.mydagger.demo.application.App;
import com.mydagger.demo.feature.news.contract.NewsContract;
import com.mydagger.demo.feature.news.di.component.DaggerNewsComponent;
import com.mydagger.demo.feature.news.model.entity.News;
import com.mydagger.demo.feature.news.presenter.NewsPresenter;
import com.mydagger.demo.feature.news.ui.adapter.NewsAdapter;
import com.solomvp.frame.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsActivity extends BaseActivity<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Inject
    NewsAdapter mNewsAdapter;

    @Inject
    List<News> mNewsList;

    @Override
    protected int initView(Bundle savedInstanceState) {
        return R.layout.activity_news;
    }

    @Override
    protected void injectInstance(Bundle savedInstanceState) {
        App app = (App) getApplication();
        DaggerNewsComponent.builder()
                .appComponent(app.getAppComponent())
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mNewsAdapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @OnClick(R.id.fab)
    public void onFabBtnClick() {
        mPresenter.getNews();
    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public void updateUI(List<News> list) {
        mNewsList.clear();
        mNewsList.addAll(list);
        mNewsAdapter.notifyDataSetChanged();
    }
}
