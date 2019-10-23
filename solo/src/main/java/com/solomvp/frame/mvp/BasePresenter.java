package com.solomvp.frame.mvp;

import com.solomvp.frame.mvp.IModel;
import com.solomvp.frame.mvp.IPresenter;
import com.solomvp.frame.mvp.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {

    protected CompositeDisposable mCompositeDisposable;
    protected M mModel;
    protected V mRootView;

    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        unDispose();
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mRootView = null;
        this.mCompositeDisposable = null;
    }

    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
