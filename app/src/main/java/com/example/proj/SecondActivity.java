package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button button;
    String value;
    ArrayList<Analysis> analyses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
        }

        button = (Button) findViewById(R.id.secondButton);
        button.setOnClickListener(view ->{
            finish();
        });

        RecyclerView rv = findViewById(R.id.rvAnalyz);
        AnalysisAdapter adapter = new AnalysisAdapter(this, analyses);
        rv.setAdapter(adapter);

        Analysis k = new Analysis();

        k.setName("Общий анализ крови");
        k.setImageResourse(R.drawable.blood);

        analyses.add(k);

        Analysis p = new Analysis();

        p.setName("Общий анализ мочи");
        p.setImageResourse(R.drawable.urine);

        analyses.add(p);
    }
}
