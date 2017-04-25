package com.hhly.practice.ui.article;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhly.practice.R;
import com.hhly.practice.core.FragmentView;
import com.hhly.practice.databinding.FragmentAndroidBinding;
import com.hhly.practice.ui.web.WebActivity;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/10/14
 */
public class ArticleFragment extends FragmentView<ArticleContract.Presneter> implements ArticleContract.View {

    private FragmentAndroidBinding mBinding;
    private RecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;

    public static ArticleFragment newInstance() {

        Bundle args = new Bundle();

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_android, container, false);
        mRecyclerView = mBinding.recyclerView;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new ArticlePresenter(this);
        mPresenter.onLoadingData(30, 1);
        mAdapter = new ArticleAdapter(mPresenter.getArticle());

        mAdapter.setOnItemClickListener(position -> {
            WebActivity.start(mActivity, mPresenter.getArticle().get(position).url, null);
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void loadDataFinish() {
        mAdapter.notifyDataSetChanged();
    }
}
