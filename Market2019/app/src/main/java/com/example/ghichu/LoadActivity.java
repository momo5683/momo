package com.example.ghichu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.DB.DB;
import com.example.market2019.R;

public class LoadActivity extends AppCompatActivity {


    private static int SPLASH_TIME = 2000; //This is 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (DB.getLoginInfo(LoadActivity.this) == null) {
                    Intent intent = new Intent(LoadActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(LoadActivity.this, GhichuActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }, SPLASH_TIME);
    }
}
