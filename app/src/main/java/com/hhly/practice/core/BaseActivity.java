package com.hhly.practice.core;

import android.support.v7.app.AppCompatActivity;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/14
 */
public class BaseActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags =
//                    (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                            |localLayoutParams.flags);
//        }
//        super.onCreate(savedInstanceState);
//
//    }
}
