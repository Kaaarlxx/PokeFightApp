package com.example.pokefightapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "pokelist";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_HP = "hp";
        public static final String COLUMN_NAME_DMG = "dmg";
        public static final String COLUMN_NAME_PP = "pp";
        public static final String COLUMN_NAME_SM = "sm";
        public static final String COLUMN_NAME_SMDMG = "smdmg";
        public FeedEntry(){}
    }
}
class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pokemons";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_TYPE + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_HP + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_DMG + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_PP + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SM + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SMDMG + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;


    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}





