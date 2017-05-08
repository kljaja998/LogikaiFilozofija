package com.gimvukts.kljaja.logikaifilozofija;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static byte izborPredmeta = 0;
    public static byte izborStrane = 0;
    public static byte izborAktivnosti = 0;
    public static byte vezbanjeBrojTacnihOdgovora = 0;
    //  public static Boolean[] stariFragment = new Boolean[113];
    public static Boolean[] odgovorenoNaPitanje = new Boolean[113];
    public static Boolean[] datTacanOdgovor = new Boolean[113];
    /*public static int[] vezbanjePrvoDugme = new int[113];
    public static int[] vezbanjeDrugoDugme = new int[113];
    public static int[] vezbanjeTreceDugme = new int[113];
    public static int[] vezbanjeCetvrtoDugme = new int[113];*/
    public static Boolean novoOcenjivanje = true;
    public static int stranaOcenjivanja = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

/**    public void button1_onClick(View v){
        TextView textview = (TextView)findViewById(R.id.textView);
        Random rand = new Random();
        int a = rand.nextInt(50) + 1;
        TypedArray citat = getResources().obtainTypedArray(R.array.citat);
        String b = citat.getString(a);
        textview.setText(b);
        citat.recycle();
    }       */

    public void bttn_logikaPojmovi_onClick (View v){
        izborPredmeta = 1;
        Intent intent = new Intent(this, izborStraneActivity.class);
        startActivity(intent);
    }
    public void bttn_filozofijaPojmovi_onClick (View v){
        izborPredmeta = 2;
        Intent intent = new Intent(this, izborStraneActivity.class);
        startActivity(intent);
    }
    public void bttn_filozofijaCitati_onClick (View v){
        izborPredmeta = 3;
        Intent intent = new Intent(this, izborStraneActivity.class);
        startActivity(intent);
    }




}
