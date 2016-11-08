package com.hhly.myapplicationdemo;

import com.hhly.data.repo.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(App app);
}
