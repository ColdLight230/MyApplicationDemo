package com.hhly.myapplicationdemo.ui.picture.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.BaseActivity;
import com.hhly.myapplicationdemo.databinding.ActivityMeizhiDetailBinding;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/22
 */
public class MeiZhiDetailActivity extends BaseActivity {
    public static final String MEIZHIPICTURE = "MEIZHIPICTURE";
    private ActivityMeizhiDetailBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_meizhi_detail);

        MeiZhiPictureBean meiZhiPictureBean = getIntent().getParcelableExtra(MEIZHIPICTURE);

        MeiZhiDetailFragment fragment = MeiZhiDetailFragment.newInstance(meiZhiPictureBean);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragment).commit();
    }
}
