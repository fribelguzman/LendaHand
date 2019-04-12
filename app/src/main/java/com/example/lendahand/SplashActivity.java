package com.example.lendahand;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.lendahand.fragments.ItemViewFragment;
import com.felipecsl.gifimageview.library.GifImageView;
import com.squareup.picasso.Picasso;

public class SplashActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        gifImageView = findViewById(R.id.hands);


        Glide.with(this).load(R.raw.giphy).into(gifImageView);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

        };
        handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) ;
        handler.removeCallbacks(runnable);
    }
}
