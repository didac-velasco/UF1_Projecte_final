package com.example.uf1_projecte_final;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FEM VISIBLES ELS BOTONS D'HISTORIA I EL DE COMENÇAR EL JOC
        Button b_historia = (Button) findViewById(R.id.btn_historia);
        Button b_joc = (Button) findViewById(R.id.btn_inici_joc);
        Button b_musica = (Button) findViewById(R.id.btn_musica);
        ImageButton b_preferencies = (ImageButton) findViewById(R.id.btn_preferencies);

        SoundPool soBotons = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        int soBoto1 = soBotons.load(this, R.raw.so_botons, 1);

        //ACCIÓ AL FER CLICK AL BOTO DE COMENÇAR
        b_joc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //CREEM EL INTENT QUE ENS PORTARA A LA PAG PER COMENÇAR EL JOC
                Intent intent = new Intent( MainActivity.this, PreguntesJoc.class);
                //S'EXECUTA L'INTENT
                startActivity(intent);
            }
        });

        //ACCIÓ AL FER CLICK AL BOTO D'HISTORIA
        b_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //CREEM EL INTENT QUE ENS PORTARA A LA PAG D'HISTORIA
                Intent intent = new Intent( MainActivity.this, Historia.class);
                //S'EXECUTA L'INTENT
                startActivity(intent); //executar intent
            }
        });

        b_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //CREEM EL INTENT QUE ENS PORTARA A LA PAG D'HISTORIA
                Intent intent = new Intent( MainActivity.this, Cantates.class);
                //S'EXECUTA L'INTENT
                startActivity(intent); //executar intent
            }
        });

        b_preferencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //CREEM EL INTENT QUE ENS PORTARA A LA PAG D'HISTORIA
                Intent intent = new Intent( MainActivity.this, Preferencies.class);
                //S'EXECUTA L'INTENT
                startActivity(intent); //executar intent
            }
        });

    }
}