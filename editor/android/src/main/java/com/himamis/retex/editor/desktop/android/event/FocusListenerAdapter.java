package com.himamis.retex.editor.desktop.android.event;

import android.view.View;

import com.himamis.retex.editor.desktop.event.FocusListener;

public class FocusListenerAdapter implements View.OnFocusChangeListener {

    private FocusListener mFocusListener;

    public FocusListenerAdapter(FocusListener focusListener) {
        mFocusListener = focusListener;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            mFocusListener.onFocusGained();
        } else {
            mFocusListener.onFocusLost();
        }
    }
}
