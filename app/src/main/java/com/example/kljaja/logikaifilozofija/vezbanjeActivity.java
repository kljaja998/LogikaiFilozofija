package com.example.kljaja.logikaifilozofija;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class vezbanjeActivity extends FragmentActivity {

    ViewPager viewPager;
    SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vezbanje);

        viewPager = (ViewPager)findViewById(R.id.view_pager_vezbanje);

        viewPager.setAdapter(swipeAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int i, final float v, final int i2) {
            }
            @Override
            public void onPageSelected(final int i) {
                FragmentInterface fragment = (FragmentInterface) swipeAdapter.instantiateItem(viewPager, i);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }
            }
            @Override
            public void onPageScrollStateChanged(final int i) {
            }
        });

        MainActivity.vezbanjeBrojTacnihOdgovora = 0;
        for (int i=0;i<113;i++){
            MainActivity.odgovorenoNaPitanje[i]=false;
            MainActivity.datTacanOdgovor[i]=false;
        }
        if (MainActivity.izborAktivnosti ==3){
            MainActivity.novoOcenjivanje= true;
        }

    }
}


