package com.hhly.practice.ui.web;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.hhly.practice.R;
import com.hhly.practice.core.BaseActivity;
import com.hhly.practice.databinding.ActivityWebBinding;


public class WebActivity extends BaseActivity {

    private static final String KEY_URL = "url";
    private static final String KEY_TITLE = "title";
    Toolbar mToolbar;
    private ActivityWebBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_web);
        mToolbar = mBinding.toolbar;

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> WebActivity.this.finish());

        String url = getIntent().getStringExtra(KEY_URL);
        String title = getIntent().getStringExtra(KEY_TITLE);
//        if (!TextUtils.isEmpty(title)) {
//            mBinding.title.setText(title);
//        }
        mBinding.webView.loadUrl(url);
    }

    public static void start(Context context, String url, String title) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(KEY_URL, url);
        intent.putExtra(KEY_TITLE, title);
        context.startActivity(intent);
    }
}
