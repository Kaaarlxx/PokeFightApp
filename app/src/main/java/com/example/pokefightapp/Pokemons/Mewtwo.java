package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Mewtwo extends Pokemon{
    public Mewtwo(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"mewtwo");
        super.setImage(R.drawable.mewtwophoto);
        super.setColor("#65318f");
    }
}
