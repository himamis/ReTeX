package com.himamis.retex.myapplication;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.himamis.retex.editor.android.FormulaEditor;
import com.himamis.retex.renderer.android.FactoryProviderAndroid;
import com.himamis.retex.renderer.share.platform.FactoryProvider;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
