package com.hhly.myapplicationdemo.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hhly.myapplicationdemo.R;


/**
 * 描    述：NavigationView 里面每一条 item
 */
public class NavigationItem extends RelativeLayout {

    protected ImageView mIcon;
    protected TextView mTitle;
    protected TextView mAlert;
    protected ImageView mBadge;
    protected RelativeLayout mRlWhole;

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
        mRlWhole = (RelativeLayout) view.findViewById(R.id.rl_whole);

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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        if (heightMode == MeasureSpec.EXACTLY){
            ViewGroup.LayoutParams layoutParams = mRlWhole.getLayoutParams();
            layoutParams.height = heightSize;
            mRlWhole.setLayoutParams(layoutParams);
        }
    }
}
