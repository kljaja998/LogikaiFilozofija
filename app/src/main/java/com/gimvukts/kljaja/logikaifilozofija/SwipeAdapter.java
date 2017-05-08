package com.gimvukts.kljaja.logikaifilozofija;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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



        int minPosition = 0;
        if ((MainActivity.izborPredmeta == 1)&&(MainActivity.izborStrane == 2)){
            minPosition = 45;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 2)){
            minPosition = 28;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 3)){
            minPosition = 57;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 4)){
            minPosition = 86;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 6)){
            minPosition = 57;
        }
        if ((MainActivity.izborPredmeta == 3)&&(MainActivity.izborStrane == 2)){
            minPosition = 46;
        }


        byte a = 0;

        if(MainActivity.izborAktivnosti == 3){
            switch (MainActivity.izborPredmeta){
                case 1:
                    switch (MainActivity.izborStrane){
                        case 1: a=45;
                            break;
                        case 2: a=40;
                            break;
                        case 5: a=85;
                            break;
                    }
                    break;

                case 2:
                    switch (MainActivity.izborStrane){
                        case 1: a=28;
                            break;
                        case 2: a=29;
                            break;
                        case 3: a=29;
                            break;
                        case 4: a=27;
                            break;
                        case 5: a=57;
                            break;
                        case 6: a=56;
                            break;
                        case 7: a=113;
                            break;
                    }
                    break;


                case 3:
                    switch (MainActivity.izborStrane){
                        case 1: a=46;
                            break;
                        case 2: a=42;
                            break;
                        case 5: a=88;
                            break;
                    }
                    break;


            }
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
            switch (MainActivity.izborPredmeta){
                case 1:
                    switch (MainActivity.izborStrane){
                        case 1: a=45;
                            break;
                        case 2: a=40;
                            break;
                        case 5: a=85;
                            break;
                    }
                    break;

                case 2:
                    switch (MainActivity.izborStrane){
                        case 1: a=28;
                            break;
                        case 2: a=29;
                            break;
                        case 3: a=29;
                            break;
                        case 4: a=27;
                            break;
                        case 5: a=57;
                            break;
                        case 6: a=56;
                            break;
                        case 7: a=113;
                            break;
                    }
                    break;


                case 3:
                    switch (MainActivity.izborStrane){
                        case 1: a=46;
                            break;
                        case 2: a=42;
                            break;
                        case 5: a=88;
                            break;
                    }
                    break;


            }
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
