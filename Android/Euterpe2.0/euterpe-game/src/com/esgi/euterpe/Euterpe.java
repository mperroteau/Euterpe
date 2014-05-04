package com.esgi.euterpe;

import com.badlogic.gdx.Game;
import com.esgi.euterpe.screens.MenuScreen;

/**
 * Created by Marine on 03/05/14.
 */
public class Euterpe extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
