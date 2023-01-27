package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Historia extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MOSTREM LA PAG AMB TOTA L'HISTORIA
        setContentView(R.layout.historia);

        ImageButton btnanterior = (ImageButton) findViewById(R.id.btAnterior);

        //ACCIÓ DEL BOTO ANTERIOR
        btnanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CREEM UN INTENT QUE ENS PORTARA A LA PAG INICIAL
                Intent intent = new Intent( Historia.this, MainActivity.class);
                //EXECUTEM INTENT
                startActivity(intent);
            }
        });
    }
}
