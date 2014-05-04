package com.esgi.euterpe.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

public abstract class AbstractScreen implements Screen {

	protected Game game;
	private AssetManager assets;
	
	public AbstractScreen(Game game){
		this.game = game;
	}
	
	public abstract void render(float delta);

	public abstract void resize(int width, int height);

	public abstract void show();

	public abstract void hide();

	public abstract void pause();

	public abstract void resume();

	public abstract void dispose();

	public AssetManager getAssetManager() {
		return assets;
	}

	public void setAssetManager(AssetManager assets) {
		this.assets = assets;
	}

}
