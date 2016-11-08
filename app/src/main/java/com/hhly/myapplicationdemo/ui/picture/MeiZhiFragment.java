package com.hhly.myapplicationdemo.ui.picture;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.FragmentView;
import com.hhly.myapplicationdemo.databinding.FragmentMeizhiBinding;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class MeiZhiFragment extends FragmentView<MeiZhiContract.Presenter> implements MeiZhiContract.View {

    private FragmentMeizhiBinding mBinding;
    private RecyclerView mRecyclerView;
    private MeiZhiAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_meizhi,container,false);
        mRecyclerView = mBinding.recyclerView;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new MeiZhiPresenter(this);
        mPresenter.onLoadingData(10,1);
        adapter = new MeiZhiAdapter(R.layout.item_meizhi, mPresenter.getMeiZhi());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRecyclerView.setAdapter(adapter);

    }

    public static MeiZhiFragment newInstance() {
        Bundle args = new Bundle();
        MeiZhiFragment fragment = new MeiZhiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLoadingDataFinish() {
        adapter.notifyDataSetChanged();
    }
}
