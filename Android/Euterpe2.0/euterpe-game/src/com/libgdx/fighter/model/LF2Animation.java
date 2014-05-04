package com.libgdx.fighter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.fighter.LF2Constants;

public class LF2Animation {
	private GameObject go;
	private GameObjectFrame[] gofs;
	private Texture[] textures; //All of the sprite files
	private TextureRegion[] keyFramesPic; //Split up sprites and put them into an single array
	private double lastKeyFrameDrawnTime = 0.0;
	private int currFrameNum = 0;
	
	private final double FRAME_PER_SEC = 30.0;
	
	public LF2Animation(GameObject go, AssetManager assets){
		this.go = go;
		this.gofs = this.go.getFrames();
		this.textures = new Texture[this.go.getMetadata().getNumOfFiles()];
		for(int i = 0; i < this.textures.length; i++){
			String fileName = this.go.getMetadata().getFileName(i);
			if(fileName == null){
				break;
			}
			this.textures[i] = assets.get(fileName, Texture.class);
		}
		
		populateTextureRegion();
	}
	
	/**
	 * 
	 * @param stateTime
	 * @param duration Duration of that frame
	 * @param currFrame current frame number
	 * @param nextFrameNum next frame to be fetched
	 * @return The pic number that should be drawn
	 */
	public TextureRegion getKeyFramePic(double stateTime, int wait, int currFrame, int nextFrameNum){
		int picNum = this.gofs[currFrame].pic;
		this.currFrameNum = currFrame;
		double realDuration = (wait + 1)/FRAME_PER_SEC;
//		this.lastKeyFrameDrawnTime = stateTime;
		
		if(stateTime >= lastKeyFrameDrawnTime + realDuration){
			this.currFrameNum = nextFrameNum;
			picNum = this.gofs[nextFrameNum].pic;
			this.lastKeyFrameDrawnTime = stateTime;
			return this.keyFramesPic[picNum];
		}
//		this.currFrameNum = currFrame;
		
		return this.keyFramesPic[picNum];
	}
	
	
	//Populate all the texture into texture regions
	private void populateTextureRegion(){
		int keyFrameIdx = 0;
		this.keyFramesPic = new TextureRegion[LF2Constants.MAX_FRAME];
		
		
		for(int i = 0; i < this.textures.length; i++){
			int tileWidth =  this.go.getMetadata().getKeyFrameWidthFrom(i);
			int tileHeight = this.go.getMetadata().getKeyFrameHeightFrom(i);
			int regionWidth = this.go.getMetadata().getRegionWidth(i);
			int regionHeight = this.go.getMetadata().getRegionHeight(i);
			
			//Skip all null frames
			if(this.textures[i] == null){
				continue;
			}
			
			TextureRegion tr = new TextureRegion(this.textures[i], 0, 0, regionWidth, regionHeight);			
			
			int x = tr.getRegionX();
			int y = tr.getRegionY();
			int rows = regionHeight / tileHeight;
			int cols = regionWidth / tileWidth;
			
			int startX = x;
			for (int row = 0; row < rows; row++, y += tileHeight) {
				x = startX;
				for (int col = 0; col < cols; col++, x += tileWidth) {
					this.keyFramesPic[keyFrameIdx++] = new TextureRegion(tr.getTexture(), x++, y, tileWidth, tileHeight);
				}
				y++;
			}
		}
	}

	public int getCurrFrameNum() {
		return currFrameNum;
	}

	public void setCurrFrameNum(int currFrameNum) {
		this.currFrameNum = currFrameNum;
	}
}
