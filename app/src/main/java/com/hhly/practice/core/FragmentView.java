package com.hhly.practice.core;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class FragmentView<P extends IPresenter> extends BaseFragment implements IView {

    protected P mPresenter;

    public FragmentView(){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView();
        }
    }
}
