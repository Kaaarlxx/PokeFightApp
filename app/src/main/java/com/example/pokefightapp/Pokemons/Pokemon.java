package com.example.pokefightapp.Pokemons;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class Pokemon implements Parcelable {
    private int hp;
    private int damage;
    private int pp;
    private int ppmax;
    private String sm;
    private int smdmg;
    private String type;
    private int image;
    private String color;
    public Pokemon(){}

    public Pokemon(int hp, int damage,int ppmax, String sm,int smdmg,String type) {
        this.hp = hp;
        this.damage = damage;
        this.pp = 0;
        this.ppmax = ppmax;
        this.sm = sm;
        this.smdmg = smdmg;
        this.type = type;
    }

    protected Pokemon(Parcel in) {
        hp = in.readInt();
        damage = in.readInt();
        pp = in.readInt();
        ppmax = in.readInt();
        sm = in.readString();
        smdmg = in.readInt();
        type = in.readString();
        image = in.readInt();
        color = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hp);
        dest.writeInt(damage);
        dest.writeInt(pp);
        dest.writeInt(ppmax);
        dest.writeString(sm);
        dest.writeInt(smdmg);
        dest.writeString(type);
        dest.writeInt(image);
        dest.writeString(color);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPpmax() {
        return ppmax;
    }

    public void setPpmax(int ppmax) {
        this.ppmax = ppmax;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public int getSmdmg() {
        return smdmg;
    }

    public void setSmdmg(int smdmg) {
        this.smdmg = smdmg;
    }

    String getname(){
        String[] str = this.getClass().toString().split("\\.");
        return str[str.length-1].toLowerCase(Locale.ROOT);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "hp=" + hp +
                ", damage=" + damage +
                ", pp=" + pp +
                ", ppmax=" + ppmax +
                ", sm='" + sm + '\'' +
                ", smdmg=" + smdmg +
                ", type='" + type + '\'' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
