package com.ch.zhihuxiangmu;


import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ch.zhihuxiangmu.ui.zhihu.activity.ZhuActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private ImageView im;
    //private static final int ANIM_TIME = 2000;
    //private static final float SCALE_END = 1.15F;
    //我们操作的欢迎界面的图片
    private static final int Imgs=R.mipmap.splash_background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(getApplicationContext()).build());
        initview();
        rxjavatimer();
    }

    private void rxjavatimer() {
        Random random = new Random(SystemClock.elapsedRealtime());//SystemClock.elapsedRealtime() 从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
        im.setImageResource(Imgs);
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {
                    @Override
                    public void call(Long aLong)
                    {
                        //Intent intent=new Intent(MainActivity.this,ZhuActivity.class);
                        //startActivity(intent);
                        //finish();
                        Welcome.startAnim(MainActivity.this,im);
                    }
                });
    }

    private void initview() {
        im = (ImageView) findViewById(R.id.yindao_image);
    }

}
