package com.example.pokefightapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.pokefightapp.Pokemons.Alakazam;
import com.example.pokefightapp.Pokemons.Charmeleon;
import com.example.pokefightapp.Pokemons.Gengar;
import com.example.pokefightapp.Pokemons.Mewtwo;
import com.example.pokefightapp.Pokemons.Pikachu;
import com.example.pokefightapp.Pokemons.Pokemon;
import com.example.pokefightapp.Pokemons.Snorlax;

import java.util.ArrayList;
import java.util.List;

public class PokeList {
   private ArrayList<Pokemon> pokes = new ArrayList<>();
    FeedReaderDbHelper dbHelper;
    SQLiteDatabase db;
    Context context;

    public PokeList(Context context){
        this.context = context;
        this.updateDatabase();
    }

    public ArrayList<Pokemon> getPokes() {
        return pokes;
    }

    public void setPokes(ArrayList<Pokemon> pokes) {
        this.pokes = pokes;
    }

    public void updateDatabase(){
        dbHelper =  new FeedReaderDbHelper(context);
        db = dbHelper.getWritableDatabase();
        String[] projection = {
                BaseColumns._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TYPE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_HP,
                FeedReaderContract.FeedEntry.COLUMN_NAME_DMG,
                FeedReaderContract.FeedEntry.COLUMN_NAME_PP,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SM,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SMDMG,
        };

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TYPE + " = ?";

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList itemIds = new ArrayList<>();
        int hp,dmg,pp,smdmg;
        String sm;
        while(cursor.moveToNext()) {
            hp = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_HP));
            dmg = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_DMG));
            pp = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_PP));
            smdmg = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SMDMG));
            sm = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SM));

            switch(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TYPE))) {
                case "pikachu":
                    pokes.add(new Pikachu(hp,dmg,pp,sm,smdmg));
                    break;
                case "charmeleon":
                    pokes.add(new Charmeleon(hp,dmg,pp,sm,smdmg));
                    break;
                case "gengar":
                    pokes.add(new Gengar(hp,dmg,pp,sm,smdmg));
                    break;
                case "alakazam":
                    pokes.add(new Alakazam(hp,dmg,pp,sm,smdmg));
                    break;
                case "mewtwo":
                    pokes.add(new Mewtwo(hp,dmg,pp,sm,smdmg));
                    break;
                case "snorlax":
                    pokes.add(new Snorlax(hp,dmg,pp,sm,smdmg));
                    break;
            }
        }
        cursor.close();
    }
}
