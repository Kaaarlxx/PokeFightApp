package com.example.pokefightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pokefightapp.Pokemons.Pokemon;

import java.util.Random;


public class Activity3 extends AppCompatActivity {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("aaaaa");
        countDownTimer.cancel();
    }

    private ImageView imageView;
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    Random r = new Random();
    private Pokemon yourPokemon;
    PokeList pokeList;
    Battle battle = new Battle();
    final Handler handler = new Handler(Looper.getMainLooper());

    CountDownTimer countDownTimer = new CountDownTimer(100000,3000) {

        @Override
        public void onTick(long l) {
            battle.attack(false);
            Toast.makeText(getApplicationContext(), getString(R.string.hit),Toast.LENGTH_SHORT).show();
            progressBar = findViewById(R.id.playerhp);
            progressBar.setProgress(battle.getPlayer().getHp());
            lose();
        }

        @Override
        public void onFinish() {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pokeList = new PokeList(getBaseContext());
        this.isPaused=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        imageView = findViewById(R.id.player);

        yourPokemon = getIntent().getParcelableExtra("pokemon");

        battle.setPlayer(yourPokemon);
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(yourPokemon.getType()+"player", "drawable", context.getPackageName());
        Glide.with(this).load(id).into(imageView);

        battle.setEnemy(pokeList.getPokes().get(r.nextInt(5)));
        imageView = findViewById(R.id.enemy);
        context = imageView.getContext();
        id = context.getResources().getIdentifier(battle.getEnemy().getType()+"enemy", "drawable", context.getPackageName());
        Glide.with(this).load(id).into(imageView);

        imageView = findViewById(R.id.vs);
        context = imageView.getContext();
        id = context.getResources().getIdentifier("vs", "drawable", context.getPackageName());
        Glide.with(this).load(id).into(imageView);

        textView = findViewById(R.id.playername);
        textView.setText(battle.getPlayer().getType());
        textView = findViewById(R.id.enemyname);
        textView.setText(battle.getEnemy().getType());


        button = findViewById(R.id.crit);
        button.setEnabled(false);
        button.setOnClickListener(view -> crit());

        button=findViewById(R.id.hit);
        button.setOnClickListener(view -> attack());

        progressBar = findViewById(R.id.enemyhp);
        progressBar.setMax(battle.getEnemy().getHp());
        progressBar.setProgress(battle.getEnemy().getHp());
        progressBar = findViewById(R.id.playerhp);
        progressBar.setMax(battle.getPlayer().getHp());
        progressBar.setProgress(battle.getPlayer().getHp());

       countDownTimer.start();
    }


    public void attack(){
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(progressBar.getProgress()+10);
        battle.attack(true);
        if(progressBar.getProgress()>=100)
        {
            button = findViewById(R.id.crit);
            button.setEnabled(true);
        }
        progressBar = findViewById(R.id.enemyhp);
        progressBar.setProgress(battle.getEnemy().getHp());

        if(battle.getEnemy().getHp()<=0){
            win();
        }


    }
    public void crit(){
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        battle.crit(true);
        button = findViewById(R.id.crit);
        button.setEnabled(false);
        progressBar = findViewById(R.id.enemyhp);
        progressBar.setProgress(battle.getEnemy().getHp());

        if(battle.getEnemy().getHp()<=0){
            win();
        }
    }

    public void lose(){
        if(battle.getPlayer().getHp()<=0)
        {
            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.hit);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.crit);
            button.setVisibility(View.INVISIBLE);
            textView = findViewById(R.id.state);
            textView.setText("You LOSE !");
            countDownTimer.cancel();
            handler.postDelayed(() -> {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            },1000);
        }
    }

    public void win() {
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        button = findViewById(R.id.hit);
        button.setVisibility(View.INVISIBLE);
        button = findViewById(R.id.crit);
        button.setVisibility(View.INVISIBLE);
        textView = findViewById(R.id.state);
        textView.setText("You WIN !");
        countDownTimer.cancel();
        handler.postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(),ListOfPokes.class);
            startActivity(intent);
        },1000);
    }
}