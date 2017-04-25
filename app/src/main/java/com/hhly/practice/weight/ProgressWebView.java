package com.hhly.practice.weight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.hhly.practice.R;
import com.orhanobut.logger.Logger;

import static android.webkit.WebSettings.LOAD_DEFAULT;

public class ProgressWebView extends WebView {

    private ProgressBar mProgressBar;
    private boolean isAnimStart = false;
    private int currentProgress;
    /**
     * App 缓存 ：16M
     */
    long APP_CACHE_MAX_SIXE = 1024 * 1024 * 16;

    public ProgressWebView(Context context) {
        this(context, null);
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.progress_webview));
        mProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 3, 0, 0));
        addView(mProgressBar);

        initSetting();
    }

    private void initSetting() {

        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);

        // cache
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(APP_CACHE_MAX_SIXE);
        String appCacheDir = getContext().getDir("cache", Context.MODE_PRIVATE).getPath();
//        String appCacheDir = getContext().getCacheDir().getAbsolutePath();
        Logger.e("appCacheDir ==   = " + appCacheDir);
        Logger.e("getCacheDir.getAbsolutePath() == " + getContext().getCacheDir().getAbsolutePath());
        Logger.e("getContext().getDir(cache).getPath() == " + getContext().getDir("cache", Context.MODE_PRIVATE).getPath());
        settings.setAppCachePath(appCacheDir);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(LOAD_DEFAULT);

        settings.setDatabaseEnabled(true);
        String dbPath = getContext().getDir("database", Context.MODE_PRIVATE).getPath();
        Logger.e("dbPath = " + dbPath);
        settings.setDatabasePath(dbPath);

        setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setAlpha(1.0f);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Logger.d(" url =  " + url);
                view.loadUrl(url);
                return true;
            }
        });


        setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                currentProgress = mProgressBar.getProgress();
                if (newProgress >= 100 && !isAnimStart) {
                    // 防止调用多次动画
                    isAnimStart = true;
                    mProgressBar.setProgress(newProgress);
                    // 开启属性动画让进度条平滑消失
                    startDismissAnimation(mProgressBar.getProgress());
                } else {
                    // 开启属性动画让进度条平滑递增
                    startProgressAnimation(newProgress);
                }
            }

            @Override
            public void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater) {
                super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
                quotaUpdater.updateQuota(APP_CACHE_MAX_SIXE * 2);
            }
        });
    }


    /**
     * progressBar递增动画
     */
    private void startProgressAnimation(int newProgress) {
        ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", currentProgress, newProgress);
        if (Math.abs(currentProgress - newProgress) > 10) {
            animator.setDuration(500);
        } else {
            animator.setDuration(200);
        }
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    /**
     * progressBar消失动画
     */
    private void startDismissAnimation(final int progress) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mProgressBar, "alpha", 1.0f, 0.0f);
        anim.setDuration(1500);  // 动画时长
        anim.setInterpolator(new DecelerateInterpolator());     // 减速
        // 关键, 添加动画进度监听器
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction = valueAnimator.getAnimatedFraction();      // 0.0f ~ 1.0f
                int offset = 100 - progress;
                mProgressBar.setProgress((int) (progress + offset * fraction));
            }
        });

        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                // 动画结束
                mProgressBar.setProgress(0);
                mProgressBar.setVisibility(View.GONE);
                isAnimStart = false;
            }
        });
        anim.start();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && canGoBack()) {  // 返回键的KEYCODE
            goBack();
            return true;  // 拦截
        }
        return super.onKeyDown(keyCode, event);
    }
}