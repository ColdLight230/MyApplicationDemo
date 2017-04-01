package com.hhly.practice.ui.android;

import com.hhly.data.bean.AndroidBean;
import com.hhly.practice.core.IPresenter;
import com.hhly.practice.core.IView;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public interface AndroidContract {

     interface View extends IView{
         void loadDataFinish();
    }

    interface Presneter extends IPresenter<AndroidContract.View>{
        void onLoadingData(int pageSize, int pageIndex);
        List<AndroidBean> getArticle();
    }
}
