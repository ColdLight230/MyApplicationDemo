package com.hhly.myapplicationdemo.ui.picture;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.BaseActivity;
import com.hhly.myapplicationdemo.databinding.ActivityMeizhiBinding;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class MeiZhiActivity extends BaseActivity {

    private ActivityMeizhiBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_meizhi);

        MeiZhiFragment meiZhiFragment = MeiZhiFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, meiZhiFragment).commit();
    }
}
