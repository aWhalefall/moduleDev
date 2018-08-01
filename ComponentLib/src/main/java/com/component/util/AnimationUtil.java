package com.component.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

import com.ftoutiao.component.R;

public class AnimationUtil {


    /**
     * 简单旋转动画
     *
     * @param view
     */
    public static void simpleRotateAnimator(View view, int angle, int duration) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, angle);
        rotateAnimation.setDuration(duration);
        view.startAnimation(rotateAnimation);
    }


    public static void counterClockWiseRotate(Context context, View imgArrowTop) {
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.anim_counter_clock_wise_rotate);
        operatingAnim.setFillAfter(true);
        if (imgArrowTop != null)
            imgArrowTop.startAnimation(operatingAnim);
    }

    public static void clockWiseRotate(Context context, View imgArrowTop) {
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.anim_clockwise_rotate);
        operatingAnim.setFillAfter(true);
        if (imgArrowTop != null)
            imgArrowTop.startAnimation(operatingAnim);
        imgArrowTop.clearAnimation();
    }

}
