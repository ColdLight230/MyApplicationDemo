package com.hhly.myapplicationdemo.ui.picture;

import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.myapplicationdemo.core.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class MeiZhiPresenter extends BasePresenter<MeiZhiContract.View> implements MeiZhiContract.Presenter {

    private List<MeiZhiPictureBean> mDatas = new ArrayList<>();

    public MeiZhiPresenter(MeiZhiContract.View view){
        super(view);
    }


    @Override
    public void onLoadingData(int pageSize, int pageIndex) {
        Observable<List<MeiZhiPictureBean>> observable = mDataManager.getMeiZhiPictures(10, 1);

        addSubsription(observable, new Subscriber<List<MeiZhiPictureBean>>() {
            @Override
            public void onCompleted() {
                mView.onLoadingDataFinish();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<MeiZhiPictureBean> meiZhiPictureBeen) {
                mDatas.clear();
                mDatas.addAll(meiZhiPictureBeen);
            }
        });
    }

    @Override
    public List<MeiZhiPictureBean> getMeiZhi() {
        return mDatas;
    }


}
