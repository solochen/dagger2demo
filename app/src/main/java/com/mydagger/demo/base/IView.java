package com.mydagger.demo.base;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public interface IView {
    default void showLoading() {
    }

    default void hideLoading() {
    }
}
