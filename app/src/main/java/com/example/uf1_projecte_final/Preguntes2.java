package com.example.uf1_projecte_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Preguntes2 extends AppCompatActivity {
    //didac
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc2);

        TextView preguntaa = findViewById(R.id.textViewPregunta);

        RadioButton res1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton res2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton res3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton res4 = (RadioButton) findViewById(R.id.rb4);

        preguntaa.setText("Quina és la relació entre el disseny de la façana del nou orgue i la ciutat de Valls?");
        res1.setText("els calçots i els castells");
        res2.setText("els castells i el campanar");
        res3.setText("el campanar i els gegants");
        res4.setText("cap relació");

        if (res1.isChecked()) {
            preguntaa.setText("Que dia es hoy");
            res1.setText("Lunes");
            res2.setText("Martes");
            res3.setText("Miercoles");

        }
    }
}
