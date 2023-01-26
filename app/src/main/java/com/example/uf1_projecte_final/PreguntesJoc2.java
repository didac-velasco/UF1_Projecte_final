package com.example.uf1_projecte_final;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PreguntesJoc2 extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt;

    LinearLayout layoutradiobutton, layoutrelacio, layoutCaselles;

    int contador = 0;

    boolean totes = false;
    boolean precerta = false;
    Object rel1, rel2, rel3, rel4;

    Boolean Preguntes_RadioButton1_3 = true;
    Boolean Preguntes_Spinner = false;
    Boolean Preguntes_CheckBox = false;
    Boolean Preguntes_RadioButton2_4 = false;
    Boolean Preguntes_RadioButton3_3 = false;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc2);

        bundle = getIntent().getExtras();
        erInt = bundle.getInt("errors");
        enInt = bundle.getInt("encerts");
        layoutradiobutton = (LinearLayout) findViewById(R.id.layoutRadioButtons);
        layoutrelacio = (LinearLayout) findViewById(R.id.layoutrelacionar);
        layoutCaselles = (LinearLayout) findViewById(R.id.layoutCheckbox);

        //enviar el menú desplegable Android a Java
        Spinner desp1 = findViewById(R.id.spinner1);
        Spinner desp2 = findViewById(R.id.spinner2);
        Spinner desp3 = findViewById(R.id.spinner3);
        Spinner desp4 = findViewById(R.id.spinner4);

        //MOSTRAR ELS ELEMENTS DECLARATS DE STRINGS.XML AL DESPLEGABLE
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcions_desple, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //AQUI DIEM QUIN LAYOUT VOLEM QUE ES VEIGI O NO
        layoutradiobutton.setVisibility(View.VISIBLE);
        layoutrelacio.setVisibility(View.INVISIBLE);
        layoutCaselles.setVisibility(View.INVISIBLE);

        TextView preguntaa = findViewById(R.id.textViewPregunta);

        RadioGroup grup=(RadioGroup) findViewById(R.id.radiogroup);

        RadioButton res1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton res2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton res3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton res4 = (RadioButton) findViewById(R.id.rb4);

        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox cb6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox cb7 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox cb9 = (CheckBox) findViewById(R.id.checkBox9);

        ImageButton Siguiente = (ImageButton) findViewById(R.id.imatgeButtonNext);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        encerts.setText(String.valueOf(enInt));
        errors.setText(String.valueOf(erInt));



        preguntaa.setText("OBSERVEU BÉ LA IMATGE I RESPONEU");
        res1.setText("ESTÀ ARRAN DE TERRA");
        res2.setText("ESTÀ SUSPÉS EN UNA BALCONADA");
        res3.setVisibility(View.INVISIBLE);
        res4.setVisibility(View.INVISIBLE);

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preguntes_RadioButton1_3==true){
                    if (res2.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        res3.setVisibility(View.VISIBLE);
                        preguntaa.setText("QUINA ÉS LA RELACIÓ ENTRE EL DISSENY DE LA FAÇANA DEL NOU ORGUE I LA CIUTAT DE VALLS?");
                        res1.setText("ELS CALÇOTS I ELS CASTELLS");
                        res2.setText("ELS CASTELLS I EL CAMPANAR");
                        res3.setText("EL CAMPANAR I ELS GEGATS");
                        Preguntes_RadioButton1_3 = false;
                        Preguntes_Spinner = true;
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_Spinner==true) {
                    if (res2.isChecked()) {
                        //AQUI DIEM QUIN LAYOUT VOLEM QUE ES VEIGI O NO
                        layoutradiobutton.setVisibility(View.INVISIBLE);
                        layoutCaselles.setVisibility(View.INVISIBLE);
                        layoutrelacio.setVisibility(View.VISIBLE);

                        preguntaa.setText("LLEGIU I RELACIONEU CADA TIPUS D’ORGUE AMB LA DEFINICIÓ QUE CREIEU QUE LI CORRESPON.");

                        desp1.setAdapter(adapter);
                        desp2.setAdapter(adapter);
                        desp3.setAdapter(adapter);
                        desp4.setAdapter(adapter);
                        //AGAFEM LA POSICIÓ DE L'OPCÓ ESCOLLIDA DEL DESPLEGABLE AMB EL setOnItemSelectedListener
                        desp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            //S'HA TRIAT UNA OPCIÓ
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                //AGAFEM LA POSICIÓ
                                rel1 = parent.getItemAtPosition(position);
                                if (rel1.toString().equals("B- ES PORTA A SOBRE MENTRE E TOCA")) {
                                    contador = contador + 1;
                                }
                            }
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        desp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel2 = parent.getItemAtPosition(position);
                                if (rel2.toString().equals("C- ES POT POSAR A DIFERENTS LLOCS")) {
                                    contador = contador + 1;
                                }
                            }

                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        desp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel3 = parent.getItemAtPosition(position);
                                if (rel3.toString().equals("A- TÉ NOMÉS UN TECLAT PERÒ JA TÉ DIMENSIONS CONSIDERABLES")) {
                                    contador = contador + 1;
                                }
                            }

                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        desp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel4 = parent.getItemAtPosition(position);
                                if (rel4.toString().equals("D- TÉ MILERS DE TUBS I NECESSITA UN ESPAI GRAN PER A POSAR-LO")) {
                                    contador = contador + 1;
                                }
                            }

                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                    if (contador == 4) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        Preguntes_Spinner=false;
                        Preguntes_CheckBox=true;
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_CheckBox==true){
                    layoutCaselles.setVisibility(View.INVISIBLE);
                    layoutradiobutton.setVisibility(View.VISIBLE);
                    layoutrelacio.setVisibility(View.INVISIBLE);

                    preguntaa.setText("MIREU BÉ LA FAÇANA DE L’ORGUE I TRIEU DE TOTES AQUESTES PARTS LES QUE SÓN VISIBLES.");

                    if (cb3.isChecked() && cb5.isChecked() && cb6.isChecked() && cb7.isChecked() && cb9.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        Preguntes_CheckBox=false;
                        Preguntes_RadioButton2_4=true;
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_RadioButton2_4==true) {
                    preguntaa.setText("QUINA ÉS LA DIFERÈNCIA ENTRE ORGUENER I ORGANISTA?");
                    res1.setText("NO HI HA CAP DIFERÈNCIA, ÉS EL MATEIX.");
                    res2.setText("L’ORGUENER CONSTRUEIX I L’ORGANISTA TOCA.");
                    res3.setVisibility(View.VISIBLE);
                    res3.setText("L’ORGANISTA CONSTRUEIX I L’ORGUENER TOCA.");
                    res4.setVisibility(View.VISIBLE);
                    res4.setText("L’ORGUENER TOCA MOLT I L’ORGANISTA NO TOCA GAIRE.");

                    if (res2.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        Preguntes_RadioButton2_4=false;
                        Preguntes_RadioButton3_3=true;
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_RadioButton3_3=true){
                    preguntaa.setText("HEU RECORDAT DE COMPTAR ELS ESCUTS DE LA CIUTAT? QUANTS ESCUTS DE LA CIUTAT HAS POGUT COMPTABILITZAR AL LLARG DE LA VISITA?");
                    res1.setText("ENTRE 10 I 20");
                    res2.setText("ENTRE 21 I 40");
                    res3.setText("MÉS DE 40");
                    res4.setVisibility(View.INVISIBLE);

                    if (res3.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        Preguntes_RadioButton3_3=false;
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                }
            }
        });
    }
}