package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Preguntes extends AppCompatActivity {
    int contadorPreguntes=1, errorsInt=0, encertsInt=0, idPregunta=0;

    private ArrayList<String> preguntesArray = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc1);

        //recuperem valors
        TextView preguntaa = findViewById(R.id.textViewPregunta);

        ImageButton btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);


        ImageButton btnanterior = (ImageButton) findViewById(R.id.btAnterior);

        //afegim preguntes a la llista
        preguntesArray.add("BUSQUEU AQUEST CARREU I SITUEU-LO AL PLÀNOL. (CAL RESPONDRE PER AVANÇAR");
        preguntesArray.add("Segons la imatge, on creieu que estava situat l’orgue anterior? Situeu-lo al plànol");
        preguntesArray.add("Observeu bé la imatge i responeu.");

        preguntaa.setText(preguntesArray.get(0));

        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorPreguntes--;
                idPregunta--;
                preguntaa.setText(preguntesArray.get(idPregunta));
            }
        });
        btnimageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==1){
                    idPregunta++;
                    preguntaa.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;


                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
        btnimageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==2){
                    idPregunta++;
                    preguntaa.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;


                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
        btnimageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==3){
                    idPregunta++;
                    preguntaa.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;


                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
        btnimageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==4){
                    idPregunta++;
                    preguntaa.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;


                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
        btnimageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==5){
                    idPregunta++;
                    preguntaa.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;


                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
        btnimageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==6){
                    idPregunta++;
                    contadorPreguntes++;

                    encertsInt++;
                    String num= encertsInt+""; //passem a String
                    encerts.setText(num);

                    Intent intent = new Intent( Preguntes.this, MainActivity.class); //crear intent
                    startActivity(intent); //executar intent
                } else {
                    errorsInt++;
                    String num= errorsInt+""; //passem a String
                    errors.setText(num);
                }
            }
        });
    }
}
