package com.hhly.practice;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/1
 */
public class MyAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity> {


    public MyAdapter(List<MultiItemEntity> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {

    }
}
