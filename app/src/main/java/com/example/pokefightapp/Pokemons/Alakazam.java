package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Alakazam extends  Pokemon{
    public Alakazam(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"alakazam");
        super.setImage(R.drawable.alakazamphoto);
        super.setColor("#bb9600");
    }
}
