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

        //fem visibles els diferents botons
        Button b_historia = (Button) findViewById(R.id.btn_historia);
        Button b_joc = (Button) findViewById(R.id.btn_inici_joc);
        Button b_musica = (Button) findViewById(R.id.btn_musica);
        ImageButton b_preferencies = (ImageButton) findViewById(R.id.btn_preferencies);

        //declarem el SoundPool per el so dels botons
        SoundPool soBotons = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        //afegim un efecte de so
        int soBoto1 = soBotons.load(this, R.raw.so_botons, 1);

        //si fem click en aquest botó anem a la classe PreguntesJoc
        b_joc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si la variable es 0 sona l'efecte de so
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //intent que reenvia a la classe PreguntesJoc
                Intent intent = new Intent( MainActivity.this, PreguntesJoc.class);
                startActivity(intent);
            }
        });

        //si fem click en aquest botó anem a la classe Historia
        b_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si la variable es 0 sona l'efecte de so
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //intent que reenvia a la classe Historia
                Intent intent = new Intent( MainActivity.this, Historia.class);
                startActivity(intent); //executar intent
            }
        });

        //si fem click en aquest botó anem a la classe Cantates
        b_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si la variable es 0 sona l'efecte de so
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //intent que reenvia a la classe Cantates
                Intent intent = new Intent( MainActivity.this, Cantates.class);
                startActivity(intent); //executar intent
            }
        });

        //si fem click en aquest botó anem a la classe Preferencies
        b_preferencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si la variable es 0 sona l'efecte de so
                if (Preferencies.So==0) {
                    soBotons.play(soBoto1, 1.0f, 1.0f, 1, 0, 1.0f);
                }
                //intent que reenvia a la classe Preferencies
                Intent intent = new Intent( MainActivity.this, Preferencies.class);
                startActivity(intent); //executar intent
            }
        });

    }
}