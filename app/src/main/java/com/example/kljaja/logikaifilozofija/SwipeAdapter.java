package com.example.kljaja.logikaifilozofija;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kljaja on 01-Feb-17.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }
    static ArrayList<Integer> list = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        int maxPosition = getCount();
        switch(MainActivity.izborAktivnosti) {
            case 1:
                fragment = new ucenjeFragment();
                break;
            case 2:
                if(position == maxPosition-1)
                    {fragment = new vezbanjeKrajFragment();}
                    else {fragment = new vezbanjeFragment();}
                break;
            case 3:
                if(position == 4)
                {fragment = new vezbanjeKrajFragment();}
                else {fragment = new vezbanjeFragment();}
                break;
           
        }
        Bundle bundle = new Bundle();

        int minPosition = SwipeMethods.getMinimumNumber();

        int a;

        if(MainActivity.izborAktivnosti == 3){
            a = SwipeMethods.getNumberForPage();
            maxPosition = a;
        }

        maxPosition = maxPosition + minPosition;
        if (MainActivity.izborAktivnosti == 2){
            maxPosition--;
        }

        if (MainActivity.izborAktivnosti == 3 && MainActivity.novoOcenjivanje)
        {
            list.clear();
            for (int i=minPosition; i<maxPosition; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            MainActivity.novoOcenjivanje=false;
            MainActivity.stranaOcenjivanja = MainActivity.izborStrane;
        }




        if(MainActivity.izborAktivnosti == 3){
            position = list.get(position);
        }else {
            position = position + minPosition;
        }



        bundle.putInt("count",position);
        bundle.putInt("maxPosition",maxPosition);
        bundle.putInt("minPosition",minPosition);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        int a=1;
        if((MainActivity.izborAktivnosti==1)|| (MainActivity.izborAktivnosti ==2)){
            a = SwipeMethods.getNumberForPage();
        }

        if (MainActivity.izborAktivnosti == 2){
            a++;
        }

        if (MainActivity.izborAktivnosti == 3){
            a = 5;
        }

        return a;
    }



}
