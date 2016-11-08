package com.hhly.myapplicationdemo.ui.picture.detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hhly.data.bean.MeiZhiPictureBean;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/23
 */
public class PictureViewModel extends BaseObservable {

    private MeiZhiPictureBean meiZhiPictureBean;

    public PictureViewModel(MeiZhiPictureBean meiZhiPictureBean){
        this.meiZhiPictureBean = meiZhiPictureBean;
    }

    @Bindable
    public String getMeiZhiUrl(){
        return meiZhiPictureBean.url;
    }

    @Bindable
    public String getDesc(){
        return meiZhiPictureBean.desc;
    }



}
