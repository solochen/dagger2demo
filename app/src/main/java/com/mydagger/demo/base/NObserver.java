package com.mydagger.demo.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public abstract class NObserver<T> implements Observer<T> {
    public NObserver() {
    }

    public void onSubscribe(Disposable d) {
    }

    public void onComplete() {
    }

    public void onError(Throwable e) {
    }
}
