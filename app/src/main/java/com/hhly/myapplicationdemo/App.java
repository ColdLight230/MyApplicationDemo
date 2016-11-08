package com.hhly.myapplicationdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.hhly.data.repo.DataManager;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/6
 */
public class App extends Application {

    @Inject
    DataManager mDataManager;

    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        init();
    }

    /**
     * 初始化数据层
     */
    private void init() {
        DaggerAppComponent.builder()
                .appModule(new AppModule(mApp, BuildConfig.API_HOST_URL))
                .build()
                .inject(this);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            Logger.init(BuildConfig.APPLICATION_ID);
        }
    }

    /**
     * 获取 DataManager
     *
     * @return dataManager
     */
    public DataManager getDataManager() {
        return mDataManager;
    }

    /**
     * 获取 Application 单例
     *
     * @return App
     */
    public static App get() {
        return mApp;
    }
}
