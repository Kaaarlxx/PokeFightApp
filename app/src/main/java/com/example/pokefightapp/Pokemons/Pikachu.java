package com.example.pokefightapp.Pokemons;

import com.example.pokefightapp.R;

public class Pikachu extends Pokemon {
    public Pikachu(int hp,int dmg, int pp, String ss,int smdmg) {
        super(hp,dmg,pp,ss,smdmg,"pikachu");
        super.setImage(R.drawable.pikachuphoto);
        super.setColor("#EDFF14");
    }

}
