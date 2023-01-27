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
    int contadorPreguntes=1, errorsInt=0, encertsInt=0, idPregunta=0, cont_info=0;

    private ArrayList<String> preguntesArray = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc1);

        //RECUPEREM ELS VALOR DEL ELEMENTS DE LA PAG
        TextView omplirPregunta = findViewById(R.id.textViewPregunta);
        ImageView imatgee = findViewById(R.id.imageView2);

        ImageButton btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        EditText encerts = (EditText) findViewById(R.id.idTotalCorrectes);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        ImageView botoInfo = (ImageView) findViewById(R.id.botoInformacio);

        //DEFINIM IMATGE
        int orgueantic = R.drawable.orgueantic;

        //AFEGIM PREGUNTES AL ARRAYLIST
        preguntesArray.add("BUSQUEU AQUEST CARREU I SITUEU-LO AL PLÀNOL. (CAL RESPONDRE PER AVANÇAR");
        preguntesArray.add("SEGONS LA IMATGE, ON CREIEU QUE ESTAVA SITUAT L'ORGUE ANTERIOR? SITUEU-LO AL PLÀNOL");

        //LI DONEM EL VALOR DE LA POSICIO 0 A LA VARIABLE DE LA PREGUNTA
        omplirPregunta.setText(preguntesArray.get(0));

        //ACCIO A L'APRETAR EL BOTO D'INFORMACIÓ
        botoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INTENT QUE EXECUTARA EL POPUP AMB L'INFORMACIÓ
                Intent intent = new Intent( PreguntesJoc1.this, PopupInfo.class);
                //LI PASEM PER PARAMETRE QUINA INFORMACIÓ VOLEM VEURE
                intent.putExtra("posicio", 1);
                //S'EXECUTA INTENT
                startActivity(intent);
            }
        });

        //ACCIO A L'APRETAR IMATGEBUTTON1
        btnimageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MIREM QUE EL CONTADOR SIGI 1
                if(contadorPreguntes==1){
                    //SUMEM 1 ALS ENCERTS
                    encertsInt++;
                    //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                    encerts.setText(String.valueOf(encertsInt));

                    //POSEM LA IMATGE NOVA
                    imatgee.setImageDrawable(getResources().getDrawable(orgueantic));

                    //SUMEM 1 A LA VARIABLE DE PREGUNTES
                    idPregunta++;
                    //AGAFEM EL VALOR DE LA VARIABLE IDPREGUNTA I LA PASEM COM HA POSICIÓ PER AGAFAR EL VALOR DE LA POSICIÓ AL ARRAY DE PREGUNTES
                    omplirPregunta.setText(preguntesArray.get(idPregunta));
                    //SUMEM 1 AL CONTADOR DE PREGUNTES
                    contadorPreguntes++;
                } else {
                    //SUMEM 1 AL CONTADOR D'INCORRECTES
                    errorsInt++;
                    //ACTUALITZEM VARIABLE D'INCORRECTES I ES MOSTRA
                    errors.setText(String.valueOf(errorsInt));
                }
            }
        });
        btnimageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MIREM QUE EL CONTADOR SIGI 2
                if(contadorPreguntes==2){
                    //SUMEM 1 ALS ENCERTS
                    encertsInt++;
                    //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                    encerts.setText(String.valueOf(encertsInt));

                    //CREEM UN INTENT PER PASSAR A LA SEGÜENT PAG AMB ELS ALTRES TIPUS DE PREGUNTES
                    Intent intent = new Intent( PreguntesJoc1.this, PreguntesJoc2.class);
                    //PASEM LA VARIABLE D'ERRORS PER PODER-LA UTILITZAR A L'ALTRE CLASS
                    intent.putExtra("errors", errorsInt);
                    //PASEM LA VARIABLE D'ENCERTS PER PODER-LA UTILITZAR A L'ALTRE CLASS
                    intent.putExtra("encerts", encertsInt);
                    //EXECUTEM INTENT
                    startActivity(intent);
                } else {
                    //SUMEM 1 AL CONTADOR D'INCORRECTES
                    errorsInt++;
                    //ACTUALITZEM VARIABLE D'INCORRECTES I ES MOSTRA
                    errors.setText(String.valueOf(errorsInt));
                }
            }
        });

        //PER LA RESTA D'IMATGESBUTTONS, SI FEM CLICK ES SUMA 1 A LA VARIABLE D'ERRORS
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
