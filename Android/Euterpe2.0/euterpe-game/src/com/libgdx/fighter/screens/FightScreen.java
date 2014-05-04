package com.libgdx.fighter.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.libgdx.fighter.FightScreenController;
import com.libgdx.fighter.FightScreenRenderer;
import com.libgdx.fighter.FightWorld;
import com.libgdx.fighter.InputHandler;

public class FightScreen extends AbstractScreen {

	public FightScreen(Game game) {
		super(game);
	}

	private FightWorld fw;
	private FightScreenRenderer fsRenderer;
	private FightScreenController fsController;
	private InputHandler inputHandler;
	private GestureDetector gestureHandler;
	private InputMultiplexer im;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		fsRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
		float aspectRatio = width/height;
//		this.fsRenderer.resize(width, height);
		System.out.println("width" + width +" height " + height);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.fw = new FightWorld(this.getAssetManager());
		this.fsRenderer = new FightScreenRenderer(this.fw, this.getAssetManager());
		
		this.fsController = new FightScreenController();
		this.inputHandler = new InputHandler(this.fsController, this.getAssetManager());
		
		
		this.im = new InputMultiplexer();
		this.gestureHandler = new GestureDetector(inputHandler);
		this.im.addProcessor(gestureHandler);
		this.im.addProcessor(inputHandler);
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
