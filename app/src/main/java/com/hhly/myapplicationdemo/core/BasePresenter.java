package com.hhly.myapplicationdemo.core;

import android.view.View;

import com.hhly.data.repo.DataManager;
import com.hhly.myapplicationdemo.App;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 描    述：Presenter 基类
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {

    protected V mView;
    protected DataManager mDataManager;

    private CompositeSubscription mCompositeSubscription;

    public BasePresenter() {
        mDataManager = App.get().getDataManager();
    }

    public BasePresenter(V view){
        this();
        attachView(view);
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        onUnSubcribe();
        mView = null;

    }

    public <T> void  addSubsription(Observable<T> observable, Subscriber<T> subscriber){
        if(mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }

        Subscription subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        mCompositeSubscription.add(subscription);
    }

    public void onUnSubcribe(){
        if(mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

}

