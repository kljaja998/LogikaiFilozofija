package com.gimvukts.kljaja.logikaifilozofija;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class vezbanjeFragment extends Fragment implements FragmentInterface {
    byte correctButton = 0;
    String pojamAutorString = null;

    public vezbanjeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vezbanje, container, false);
        Bundle bundle = getArguments();
        final int position = bundle.getInt("count");
        int minPosition = bundle.getInt("minPosition");
        int maxPosition = bundle.getInt("maxPosition");




        final TextView text_objasnjenjeCitat = (TextView) view.findViewById(R.id.text_vezbanje_objasnjenjeCitat);
        final TextView text_rezultat = (TextView) view.findViewById(R.id.text_vezbanje_rezultat);

        final Button bttn1 = (Button) view.findViewById(R.id.bttn_vezbanje_opcija1);
        final Button bttn2 = (Button) view.findViewById(R.id.bttn_vezbanje_opcija2);
        final Button bttn3 = (Button) view.findViewById(R.id.bttn_vezbanje_opcija3);
        final Button bttn4 = (Button) view.findViewById(R.id.bttn_vezbanje_opcija4);


        // Gets array from resources containing quote/explanation
        TypedArray citatObjasnjenje = null;
        switch (MainActivity.izborPredmeta){
            case 1: citatObjasnjenje = getResources().obtainTypedArray(R.array.logikaObjasnjenje);
                break;
            case 2: citatObjasnjenje = getResources().obtainTypedArray(R.array.filozofijaObjasnjenje);
                break;
            case 3: citatObjasnjenje = getResources().obtainTypedArray(R.array.citat);
                break;
        }

        // Gets array from resources containing quote Author/term

        TypedArray pojamAutor = null;
        switch (MainActivity.izborPredmeta){
            case 1: pojamAutor = getResources().obtainTypedArray(R.array.logikaPojam);
                break;
            case 2: pojamAutor = getResources().obtainTypedArray(R.array.filozofijaPojam);
                break;
            case 3: pojamAutor = getResources().obtainTypedArray(R.array.autor);
                break;
        }

        //Sets the text for the quote/explanation

        String citatObjasnjenjeString = citatObjasnjenje.getString(position);
        citatObjasnjenje.recycle();
        text_objasnjenjeCitat.setText(citatObjasnjenjeString);

        //
        pojamAutorString = pojamAutor.getString(position);


        ArrayList<String> odgovori = new ArrayList<>();
        odgovori.add(0,pojamAutorString);

        ArrayList<Integer> netacniOdgovori = new ArrayList<>();
        for (int i=minPosition;i<position;i++){
            if (MainActivity.izborPredmeta == 3){
                if (i>0) {
                    if ((pojamAutor.getString(i) != pojamAutor.getString(i - 1)) && (pojamAutor.getString(i) != pojamAutorString)) {
                        netacniOdgovori.add(new Integer(i));
                    }
                }
            } else {
            netacniOdgovori.add(new Integer(i));
            }

        }
        for (int i = position + 1; i<maxPosition; i++){
            if (MainActivity.izborPredmeta == 3){
                if (i>0){
                    if ((pojamAutor.getString(i) != pojamAutor.getString(i-1)) && (pojamAutor.getString(i) != pojamAutorString)){
                        netacniOdgovori.add(new Integer(i));
                    }
                }
            } else {
                netacniOdgovori.add(new Integer(i));
            }

        }
        Collections.shuffle(netacniOdgovori);
        for (int i=1;i<4;i++){
            int a = netacniOdgovori.get(i);
            String b = pojamAutor.getString(a);
            odgovori.add(new String(b));

        }
        Collections.shuffle(odgovori);

        bttn1.setText(odgovori.get(0));
        if(odgovori.get(0) == pojamAutorString){
            correctButton = 0;
        }
        bttn2.setText(odgovori.get(1));
        if(odgovori.get(1) == pojamAutorString){
            correctButton = 1;
        }
        bttn3.setText(odgovori.get(2));
        if(odgovori.get(2) == pojamAutorString){
            correctButton = 2;
        }
        bttn4.setText(odgovori.get(3));
        if(odgovori.get(3) == pojamAutorString){
            correctButton = 3;
        }



        if (MainActivity.odgovorenoNaPitanje[position]){
            bttn1.setEnabled(false);
            bttn2.setEnabled(false);
            bttn3.setEnabled(false);
            bttn4.setEnabled(false);
            if (MainActivity.datTacanOdgovor[position]){
                text_rezultat.setText("Tačan odgovor");
            } else {
                text_rezultat.setText("Netačan odgovor. Tačan odgovor je: " + pojamAutorString);
            }
        }

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn1.setEnabled(false);
                bttn2.setEnabled(false);
                bttn3.setEnabled(false);
                bttn4.setEnabled(false);
                if (correctButton == 0){
                    text_rezultat.setText("Tačan odgovor");
                    MainActivity.vezbanjeBrojTacnihOdgovora++;
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = true;
                } else{
                    text_rezultat.setText("Netačan odgovor. Tačan odgovor je: " + pojamAutorString);
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = false;
                }
            }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn1.setEnabled(false);
                bttn2.setEnabled(false);
                bttn3.setEnabled(false);
                bttn4.setEnabled(false);
                if (correctButton == 1){
                    text_rezultat.setText("Tačan odgovor");
                    MainActivity.vezbanjeBrojTacnihOdgovora++;
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = true;
                } else{
                    text_rezultat.setText("Netačan odgovor. Tačan odgovor je: " + pojamAutorString);
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = false;
                }

            }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn1.setEnabled(false);
                bttn2.setEnabled(false);
                bttn3.setEnabled(false);
                bttn4.setEnabled(false);
                if (correctButton == 2){
                    text_rezultat.setText("Tačan odgovor");
                    MainActivity.vezbanjeBrojTacnihOdgovora++;
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = true;
                } else{
                    text_rezultat.setText("Netačan odgovor. Tačan odgovor je: " + pojamAutorString);
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = false;
                }
            }
        });
        bttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttn1.setEnabled(false);
                bttn2.setEnabled(false);
                bttn3.setEnabled(false);
                bttn4.setEnabled(false);
                if (correctButton == 3){
                    text_rezultat.setText("Tačan odgovor");
                    MainActivity.vezbanjeBrojTacnihOdgovora++;
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = true;
                } else{
                    text_rezultat.setText("Netačan odgovor. Tačan odgovor je: " + pojamAutorString);
                    MainActivity.odgovorenoNaPitanje[position] = true;
                    MainActivity.datTacanOdgovor[position] = false;
                }
            }
        });















        return view;
    }

    @Override
    public void fragmentBecameVisible() {
        // You can do your animation here because we are visible! (make sure onViewCreated has been called too and the Layout has been laid. Source for another question but you get the idea.


    }

}
