package com.radek.materialdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

/**
 * Created by Radek on 19.05.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static String mypassword = "ala";

    private EditText passwordEditText;
    private FloatingActionButton fab;
    private TextInputLayout passwordInputLayout;
    private  CoordinatorLayout coordinatorLayout;
    private Animation shake;

    private View.OnClickListener myFabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar.make(coordinatorLayout, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            startActivity(new Intent(getApplicationContext(), DetailActivity.class));
//            } else {
//            if (passwordEditText.getText().toString().equals(mypassword)) {
//                startActivity(new Intent(getApplicationContext(), DetailActivity.class));
//            } else {
//             ///   passwordEditText.setError("to nie to hasło");
//                passwordInputLayout.setError("to nie to haslo");
//            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        initView();
        setView();
        initToolbar();

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

    }

    private void initView() {
        passwordEditText = (EditText) findViewById(R.id.password);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.password_imput_layout);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);

    }

    private void setView() {
        fab.setOnClickListener(myFabListener);

    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
