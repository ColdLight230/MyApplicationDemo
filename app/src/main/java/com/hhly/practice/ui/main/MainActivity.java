package com.hhly.practice.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.LruCache;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.hhly.practice.R;
import com.hhly.practice.core.BaseActivity;
import com.hhly.practice.databinding.ActivityMainUserBinding;
import com.hhly.practice.ui.article.ArticleFragment;
import com.hhly.practice.ui.picture.MeiZhiFragment;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/26
 */
public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawLayout;
    private Toolbar mToolbar;
    private int currentFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainUserBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_user);

        mDrawLayout = mBinding.drawLayout;
        mToolbar = mBinding.appBarMain.toolbar;
        mToolbar.setTitle("Article");

        //设置toolbar左侧菜单按钮事件
        mToolbar.setNavigationOnClickListener(v -> mDrawLayout.openDrawer(GravityCompat.START));
        manager = getSupportFragmentManager();


        mBinding.navLayout.navigationItemAndroid.setOnClickListener(v -> {
            currentFragment = 0;
            mToolbar.setTitle("Android");
            onResume();
            mDrawLayout.closeDrawer(GravityCompat.START);
        });

        mBinding.navLayout.navigationItemGirl.setOnClickListener(v -> {
            currentFragment = 1;
            mToolbar.setTitle("Girl");
            onResume();
            mDrawLayout.closeDrawer(GravityCompat.START);
        });
        mBinding.navLayout.navigationItemSetting.setOnClickListener(v -> mDrawLayout.closeDrawer(GravityCompat.START));
    }


    @Override
    protected void onResume() {
        super.onResume();
        manager.beginTransaction().replace(R.id.fl_content, FragmentFactory.get(currentFragment)).commit();
    }

    private static class FragmentFactory {

        private static LruCache<Integer, Fragment> mFragmentLruCache = new LruCache<>(2);

        static Fragment get(int position) {
            Fragment fragment = mFragmentLruCache.get(position);
            if (fragment == null) {
                switch (position) {
                    case 0:
                        fragment = ArticleFragment.newInstance();
                        break;
                    case 1:
                        fragment = MeiZhiFragment.newInstance();
                        break;
                }
                mFragmentLruCache.put(position, fragment);
            }
            return fragment;
        }
    }

}
