package cz.natur.cuni.mirai.math.android.event;

import android.view.View;

import cz.natur.cuni.mirai.math.event.ClickListener;

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
