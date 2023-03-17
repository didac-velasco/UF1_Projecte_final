package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class PreguntesJoc extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt;
    int contador = 0, contadorInfo=2, contadorPreguntes=1;

    boolean totes = false, precerta = false;
    Object rel1, rel2, rel3, rel4;
    Boolean Preguntes_ImatgeBotons = true, Preguntes_RadioButton4_2 = false, Preguntes_RadioButton3_3 = false,
            Preguntes_RadioButton1_3 = false, Preguntes_Spinner = false, Preguntes_RadioButton2_4 = false,
            Preguntes_CheckBox = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc);

        //RECUPEREM ELS VALOR DEL ELEMENTS DE LA PAG
        LinearLayout layoutradiobutton = (LinearLayout) findViewById(R.id.layoutRadioButtons);
        LinearLayout layoutrelacio = (LinearLayout) findViewById(R.id.layoutrelacionar);
        LinearLayout  layoutCaselles = (LinearLayout) findViewById(R.id.layoutCheckbox);
        LinearLayout layoutImg = (LinearLayout) findViewById(R.id.layoutImtgesBotons);

        //PASEM ELS SPINNER DE ANDROID A JAVA
        Spinner desp1 = findViewById(R.id.spinner1);
        Spinner desp2 = findViewById(R.id.spinner2);
        Spinner desp3 = findViewById(R.id.spinner3);
        Spinner desp4 = findViewById(R.id.spinner4);

        //OMPLIM EL DESPLEGABLE AMB ELS VAROLS DEFINITS A values/strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcions_desple, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //AQUI DIEM QUIN LAYOUT VOLEM QUE ES VEIGI O NO
        layoutImg.setVisibility(View.VISIBLE);
        layoutradiobutton.setVisibility(View.INVISIBLE);
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

        //preguntes dels botons, recuperem botons
        ImageButton btnimageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton btnimageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnimageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnimageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnimageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton btnimageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        ImageButton Siguiente = (ImageButton) findViewById(R.id.imatgeButtonNext);

        ImageView botoInfo = (ImageView) findViewById(R.id.idInfo);

        //DEFINIM IMATGES QUE NECESSITEM
        ImageView imatge = findViewById(R.id.imatgePregunta);
        int orgueantic = R.drawable.orgueantic;
        int orgue = R.drawable.img_orgue3;
        int tiposorgue = R.drawable.tiposorgue;
        int partsorgue = R.drawable.partsorgue;
        int teclat = R.drawable.teclat;
        int escuts = R.drawable.escuts;

        EditText encerts = (EditText) findViewById(R.id.idTotalCorrectes);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        encerts.setText(String.valueOf(enInt));
        errors.setText(String.valueOf(erInt));

        //ACCIO A L'APRETAR EL BOTO D'INFORMACIÓ
        botoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INTENT QUE EXECUTARA EL POPUP AMB L'INFORMACIÓ
                Intent intent = new Intent( PreguntesJoc.this, PopupInfo.class);
                //LI PASEM PER PARAMETRE QUINA INFORMACIÓ VOLEM VEURE
                intent.putExtra("posicio", contadorInfo);
                startActivity(intent); //INICIEM INTENT
            }
        });

        //ACCIO A L'APRETAR EL BOTO SEGÜENT
        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preguntes_RadioButton4_2==true){
                    //COMPROVEM QUE EL RADIOBUTTON2 ES L'OPCIÓ MARCADA
                    if (res2.isChecked()) {
                        contadorInfo=3;
                        enInt++;
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        encerts.setText(String.valueOf(enInt));

                        //CAMBIEM ELS VALORS DEL BOLEANS
                        Preguntes_RadioButton1_3 = true;
                        Preguntes_RadioButton4_2 = false;

                        //FEM VISIBLE 1 DELS RADIOSBUTTONS OCULTATS
                        res3.setVisibility(View.VISIBLE);
                        //LI PASEM LA NOVA PREGUNTA QUE HA DE MOSTRAR
                        preguntaa.setText("Aneu davant de l'orgue nou i obriu la informació. \n QUINA ÉS LA RELACIÓ ENTRE EL DISSENY DE LA FAÇANA DEL NOU ORGUE I LA CIUTAT DE VALLS?");
                        //LI PASEM LES NOVES RESPOSTES
                        res1.setText("ELS CALÇOTS I ELS CASTELLS");
                        res2.setText("ELS CASTELLS I EL CAMPANAR");
                        res3.setText("EL CAMPANAR I ELS GEGATS");
                        //POSEM UNA IMATGE NOVA
                        imatge.setImageDrawable(getResources().getDrawable(orgue));

                    } else {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                    //COMPROVEM EL BOLEA
                } else if (Preguntes_RadioButton1_3==true){
                    //COMPROVEM QUE EL SEGON RADIOBUTTON ES L'OPCIÓ MARCADA
                    if (res2.isChecked()) {
                        contadorInfo=4;
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        //CAMBIEM ELS VALORS DEL BOLEANS
                        Preguntes_RadioButton1_3 = false;
                        Preguntes_Spinner = true;

                        //FEM CANVI DE LAYOUT DIEM QUIN VOLEM VEURE I QUIN NO
                        layoutradiobutton.setVisibility(View.INVISIBLE);
                        layoutCaselles.setVisibility(View.INVISIBLE);
                        layoutrelacio.setVisibility(View.VISIBLE);

                        //LI PASEM LA NOVA PREGUNTA QUE HA DE MOSTRAR
                        preguntaa.setText("Obriu la informació. \n LLEGIU I RELACIONEU CADA TIPUS D’ORGUE AMB LA DEFINICIÓ QUE CREIEU QUE LI CORRESPON.");
                        //POSEM UNA NOVA IMATGE
                        imatge.setImageDrawable(getResources().getDrawable(tiposorgue));

                        //CANVIAR IMATGE BOTO SEGÜENT
                        Siguiente.setImageResource(R.drawable.opcions);
                    } else {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                    //COMPROVEM EL BOLEA
                } else if (Preguntes_Spinner==true) {
                    //TORNEM A POSAR EL BOTO PER PASAR DE PREGUNTA
                    Siguiente.setImageResource(R.drawable.next);
                    //MOSTREM ELS SPINNERS
                    desp1.setAdapter(adapter);
                    desp2.setAdapter(adapter);
                    desp3.setAdapter(adapter);
                    desp4.setAdapter(adapter);
                    erInt=erInt-4;
                    errors.setText(String.valueOf(erInt));

                    //AGAFEM LA POSICIÓ DE L'OPCÓ ESCOLLIDA DEL DESPLEGABLE AMB EL setOnItemSelectedListener
                    desp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        //S'HA TRIAT UNA OPCIÓ
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            //AGAFEM EL VALOR TRIAT DINS D'UN OBJECTE
                            rel1 = parent.getItemAtPosition(position);
                            //COMPROVEM QUE L'OBJECTE SIGUI IGUAL QUE L'OPCIO CORRECTA
                            if (rel1.toString().equals("B- ES PORTA A SOBRE MENTRE E TOCA")) {
                                contador = contador + 1;
                            } else {
                                //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                                erInt++;
                                errors.setText(String.valueOf(erInt));
                            }
                        }

                        //AQUESTA FUNCIÓ ES BUIDA PERQUE EN EL NOSTRE CAS NO L'UTILITZEM, PERO ES OBLIGATORIA TENIR-LA, JA QUE VA JUNTA AMB L'ANTERIOR
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    //S'HA TRIAT UNA OPCIÓ
                    desp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            //AGAFEM EL VALOR TRIAT DINS D'UN OBJECTE
                            rel2 = parent.getItemAtPosition(position);
                            //COMPROVEM QUE L'OBJECTE SIGUI IGUAL QUE L'OPCIO CORRECTA
                            if (rel2.toString().equals("C- ES POT POSAR A DIFERENTS LLOCS")) {
                                //SUMEM 1 SI ES SI
                                contador = contador + 1;
                            } else {
                                //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                                erInt++;
                                errors.setText(String.valueOf(erInt));
                            }
                        }

                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    desp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            //AGAFEM EL VALOR TRIAT DINS D'UN OBJECTE
                            rel3 = parent.getItemAtPosition(position);
                            //COMPROVEM QUE L'OBJECTE SIGUI IGUAL QUE L'OPCIO CORRECTA
                            if (rel3.toString().equals("A- TÉ NOMÉS UN TECLAT PERÒ JA TÉ DIMENSIONS CONSIDERABLES")) {
                                //SUMEM 1 SI ES SI
                                contador = contador + 1;
                            } else {
                                //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                                erInt++;
                                errors.setText(String.valueOf(erInt));
                            }
                        }

                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    desp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            //AGAFEM EL VALOR TRIAT DINS D'UN OBJECTE
                            rel4 = parent.getItemAtPosition(position);
                            //COMPROVEM QUE L'OBJECTE SIGUI IGUAL QUE L'OPCIO CORRECTA
                            if (rel4.toString().equals("D- TÉ MILERS DE TUBS I NECESSITA UN ESPAI GRAN PER A POSAR-LO")) {
                                //SUMEM 1 SI ES SI
                                contador = contador + 1;
                            } else {
                                //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                                erInt++;
                                errors.setText(String.valueOf(erInt));
                            }
                        }
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    //COMPROVEM QUE EL CONTADOR ES IGUAL A 4
                    if (contador == 4) {
                        //DONEM UN VALOR NOU AL CONTADOR
                        contadorInfo=5;
                        //SUMEM 1 AL CONTADOR DE CORRECTES
                        enInt++;
                        //ACTUALITZEM VARIABLE DE CORRECTES I ES MOSTRA
                        encerts.setText(String.valueOf(enInt));

                        //CANVIEM ELS VALORS DELS BOLEANS
                        Preguntes_Spinner=false;
                        Preguntes_CheckBox=true;
                        //DIEM QUIN LAYOUT VOLEM VEURE I QUIN NO
                        layoutCaselles.setVisibility(View.VISIBLE);
                        layoutradiobutton.setVisibility(View.INVISIBLE);
                        layoutrelacio.setVisibility(View.INVISIBLE);

                        //POSEM LA NOVA PREGUNTA
                        preguntaa.setText("Obriu la informació. \n MIREU BÉ LA FAÇANA DE L’ORGUE I TRIEU DE TOTES AQUESTES PARTS LES QUE SÓN VISIBLES.");
                        //POSEM UNA IMATGE NOVA
                        imatge.setImageDrawable(getResources().getDrawable(partsorgue));
                    }
                    //COMPROVEM EL BOLEA
                } else if (Preguntes_CheckBox==true){
                    //COMPROVEM QUE ELS CHECKSBOX 3,5,6,7 I 9 SON ELS TRIATS
                    if (cb3.isChecked() && cb5.isChecked() && cb6.isChecked() && cb7.isChecked() && cb9.isChecked()) {
                        //DONEM UN VALOR NOU A LA VARIABLE
                        contadorInfo=6;
                        //SUMEM 1 A CORRECTES I MOSTREM
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        //CANVIEM ELS BOLEANS
                        Preguntes_CheckBox=false;
                        Preguntes_RadioButton2_4=true;
                        //DIEM QUIN LAYOUT VOLEM VEURE
                        layoutCaselles.setVisibility(View.INVISIBLE);
                        layoutradiobutton.setVisibility(View.VISIBLE);
                        layoutrelacio.setVisibility(View.INVISIBLE);
                        //PASEM LA NOVA PREGUNTA AMB LES SEVES RESPOSTES
                        preguntaa.setText("Ja esteu acabant. \n QUINA ÉS LA DIFERÈNCIA ENTRE ORGUENER I ORGANISTA?");
                        res1.setText("NO HI HA CAP DIFERÈNCIA, ÉS EL MATEIX.");
                        res2.setText("L’ORGUENER CONSTRUEIX I L’ORGANISTA TOCA.");
                        res3.setVisibility(View.VISIBLE);
                        res3.setText("L’ORGANISTA CONSTRUEIX I L’ORGUENER TOCA.");
                        res4.setVisibility(View.VISIBLE);
                        res4.setText("L’ORGUENER TOCA MOLT I L’ORGANISTA NO TOCA GAIRE.");
                        //POSEM UNA IMATGE NOVA
                        imatge.setImageDrawable(getResources().getDrawable(teclat));
                    } else {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_RadioButton2_4==true) {
                    if (res2.isChecked()) {
                        contadorInfo=7;
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        //CANVIEM ELS VALORS DELS BOLEANS
                        Preguntes_RadioButton2_4=false;
                        Preguntes_RadioButton3_3=true;
                        //LI PASEM LA NOVA PREGUNTA AMB LES RESPOSTES
                        preguntaa.setText("HEU RECORDAT DE COMPTAR ELS ESCUTS DE LA CIUTAT? QUANTS ESCUTS DE LA CIUTAT HAS POGUT COMPTABILITZAR AL LLARG DE LA VISITA?");
                        res1.setText("ENTRE 10 I 20");
                        res2.setText("ENTRE 21 I 40");
                        res3.setText("MÉS DE 40");
                        res4.setVisibility(View.INVISIBLE);
                        //POSEM UNA IMATGE NOVA
                        imatge.setImageDrawable(getResources().getDrawable(escuts));
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                } else if (Preguntes_RadioButton3_3=true){
                    if (res3.isChecked()) {
                        enInt++;
                        encerts.setText(String.valueOf(enInt));
                        Preguntes_RadioButton3_3=false;

                        //CREEM UN INTENT NOU QUE ENS PASARA A LA PAG FINAL
                        Intent intent = new Intent( PreguntesJoc.this, finalJoc.class);
                        //PASEM LA VARIABLE D'ENCERTS I D'ERRORS PER PODER-LA UTILITZAR A L'ALTRE CLASS
                        intent.putExtra("errors", erInt);
                        intent.putExtra("encerts", enInt);
                        startActivity(intent); //INICIEM INTENT
                    } else {
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                }
            }
        });
        if (Preguntes_ImatgeBotons==true) {
            btnimageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //MIREM QUE EL CONTADOR SIGI 1
                    if (contadorPreguntes == 1) {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        contadorPreguntes++;

                        //preparem següent pregunta
                        imatge.setImageDrawable(getResources().getDrawable(orgueantic));
                        preguntaa.setText("Ara ja podeu entrar a la nau i continuar amb la visita. SEGONS LA IMATGE, ON CREIEU QUE ESTAVA\n SITUAT L'ORGUE ANTERIOR? SITUEU-LO AL PLÀNOL");

                    } else {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                }
            });
            btnimageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //MIREM QUE EL CONTADOR SIGI 2
                    if (contadorPreguntes == 2) {
                        //ACTUALITZEM VARIABLE ENCERTS I ES MOSTRA
                        enInt++;
                        encerts.setText(String.valueOf(enInt));

                        //preparem nova pregunta
                        //LI PASEM LA NOVA PREGUNTA QUE HA DE MOSTRAR
                        preguntaa.setText("Ara aneu al lloc anterior i obriu la informació. OBSERVEU BÉ LA IMATGE I RESPONEU");
                        //TAMBÉ LI PASEM LES SEVES RESPOSTES
                        res1.setText("ESTÀ ARRAN DE TERRA");
                        res2.setText("ESTÀ SUSPÉS EN UNA BALCONADA");
                        //OCULTEM AQUESTS DOS RADIOBUTTONS PERQUE NO ELS UTILITZEM
                        layoutImg.setVisibility(View.INVISIBLE);
                        layoutradiobutton.setVisibility(View.VISIBLE);
                        res3.setVisibility(View.INVISIBLE);
                        res4.setVisibility(View.INVISIBLE);

                        //CAMBIEM ELS VALORS DEL BOLEANS
                        Preguntes_ImatgeBotons = false;
                        Preguntes_RadioButton4_2 = true;
                    } else {
                        //ACTUALITZEM VARIABLE D'INCORRECTES I ES MOSTRA
                        erInt++;
                        errors.setText(String.valueOf(erInt));
                    }
                }
            });
            btnimageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    erInt++;
                    errors.setText(String.valueOf(erInt));
                }
            });
            btnimageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    erInt++;
                    errors.setText(String.valueOf(erInt));
                }
            });
            btnimageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    erInt++;
                    errors.setText(String.valueOf(erInt));
                }
            });
            btnimageButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    erInt++;
                    errors.setText(String.valueOf(erInt));
                }
            });
        }
    }
}