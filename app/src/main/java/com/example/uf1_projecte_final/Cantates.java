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

        ImageView botoInfo = (ImageView) findViewById(R.id.idInfo);

        mediaPlayer = MediaPlayer.create(this, R.raw.cantata);

        ImageButton playButton = findViewById(R.id.btnPlay);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        ImageButton pauseButton = findViewById(R.id.btnPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        ImageButton restartButton = findViewById(R.id.btnReset);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

        botoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INTENT QUE EXECUTARA EL POPUP AMB L'INFORMACIÓ
                Intent intent = new Intent( Cantates.this, PopupInfo.class);
                //LI PASEM PER PARAMETRE QUINA INFORMACIÓ VOLEM VEURE
                intent.putExtra("posicio", 8);
                startActivity(intent); //INICIEM INTENT
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}

