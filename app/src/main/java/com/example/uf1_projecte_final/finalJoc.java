package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class finalJoc extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt, Pencerts, Perrors, suma;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_joc);
        //OBTENIM ELS VALORS DE LES VARIABLES
        bundle = getIntent().getExtras();
        erInt = bundle.getInt("errors");
        enInt = bundle.getInt("encerts");

        Button boto = (Button) findViewById(R.id.button);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        //DONEM EL TOTAL D'ENCERTS
        encerts.setText(String.valueOf(enInt));
        EditText errors = (EditText) findViewById(R.id.idErrors);
        //DONEM EL TOTAL D'INCORRECTES
        errors.setText(String.valueOf(erInt));


        //ACCIÓ BOTO TORNAR INICI
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CREEM UN INTENT QUE ENS PORTARA A LA PAG INICIAL
                Intent intent = new Intent( finalJoc.this, MainActivity.class);
                //EXECUTEM INTENT
                startActivity(intent);
            }
        });
    }
}
