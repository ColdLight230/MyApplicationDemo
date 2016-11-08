package com.hhly.myapplicationdemo.ui.picture;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.myapplicationdemo.R;
import com.hhly.myapplicationdemo.ui.picture.detail.MeiZhiDetailActivity;
import com.hhly.myapplicationdemo.utils.DisplayUtils;
import com.hhly.myapplicationdemo.utils.ImageLoader;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class MeiZhiAdapter extends BaseQuickAdapter<MeiZhiPictureBean> {

    private int imgWidth;

    public MeiZhiAdapter(int layoutResId, List<MeiZhiPictureBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        BaseViewHolder baseViewHolder = super.onCreateDefViewHolder(parent, viewType);
        ImageView view = baseViewHolder.getView(R.id.img_meizhi);

        int screenWidth = DisplayUtils.getScreenWidth(mContext);
        imgWidth = (screenWidth) / 3;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imgWidth, 16 * imgWidth / 9);
        view.setLayoutParams(layoutParams);
        return baseViewHolder;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final MeiZhiPictureBean meiZhiPictureBean) {
        ImageView imageView = baseViewHolder.getView(R.id.img_meizhi);
        ImageLoader.loadResize(mContext, meiZhiPictureBean.url, imgWidth, 16 * imgWidth / 9).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MeiZhiDetailActivity.class);
                intent.putExtra(MeiZhiDetailActivity.MEIZHIPICTURE, meiZhiPictureBean);
                mContext.startActivity(intent);
            }
        });
    }
}
