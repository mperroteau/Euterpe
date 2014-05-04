package com.libgdx.fighter;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
	private TextureRegion[] layers;
	private TextureAtlas bg;
	private int width;
	private int texturePerLayer;
	
	
	public Background(String fileName, int width, int texturePerLayer, AssetManager assets){
		this.bg = assets.get(fileName, TextureAtlas.class);
		this.width = width;		
		this.texturePerLayer = texturePerLayer;
		this.layers = new TextureRegion[this.bg.getRegions().size];
		
	}
	
	public void render(SpriteBatch batch, CameraManager camera){
		
//		batch.draw(texture, x, y);
		
	}
}
