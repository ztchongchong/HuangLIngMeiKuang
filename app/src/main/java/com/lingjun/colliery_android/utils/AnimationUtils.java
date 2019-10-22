package com.lingjun.colliery_android.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by nefa on 2018/1/8.
 */

public class AnimationUtils {

    //从左往右移动
    public static void leftToRight(final View rootView, final View view, int offsetX, long duration ){
        ObjectAnimator oa = ObjectAnimator.ofFloat(rootView,"translationX",0,offsetX);
        oa.setDuration(duration);
        oa.start();
        oa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //从右往左移动
    public static void rightToLeft(final View rootView, final View view, int offsetX, long duration){
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(rootView,"translationX",offsetX,0);
        oa1.setDuration(duration);
        oa1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        oa1.start();

    }

    //从左往右移动
    public static void leftToRight_2(final View rootView, final View view, int offsetX, long duration ){
        ObjectAnimator oa = ObjectAnimator.ofFloat(rootView,"translationX",0,offsetX);
        oa.setDuration(duration);
        oa.start();
        oa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //从右往左移动
    public static void rightToLeft_2(final View rootView, final View view, int offsetX, long duration){
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(rootView,"translationX",offsetX,0);
        oa1.setDuration(duration);
        oa1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        oa1.start();

    }
}
