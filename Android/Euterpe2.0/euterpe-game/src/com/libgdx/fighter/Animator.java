package com.libgdx.fighter;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
	private Texture spriteSheet;
	
	private TextureRegion[] standing;
	private TextureRegion[] walking;
	private TextureRegion[] running;
	private TextureRegion[] heavy_obj_walk;
	private TextureRegion[] heavy_obj_run;
	private TextureRegion[] heavy_stop_run;
	private TextureRegion[] normal_weapon_atck;
	private TextureRegion[] jump_weapon_atck;
	
	public Animator(String filename, int width, int height, AssetManager assets){
		this.spriteSheet = ((Texture)assets.get(filename, Texture.class));
	}
	
}
