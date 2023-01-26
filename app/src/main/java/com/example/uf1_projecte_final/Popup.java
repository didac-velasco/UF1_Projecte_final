package com.example.uf1_projecte_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;

public class Popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics mida = new DisplayMetrics(); //capturar mida pantalla
        getWindowManager().getDefaultDisplay().getMetrics(mida);

        int ample = mida.widthPixels;
        int altura = mida.heightPixels;

        //mides pop-up
        getWindow().setLayout((int) (ample*0.85), (int) (altura*0.5));

    }
}