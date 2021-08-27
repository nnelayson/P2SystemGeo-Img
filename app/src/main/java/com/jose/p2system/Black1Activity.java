package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Black1Activity extends AppCompatActivity {

    Button btnadptblack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black1);

        btnadptblack = findViewById(R.id.btnadptblack);
        btnadptblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Black1Activity.this,AdoptionActivity.class);
                startActivity(intent);
            }
        });

    }
}