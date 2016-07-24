package com.luka.jounery.justgo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 */
public class BaseActivity extends AppCompatActivity {
    public BaseActivity mContext;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        mContext = this;
    }

    public void showSnackBar(View view, String snack) {
        Snackbar.make(view, snack, Snackbar.LENGTH_SHORT).show();
    }
}
