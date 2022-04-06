package com.example.pokefightapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.pokefightapp.Pokemons.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemons){
        super(context,0,pokemons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pokemon, parent, false);
        }
        System.out.println(pokemon.getType());
        int id = convertView.getResources().getIdentifier(pokemon.getType(), "color",getContext().getPackageName());
        System.out.println(id);
        convertView.setBackgroundColor(getContext().getResources().getColor(id));
        TextView pokename = (TextView) convertView.findViewById(R.id.pokename2);
        pokename.setText(pokemon.getType());
        ImageView img = (ImageView) convertView.findViewById(R.id.pokephoto);
        img.setImageDrawable(getContext().getResources().getDrawable(pokemon.getImage()));
        TextView hp = (TextView) convertView.findViewById(R.id.hpamm);
        hp.setText("HP : "+String.valueOf(pokemon.getHp()));
        TextView dmg = (TextView) convertView.findViewById(R.id.dmgamm);
        dmg.setText("DMG : " + String.valueOf(pokemon.getDamage()));
        TextView pp = (TextView) convertView.findViewById(R.id.ppmax);
        pp.setText("PPmax : " + String.valueOf(pokemon.getPpmax()));
        TextView sm = (TextView) convertView.findViewById(R.id.smdmg);
        sm.setText(pokemon.getSm() + " : " + String.valueOf(pokemon.getSmdmg()));


        return convertView;
    }
}
