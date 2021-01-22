package com.example.students;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GamesDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "games";
    private static final int DB_VERSION = 1;

    public GamesDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlText = "CREATE TABLE Authors (\n" +
                "id                  Integer PRIMARY KEY AUTOINCREMENT,\n" +
                "author              TEXT(10) NOT NULL,\n" +
                "genre               TIME(100),\n" +
                "countryOfIssue      INTEGER,\n" +
                "criticallyTestedFlg BOOLEAN,\n" +
                "onSaleFlg           BOOLEAN\n" +
                ");";
        sqLiteDatabase.execSQL(sqlText);

        populateDB(sqLiteDatabase);
    }

    private void populateDB(SQLiteDatabase db) {
        for(Games_genre games_genre: Games_genre.getGenres() ) {
            inrestRow(db, games_genre);
        }
    }

    private void inrestRow(SQLiteDatabase db, Games_genre games_genre) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("author", games_genre.getAuthor());
        contentValues.put("genre", games_genre.getGenre());
        contentValues.put("countryOfIssue", games_genre.getCountryOfIssue());
        contentValues.put("criticallyTestedFlg", games_genre.isCriticallyTestedFlg());
        contentValues.put("onSaleFlg", games_genre.isOnSaleFlg());
        db.insert("Authors",null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
