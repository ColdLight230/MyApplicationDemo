package com.hhly.myapplicationdemo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.LruCache;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.core.BaseActivity;
import com.hhly.myapplicationdemo.databinding.ActivityMainUserBinding;
import com.hhly.myapplicationdemo.ui.android.AndroidFragment;
import com.hhly.myapplicationdemo.ui.picture.MeiZhiFragment;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/26
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ActivityMainUserBinding mBinding;
    private DrawerLayout mDrawLayout;
    private Toolbar mToolbar;
    private int currentFragment;
    private FrameLayout mFrameLayout;
    private FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_user);

        mDrawLayout = mBinding.drawLayout;
        mToolbar = mBinding.appBarMain.toolbar;
        mToolbar.setTitle("Android");

//        StatusBarUtil.setColorForDrawerLayout(this,mDrawLayout, ContextCompat.getColor(this, R.color.colorPrimaryDark));

        //设置toolbar左侧菜单按钮事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawLayout.openDrawer(GravityCompat.START);
            }
        });
        mFrameLayout = mBinding.appBarMain.flContent;
        manager = getSupportFragmentManager();


        mBinding.navLayout.navigationItemAndroid.setOnClickListener(this);
        mBinding.navLayout.navigationItemGirl.setOnClickListener(this);
        mBinding.navLayout.navigationItemMusic.setOnClickListener(this);
        mBinding.navLayout.navigationItemVedio.setOnClickListener(this);
        mBinding.navLayout.navigationItemSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigation_item_android:
                currentFragment = 0;
                mToolbar.setTitle("Android");
                onResume();
                break;
            case R.id.navigation_item_girl:
                currentFragment = 1;
                mToolbar.setTitle("Girl");
                onResume();
                break;
            case R.id.navigation_item_music:
                currentFragment = 2;
                mToolbar.setTitle("Music");
                onResume();
                break;
            case R.id.navigation_item_vedio:
                currentFragment = 3;
                mToolbar.setTitle("Vedio");
                onResume();
                break;
            case R.id.navigation_item_setting:
                currentFragment = 4;
                mToolbar.setTitle("Setting");
                onResume();
                break;
        }

        mDrawLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.beginTransaction().replace(R.id.fl_content,FragmentFactory.get(currentFragment)).commit();
    }

    static class FragmentFactory {

        private static LruCache<Integer, Fragment> mFragmentLruCache = new LruCache<>(4);

        public static Fragment get(int position) {
            Fragment fragment = mFragmentLruCache.get(position);
            if (fragment == null) {
                switch (position) {
                    case 0:
                        fragment = AndroidFragment.newInstance();
                        break;
                    case 1:
                        fragment = MeiZhiFragment.newInstance();
                        break;
                    case 2:
                        fragment = AndroidFragment.newInstance();
                        break;
                    case 3:
                        fragment = AndroidFragment.newInstance();
                        break;
                    case 4:
                        fragment = AndroidFragment.newInstance();
                        break;
                    default:
                        fragment = AndroidFragment.newInstance();
                        break;
                }
                mFragmentLruCache.put(position, fragment);
            }
            return fragment;
        }
    }
}
