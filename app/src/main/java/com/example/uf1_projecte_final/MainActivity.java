package com.example.uf1_projecte_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b_historia = (Button) findViewById(R.id.btn_historia);
        Button b_joc = (Button) findViewById(R.id.btn_inici_joc);

        //creem intent
        b_joc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, PreguntesJoc1.class); //crear intent
                startActivity(intent); //executar intent
            }
        });

        b_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, Historia.class); //crear intent
                startActivity(intent); //executar intent
            }
        });

    }
}