package com.hhly.myapplicationdemo.ui.picture;

import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.myapplicationdemo.core.IPresenter;
import com.hhly.myapplicationdemo.core.IView;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public interface MeiZhiContract {

    interface View extends IView{
        void onLoadingDataFinish();
    }

    interface Presenter extends IPresenter<MeiZhiContract.View>{
        void onLoadingData(int pageSize, int pageIndex);
        List<MeiZhiPictureBean> getMeiZhi();
    }
}
