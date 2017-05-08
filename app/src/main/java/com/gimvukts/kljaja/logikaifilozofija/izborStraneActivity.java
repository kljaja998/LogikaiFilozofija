package com.gimvukts.kljaja.logikaifilozofija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class izborStraneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izbor_strane);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button bttn1 = (Button) findViewById(R.id.bttn_trecaStrana);
        Button bttn2 = (Button) findViewById(R.id.bttn_cetvrtaStrana);
        Button bttn3 = (Button) findViewById(R.id.bttn_drugeDveStrane);
        Button bttn4 = (Button) findViewById(R.id.bttn_sveCetiriStrane);
        bttn1.setVisibility(View.GONE);
        bttn2.setVisibility(View.GONE);
        bttn3.setVisibility(View.GONE);
        bttn4.setVisibility(View.GONE);
        if (MainActivity.izborPredmeta == 2){
            bttn1.setVisibility(View.VISIBLE);
            bttn2.setVisibility(View.VISIBLE);
            bttn3.setVisibility(View.VISIBLE);
            bttn4.setVisibility(View.VISIBLE);
        }
    }
    public void bttn_prvaStrana_onClick (View v){
        MainActivity.izborStrane = 1;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_drugaStrana_onClick (View v){
        MainActivity.izborStrane = 2;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_trecaStrana_onClick (View v){
        MainActivity.izborStrane = 3;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_cetvrtaStrana_onClick (View v){
        MainActivity.izborStrane = 4;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_prveDveStrane_onClick (View v){
        MainActivity.izborStrane = 5;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_drugeDveStrane_onClick (View v){
        MainActivity.izborStrane = 6;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }
    public void bttn_sveCetiriStrane_onClick (View v){
        MainActivity.izborStrane = 7;
        Intent intent = new Intent(this, izborAktivnostiActivity.class);
        startActivity(intent);
    }


}
