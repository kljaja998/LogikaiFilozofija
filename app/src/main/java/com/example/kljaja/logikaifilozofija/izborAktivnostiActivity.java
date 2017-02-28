package com.example.kljaja.logikaifilozofija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class izborAktivnostiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izbor_aktivnosti);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bttn_izborAktivnosti_ucenje_onClick(View v){
        MainActivity.izborAktivnosti=1;
        Intent intent = new Intent(getApplicationContext(), ucenjeActivity.class);
        startActivity(intent);
    }
    public void bttn_izborAktivnosti_vezbanje_onClick(View v){
        MainActivity.izborAktivnosti=2;
        Intent intent = new Intent(getApplicationContext(), vezbanjeActivity.class);
        startActivity(intent);
    }
    public void bttn_izborAktivnosti_ocenjivanje_onClick(View v){
        MainActivity.izborAktivnosti=3;
        Intent intent = new Intent(getApplicationContext(),vezbanjeActivity.class);
        startActivity(intent);
    }
}
