package com.mydagger.demo.feature.user.contract;

import com.solomvp.frame.mvp.IModel;
import com.solomvp.frame.mvp.IView;
import com.mydagger.demo.entity.Self;

import io.reactivex.Observable;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public interface UserContract {

    interface View extends IView {
        void startLoadMore();
        void endLoadMore();
    }


    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface Model extends IModel{
        Observable<Self> getUsers(String token);
    }
}
