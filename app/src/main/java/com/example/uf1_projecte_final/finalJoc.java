package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class finalJoc extends AppCompatActivity {
    Bundle bundle;
    int erInt, enInt, Pencerts, Perrors, suma;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_joc);

        bundle = getIntent().getExtras();
        erInt = bundle.getInt("errors");
        enInt = bundle.getInt("encerts");
        Button boto = (Button) findViewById(R.id.button);

        EditText encerts = (EditText) findViewById(R.id.idEncerts);
        encerts.setText(String.valueOf(enInt));
        EditText errors = (EditText) findViewById(R.id.idErrors);
        errors.setText(String.valueOf(erInt));

        suma = erInt + enInt;
        Pencerts = enInt*100/suma;
        Perrors = erInt*100/suma;

        EditText Tcorrectes = (EditText) findViewById(R.id.idTotalCorrectes);
        Tcorrectes.setText(String.valueOf(Pencerts));
        EditText Tincorrectes = (EditText) findViewById(R.id.idTotalIncorrectes);
        Tincorrectes.setText(String.valueOf(Perrors));

        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( finalJoc.this, MainActivity.class); //crear intent
                startActivity(intent); //executar intent
            }
        });
    }
}
