package com.hhly.myapplicationdemo.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hhly.myapplicationdemo.R;


/**
 * 描    述：NavigationView 里面每一条 item
 * 作    者：longs@13322.com
 * 时    间：2016/9/1
 */
public class NavigationItem extends RelativeLayout {

    protected ImageView mIcon;
    protected TextView mTitle;
    protected TextView mAlert;
    protected ImageView mBadge;

    public NavigationItem(Context context) {
        this(context, null);
    }

    public NavigationItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, R.layout.view_navigation_item, this);
        mIcon = (ImageView) view.findViewById(R.id.icon);
        mTitle = (TextView) view.findViewById(R.id.title);
        mAlert = (TextView) view.findViewById(R.id.alert_num);
        mBadge = (ImageView) view.findViewById(R.id.alert);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationItem);

        int iconSrc = typedArray.getResourceId(R.styleable.NavigationItem_nav_item_icon_src, R.drawable.ic_picture);
        String title = typedArray.getString(R.styleable.NavigationItem_nav_item_title);

        typedArray.recycle();

        mIcon.setImageDrawable(ContextCompat.getDrawable(context, iconSrc));
        mTitle.setText(title);
    }

    public String getTitle(){
        return mTitle.getText().toString().trim();
    }
}
