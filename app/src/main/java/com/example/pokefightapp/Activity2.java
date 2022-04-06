package com.example.pokefightapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pokefightapp.Pokemons.Pokemon;

public class Activity2 extends AppCompatActivity {
    boolean isPaused = false;

    @Override
    protected void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isPaused){
            finish();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

    private ImageView imgview;
    private TextView textView;
    private Button button;
    PokeList pokeList;
    PokemonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.isPaused=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Pokemon selected = getIntent().getParcelableExtra("poke");
        System.out.println(selected.toString());
        imgview = findViewById(R.id.imageView);
        imgview.setImageDrawable(getResources().getDrawable(selected.getImage()));
        textView = findViewById(R.id.name);
        textView.setText(selected.getType());
        textView = findViewById(R.id.hp);
        textView.setText("HP = " + selected.getHp());
        textView = findViewById(R.id.dmg);
        textView.setText("DMG = " + selected.getDamage());
        textView = findViewById(R.id.pp);
        textView.setText("PPmax = " + selected.getPpmax());
        textView = findViewById(R.id.ssd);
        textView.setText(selected.getSm()+" DMG = " + selected.getSmdmg());
        button = findViewById(R.id.select);
        button.setOnClickListener(view -> openActivity3(selected));
    }
    public void openActivity3(Pokemon p){
        Intent intent = new Intent(this,Activity3.class);
        intent.putExtra("pokemon",p);
        startActivity(intent);
    }

}