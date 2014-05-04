package com.libgdx.fighter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.libgdx.fighter.LF2Constants;
import com.libgdx.fighter.Metadata;
import com.libgdx.fighter.model.GameObject;
import com.libgdx.fighter.model.GameObjectFrame;
import com.libgdx.fighter.model.LF2Character;

public class ObjectParser_BK {
	private final static int DEFAULT_BUFFER = 8192;
	
	private static HashMap<String, String> mapBuffer = new HashMap<String, String>();
		
	private final static int TOKEN_NONE = 0;
	private final static int TOKEN_COLON = 1;
	private final static int TOKEN_SPACE = 2;
	private final static int TOKEN_HASH = 3;
	private final static int TOKEN_TAB = 4;
	private final static int TOKEN_OPEN_PARAN = 5;
	private final static int TOKEN_CLOSE_PARAN = 6;
	private final static int TOKEN_HYPHEN = 7;
	
	
	public static void parseLine(String line){
		StringBuffer attr = new StringBuffer();
		StringBuffer value = new StringBuffer();
		
		
		
		boolean isColonReached = false;
		boolean isHashReached = false;
		
		for(int i = 0; i < line.length(); i++){
			char c = line.charAt(i);
			if(nextToken(c) == TOKEN_HASH){
				isHashReached = true;
				continue;
			}
			
			if(nextToken(c) == TOKEN_SPACE || nextToken(c) == TOKEN_TAB){
				if(attr.length() != 0 && value.length() != 0){
//					System.out.println("Attribute: " + attr.toString());
//					System.out.println("Value: " + value.toString());
//					System.out.println();
					mapBuffer.put(attr.toString(), value.toString());
					attr.delete(0, attr.length());
					value.delete(0, value.length());
					isColonReached = false; //Reset for next value
				}
				continue;
			}
			
			if(nextToken(c) == TOKEN_COLON){
				isColonReached = true; //Start to read value
				continue;
			}
			
			if(nextToken(c) == TOKEN_NONE && isColonReached && (!isHashReached)){
				value.append(c);
				continue;
			}else if(nextToken(c) == TOKEN_NONE && !isColonReached && (!isHashReached)){
				attr.append(c);
				continue;
			}
		}
		
		if(attr.length() != 0  && value.length() != 0){
			mapBuffer.put(attr.toString(), value.toString());
//			System.out.println("Line : '" + line + "' parsed.\n");
		}else if(isHashReached){
//			System.out.println("Line : '" + line + "' parsed.\n");
		}
	}
	
	
	private static int nextToken(char c){
		
		switch(c){
		case '\t':
			return TOKEN_TAB;
		case ' ':
			return TOKEN_SPACE;
		case '#':
			return TOKEN_HASH;
		case ':':
			return TOKEN_COLON;
		case '(':
			return TOKEN_OPEN_PARAN;
		case ')':
			return TOKEN_CLOSE_PARAN;
		case '-':
			return TOKEN_HYPHEN;
		default:
			return TOKEN_NONE;
		}
	}
	
	/**
	 * 
	 * @param fileName Meta data file name
	 * @throws IOException
	 */
	public void preLoadGameObject(String fileName) throws IOException{
		FileHandle h = Gdx.files.internal(fileName);
		
		BufferedReader br = h.reader(DEFAULT_BUFFER);
		String currLine;
		String currTag = "";
		
		while ((currLine = br.readLine()) != null){
			if(currLine.equals("")){
				continue;
			}
			if(currLine.equals(LF2Constants.GameDataConstant.OBJECT)){
				currTag = LF2Constants.GameDataConstant.OBJECT;
				continue;
			}
			
			if(currLine.contains(LF2Constants.GameDataConstant.END)){
				currTag = currTag + LF2Constants.GameDataConstant.END;
			}
			
			if(currTag.equals(LF2Constants.GameDataConstant.OBJECT)){
				parseLine(currLine);
				
				int id = Integer.parseInt(mapBuffer.get(LF2Constants.GameDataConstant.ID));
				int type = Integer.parseInt(mapBuffer.get(LF2Constants.GameDataConstant.TYPE));
				String file = mapBuffer.get(LF2Constants.GameDataConstant.FILE);
				String name = file.split("\\\\")[1];
				
//				for(String key : mapBuffer.keySet()){
//					System.out.println("Attr " + key);
//					System.out.println("Value " + mapBuffer.get);
//				}
				String[] files = new String[LF2Constants.MAX_SPRITE_FILES];
				Metadata metaData = new Metadata(files);
				metaData.id = id;
				metaData.type = type;
				metaData.name = name;
				
				mapBuffer.clear();
				createGameObjectFromFile(metaData, file);
				
			}
			
		}
	}
	
	//Parse file line, set up sprite from to
	private String parseFileLine(Metadata metaData, String fileLine, int fileNum){
		int spriteStart;
		int spriteEnd;
		int width, height;
		
		StringBuffer sbStart = new StringBuffer();
		StringBuffer sbEnd  = new StringBuffer();
		
		StringBuffer fileTag = new StringBuffer();
		
		boolean isOpenParan = false;
		boolean isCloseParan = false;
		boolean isHyphen = false;
		boolean isColon = false;
		
		for(int i = 0; i < fileLine.length(); i++){
			char c = fileLine.charAt(i);
			
			if(!isCloseParan){
				fileTag.append(c);
			}
			
			if(nextToken(c) == TOKEN_OPEN_PARAN){
				isOpenParan = true;
				continue;
			}
			
			if(nextToken(c) == TOKEN_HYPHEN){
				isOpenParan = false;
				isHyphen = true;
				continue;
			}
			
			if(nextToken(c) == TOKEN_CLOSE_PARAN){
				isHyphen = false;
				isCloseParan = true;
				continue;
			}
			
			if(nextToken(c) == TOKEN_COLON){
//				isCloseParan = false;
				isColon = true;
				continue;
			}
			
			 
			
			if(isOpenParan){
				sbStart.append(c);
			}
			
			if(isHyphen){
				sbEnd.append(c);
			}
			
		}
		
		
		spriteStart = Integer.parseInt(sbStart.toString());
		spriteEnd = Integer.parseInt(sbEnd.toString());
		
		
		
		metaData.setSpriteFromToForFile(fileNum, spriteStart, spriteEnd);
		return fileTag.toString();
//		metaData.setRegionSize(fileNum, , height);
	}
	
	private GameObjectFrame processFrame(ArrayList<String> frameStrTemp){
		GameObjectFrame frame = new GameObjectFrame();
		String currTag = "";
		
		for(int i = 0; i < frameStrTemp.size(); i++){
			String line = frameStrTemp.get(i);
			
			if(line.equals("bpoint:") 
					|| line.equals("opoint:") 
					|| line.equals("wpoint:") 
					|| line.equals("bdy:") 
					|| line.equals("itr:")
					|| line.equals("")){
				currTag = line;
			}
			
		}
		
		return frame;
	}
	
	private void createGameObjectFromFile(Metadata metaData, String fileName) throws IOException{
		FileHandle fh = Gdx.files.internal(fileName);
		
		BufferedReader br = fh.reader(DEFAULT_BUFFER);
		String currLine;
		String currTag = "";
		
		int fileCount = 0, frameNum = 0, prevFrameNum = -1;
		
		GameObject go = null;
		ArrayList<GameObjectFrame> frames = new ArrayList<GameObjectFrame>();
		ArrayList<String> frameStrTemp = new ArrayList<String>();
		if(metaData.type == GameObject.Type.CHARACTER){
			go = new LF2Character(metaData);
		}else if(metaData.type == GameObject.Type.CHARACTER_MOVE){
			
		}else if(metaData.type == GameObject.Type.THROWABLE_HEAVY){
			
		}else if(metaData.type == GameObject.Type.THROWABLE_LIGHT){
			
		}else if(metaData.type == GameObject.Type.THROWABLE_BALL){
			
		}else if(metaData.type == GameObject.Type.OTHERS){
			
		}
		
		while ((currLine = br.readLine()) != null){
			if(currLine.equals("")){
				continue; //Skip for line break
			}
			
			if(currLine.equals(LF2Constants.GameDataConstant.BMP_BEGIN)){
				currTag = LF2Constants.GameDataConstant.BMP_BEGIN;
				continue;
			}else if(currLine.contains(LF2Constants.GameDataConstant.FRAME)){
				currTag = LF2Constants.GameDataConstant.FRAME;
				continue;
			}else if(currLine.equals(LF2Constants.GameDataConstant.FRAME_END)){
				currTag = LF2Constants.GameDataConstant.FRAME_END;
			}

			
			if(currTag.contains(LF2Constants.GameDataConstant.FRAME) && !currTag.contains(LF2Constants.GameDataConstant.FRAME_END)){
				//Storing the frame elements for later processing
				frameStrTemp.add(currLine);
				continue;
			}
			//Now, end of frame, can process at once
			if(currTag.equals(LF2Constants.GameDataConstant.FRAME_END)){
				GameObjectFrame frame = processFrame(frameStrTemp);
				frames.add(frame);
				
				//Process complete, empty it
				frameStrTemp.clear();
			}
			
			//End of BMP tag, now populate the data to metadata and game object
			if(currTag.equals(LF2Constants.GameDataConstant.BMP_END)){

				currTag = LF2Constants.GameDataConstant.BMP_END;
				if(metaData.type == GameObject.Type.CHARACTER){

					LF2Character c = (LF2Character)go;
					c.getMetadata().name = mapBuffer.get(LF2Constants.GameDataConstant.NAME);
			
					c.walking_frame_rate = Integer.parseInt(mapBuffer.get(LF2Constants.GameDataConstant.WALKING_FRAME_RATE));
					c.walking_speed = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.WALKING_SPEED));
					c.walking_speedz = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.WALKING_SPEEDZ));
					c.running_frame_rate = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.RUNNING_FRAME_RATE));
					c.running_speed = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.RUNNING_SPEED));
					c.running_speedz = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.RUNNING_SPEEDZ));
					c.heavy_walking_speed = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.HEAVY_WALKING_SPEED));
					c.heavy_walking_speedz = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.HEAVY_WALKING_SPEEDZ));
					c.heavy_running_speed = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.HEAVY_RUNNING_SPEED));
					c.heavy_running_speedz = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.HEAVY_RUNNING_SPEEDZ));
					c.jump_height = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.JUMP_HEIGHT));
					c.jump_distance = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.JUMP_DISTANCE));
					c.jump_distancez = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.JUMP_DISTANCEZ));
					c.dash_height = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.DASH_HEIGHT));
					c.dash_distance = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.DASH_DISTANCE));
					c.dash_distancez = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.DASH_DISTANCEZ));
					c.rowing_height = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.ROWING_HEIGHT));
					c.rowing_distance = Float.parseFloat(mapBuffer.get(LF2Constants.GameDataConstant.ROWING_DISTANCE));


				}else if(metaData.type == GameObject.Type.CHARACTER_MOVE){
					
				}else if(metaData.type == GameObject.Type.THROWABLE_HEAVY){
					
				}else if(metaData.type == GameObject.Type.THROWABLE_LIGHT){
					
				}else if(metaData.type == GameObject.Type.THROWABLE_BALL){
					
				}else if(metaData.type == GameObject.Type.OTHERS){
					
				}
			}
			
			parseLine(currLine);
			if(currLine.contains(LF2Constants.GameDataConstant.FILE) && metaData.type == GameObject.Type.CHARACTER){
				String path = parseFileLine(metaData, currLine, fileCount);
				int w, h;
				w = Integer.parseInt(mapBuffer.get(LF2Constants.GameDataConstant.W));
				h = Integer.parseInt(mapBuffer.get(LF2Constants.GameDataConstant.H));
				
				
				metaData.setFile(fileCount, path);
				metaData.setSpriteDimensionForFile(fileCount, w, h);
				
				fileCount++;
				continue;
			}
			
		}
		
		if(go != null){
			go.setFrames(frames.toArray(new GameObjectFrame[frames.size()]));
		}
		
		
		CacheManager.put(metaData.id, go);
	}
	
}
