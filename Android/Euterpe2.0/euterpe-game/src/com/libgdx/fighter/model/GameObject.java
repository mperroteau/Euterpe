package com.libgdx.fighter.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.fighter.Metadata;

public class GameObject {
	private int state;
	private Rectangle bound;
	private Metadata metaData;
	
	private GameObjectFrame[] frames;

	public static class Type{
		public static final int CHARACTER = 0;
		public static final int THROWABLE_LIGHT = 1;
		public static final int THROWABLE_HEAVY = 2;
		public static final int CHARACTER_MOVE = 3;
		public static final int THROWABLE_BALL = 4;
		public static final int OTHERS = 5;
		public static final int DRINKABLE = 6;
	}
	
	public static class State{
		public static final int STANDING = 0;
		public static final int WALKING = 1;
		public static final int RUNNING = 2;
		public static final int PUNCH = 3;
		public static final int JUMP = 4;
		public static final int DASH = 5;
		public static final int ROWING = 6;
		public static final int DEFEND = 7;
		public static final int BROKEN_DEFEND = 8;
		public static final int CATCHING = 9;
		public static final int CAUGHT = 10;
		public static final int INJURED = 11; //BEING HURT
		public static final int FALLING = 12; //HURT IN SKY
		public static final int ICE = 13;
		public static final int LYING = 14;
		public static final int VARIOUS = 15; //Can be iced, hurtable by ally
		public static final int FAINT = 16;	//Can be caught by enemy
		public static final int DRINKING = 17;
		public static final int FIRE = 18; //Being burnt, can hurt ally
		public static final int BURN_RUN = 19; //For firen only
		
		public static final int TELEPORT1 = 400; //To closet enemy, Woody
		public static final int TELEPORT2 = 401; //To closet ally
		
		public static final int TRANSFORM1 = 500; //Transform
		public static final int TRANSFORM2 = 501; //Transform back	
		
		public static final int LIGHT_WPN_SKY = 1000; //Light wpn on sky
		public static final int LIGHT_WPN_HAND = 1001; //Light wpn on hand
		public static final int LIGHT_WPN_THW = 1002; //Light wpn being thrown
		public static final int LIGHT_WPN_RB = 1003; //Light wpn rebound on ground
		public static final int LIGHT_WPN_GROUND = 1004; //Light wpn on the gorund
			
		public static final int SELF_HEAL = 1700; //John self heal
		
		
		public static final int HEAVY_WPN_SKY = 2000;
		public static final int HEAVY_WPN_HAND = 2001;
		public static final int HEAVY_WPN_GROUND = 2002;
		
		
		
		public static final int FLYING_BALL = 3000;
		public static final int FLYING_BALL_HIT_EXP = 3001; //Flying moves that hit enemy and explode
		public static final int FLYING_BALL_CANCEL = 3002;	//Flying moves cancelled and exploded
		public static final int FLYING_BALL_RB = 3003;	//Flying ball rebound and exploded
		public static final int FLYING_BALL_DIS = 3004; //Flying ball disappeared
		
		public static final int WIND_FLYING = 3005;
		public static final int SUPER_ARROW = 3006;
		
		public static final int TRANSFORM_LOUISEX = 9995;
		public static final int TRANSFORM_LOUIS_ARM = 9996; //Louis armor
		public static final int MESSAGE = 9997;
		public static final int DELETED = 9998;
		public static final int BROKEN_THING = 9999;
		
	}

	
	public GameObject(Metadata metaData){
		this.metaData = metaData;
		this.bound = new Rectangle();
//		this.bound.setWidth(metaData.get);
//		this.bound.setHeight(79);
	}
	
	

//	public TextureAtlas getTextureAtlas() {
//		return textureAtlas;
//	}
//
//	public void setTextureAtlas(TextureAtlas textureAtlas) {
//		this.textureAtlas = textureAtlas;
//	}

	public Rectangle getBound() {
		return bound;
	}

	public void setBound(Rectangle bound) {
		this.bound = bound;
	}

	public Metadata getMetadata() {
		return metaData;
	}

	public void setMetaData(Metadata metaData) {
		this.metaData = metaData;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public GameObjectFrame[] getFrames() {
		return frames;
	}

	public void setFrames(GameObjectFrame[] frames) {
		this.frames = frames;
	}
	
	public GameObjectFrame getFrame(int i){
		return this.frames[i];
	}
	
	public void setFrame(GameObjectFrame frame, int i){
		this.frames[i] = frame;
	}
	
}
