package com.libgdx.fighter;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Rectangle;
import com.libgdx.fighter.model.GameObject;
import com.libgdx.fighter.model.GameObjectFrame;
import com.libgdx.fighter.model.LF2Actor;
import com.libgdx.fighter.model.LF2Character;
import com.libgdx.fighter.utils.CacheManager;

public class FightWorld {
//	private ArrayList<GameObject> gameObjects;
	private ArrayList<LF2Actor> lf2Actors;
	
	private ArrayList<Rectangle> mapLayers;
	
	private AssetManager assets;
	
	public FightWorld(AssetManager assets){
//		this.gameObjects = new ArrayList<GameObject>();
		this.mapLayers = new ArrayList<Rectangle>();
		
		this.assets = assets;
		this.lf2Actors = new ArrayList<LF2Actor>();
		
		initGameActors();
	}
	
	public void initGameActors(){
		LF2Actor actor1 = new LF2Actor((GameObject)CacheManager.get(0), this.assets);
		LF2Actor actor2 = new LF2Actor((GameObject)CacheManager.get(0), this.assets);
		
		this.lf2Actors.add(actor1);
		this.lf2Actors.add(actor2);
		
	}
	
	
	public void initTestingFW(){
		Metadata meta = new Metadata("Template", new String[]{"sprites/template0.png", "sprites/template1.png"});
		meta.setRegionSize(0, 800, 560); //Template sprite actual dimension: 800 * 560
		meta.setRegionSize(1, 800, 560); //Template sprite actual dimension: 800 * 560
		meta.setSpriteDimensionForFile(0, 79, 79); //Sprite dimension 79 * 79
		meta.setSpriteDimensionForFile(1, 79, 79); //Sprite dimension 79 * 79
		meta.setSpriteFromToForFile(0, 0, 69); //File 0, pic from 0  - 69
		meta.setSpriteFromToForFile(1, 70, 139); //File 1, pic from 70 - 139
		
		GameObjectFrame[] gof = new GameObjectFrame[4];
		gof[0] = new GameObjectFrame();
		gof[1] = new GameObjectFrame();
		gof[2] = new GameObjectFrame();
		gof[3] = new GameObjectFrame();
		
		gof[0].pic = 0;
		gof[0].next = 1;
		gof[0].wait = 3;
		
		gof[1].pic = 1;
		gof[1].next = 2;
		gof[1].wait = 3;
		
		gof[2].pic = 2;
		gof[2].next = 3;
		gof[2].wait = 3;
		
		gof[3].pic = 3;
		gof[3].next = 0;
		gof[3].wait = 3;
		
		LF2Character c = new LF2Character(meta);
		c.setFrames(gof);
//		this.gameObjects.add(c);
		
		Rectangle ground1 = new Rectangle(0,40, 800, 115);
		Rectangle ground2 = new Rectangle(800,40, 800, 115);
		
		Rectangle ground3 = new Rectangle(0,155, 750, 66);
		Rectangle ground4 = new Rectangle(750,155, 750, 66);
		
		this.mapLayers.add(ground1);
		this.mapLayers.add(ground2);
		this.mapLayers.add(ground3);
		this.mapLayers.add(ground4);
		
		CacheManager.get(0);
	}
	
//	public ArrayList<GameObject> getGameObjects(){
//		return this.gameObjects;
//	}
	
//	public GameObject getGameObject(int i){
//		return this.gameObjects.get(i);
//	}
	
	public ArrayList<Rectangle> getMapLayers(){
		return this.mapLayers;
	}
	
	public Rectangle getMapLayer(int i){
		return this.mapLayers.get(i);
	}
	
	public ArrayList<LF2Actor> getActors(){
		return this.lf2Actors;
	}
	
	public LF2Actor getActor(int i){
		return this.lf2Actors.get(i);
	}
	
}
