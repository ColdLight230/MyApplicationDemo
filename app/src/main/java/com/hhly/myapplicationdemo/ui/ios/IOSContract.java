package com.hhly.myapplicationdemo.ui.ios;

import com.hhly.myapplicationdemo.core.IPresenter;
import com.hhly.myapplicationdemo.core.IView;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public interface IOSContract {

     interface View extends IView{

    }

    interface Presneter extends IPresenter<IOSContract.View>{

    }
}
