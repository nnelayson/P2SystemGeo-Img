package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GhostActivity extends AppCompatActivity {

    Button btnadptghost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);

        btnadptghost = findViewById(R.id.btnadptghost);

        btnadptghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GhostActivity.this, AdoptionActivity.class);
                startActivity(intent);
            }
        });

    }
}