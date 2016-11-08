package com.hhly.myapplicationdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.hhly.myapplicationdemo.databinding.ActivityRecyclerBinding;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
