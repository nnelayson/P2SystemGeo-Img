package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Barbie1Activity extends AppCompatActivity {

    Button btnadptbarbie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barbie1);

        btnadptbarbie = findViewById(R.id.btnadptbarbie);
        btnadptbarbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Barbie1Activity.this,AdoptionActivity.class);
                startActivity(intent);
            }
        });
    }
}