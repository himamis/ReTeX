package com.himamis.retex.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import keyboard.ReTeXInput;
import keyboard.ReTeXInput_;

@EBean
public class MyListAdapter extends BaseAdapter {

    @RootContext
    Context mContext;

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReTeXInput reTeXInput;

        if (convertView == null) {
            reTeXInput = ReTeXInput_.build(mContext);
        } else {
            reTeXInput = (ReTeXInput) convertView;
        }
        return reTeXInput;
    }
}
