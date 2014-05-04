package com.libgdx.fighter;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraManager {
	private OrthographicCamera camera;
	
	public int camX;
	public int camY;
	private int camW;
	private int camH;
	public int offsetX;
	public int offsetY;
	
	public CameraManager(){
		
		this.camW = Config.VIRTAUL_MAP_WIDTH;
		this.camH = Config.VIRTUAL_MAP_HEIGHT;
		this.camX = Config.VIRTAUL_MAP_WIDTH/2;
		this.camY = Config.VIRTUAL_MAP_HEIGHT/2;
		
		
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Config.VIRTAUL_MAP_WIDTH, Config.VIRTUAL_MAP_HEIGHT);
		this.camera.viewportWidth = Config.VIRTAUL_MAP_WIDTH;
		this.camera.viewportHeight = Config.VIRTUAL_MAP_HEIGHT;
		this.camera.position.set(this.camX, this.camY, 0);
		this.camera.update();
	}
	
	public void updateCameraPosition(float playerX, float mapWidth){
		
		if(this.camX < mapWidth - this.camW/2){
			this.camX += (int)playerX;
		}
		
		if(this.camX > mapWidth/4){
			this.camX -= (int)playerX;
		}
		
		this.camera.position.set(this.camX, this.camY, 0);
		this.camera.update();
	}
}
