package com.example.expense.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "database.db";

    private static final int DB_VERSION = 1;

    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // création de la table users
        String createTableUser = "CREATE TABLE IF NOT EXISTS users(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "full_name VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "username VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "created_at DATETIME," +
                "updated_at DATETIME" +
                ");";

        // création de la table event
        String createTableEvent = "CREATE TABLE IF NOT EXISTS events(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "start_time TIME NOT NULL," +
                "end_time TIME NOT NULL," +
                "amount_daily_recipe FLOAT NOT NULL," +
                "amount_daily_expense FLOAT NOT NULL," +
                "created_at DATETIME," +
                "updated_at DATETIME" +
                ");";

        sqLiteDatabase.execSQL(createTableEvent);
        sqLiteDatabase.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
