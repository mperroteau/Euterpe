package com.libgdx.fighter;

public class Metadata {
	public int id;
	public int type;
	public String name;
	private String[] files;
	
	//Widths and heights of the sprite in particular file
	private int[] widths;
	private int[] heights;
	
	private int[][] frameFromTo; //Frame from to
	
	private int[] regionWidths;
	private int[] regionHeights;
	
	public Metadata(){
		
	}
	
	public Metadata(String[] files){
		this.name = "";
		this.files = files;
		this.widths = new int[this.files.length];
		this.heights = new int[this.files.length];
		this.frameFromTo = new int[this.files.length][2];
		
		this.regionWidths = new int[this.files.length];	//NPOT width
		this.regionHeights = new int[this.files.length];	//NPOT height
	}
	
	public Metadata(String name, String[] files){
		this(files);
		this.name = name;
	}
	
	public int getKeyFrameWidthFrom(int num){
		return this.widths[num];
	}
	
	public int getNumOfFiles(){
		return this.files.length;
	}
	
	public String getFileName(int i){
		return this.files[i];
	}
	
	/**
	 * 
	 * @param num Texture file number
	 * @return Height of pic
	 */
	public int getKeyFrameHeightFrom(int num){
		return this.heights[num];
	}
	
	public int getRegionWidth(int num){
		return this.regionWidths[num];
	}
	
	public int getRegionHeight(int num){
		return this.regionHeights[num];
	}
	
	public void setRegionHeight(int num, int height){
		this.regionHeights[num] = height;
	}
	
	public void setRegionWidth(int num, int width){
		this.regionWidths[num] = width;
	}
	
	public void setRegionSize(int num, int width, int height){
		this.regionHeights[num] = height;
		this.regionWidths[num] = width;
	}
	
	/**
	 * 
	 * @param fileNum 
	 * @param from From frame
	 * @param to To frame
	 */
	public void setSpriteFromToForFile(int fileNum, int from, int to){
		this.frameFromTo[fileNum][0] = from;
		this.frameFromTo[fileNum][1] = to;
	}
	
	public void setSpriteDimensionForFile(int fileNum, int width, int height){
		this.widths[fileNum] = width;
		this.heights[fileNum] = height;
	}
	
	/**
	 * 
	 * @param fileNum File number
	 * @return The From frame of that file
	 */
	public int getSpriteFromFrameForFile(int fileNum){
		return this.frameFromTo[fileNum][0];
	}
	
	/**
	 * 
	 * @param fileNum File number
	 * @return The To frame of that file
	 */
	public int getSpriteToFrameForFile(int fileNum){
		return this.frameFromTo[fileNum][1];
	}
	
	
	public int getTotalFrame(){
		//Return the last file num
		return this.frameFromTo[this.files.length - 1][1] + 1;
	}
	
	public void setFile(int fileNum, String path){
		this.files[fileNum] = path;
	}
	
	public String getFile(int fileNum){
		return this.files[fileNum];
	}
}
