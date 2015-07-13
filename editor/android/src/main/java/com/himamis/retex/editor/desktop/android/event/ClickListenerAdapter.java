package com.himamis.retex.editor.desktop.android.event;

import android.view.View;

import com.himamis.retex.editor.desktop.event.ClickListener;

public class ClickListenerAdapter implements View.OnClickListener {

    private ClickListener mClickListener;

    public ClickListenerAdapter(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        mClickListener.onClick();
    }
}
