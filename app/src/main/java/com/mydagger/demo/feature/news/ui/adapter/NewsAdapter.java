package com.mydagger.demo.feature.news.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mydagger.demo.R;
import com.mydagger.demo.entity.News;
import com.solomvp.frame.base.GlideApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chenshaolong on 2019/10/23.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<News> mNews;
    Context mContext;

    public NewsAdapter(List<News> list) {
        mNews = list;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
        News news = mNews.get(i);
        viewHolder.mTvTitle.setText(news.getTitle());
        viewHolder.mTvSubTitle.setText(news.getDigest());
        viewHolder.mTvTime.setText(news.getPtime());
        GlideApp.with(mContext)
                .load(news.getImgsrc())
                .centerCrop()
                .into(viewHolder.mIvLogo);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTvTitle;

        @BindView(R.id.tv_subtitle)
        TextView mTvSubTitle;

        @BindView(R.id.iv_logo)
        ImageView mIvLogo;

        @BindView(R.id.tv_time)
        TextView mTvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
