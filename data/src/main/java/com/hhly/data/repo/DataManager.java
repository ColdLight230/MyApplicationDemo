package com.hhly.data.repo;

import android.content.Context;

import com.hhly.data.api.BaseApi;
import com.hhly.data.bean.HistoryInfoBean;
import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.data.bean.ResultBaseBean;
import com.hhly.data.bean.TestBean;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */
public class DataManager {
    @Inject
    BaseApi mBaseApi;

    public DataManager(Context context, String apiHostUrl){
        DaggerDataComponent.builder()
                .dataModule(new DataModule(context, apiHostUrl))
                .build()
                .inject(this);
    }

    public Observable<List<HistoryInfoBean>> getHistoryInfo(int pageSize, int pageIndex){
        return mBaseApi.getHistoryInfo(pageSize,pageIndex)
                .compose(DataManager.<List<HistoryInfoBean>>handleResult());
    }

    public Observable<List<MeiZhiPictureBean>> getMeiZhiPictures(int pageSize, int pageIndex){
        return mBaseApi.getMeiZhiPicture(pageSize, pageIndex)
                .compose(DataManager.<List<MeiZhiPictureBean>>handleResult());
    }

    private static <T> Observable.Transformer<ResultBaseBean<T>, T> handleResult() {
        return new Observable.Transformer<ResultBaseBean<T>, T>() {

            @Override
            public Observable<T> call(Observable<ResultBaseBean<T>> apiResultObservable) {
                return apiResultObservable.flatMap(new Func1<ResultBaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(ResultBaseBean<T> tApiResult) {
                        if (!tApiResult.error) {
                            return Observable.just(tApiResult.results);
                        } else {
                            // TODO: 抛出自定义异常
                            return Observable.error(new Exception());
                        }
                    }
                });
            }
        };
    }
}
