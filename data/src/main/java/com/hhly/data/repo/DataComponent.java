package com.hhly.data.repo;

import com.hhly.data.api.BaseApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */
@Singleton
@Component(modules = {DataModule.class})
public interface DataComponent {

    void inject(DataManager dataManager);
}
