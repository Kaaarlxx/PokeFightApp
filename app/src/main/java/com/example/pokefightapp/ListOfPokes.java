package com.example.pokefightapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pokefightapp.Pokemons.Pokemon;

public class ListOfPokes extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        PokeList pokes = new PokeList(getBaseContext());

        PokemonAdapter pokemonAdapter = new PokemonAdapter(getApplicationContext(),pokes.getPokes());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofpokes);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(pokemonAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            changeview(pokes.getPokes().get(i));
        });

    }

    private void changeview(Pokemon pokemon) {
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra("poke",pokemon);
        startActivity(intent);
    }
}
