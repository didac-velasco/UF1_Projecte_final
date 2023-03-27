package com.example.uf1_projecte_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Preferencies extends AppCompatActivity {
    //creem una variable estatica
    public static int So = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencies);

        //recuperem valors de les imatges
        ImageButton b_So = (ImageButton) findViewById(R.id.botoSo);
        ImageButton b_NoSo = (ImageButton) findViewById(R.id.botoNoSo);

        //si fem click en aquest botó posem la variable So a 0
        b_So.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                So=0;
            }
        });

        //si fem click en aquest botó posem la variable So a 1
        b_NoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                So=1;
            }
        });
    }
}
