package com.hhly.practice;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hhly.data.bean.HistoryInfoBean;
import com.hhly.practice.bean.User;
import com.hhly.practice.databinding.ActivityMainBinding;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button mBtnAction;
    private List<User> userList;

    private String url = "http://o9xh2w3ir.bkt.clouddn.com/0824masaike.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String apiHostUrl = BuildConfig.API_HOST_URL;

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBtnAction = binding.btnAction;

        mBtnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PLMediaPlayerActivity.class);
                intent.putExtra("videoPath", url);
                startActivity(intent);
            }
        });


        App.get().getDataManager().getHistoryInfo(10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<HistoryInfoBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MainActivity", "onCompleted---");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<HistoryInfoBean> historyInfoBeans) {
                        Log.d("MainActivity", historyInfoBeans.size() + "---");
                    }
                });
    }
}
