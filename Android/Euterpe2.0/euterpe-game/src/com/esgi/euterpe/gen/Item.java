package com.esgi.euterpe.gen;

import com.esgi.euterpe.gen.items.ItemType;

import java.sql.Time;

/**
 * Created by Marine on 11/01/14.
 */
public class Item {
    int coordx;
    int coordy;
    Time time;
    ItemType type;

    public void Item(int _coordx,int _coordy, Time _time, ItemType _type){
        this.coordx = _coordx;
        this.coordy = _coordy;
        this.time = _time;
        this.type = _type;
    }

    public void play(){
        //joue l'item
    }

}
