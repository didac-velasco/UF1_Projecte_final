package com.example.uf1_projecte_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

public class Preferencies extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencies);

        ImageButton b_So = (ImageButton) findViewById(R.id.botoSo);
        ImageButton b_NoSo = (ImageButton) findViewById(R.id.botoNoSo);
        ImageButton b_Recetejar = (ImageButton) findViewById(R.id.botoRecargar);
    }
}
