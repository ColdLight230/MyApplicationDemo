package com.hhly.myapplicationdemo.ui.android;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhly.data.bean.AndroidBean;
import com.hhly.myapplicationdemo.R;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/12/3
 */

public class AndroidAdapter extends BaseQuickAdapter<AndroidBean> {

    public AndroidAdapter(int layoutResId, List<AndroidBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AndroidBean androidBean) {
        baseViewHolder.setText(R.id.tv_title, androidBean.desc);
        baseViewHolder.setText(R.id.tv_date, androidBean.publishedAt);

        CardView cv_content = baseViewHolder.getView(R.id.cv_content);
        final int position = baseViewHolder.getPosition();
        cv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
