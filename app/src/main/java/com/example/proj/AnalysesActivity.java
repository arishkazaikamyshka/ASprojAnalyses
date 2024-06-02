package com.example.proj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class AnalysesActivity extends AppCompatActivity {

    Button button, btn;
    int n;
    int bu;
    double[] mi;
    double[] ma;
    String[] na;


    @Override
    protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.analyses_main);
        TextView tv0 = findViewById(R.id.ht0);
        TextView tv1 = findViewById(R.id.ht1);
        TextView tv2 = findViewById(R.id.ht2);
        TextView tv3 = findViewById(R.id.ht3);
        TextView tv4 = findViewById(R.id.ht4);
        TextView tv5 = findViewById(R.id.ht5);
        TextView tv6 = findViewById(R.id.ht6);
        TextView tv7 = findViewById(R.id.ht7);
        TextView tv8 = findViewById(R.id.ht8);
        TextView tv9 = findViewById(R.id.ht9);
        TextView tv10 = findViewById(R.id.ht10);
        TextView tv11 = findViewById(R.id.ht11);
        TextView tv12 = findViewById(R.id.ht12);
        TextView tw0 = findViewById(R.id.hv0);
        TextView tw1 = findViewById(R.id.hv1);
        TextView tw2 = findViewById(R.id.hv2);
        TextView tw3 = findViewById(R.id.hv3);
        TextView tw4 = findViewById(R.id.hv4);
        TextView tw5 = findViewById(R.id.hv5);
        TextView tw6 = findViewById(R.id.hv6);
        TextView tw7 = findViewById(R.id.hv7);
        TextView tw8 = findViewById(R.id.hv8);
        TextView tw9 = findViewById(R.id.hv9);
        TextView tw10 = findViewById(R.id.hv10);
        TextView tw11 = findViewById(R.id.hv11);
        TextView tw12 = findViewById(R.id.hv12);
        EditText et0 = findViewById(R.id.et0);
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        EditText et3 = findViewById(R.id.et3);
        EditText et4 = findViewById(R.id.et4);
        EditText et5 = findViewById(R.id.et5);
        EditText et6 = findViewById(R.id.et6);
        EditText et7 = findViewById(R.id.et7);
        EditText et8 = findViewById(R.id.et8);
        EditText et9 = findViewById(R.id.et9);
        EditText et10 = findViewById(R.id.et10);
        EditText et11 = findViewById(R.id.et11);
        EditText et12 = findViewById(R.id.et12);

        EditText[] et = {et0, et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12};
        TextView[] tw = {tw0, tw1, tw2, tw3, tw4, tw5, tw6, tw7, tw8, tw9, tw10, tw11, tw12};
        TextView[] tv = {tv0, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12};
        String[] un = {"Белок", "Сахар", "Кетоновые тела", "Пигментные тела", "Общий азот мочи", "Мочевина", "Аммиак", "Мочевая кислота", "Креатинин", "Относительная плотность", "Лейкоциты", "Глюкоза", "Эпителий"};
        double[] mmi1 = {0, 0, 0, 0, 400, 20, 0.6, 0.27, 12, 1.012, 0, 0, 0};
        double[] mma1 = {0.1, 0.05, 50, 6, 1200, 35, 1.3, 0.8, 12, 1.025, 3, 1, 5};
        double[] wmi1 = {0, 0, 0, 0, 400, 20, 0.6, 0.27, 0.5, 1.012, 0, 0, 0};
        double[] wma1 = {0.1, 0.05, 50, 6, 1200, 35, 1.3, 0.8, 1.6, 1.025, 3, 1, 5};
        String[] bn = {"Гемоглобин", "Эритроциты", "Цветовой показатель", "Рецикулоциты", "Тромбоциты", "СОЭ", "Лейкоциты", "Палочкоядерные", "Сегментоядерные", "Эозинофилы", "Базофилы", "Лимфоциты", "Моноциты"};
        double[] mmi0 = {130, 4, 0.85, 0.2, 180, 2, 4, 1, 47, 0, 0, 18, 2};
        double[] mma0 = {160, 5.1, 1.15, 1.2, 320, 15, 9, 6, 72, 5, 1, 40, 9};
        double[] wmi0 = {120, 3.7, 0.85, 0.2, 180, 1, 4, 1, 47, 0, 0, 18, 2};
        double[] wma0 = {140, 4.7, 1.15, 1.2, 320, 10, 9, 6, 72, 5, 1, 40, 9};
        double[] res = new double[13];

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            n = extras.getInt("key");
        }
        if (extras != null) {
            bu = extras.getInt("blur");
        }
        button = (Button) findViewById(R.id.btnPast);
        button.setOnClickListener(view -> {
            finish();
        });
        if (bu == 0) {
            na = bn;
            if (n == 2){
                mi = mmi0;
                ma = mma0;
            }
            else{
                mi = wmi0;
                ma = wma0;
            }
        }
        else {
            na = un;
            if (n == 2){
                mi = mmi1;
                ma = mma1;
            }
            else{
                mi = wmi1;
                ma = wma1;
            }
        }
        for (int i = 0; i < 13; i++) {
            tv[i].setText("  " + na[i]);
        }
        btn = findViewById(R.id.btnAnalyz);
        btn.setOnClickListener(view ->{
            for (int j = 0; j < 13; j++){
                String v = String.valueOf((et[j].getText()));
                double vv = Double.parseDouble(v);
                res[j] = vv;
            }
            for (int j = 0; j < 13; j++){
                if (mi[j] > res[j]){
                    tw[j].setText("Ниже нормы");
                }
                else if (ma[j] < res[j]){
                    tw[j].setText("Выше нормы");
                }
                else {
                    tw[j].setText("В пределах нормы");
                }
            }
        });
    }
}