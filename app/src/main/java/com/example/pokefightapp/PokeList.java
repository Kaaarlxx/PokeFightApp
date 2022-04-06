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

    public PokeList(Context context){
        dbHelper =  new FeedReaderDbHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    public ArrayList<Pokemon> getPokes() {
        return pokes;
    }

    public void setPokes(ArrayList<Pokemon> pokes) {
        this.pokes = pokes;
    }
}
