package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PreguntesJoc1 extends AppCompatActivity {
    int contadorPreguntes=1, errorsInt=0, encertsInt=0, idPregunta=0;

    private ArrayList<String> preguntesArray = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc1);

        //recuperem valors
        TextView omplirPregunta = findViewById(R.id.textViewPregunta);
        ImageView imatgee = findViewById(R.id.imageView2);


        ImageButton btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        ImageButton btnanterior = (ImageButton) findViewById(R.id.btAnterior);

        ImageView botoInfo = (ImageView) findViewById(R.id.botoInformacio);

        //afegim preguntes a la llista
        preguntesArray.add("BUSQUEU AQUEST CARREU I SITUEU-LO AL PLÀNOL. (CAL RESPONDRE PER AVANÇAR");
        preguntesArray.add("SEGONS LA IMATGE, ON CREIEU QUE ESTAVA SITUAT L'ORGUE ANTERIOR? SITUEU-LO AL PLÀNOL");

        omplirPregunta.setText(preguntesArray.get(0));

        botoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( PreguntesJoc1.this, PopupInfo.class); //crear intent
                startActivity(intent); //executar intent
            }
        });

        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idPregunta>0){
                    contadorPreguntes--;
                    idPregunta--;
                    encertsInt--;
                    omplirPregunta.setText(preguntesArray.get(idPregunta));
                } else {
                    encertsInt=0;
                    Toast.makeText(getApplicationContext(), "No hi han més preguntes!", Toast.LENGTH_SHORT).show();
                }
                encerts.setText(String.valueOf(encertsInt));
            }
        });
        btnimageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==1){
                    encertsInt++;
                    encerts.setText(String.valueOf(encertsInt));

                    //posar imatge nova
                    int aaaaa = R.drawable.aaaaa;
                    imatgee.setImageDrawable(getResources().getDrawable(aaaaa));

                    idPregunta++;
                    omplirPregunta.setText(preguntesArray.get(idPregunta));
                    contadorPreguntes++;
                } else {
                    errorsInt++;
                    errors.setText(String.valueOf(errorsInt));
                }
            }
        });
        btnimageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPreguntes==2){
                    encertsInt++;
                    encerts.setText(String.valueOf(encertsInt));

                    Intent intent = new Intent( PreguntesJoc1.this, PreguntesJoc2.class); //crear intent
                    intent.putExtra("errors", errorsInt);
                    intent.putExtra("encerts", encertsInt);
                    startActivity(intent); //executar intent
                } else {
                    errorsInt++;
                    errors.setText(String.valueOf(errorsInt));
                }
            }
        });
        btnimageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorsInt++;
                errors.setText(String.valueOf(errorsInt));
            }
        });
        btnimageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorsInt++;
                errors.setText(String.valueOf(errorsInt));
            }
        });
        btnimageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorsInt++;
                errors.setText(String.valueOf(errorsInt));
            }
        });
        btnimageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorsInt++;
                errors.setText(String.valueOf(errorsInt));
            }
        });
    }
}
