package com.esgi.euterpe;

import com.badlogic.gdx.Game;
import com.esgi.euterpe.Screens.SampleScreen;

/**
 * Created by Marine on 05/12/13.
 */
public class GameCore extends Game {
    @Override
    public void create(){
        setScreen(new SampleScreen()); //Set the primary screen
    }
}
