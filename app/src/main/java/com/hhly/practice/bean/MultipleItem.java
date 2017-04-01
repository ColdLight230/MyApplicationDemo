package com.hhly.practice.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/2
 */
public class MultipleItem implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int PICTURE = 2;
    public static final int VIDEO = 3;

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
