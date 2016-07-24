package com.luka.jounery.justgo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.luka.jounery.justgo.base.BaseActivity;
import com.luka.jounery.justgo.R;
import com.luka.jounery.justgo.video.VideoActivity;
import com.luka.jounery.justgo.presenter.LoginPresenterCompl;

public class LoginActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ILoginView, View.OnClickListener {

    private EditText etUsernanme;
    private EditText etPassword;
    private ProgressBar progressBar;
    private LoginPresenterCompl loginPresenter;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(LoginActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        etUsernanme = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        findViewById(R.id.btLogin).setOnClickListener(this);
        findViewById(R.id.btClear).setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterCompl(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btClear:
                loginPresenter.clear();
                break;

            case R.id.btLogin:
                loginPresenter.setProgressBarVisibility(View.VISIBLE);
                loginPresenter.doLogin(etUsernanme.getText().toString(),etPassword.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        etUsernanme.setText("");
        etPassword.setText("");
    }

    @Override
    public void onLoginResult(boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.GONE);
        if(result){
            Snackbar.make(drawer,"Login Success",Snackbar.LENGTH_SHORT).show();
        }else{
            Snackbar.make(drawer,"Login Fail，code:"+code,Snackbar.LENGTH_SHORT).setAction("reInput", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.clear();
                }
            }).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
