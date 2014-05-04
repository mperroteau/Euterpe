package com.esgi.euterpe.gen.items;

/**
 * Created by Marine on 11/01/14.
 */
public abstract class ItemType {

    private String name;

    public void ItemType(String _name) {
        name = _name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public abstract void setItemElements();


}
