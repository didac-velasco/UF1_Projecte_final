package com.example.uf1_projecte_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class PreguntesJoc2 extends AppCompatActivity {
    Bundle bundle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc2);

        bundle=getIntent().getExtras();
        int erInt = bundle.getInt("errors");
        int enInt = bundle.getInt("encerts");
        //int errorInt, encertsInt;

        TextView preguntaa = findViewById(R.id.textViewPregunta);

        RadioButton res1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton res2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton res3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton res4 = (RadioButton) findViewById(R.id.rb4);

        ImageButton Siguiente = (ImageButton) findViewById(R.id.imatgeButtonNext);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        encerts.setText(ErrorsEncerts(enInt));
        errors.setText(ErrorsEncerts(erInt));

        preguntaa.setText("OBSERVEU BÉ LA IMATGE I RESPONEU");
        res1.setText("ESTÀ ARRAN DE TERRA");
        res2.setText("ESTÀ SUSPÉS EN UNA BALCONADA");
        res3.setText("");
        res4.setText("");

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res2.isChecked()) {
                    encerts.setText(enInt);
                    preguntaa.setText("QUINA ÉS LA RELACIÓ ENTRE EL DISSENY DE LA FAÇANA DEL NOU ORGUE I LA CIUTAT DE VALLS?");
                    res1.setText("ELS CALÇOTS I ELS CASTELLS");
                    res2.setText("ELS CASTELLS I EL CAMPANAR");
                    res3.setText("EL CAMPANAR I ELS GEGANTS");
                } else {
                    //errors.setText(ErrorsEncerts(errorsInt));
                }
            }
        });
    }
    public String ErrorsEncerts(int sumar){
        String num= sumar+""; //passem a String
        return num;
    }
}