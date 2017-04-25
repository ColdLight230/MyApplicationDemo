package com.hhly.practice.core;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public abstract class BaseFragment extends RxFragment {

    protected final String TAG = getClass().getSimpleName();
    protected BaseActivity mActivity;
    public String mPageName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageName = onSetPageName();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @NonNull

    protected String onSetPageName() {
        return TAG;
    }

    /**
     * 是否是 TabFragment，某些情况需要这个参数判断是否显示阴影
     *
     * @return boolean
     */
    public boolean isTabFragment() {
        return false;
    }

    public final void replaceFragment(Fragment fragment, @IdRes int containerId, boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    public final void replaceFragment(Fragment fragment, @IdRes int containerId) {
        replaceFragment(fragment, containerId, true);
    }
}
