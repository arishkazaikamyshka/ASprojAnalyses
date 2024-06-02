package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GenderActivity extends AppCompatActivity {
    Button button, btn, bttn;
    int n;
    int bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            bu = extras.getInt("blur");
        }
        button = (Button) findViewById(R.id.btnLast);
        button.setOnClickListener(view -> {
            finish();
        });

        Intent i = new Intent(this, AnalysesActivity.class);
        n = 1;
        btn = (Button) findViewById(R.id.btnMan);
        btn.setOnClickListener(view -> {
            i.putExtra("key",n);
            i.putExtra("blur", bu);
            startActivity(i);
        });

        n = 2;
        bttn = (Button) findViewById(R.id.btnWoman);
        bttn.setOnClickListener(view -> {
            i.putExtra("key",n);
            i.putExtra("blur", bu);
            startActivity(i);
        });
    }
}
