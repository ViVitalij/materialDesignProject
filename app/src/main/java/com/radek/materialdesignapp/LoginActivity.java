package com.radek.materialdesignapp;

import android.animation.Animator;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Radek on 19.05.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static String mypassword = "ala";
    @BindView(R.id.android)
    ImageView imageView;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText passwordEditText;
    @BindView(R.id.password_input_layout)
    TextInputLayout passwordInputLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

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
        ButterKnife.bind(this);
        initView();
        setView();
        initToolbar();

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//        imageView.startAnimation(shake);

    }

    private void initView() {
        passwordEditText = (EditText) findViewById(R.id.password);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.password_input_layout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        imageView = (ImageView) findViewById(R.id.android);

    }

    private void setView() {
        fab.setOnClickListener(myFabListener);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.clearAnimation();
            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight()) / 2;
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(imageView, (int) event.getX(), (int) event.getY(), 0, finalRadius);
                imageView.setVisibility(View.VISIBLE);
                anim.start();
                return false;
            }
        });


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
