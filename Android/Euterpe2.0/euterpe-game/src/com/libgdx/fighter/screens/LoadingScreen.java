package com.libgdx.fighter.screens;

import java.io.IOException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.fighter.Config;
import com.libgdx.fighter.utils.ObjectParser;
import com.libgdx.fighter.utils.ObjectParser_BK;

public class LoadingScreen extends AbstractScreen {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture splash;
	private TextureRegion loadingBar;
	private Thread dataLoadThread;
	
	
	
	public LoadingScreen(Game game){
		super(game);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.setProjectionMatrix(this.camera.combined);
		this.batch.begin();
		
		if(this.getAssetManager().update()){
			this.batch.end();
			AbstractScreen s = new FightScreen(game);
			s.setAssetManager(this.getAssetManager());
			try{
				dataLoadThread.join();
				this.game.setScreen(s);
			}catch (InterruptedException ie){
				System.out.println(ie);
			}
			
		}else{
			this.batch.draw(splash, Config.VIRTAUL_MAP_WIDTH/2 - splash.getWidth()/2, Config.VIRTUAL_MAP_HEIGHT/2 - splash.getHeight()/2);
			this.batch.end();
		}
		
		
		
		
//		this.batch.setProjectionMatrix(this.camera.combined);
//		this.batch.begin();
//		
//		if(!this.assets.update()){
//			this.game.setScreen(new FightScreen());
//			this.batch.draw(this.splash, Config.VIRTAUL_MAP_WIDTH/2 - splash.getWidth()/2, Config.VIRTUAL_MAP_HEIGHT/2 - splash.getHeight()/2);
//			this.batch.draw(this.loadingBar, 0.0F, 0.0F, this.assets.getProgress() * Config.VIRTAUL_MAP_WIDTH + 1.0F, 1.0F);
//		}else{
//			this.batch.end();
//		}

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {
		this.setAssetManager(new AssetManager());
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Config.VIRTAUL_MAP_WIDTH, Config.VIRTUAL_MAP_HEIGHT);
		this.splash = new Texture(Gdx.files.internal("sprites/splash.png"));
		this.loadingBar = new TextureRegion(this.splash, 0, 80, 1, 1);
		this.batch = new SpriteBatch();
		
		
		loadAssets();
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

	private void loadAssets() {
//		ObjectParser p = new ObjectParser();
//			try {
//				p.preLoadGameObject("data\\data.txt");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		ObjectParser.parseLine("pic: 97  state: 15  wait: 6  next: 53  dvx: 0  dvy: 0  centerx: 41  centery: 68  hit_a: 0  hit_d: 0  hit_j: 0");
		
		ObjectParser p = new ObjectParser();
		dataLoadThread = new Thread(p);
		dataLoadThread.start();
//		p.parseLine("   pic: 130  state: 11  wait: 2  next: 225  dvx: 0  dvy: 0  centerx: 48  centery: 79  hit_a: 0  hit_d: 0  hit_j: 0");
//		p.loadMetadata("data\\data.txt");
//		p.parseLine("id: 100  type: 1  file: data\\weapon0.txt   #stick");
//		this.getAssetManager().load("sprites\\template.png", Texture.class);
		this.getAssetManager().load("sprites\\template0.png", Texture.class);
		this.getAssetManager().load("sprites\\template1.png", Texture.class);
		this.getAssetManager().load("data\\controller.png", Texture.class);
		this.getAssetManager().load("bg\\template\\1\\template1.atlas", TextureAtlas.class);
	}
}
