package com.hhly.practice;

import com.hhly.data.repo.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */
@Module
public class AppModule {
    private App mApp;
    private String mHostUrl;

    public AppModule(App app, String apiHostUrl){

        this.mApp = app;
        this.mHostUrl = apiHostUrl;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(){
        return new DataManager(mApp, mHostUrl);
    }

}
