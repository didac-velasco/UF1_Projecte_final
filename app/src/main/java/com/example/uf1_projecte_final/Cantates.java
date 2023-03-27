package com.example.uf1_projecte_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Cantates extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantates);

        //declarem les diferents imatges
        ImageView botoInfo = (ImageView) findViewById(R.id.idInfo);
        ImageButton playButton = findViewById(R.id.btnPlay);
        ImageButton pauseButton = findViewById(R.id.btnPause);
        ImageButton restartButton = findViewById(R.id.btnReset);

        //recuperem la cantata
        mediaPlayer = MediaPlayer.create(this, R.raw.cantata);

        //si fem click en aquest botó iniciem la música
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        //si fem click en aquest botó pausem la música
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        //si fem click en aquest botó recetegem i tornem a començar la música
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

        //si fem click en aquest botó s'ens mostra el PopUp de la informació
        botoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent que reenvia a la classe PopupInfo
                Intent intent = new Intent( Cantates.this, PopupInfo.class);
                //passem per parametre la posicio de la informació
                intent.putExtra("posicio", 8);
                startActivity(intent); //executem intent
            }
        });

    }
    //
    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}

