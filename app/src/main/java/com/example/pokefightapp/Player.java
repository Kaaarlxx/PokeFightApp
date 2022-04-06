package com.example.pokefightapp;

import android.content.Context;

import com.example.pokefightapp.Pokemons.Pokemon;

public class Player {
    PokeList pokeList;
    Pokemon actPokemon;
    int points;


    public Player(Context context) {
        this.pokeList = new PokeList(context);
        this.points = 0;
    }

    public PokeList getPokeList() {
        return pokeList;
    }

    public void setPokeList(PokeList pokeList) {
        this.pokeList = pokeList;
    }

    public Pokemon getActPokemon() {
        return actPokemon;
    }

    public void setActPokemon(Pokemon actPokemon) {
        this.actPokemon = actPokemon;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
