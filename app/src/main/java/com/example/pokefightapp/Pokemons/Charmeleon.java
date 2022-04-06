package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Charmeleon extends Pokemon {
    public Charmeleon(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"charmeleon");
        super.setImage(R.drawable.charmeleonphoto);
        super.setColor("#bb4c00");
    }
}
