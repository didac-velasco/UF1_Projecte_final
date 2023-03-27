package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FinalJoc extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_joc);

        //declarem els diferents elements
        Button boto = (Button) findViewById(R.id.button);
        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        EditText errors = (EditText) findViewById(R.id.idErrors);

        //obtenim els valors de les variables errors i encerts que passem per l'intent
        bundle = getIntent().getExtras();
        erInt = bundle.getInt("errors");
        enInt = bundle.getInt("encerts");

        //afegim per pantalla els valors
        encerts.setText(String.valueOf(enInt));
        errors.setText(String.valueOf(erInt));

        //si fem click en aquest botó tornem al MainActivity
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent que reenvia a la classe MainActivity
                Intent intent = new Intent( FinalJoc.this, MainActivity.class);
                startActivity(intent); //executem intent
            }
        });
    }
}
