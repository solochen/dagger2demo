package com.mydagger.demo.feature.user.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mydagger.demo.R;
import com.mydagger.demo.application.App;
import com.solomvp.frame.base.BaseActivity;
import com.mydagger.demo.di.component.DaggerUserComponent;
import com.mydagger.demo.feature.user.contract.UserContract;
import com.mydagger.demo.feature.user.presenter.UserPresenter;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<UserPresenter> implements UserContract.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected int initView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    protected void injectInstance(Bundle savedInstanceState) {
        App app = (App) getApplication();
        DaggerUserComponent
                .builder()
                .appComponent(app.getAppComponent())
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getUser();

            }
        });

    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }
}
