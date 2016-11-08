package com.hhly.myapplicationdemo.ui.android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.FragmentView;
import com.hhly.myapplicationdemo.databinding.FragmentAndroidBinding;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public class AndroidFragment extends FragmentView<AndroidContract.Presneter> implements AndroidContract.View{

    private FragmentAndroidBinding mBinding;

    public static AndroidFragment newInstance() {

        Bundle args = new Bundle();

        AndroidFragment fragment = new AndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_android,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new AndroidPresenter();
    }
}
