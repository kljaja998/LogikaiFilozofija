package com.gimvukts.kljaja.logikaifilozofija;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class vezbanjeKrajFragment extends Fragment implements FragmentInterface{



    public vezbanjeKrajFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vezbanje_kraj, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textKrajVezbanja);


        // TextView debug = (TextView)view.findViewById(R.id.text_debug);
        /*TextView debug1 = (TextView)view.findViewById(R.id.textView2);
        TextView debug2 = (TextView)view.findViewById(R.id.textView3);
        TextView debug3 = (TextView)view.findViewById(R.id.textView5);*/


        Bundle bundle = getArguments();
        int maxPosition = bundle.getInt("maxPosition");
        int minPosition = bundle.getInt("minPosition");
        int maximumPoints = maxPosition - minPosition;
        if (MainActivity.izborAktivnosti == 3) {
            maximumPoints = 4;
        }
        textView.setText(MainActivity.vezbanjeBrojTacnihOdgovora + " / " + maximumPoints);


        /*debug1.setText("izbor strane: " + MainActivity.izborStrane);
        debug2.setText("izbor predmeta: " + MainActivity.izborPredmeta);
        debug3.setText("strana ocenjivanja: " + MainActivity.stranaOcenjivanja);*/

        // debug.setText("minPosition: "+minPosition + "  maxPosition: "+maxPosition);



        return view;
    }

    @Override
    public void fragmentBecameVisible() {
        // You can do your animation here because we are visible! (make sure onViewCreated has been called too and the Layout has been laid. Source for another question but you get the idea.

        Bundle bundle = getArguments();
        TextView textView = (TextView) getView().findViewById(R.id.textKrajVezbanja);

        int maxPosition = bundle.getInt("maxPosition");
        int minPosition = bundle.getInt("minPosition");
        int maximumPoints = maxPosition - minPosition;
        if (MainActivity.izborAktivnosti == 3) {
            maximumPoints = 4;
        }

        textView.setText(MainActivity.vezbanjeBrojTacnihOdgovora + " / " + maximumPoints);

    }




}

