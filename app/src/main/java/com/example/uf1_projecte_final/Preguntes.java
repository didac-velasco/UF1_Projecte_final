package com.example.uf1_projecte_final;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Preguntes extends AppCompatActivity {
    int contadorPreguntes=0, errors=0, encerts=0;

    private ArrayList<String> preguntesArray = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc1);
        TextView pregunta = findViewById(R.id.textViewPregunta);
        //recuperem valors
        ImageButton btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        ImageView imatge = (ImageView) findViewById(R.id.imageView2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
       // ImageView imatge2 = (ImageView) findViewById(R.id.imageView3);

        Button btnsiguiente = findViewById(R.id.seguent);
        Button btnanterior = findViewById(R.id.anterior);

        //afegim preguntes a la llista
        preguntesArray.add("BUSQUEU AQUEST CARREU I SITUEU-LO AL PLÀNOL. (CAL RESPONDRE PER AVANÇAR");
        preguntesArray.add("Durant la visita haureu d’anar-vos fixant si hi ha recordatoris referents a la ciutat tal com hem vist a fora. Quantifiqueu-los i al final del recorregut trieu la resposta correcta.");

        pregunta.setText(preguntesArray.get(contadorPreguntes));

        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorPreguntes++;
                pregunta.setText(preguntesArray.get(contadorPreguntes));
                imatge.setBackgroundResource(R.drawable.aaaaa);

            }
        });
        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorPreguntes--;
                pregunta.setText(preguntesArray.get(contadorPreguntes));
            }
        });
        btnimageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encerts++;
            }
        });
    }
}
