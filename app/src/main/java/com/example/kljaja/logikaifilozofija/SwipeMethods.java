package com.example.kljaja.logikaifilozofija;



class SwipeMethods {
    static int getNumberForPage() {
        int a=1;
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

        return a;
    }
    static int getMinimumNumber(){
        int a = 0;
        if ((MainActivity.izborPredmeta == 1)&&(MainActivity.izborStrane == 2)){
            a = 45;
        }

        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 2)){
            a = 28;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 3)){
            a = 57;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 4)){
            a = 86;
        }
        if ((MainActivity.izborPredmeta == 2)&&(MainActivity.izborStrane == 6)){
            a = 57;
        }
        if ((MainActivity.izborPredmeta == 3)&&(MainActivity.izborStrane == 2)){
            a = 46;
        }
        return a;
    }



}
