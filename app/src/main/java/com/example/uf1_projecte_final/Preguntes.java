package com.example.uf1_projecte_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Preguntes extends AppCompatActivity {
    TextView pregunta, finalbuenas;
    ImageButton btnimageButton1, btnimageButton2, btnimageButton3, btnimageButton4, btnimageButton5, btnimageButton6;
    Button btnsiguiente, btnanterior;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc_p1);
        pregunta = findViewById(R.id.textViewPregunta);
        btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        btnsiguiente = findViewById(R.id.seguent);
        btnanterior = findViewById(R.id.anterior);

        pregunta.setText("BUSQUEU AQUEST CARREU I SITUEU-LO AL PLÀNOL. (CAL RESPONDRE PER AVANÇAR)");
    }
}
