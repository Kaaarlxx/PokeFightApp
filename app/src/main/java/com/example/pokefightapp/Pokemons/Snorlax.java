package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Snorlax extends Pokemon{
    public Snorlax(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"snorlax");
        super.setImage(R.drawable.snorlaxphoto);
        super.setColor("#2b2e7f");
    }
}
