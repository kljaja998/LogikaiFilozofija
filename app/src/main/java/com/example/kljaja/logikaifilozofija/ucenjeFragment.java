package com.example.kljaja.logikaifilozofija;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ucenjeFragment extends Fragment {
    TextView textView1;
    TextView textView2;

    public ucenjeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ucenje,container,false);
        textView1 = (TextView)view.findViewById(R.id.text_objasnjenje_citat_ucenje);
        textView2 = (TextView)view.findViewById(R.id.text_pojam_autor_ucenje);
        Bundle bundle = getArguments();
        int position = bundle.getInt("count");
        TypedArray citatObjasnjenje = null;
        TypedArray pojamAutor = null;
        switch (MainActivity.izborPredmeta){
            case 1: citatObjasnjenje = getResources().obtainTypedArray(R.array.logikaObjasnjenje);
                    break;
            case 2: citatObjasnjenje = getResources().obtainTypedArray(R.array.filozofijaObjasnjenje);
                    break;
            case 3: citatObjasnjenje = getResources().obtainTypedArray(R.array.citat);
                    break;
        }
        switch (MainActivity.izborPredmeta){
            case 1: pojamAutor = getResources().obtainTypedArray(R.array.logikaPojam);
                    break;
            case 2: pojamAutor = getResources().obtainTypedArray(R.array.filozofijaPojam);
                    break;
            case 3: pojamAutor = getResources().obtainTypedArray(R.array.autor);
                    break;
        }

        String objasnjenjeCitatString = citatObjasnjenje.getString(position);
        String pojamAutorString = pojamAutor.getString(position);
        citatObjasnjenje.recycle();
        pojamAutor.recycle();
        position++;
        textView1.setText(position+ ": " + objasnjenjeCitatString);
        textView2.setText(pojamAutorString);
        return view;
    }

}
