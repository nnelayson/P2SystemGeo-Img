package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DelroActivity extends AppCompatActivity {

    Button btnadptdelro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delro);

        btnadptdelro = findViewById(R.id.btnadptdelro);
        btnadptdelro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DelroActivity.this, AdoptionActivity.class);
                startActivity(intent);
            }
        });

    }
}