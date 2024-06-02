package com.example.proj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasesHelp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Analyzes.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
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

        db.execSQL("CREATE TABLE Blood (" + COLUMN_ID0
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME0
                + " TEXT, " + COLUMN_EdIzm0 + " TEXT, " + COLUMN_ManMin0
                + " REAL, " + COLUMN_ManMax0 + " REAL, " + COLUMN_WomanMin0
                + " REAL, " + COLUMN_WomanMax0 + "REAL);");
        String s = "CREATE TABLE Urine (" + COLUMN_ID1
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME1
                + " TEXT, " + COLUMN_EdIzm1 + " TEXT, " + COLUMN_ManMin1
                + " REAL, " + COLUMN_ManMax1 + " REAL, " + COLUMN_WomanMin1
                + " REAL, " + COLUMN_WomanMax1 + "REAL);";
        db.execSQL(s);
        db.execSQL("INSERT INTO "+ TABLE0 +" (" + COLUMN_NAME0
                + ", " + COLUMN_EdIzm0  + ", " + COLUMN_ManMin0  + ", "
                + COLUMN_ManMax0  + ", " + COLUMN_WomanMin0  + ", " + COLUMN_WomanMax0
                + ") VALUES ('Гемоглобин', 'г/л', 130, 160, 120, 140);");
                //+ "('Эритроциты', '10^12', 4, 5.1, 3.7, 4.7);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE1 +" (" + COLUMN_NAME1
                + ", " + COLUMN_EdIzm1  + ", " + COLUMN_ManMin1  + ", "
                + COLUMN_ManMax1  + ", " + COLUMN_WomanMin1  + ", " + COLUMN_WomanMax1
                + ") VALUES ('Белок', 'г/сут', 0, 0.1, 0, 0.1),"
                + "('Сахар', 'г/сут', 0, 0.05, 0, 0.05);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE0);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        onCreate(db);
    }
}

