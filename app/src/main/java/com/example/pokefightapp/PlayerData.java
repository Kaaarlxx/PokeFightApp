package com.example.pokefightapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


    public class PlayerData implements BaseColumns {
        public static final String TABLE_NAME = "Wins";
        public static final String COLUMN_NAME_WINS = "wins";
        public PlayerData() {
        }
    }

class PlayerReader extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pokemons";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlayerData.TABLE_NAME + " (" +
                    PlayerData._ID + " INTEGER PRIMARY KEY," +
                    PlayerData.COLUMN_NAME_WINS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PlayerData.TABLE_NAME;


    public PlayerReader(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}






