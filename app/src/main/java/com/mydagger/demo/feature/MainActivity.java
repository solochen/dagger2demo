package com.mydagger.demo.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mydagger.demo.R;
import com.mydagger.demo.application.App;
import com.mydagger.demo.base.User;
import com.mydagger.demo.di.component.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Inject
    User user;

    @Inject
    String mTitleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App app = (App) getApplication();
        DaggerActivityComponent
                .builder()
                .appComponent(app.getAppComponent())
                .build()
                .inject(this);


        setTitle();
    }

    private void setTitle() {
        mTvTitle.setText(mTitleName);
    }

}
