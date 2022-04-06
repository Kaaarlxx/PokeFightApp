package com.example.pokefightapp;

import com.example.pokefightapp.Pokemons.Pokemon;

public class Battle {
    private Pokemon player;
    private Pokemon enemy;

    public Battle(Pokemon player, Pokemon enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    public Battle(){};

    public Pokemon getPlayer() {
        return player;
    }

    public void setPlayer(Pokemon player) {
        this.player = player;
    }

    public Pokemon getEnemy() {
        return enemy;
    }

    public void setEnemy(Pokemon enemy) {
        this.enemy = enemy;
    }

    void attack(boolean isPlayerAttacking){

        if(isPlayerAttacking){
            enemy.setHp(enemy.getHp()-player.getDamage());
        }
        else{
            player.setHp(player.getHp()-enemy.getDamage());
        }
    }

    void crit(boolean isPlayerAttacking){
        if(isPlayerAttacking){
            enemy.setHp(enemy.getHp()-player.getSmdmg());
        }
        else{
            player.setHp(player.getHp()-enemy.getSmdmg());
        }
    }
}
