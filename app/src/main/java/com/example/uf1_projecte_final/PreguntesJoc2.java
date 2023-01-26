package com.example.uf1_projecte_final;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PreguntesJoc2 extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt;

    LinearLayout layoutradiobutton, layoutrelacio, layoutCaselles;

    String selec;

    Object rel1,rel2,rel3,rel4;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc2);

        bundle=getIntent().getExtras();
        erInt = bundle.getInt("errors");
        enInt = bundle.getInt("encerts");
        layoutradiobutton = (LinearLayout) findViewById(R.id.layoutRadioButtons);
        layoutrelacio = (LinearLayout) findViewById(R.id.layoutrelacionar);
        layoutCaselles = (LinearLayout) findViewById(R.id.layoutCheckbox);

        //enviar el menú desplegable Android a Java
        Spinner desp1=findViewById(R.id.spinner1);
        Spinner desp2=findViewById(R.id.spinner2);
        Spinner desp3=findViewById(R.id.spinner3);
        Spinner desp4=findViewById(R.id.spinner4);

        //MOSTRAR ELS ELEMENTS DECLARATS DE STRINGS.XML AL DESPLEGABLE
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.opcions_desple, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //AQUI DIEM QUIN LAYOUT VOLEM QUE ES VEIGI O NO
        layoutrelacio.setVisibility(View.INVISIBLE);
        layoutCaselles.setVisibility(View.INVISIBLE);

        TextView preguntaa = findViewById(R.id.textViewPregunta);

        RadioButton res1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton res2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton res3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton res4 = (RadioButton) findViewById(R.id.rb4);

        ImageButton Siguiente = (ImageButton) findViewById(R.id.imatgeButtonNext);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        encerts.setText(String.valueOf(enInt));
        errors.setText(String.valueOf(erInt));

        preguntaa.setText("OBSERVEU BÉ LA IMATGE I RESPONEU");
        res1.setText("ESTÀ ARRAN DE TERRA");
        res2.setText("ESTÀ SUSPÉS EN UNA BALCONADA");
        res3.setText("");
        res4.setText("");

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res2.isChecked()) {
                    enInt++;
                    encerts.setText(String.valueOf(enInt));

                    preguntaa.setText("QUINA ÉS LA RELACIÓ ENTRE EL DISSENY DE LA FAÇANA DEL NOU ORGUE I LA CIUTAT DE VALLS?");
                    res1.setText("ELS CALÇOTS I ELS CASTELLS");
                    res2.setText("ELS CASTELLS I EL CAMPANAR");
                    res3.setText("EL CAMPANAR I ELS GEGANTS");

                    if (res2.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        //AQUI DIEM QUIN LAYOUT VOLEM QUE ES VEIGI O NO
                        layoutradiobutton.setVisibility(View.INVISIBLE);
                        layoutCaselles.setVisibility(View.INVISIBLE);
                        layoutrelacio.setVisibility(View.VISIBLE);

                        preguntaa.setText("LLEGIU I RELACIONEU CADA TIPUS D’ORGUE AMB LA DEFINICIÓ QUE CREIEU QUE LI CORRESPON.");

                        desp1.setAdapter(adapter);
                        //AGAFEM LA POSICIÓ DE L'OPCÓ ESCOLLIDA DEL DESPLEGABLE AMB EL setOnItemSelectedListener
                        desp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            //S'HA TRIAT UNA OPCIÓ
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                //AGAFEM LA POSICIÓ
                                rel1 = parent.getItemAtPosition(position);
                            }
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        desp2.setAdapter(adapter);
                        desp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel2 = parent.getItemAtPosition(position);
                            }
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        desp3.setAdapter(adapter);
                        desp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel3 = parent.getItemAtPosition(position);
                            }
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        desp4.setAdapter(adapter);
                        desp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                rel4 = parent.getItemAtPosition(position);
                            }
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        //&& desp2.equals(3) && desp3.equals(1) && desp4.equals(4)
                        /*if(rel1.equals()){
                            enInt++;
                            encerts.setText(String.valueOf(enInt));

                            layoutCaselles.setVisibility(View.VISIBLE);
                            layoutradiobutton.setVisibility(View.INVISIBLE);
                            layoutrelacio.setVisibility(View.INVISIBLE);

                            preguntaa.setText("MIREU BÉ LA FAÇANA DE L’ORGUE I TRIEU DE TOTES AQUESTES PARTS LES QUE SÓN VISIBLES.");

                        }*/
                    }

                } else {
                    erInt++;
                    errors.setText(String.valueOf(erInt));
                }
            }
        });
    }
}