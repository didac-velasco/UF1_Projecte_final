package com.example.uf1_projecte_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class finalJoc extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_joc);

        Button boto = (Button) findViewById(R.id.button);

        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( finalJoc.this, MainActivity.class); //crear intent
                startActivity(intent); //executar intent
            }
        });
    }
}
