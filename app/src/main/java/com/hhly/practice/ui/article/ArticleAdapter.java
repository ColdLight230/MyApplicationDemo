package com.hhly.practice.ui.article;

import android.support.v7.widget.CardView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhly.data.bean.AndroidBean;
import com.hhly.practice.R;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/12/3
 */

public class ArticleAdapter extends BaseQuickAdapter<AndroidBean> {
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ArticleAdapter(List<AndroidBean> data) {
        super(R.layout.item_android, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AndroidBean androidBean) {
        baseViewHolder.setText(R.id.tv_title, androidBean.desc);
        baseViewHolder.setText(R.id.tv_date, androidBean.publishedAt);

        CardView cv_content = baseViewHolder.getView(R.id.cv_content);
        int position = baseViewHolder.getAdapterPosition();
        RxView.clicks(cv_content).throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> onItemClickListener.onItemClick(position));
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
