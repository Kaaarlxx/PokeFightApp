package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Gengar extends Pokemon{
    public Gengar(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"gengar");
        super.setImage(R.drawable.gengarphoto);
        super.setColor("#652f63");
    }
}
