package com.hhly.data.repo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */

@Component(modules = {DataModule.class})
@Singleton
public interface DataComponent {

    void inject(DataManager dataManager);
}
