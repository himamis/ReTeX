package com.himamis.retex.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import keyboard.HasKeyboard;
import keyboard.Keyboard;
import keyboard.gwt.MathKeyboardView;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity implements HasKeyboard {

    @ViewById(R.id.root_panel)
    protected ViewGroup mRootPanel;

    @Bean
    MyListAdapter myListAdapter;

    private MathKeyboardView mMathKeyboardView;

    @AfterViews
    void setupKeyboard() {
        mMathKeyboardView = new MathKeyboardView(this, null);
        RelativeLayout.LayoutParams relayoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                Math.round(186 * getResources().getDisplayMetrics().density)
        );
        relayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        mMathKeyboardView.setLayoutParams(relayoutParams);
        mRootPanel.addView(mMathKeyboardView);
        mMathKeyboardView.setVisibility(View.GONE);
    }

    @Override
    public void showKeyboard() {
        if (mMathKeyboardView.getVisibility() != View.VISIBLE) {
            mMathKeyboardView.animate().alpha(1f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    mMathKeyboardView.setVisibility(View.VISIBLE);
                }
            }).start();
        }
    }

    @Override
    public void hideKeyboard() {
        if (mMathKeyboardView.getVisibility() == View.VISIBLE) {
            mMathKeyboardView.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mMathKeyboardView.setVisibility(View.GONE);
                }
            }).start();
        }
    }

    @Override
    public Keyboard getKeyboard() {
        return mMathKeyboardView;
    }

    @Override
    public void onBackPressed() {
        if (mMathKeyboardView.getVisibility() == View.VISIBLE) {
            hideKeyboard();
        } else {
            super.onBackPressed();
        }
    }
}
