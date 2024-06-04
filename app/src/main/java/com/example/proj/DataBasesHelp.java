package com.example.proj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasesHelp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Analyzes.db"; // название бд
    private static final int SCHEMA = 2; // версия базы данных
    public static final String TABLE0 = "Blood";
    public static final String COLUMN_ID0 = "_id";
    public static final String COLUMN_NAME0 = "Name";
    public static final String COLUMN_EdIzm0 = "EdIzm";
    public static final String COLUMN_ManMin0 = "ManMin";
    public static final String COLUMN_ManMax0 = "ManMax";
    public static final String COLUMN_WomanMin0 = "WomanMin";
    public static final String COLUMN_WomanMax0 = "WomanMax";
    public static final String TABLE1 = "Urine";
    public static final String COLUMN_ID1 = "_id";
    public static final String COLUMN_NAME1 = "Name";
    public static final String COLUMN_EdIzm1 = "EdIzm";
    public static final String COLUMN_ManMin1 = "ManMin";
    public static final String COLUMN_ManMax1 = "ManMax";
    public static final String COLUMN_WomanMin1 = "WomanMin";
    public static final String COLUMN_WomanMax1 = "WomanMax";

    public DataBasesHelp(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sb = "CREATE TABLE Blood (" + COLUMN_ID0
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME0
                + " TEXT, " + COLUMN_EdIzm0 + " TEXT, " + COLUMN_ManMin0
                + " REAL, " + COLUMN_ManMax0 + " REAL, " + COLUMN_WomanMin0
                + " REAL, " + COLUMN_WomanMax0 + " REAL);";
        db.execSQL(sb);
        String su = "CREATE TABLE Urine (" + COLUMN_ID1
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME1
                + " TEXT, " + COLUMN_EdIzm1 + " TEXT, " + COLUMN_ManMin1
                + " REAL, " + COLUMN_ManMax1 + " REAL, " + COLUMN_WomanMin1
                + " REAL, " + COLUMN_WomanMax1 + " REAL);";
        db.execSQL(su);
        db.execSQL("INSERT INTO "+ TABLE0 +" (" + COLUMN_NAME0
                + ", " + COLUMN_EdIzm0  + ", " + COLUMN_ManMin0  + ", "
                + COLUMN_ManMax0  + ", " + COLUMN_WomanMin0  + ", " + COLUMN_WomanMax0
                + ") VALUES ('Гемоглобин', 'г/л', 130, 160, 120, 140),"
                + "('Эритроциты', '10^12', 4, 5.1, 3.7, 4.7),"
                + "('Цветовой показатель', ' ', 0.85, 1.15, 0.85, 1.15),"
                + "('Рецикулоциты', '%', 0.2, 1.2, 0.2, 1.2),"
                + "('Тромбоциты', '10^9', 180, 320, 180, 320),"
                + "('СОЭ', 'мм/ч', 2, 15, 1, 10),"
                + "('Лейкоциты', '10^9', 4, 9, 4, 9),"
                + "('Палочкоядерные', '%', 1, 6, 1, 6),"
                + "('Сегментоядерные', '%', 47, 72, 47, 72),"
                + "('Эозинофилы', '%', 0, 5, 0, 5),"
                + "('Базофилы', '%', 0, 1, 0, 1),"
                + "('Лимфоциты', '%', 18, 40, 18, 40),"
                + "('Моноциты', '%', 2, 9, 2, 9);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE1 +" (" + COLUMN_NAME1
                + ", " + COLUMN_EdIzm1  + ", " + COLUMN_ManMin1  + ", "
                + COLUMN_ManMax1  + ", " + COLUMN_WomanMin1  + ", " + COLUMN_WomanMax1
                + ") VALUES ('Белок', 'г/сут', 0, 0.1, 0, 0.1),"
                + "('Сахар', 'г/сут', 0, 0.05, 0, 0.05),"
                + "('Кетоновые тела', 'мг/сут', 0, 50, 0, 50),"
                + "('Пигментные тела', 'мг/сут', 0, 6, 0, 6),"
                + "('Общий азот мочи', 'ммоль/сут', 400, 1200, 400, 1200),"
                + "('Мочевина', 'г/сут', 20, 35, 20, 35),"
                + "('Аммиак', 'г/сут', 0.6, 1.3, 0.6, 1.3),"
                + "('Мочевая кислота', 'г/сут', 0.27, 0.8, 0.27, 0.8),"
                + "('Креатинин', 'г/сут', 12, 12, 0, 1.6),"
                + "('Относительная плотность', 'г/мл', 1.012, 1.025, 1.012, 1.025),"
                + "('Лейкоциты', 'п/зр', 0, 3, 0, 3),"
                + "('Глюкоза', 'ммоль/л', 0, 1, 0, 1),"
                + "('Эпителий', ' ', 0, 5, 0, 5);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE0);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        onCreate(db);
    }
}

