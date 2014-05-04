package com.esgi.euterpe;

import android.content.Context;
import com.badlogic.gdx.Game;
import com.esgi.euterpe.Screens.MenuScreen;

/**
 * Created by Marine on 05/12/13.
 */
public class GameCore extends Game {

    private Context context;
    public GameCore(Context _context){
        this.context = _context.getApplicationContext();

    }

    @Override
    public void create(){
        //setScreen(new SampleScreen(this.context)); //Set the primary screen
        setScreen(new MenuScreen(this));

    }

    public void render(){
    }
}
