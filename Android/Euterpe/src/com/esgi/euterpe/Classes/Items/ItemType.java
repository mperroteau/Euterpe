package com.esgi.euterpe.Classes.Items;

/**
 * Created by Marine on 11/01/14.
 */
public abstract class ItemType {

    android.R.string name = null;

    public void ItemType(android.R.string _name){
        name = _name;
    }

    public android.R.string getName(){
        return this.name;
    }

    public void setName(android.R.string _name){
        this.name = _name;
    }

    public abstract void setItemElements();


}
