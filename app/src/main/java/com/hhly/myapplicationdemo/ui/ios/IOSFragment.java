package com.hhly.myapplicationdemo.ui.ios;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.FragmentView;
import com.hhly.myapplicationdemo.databinding.FragmentIosBinding;
import com.hhly.myapplicationdemo.ui.android.AndroidContract;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public class IOSFragment extends FragmentView<IOSContract.Presneter> implements IOSContract.View{

    private FragmentIosBinding mBinding;

    public static IOSFragment newInstance() {

        Bundle args = new Bundle();

        IOSFragment fragment = new IOSFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_ios,container,false);
        return mBinding.getRoot();
    }
}
