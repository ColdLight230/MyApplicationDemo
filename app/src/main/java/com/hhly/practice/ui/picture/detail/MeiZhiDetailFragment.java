package com.hhly.practice.ui.picture.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.practice.BR;
import com.hhly.practice.R;
import com.hhly.practice.core.FragmentView;
import com.hhly.practice.databinding.FragmentMeizhiDetailBinding;
import com.hhly.practice.utils.ImageLoader;

import uk.co.senab.photoview.PhotoView;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/22
 */
public class MeiZhiDetailFragment extends FragmentView<MeiZhiDetailContract.Presenter> implements MeiZhiDetailContract.View {


    private FragmentMeizhiDetailBinding mBinding;
    private PhotoView photoView;
    private TextView tv_desc;
    private Bundle bundle;
    private MeiZhiPictureBean meiZhiPictureBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_meizhi_detail,container,false);
        bundle = getArguments();

        meiZhiPictureBean = bundle.getParcelable(MeiZhiDetailActivity.MEIZHIPICTURE);
        photoView = mBinding.photoView;
        tv_desc = mBinding.description;

        PictureViewModel pictureViewModel = new PictureViewModel(meiZhiPictureBean);
        mBinding.setVariable(BR.picture, pictureViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageLoader.loadFitCenter(getContext(), meiZhiPictureBean.url).into(photoView);
    }

    public static MeiZhiDetailFragment newInstance(MeiZhiPictureBean meiZhiPictureBean) {

        Bundle args = new Bundle();
        args.putParcelable(MeiZhiDetailActivity.MEIZHIPICTURE, meiZhiPictureBean);
        MeiZhiDetailFragment fragment = new MeiZhiDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
