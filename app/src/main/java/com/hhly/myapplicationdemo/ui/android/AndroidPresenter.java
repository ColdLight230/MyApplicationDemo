package com.hhly.myapplicationdemo.ui.android;

import com.hhly.data.bean.AndroidBean;
import com.hhly.myapplicationdemo.core.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public class AndroidPresenter extends BasePresenter<AndroidContract.View> implements AndroidContract.Presneter {

    private List<AndroidBean> mDatas = new ArrayList<>();

    public AndroidPresenter(AndroidContract.View view){
        super(view);
    }

    @Override
    public void onLoadingData(int pageSize, int pageIndex) {
        Observable<List<AndroidBean>> androidArticle = mDataManager.getAndroidArticle(pageSize, pageIndex);

        addSubsription(androidArticle, new Subscriber<List<AndroidBean>>() {
            @Override
            public void onCompleted() {
                mView.loadDataFinish();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<AndroidBean> androidBeen) {
                mDatas.clear();
                mDatas.addAll(androidBeen);
            }
        });
    }

    @Override
    public List<AndroidBean> getArticle() {
        return mDatas;
    }
}
