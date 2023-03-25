package com.example.uf1_projecte_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Cantates extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantates);

        ImageView botoInfo = (ImageView) findViewById(R.id.idInfo);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageButton control = (ImageButton) findViewById(R.id.idControlMusica);
        ImageButton reiniciar = (ImageButton) findViewById(R.id.idTornarComencar);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cantata);

        boolean controlMusica = true;
        
        if (controlMusica==true){
            controlMusica=false;
        } else {
            controlMusica=true;
        }
        boolean FinalcontrolMusica = controlMusica;
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FinalcontrolMusica ==true){
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.reset();
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
}
