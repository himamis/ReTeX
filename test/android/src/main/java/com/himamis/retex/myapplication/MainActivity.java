package com.himamis.retex.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.himamis.retex.editor.android.FormulaEditor;
import com.himamis.retex.renderer.android.FactoryProviderAndroid;
import com.himamis.retex.renderer.share.platform.FactoryProvider;


public class MainActivity extends ActionBarActivity {

    private FormulaEditor mFormulaEditor;
    private Button mPushButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mFormulaEditor = (FormulaEditor) findViewById(R.id.formula_editor);
        mPushButton = (Button) findViewById(R.id.push_button);
    }
}
