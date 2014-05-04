package com.libgdx.fighter.model;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class LF2Actor {
	private GameObject go;
	private Texture barTexture;
	private Vector2 position;
	private ArrayList<Rectangle> bdyBounds;
	private ArrayList<Rectangle> itrBounds;
	private LF2Animation animations;
	private TextureRegion currPic;
	
	private int currFrameNum; 
//	private int currWait;
//	private int nextFrameNum;
	private int state;
	
	
	
	public LF2Actor(GameObject go, AssetManager assets){
		this.go = go;
		this.position = new Vector2();
		this.animations = new LF2Animation(go, assets);
		this.position.x = 40;
		this.position.y = 40;
		
		this.currFrameNum = this.animations.getCurrFrameNum();
	}
	
	
	
	public void update(float stateTime, int next){
		currFrameNum = this.animations.getCurrFrameNum();
		int currWait = this.go.getFrame(currFrameNum).wait;
		int nextFrameNum = this.go.getFrame(currFrameNum).next;	
		//TMP
		if(nextFrameNum == 999){
			nextFrameNum = 0;
		}
//		
//		
//		
//		
		currPic = animations.getKeyFramePic(stateTime, currWait , currFrameNum, nextFrameNum);
	}
	
	public static LF2Actor newInstance(GameObject go, AssetManager assets){
		return new LF2Actor(go, assets);
	}
	
	public TextureRegion getCurrentPic(){
		return this.currPic;
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}
}
