package com.hhly.myapplicationdemo.core;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public interface IPresenter<V extends IView> {

    void attachView(V view);

    void detachView();
}
