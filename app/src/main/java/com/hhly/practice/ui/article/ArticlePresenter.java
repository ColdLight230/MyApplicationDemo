package com.hhly.practice.ui.article;

import com.hhly.data.bean.AndroidBean;
import com.hhly.practice.core.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public class ArticlePresenter extends BasePresenter<ArticleContract.View> implements ArticleContract.Presneter {

    private List<AndroidBean> mDatas = new ArrayList<>();

    public ArticlePresenter(ArticleContract.View view){
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
