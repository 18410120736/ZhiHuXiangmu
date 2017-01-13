package com.ch.zhihuxiangmu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.ch.zhihuxiangmu.ui.zhihu.activity.ZhuActivity;

/**
 * Created by 123 on 2017/1/5.
 */
public class Welcome{
    private static final int ANIM_TIME = 2000;
    private static final float SCALE_END = 1.15F;

    public static void startAnim(final MainActivity mainActivity, ImageView im) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(im, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(im, "scaleY", 1f, SCALE_END);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {
                Intent intent=new Intent(mainActivity,ZhuActivity.class);
                mainActivity.startActivity(intent);
                mainActivity.finish();
            }
        });

    }
}
