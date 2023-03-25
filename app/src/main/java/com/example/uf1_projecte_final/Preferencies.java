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
    public static int So = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencies);

        ImageButton b_So = (ImageButton) findViewById(R.id.botoSo);
        ImageButton b_NoSo = (ImageButton) findViewById(R.id.botoNoSo);

        b_So.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                So=0;
            }
        });

        b_NoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                So=1;
            }
        });
    }
}
