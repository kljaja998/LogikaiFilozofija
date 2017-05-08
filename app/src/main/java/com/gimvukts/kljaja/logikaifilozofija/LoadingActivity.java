package com.gimvukts.kljaja.logikaifilozofija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3000);  //Delay of 3 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(LoadingActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    //  overridePendingTransition(R.anim, R.anim.fade_in);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
