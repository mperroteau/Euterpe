package com.libgdx.fighter;

import com.badlogic.gdx.Game;
import com.libgdx.fighter.screens.FightScreen;
import com.libgdx.fighter.screens.LoadingScreen;

public class LittleFighter extends Game {

	@Override
	public void create() {
		setScreen(new LoadingScreen(this));
	}

}
