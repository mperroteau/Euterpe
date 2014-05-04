package com.libgdx.fighter.utils;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.libgdx.fighter.LF2Constants;
import com.libgdx.fighter.Metadata;
import com.libgdx.fighter.model.GameObject;
import com.libgdx.fighter.model.GameObjectFrame;
import com.libgdx.fighter.model.GameObjectFrame.GameObjectBody;
import com.libgdx.fighter.model.GameObjectFrame.GameObjectInteraction;
import com.libgdx.fighter.model.LF2Character;
import com.libgdx.fighter.model.Moves;
import com.libgdx.fighter.model.Weapon;
import com.libgdx.fighter.model.Weapon.LF2Entry;

public class ObjectParser implements Runnable{
	
	private HashMap<String, String> attrValuePair;
//	private HashMap<String, String> frameAttrValuePair;
	private final String TOKEN_SPACE = " +";
	private final String TOKEN_HASH = "#";
	private final String TOKEN_LINE_BREAK = "\r\n";
	private final String TOKEN_OPEN_PARAN = "(";
	private final String TOKEN_HYPHEN = "-";
	private final String TOKEN_CLOSE_PARAN = ")";
//	private final int NORMAL_MODE = 0;
//	private final int FRAME_MODE = 1;
	
	public ObjectParser(){
		this.attrValuePair = new HashMap<String, String>();
//		this.frameAttrValuePair = new HashMap<String, String>();
	}
	
	//Specific for file(x-y)
	public String parseFileLine(String line, Metadata metaData, int fileNum){		
		int w = 0, h = 0, row = 0, col = 0;
		int from = 0, to = 0;
		String fileName = "";
		
		String[] attrs = line.split(TOKEN_SPACE);
		
		for(int i = 0; i < attrs.length; i++){
			if(attrs[i].contains(LF2Constants.GameDataConstant.FILE)){
				
				int idxOpenParan = attrs[i].indexOf(TOKEN_OPEN_PARAN);
				int idxHyphen = attrs[i].indexOf(TOKEN_HYPHEN);
				int idxCloseParan = attrs[i].indexOf(TOKEN_CLOSE_PARAN);
				
				String fromStr = attrs[i].substring(idxOpenParan + 1, idxHyphen);
				String toStr = attrs[i].substring(idxHyphen + 1, idxCloseParan);
				
				from = Integer.parseInt(fromStr);
				to = Integer.parseInt(toStr);
				
				fileName = attrs[++i];
			}else if(attrs[i].equals(LF2Constants.GameDataConstant.W)){
				w = Integer.parseInt(attrs[++i]);
			}else if(attrs[i].equals(LF2Constants.GameDataConstant.H)){
				h = Integer.parseInt(attrs[++i]);
			}else if(attrs[i].equals(LF2Constants.GameDataConstant.ROW)){
				row = Integer.parseInt(attrs[++i]);
			}else if(attrs[i].equals(LF2Constants.GameDataConstant.COL)){
				col = Integer.parseInt(attrs[++i]);
			}
		}
		
		
		
		metaData.setFile(fileNum, fileName.replaceAll("\\\\", "/"));
		metaData.setSpriteDimensionForFile(fileNum, w, h);
		metaData.setSpriteFromToForFile(fileNum, from, to);
		
		metaData.setRegionSize(fileNum, (w + 1) * row, (h + 1) * col);
		
		return fileName;
	}
	
	public void parseLine(String line){
		
		String attr = "", value = "";
		
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(line);
		while(st.hasMoreElements()){
			if(count % 2 == 0){
				attr = st.nextToken();
			}else{
				value = st.nextToken();
				this.attrValuePair.put(attr, value);
			}
			count++;
		}
		
	}
	
	private int getIntFromKey(String key){
		String str = this.attrValuePair.get(key);
		
		if(str == null){
			return LF2Constants.NO_MOVE;
		}else{
			try{
				return Integer.parseInt(str);
			}catch (NumberFormatException nfe){
				return LF2Constants.NO_MOVE;
			}
		}	
	}
	
	private float getFloatFromKey(String key){
		String str = this.attrValuePair.get(key);
		
		if(str == null){
			return LF2Constants.NO_MOVE;
		}else{
			try{
				return Float.parseFloat(str);
			}catch (NumberFormatException nfe){
				return LF2Constants.NO_MOVE;
			}
		}
	}
	
	
	private String getStrFromKey(String key){
		return this.attrValuePair.get(key);
	}
	
	private void clearAttrValueMap(){
		this.attrValuePair.clear();
	}
	
	private void prepareFrame(GameObjectFrame gof, String line, String currFrameTag){
		
		//Picture line
		if(line.contains(LF2Constants.GameDataConstant.PIC)){
			parseLine(line);
			gof.pic = this.getIntFromKey(LF2Constants.GameDataConstant.PIC);
			gof.state = this.getIntFromKey(LF2Constants.GameDataConstant.STATE);
			gof.wait = this.getIntFromKey(LF2Constants.GameDataConstant.WAIT);
			gof.next = this.getIntFromKey(LF2Constants.GameDataConstant.NEXT);
			gof.dvx = this.getIntFromKey(LF2Constants.GameDataConstant.DVX);
			gof.dvy = this.getIntFromKey(LF2Constants.GameDataConstant.DVY);
			gof.dvz = this.getIntFromKey(LF2Constants.GameDataConstant.DVZ);
			gof.centerx = this.getIntFromKey(LF2Constants.GameDataConstant.CENTERX);
			gof.centery = this.getIntFromKey(LF2Constants.GameDataConstant.CENTERY);
			
			gof.hit_a = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_A);
			gof.hit_d = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_D);
			gof.hit_j = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_J);
			
			gof.hit_Da = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_DA);
			gof.hit_Dj = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_DJ);
			
			gof.hit_Fa = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_FA);
			gof.hit_Fj = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_FJ);
			
			gof.hit_Ua = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_UA);
			gof.hit_Uj = this.getIntFromKey(LF2Constants.GameDataConstant.HIT_UJ);
			
			gof.mp = this.getIntFromKey(LF2Constants.GameDataConstant.MP);
			
			clearAttrValueMap();
			return;
		}
		
		if(line.contains(LF2Constants.GameDataConstant.SOUND)){
			parseLine(line);
			gof.sound = this.getStrFromKey(LF2Constants.GameDataConstant.SOUND);
			clearAttrValueMap();
			
			return;
		}
		
		if(currFrameTag.contains(LF2Constants.GameDataConstant.WPOINT)){
			parseLine(line);
			
			gof.wpoint.kind = this.getIntFromKey(LF2Constants.GameDataConstant.KIND);
			gof.wpoint.x = this.getIntFromKey(LF2Constants.GameDataConstant.X);
			gof.wpoint.y = this.getIntFromKey(LF2Constants.GameDataConstant.Y);
			gof.wpoint.weaponact = this.getIntFromKey(LF2Constants.GameDataConstant.WEAPONACT);
			gof.wpoint.attacking = this.getIntFromKey(LF2Constants.GameDataConstant.ATTACKING);
			gof.wpoint.cover = this.getIntFromKey(LF2Constants.GameDataConstant.COVER);
			gof.wpoint.dvx = this.getIntFromKey(LF2Constants.GameDataConstant.DVX);
			gof.wpoint.dvy = this.getIntFromKey(LF2Constants.GameDataConstant.DVY);
			gof.wpoint.dvz = this.getIntFromKey(LF2Constants.GameDataConstant.DVZ);
			
			clearAttrValueMap();
			
			return;
		}
		
		if(currFrameTag.contains(LF2Constants.GameDataConstant.OPOINT)){
			parseLine(line);
			
			gof.opoint.kind = this.getIntFromKey(LF2Constants.GameDataConstant.KIND);
			gof.opoint.x = this.getIntFromKey(LF2Constants.GameDataConstant.X);
			gof.opoint.y = this.getIntFromKey(LF2Constants.GameDataConstant.Y);
			gof.opoint.dvx = this.getIntFromKey(LF2Constants.GameDataConstant.DVX);
			gof.opoint.dvy = this.getIntFromKey(LF2Constants.GameDataConstant.DVY);
			gof.opoint.oid = this.getIntFromKey(LF2Constants.GameDataConstant.OID);
			
			clearAttrValueMap();
			
			return;
		}
		
		if(currFrameTag.contains(LF2Constants.GameDataConstant.BDY)){
			GameObjectBody bdy = gof.new GameObjectBody(); 
			parseLine(line);
			
			bdy.kind = this.getIntFromKey(LF2Constants.GameDataConstant.KIND);
			bdy.x = this.getIntFromKey(LF2Constants.GameDataConstant.X);
			bdy.y = this.getIntFromKey(LF2Constants.GameDataConstant.Y);
			bdy.w = this.getIntFromKey(LF2Constants.GameDataConstant.W);
			bdy.h = this.getIntFromKey(LF2Constants.GameDataConstant.H);
			
			gof.addBdy(bdy);
			
			clearAttrValueMap();
			
			return;
		}
		
		if(currFrameTag.contains(LF2Constants.GameDataConstant.BPOINT)){
			parseLine(line);
			
			gof.bpoint.x = this.getIntFromKey(LF2Constants.GameDataConstant.X);
			gof.bpoint.y = this.getIntFromKey(LF2Constants.GameDataConstant.Y);
			
			clearAttrValueMap();
			
			return;
		}
		
		if(currFrameTag.contains(LF2Constants.GameDataConstant.ITR)){
			if(line.contains(LF2Constants.GameDataConstant.CATCHINGACT) 
					|| line.contains(LF2Constants.GameDataConstant.CATCHINGACT)){
				Scanner scanner = new Scanner(line.trim());
				
				//catchingact: %d %d  caughtact: %d %d
				scanner.next();
				gof.getLastItr().catchingact1 = scanner.nextInt();
				gof.getLastItr().catchingact2 = scanner.nextInt();
				
				scanner.next();
				gof.getLastItr().caughtact1 = scanner.nextInt();
				gof.getLastItr().caughtact2 = scanner.nextInt();
				
				return;
				
			}
			
			if(line.contains(LF2Constants.GameDataConstant.EFFECT)){
				
				//The effect attribute is at the beginning of the element
				if(line.trim().indexOf(LF2Constants.GameDataConstant.EFFECT) == 0){
					Scanner scanner = new Scanner(line.trim());
					
					//Effect is on a new line
					scanner.next();
					gof.getLastItr().effect = scanner.nextInt();
					
					return;
				}
			}
			
			//Effect attribute is on the same line
			GameObjectInteraction itr = gof.new GameObjectInteraction();
			parseLine(line);
			
			itr.kind = this.getIntFromKey(LF2Constants.GameDataConstant.KIND);
			itr.x = this.getIntFromKey(LF2Constants.GameDataConstant.X);
			itr.y = this.getIntFromKey(LF2Constants.GameDataConstant.Y);
			itr.w = this.getIntFromKey(LF2Constants.GameDataConstant.W);
			itr.h = this.getIntFromKey(LF2Constants.GameDataConstant.H);
			itr.dvx = this.getIntFromKey(LF2Constants.GameDataConstant.DVX);
			itr.dvy = this.getIntFromKey(LF2Constants.GameDataConstant.DVY);
			itr.bdefend = this.getIntFromKey(LF2Constants.GameDataConstant.BDEFEND);
			itr.fall = this.getIntFromKey(LF2Constants.GameDataConstant.FALL);
			itr.arest = this.getIntFromKey(LF2Constants.GameDataConstant.AREST);
			itr.vrest = this.getIntFromKey(LF2Constants.GameDataConstant.VREST);
			itr.effect = this.getIntFromKey(LF2Constants.GameDataConstant.EFFECT);
			itr.zwidth = this.getIntFromKey(LF2Constants.GameDataConstant.ZWIDTH);
			itr.injury = this.getIntFromKey(LF2Constants.GameDataConstant.INJURY);
			
			
			gof.addItr(itr);
			clearAttrValueMap();
			
			return;
		}
	}
	
	private void setCharacterBMPBegin(LF2Character c){
		c.getMetadata().name = this.getStrFromKey(LF2Constants.GameDataConstant.NAME);
		
		c.walking_frame_rate = this.getIntFromKey(LF2Constants.GameDataConstant.WALKING_FRAME_RATE);
		c.walking_speed = this.getFloatFromKey(LF2Constants.GameDataConstant.WALKING_SPEED);
		c.walking_speedz = this.getFloatFromKey(LF2Constants.GameDataConstant.WALKING_SPEEDZ);
		c.running_frame_rate = this.getFloatFromKey(LF2Constants.GameDataConstant.RUNNING_FRAME_RATE);
		c.running_speed = this.getFloatFromKey(LF2Constants.GameDataConstant.RUNNING_SPEED);
		c.running_speedz = this.getFloatFromKey(LF2Constants.GameDataConstant.RUNNING_SPEEDZ);
		c.heavy_walking_speed = this.getFloatFromKey(LF2Constants.GameDataConstant.HEAVY_WALKING_SPEED);
		c.heavy_walking_speedz = this.getFloatFromKey(LF2Constants.GameDataConstant.HEAVY_WALKING_SPEEDZ);
		c.heavy_running_speed = this.getFloatFromKey(LF2Constants.GameDataConstant.HEAVY_RUNNING_SPEED);
		c.heavy_running_speedz = this.getFloatFromKey(LF2Constants.GameDataConstant.HEAVY_RUNNING_SPEEDZ);
		c.jump_height = this.getFloatFromKey(LF2Constants.GameDataConstant.JUMP_HEIGHT);
		c.jump_distance = this.getFloatFromKey(LF2Constants.GameDataConstant.JUMP_DISTANCE);
		c.jump_distancez = this.getFloatFromKey(LF2Constants.GameDataConstant.JUMP_DISTANCEZ);
		c.dash_height = this.getFloatFromKey(LF2Constants.GameDataConstant.DASH_HEIGHT);
		c.dash_distance = this.getFloatFromKey(LF2Constants.GameDataConstant.DASH_DISTANCE);
		c.dash_distancez = this.getFloatFromKey(LF2Constants.GameDataConstant.DASH_DISTANCEZ);
		c.rowing_height = this.getFloatFromKey(LF2Constants.GameDataConstant.ROWING_HEIGHT);
		c.rowing_distance = this.getFloatFromKey(LF2Constants.GameDataConstant.ROWING_DISTANCE);		
	}
	
	
	private void setWeaponBMPBegin(Weapon w){
		w.weapon_hp = this.getIntFromKey(LF2Constants.GameDataConstant.WEAPON_HP);
		w.weapon_drop_hurt = this.getIntFromKey(LF2Constants.GameDataConstant.WEAPON_DROP_HURT);
		w.weapon_hit_sound = this.getStrFromKey(LF2Constants.GameDataConstant.WEAPON_HIT_SOUND);
		w.weapon_broken_sound = this.getStrFromKey(LF2Constants.GameDataConstant.WEAPON_BROKEN_SOUND);
		w.weapon_drop_sound = this.getStrFromKey(LF2Constants.GameDataConstant.WEAPON_DROP_SOUND); 
		w.weapon_broken_sound = this.getStrFromKey(LF2Constants.GameDataConstant.WEAPON_BROKEN_SOUND);
	}
	
	private void setWeaponStrengthEntry(LF2Entry e){
		// dvx: 2  fall: 40  vrest: 10 bdefend: 16  injury: 40
		e.dvx = this.getIntFromKey(LF2Constants.GameDataConstant.DVX);
		e.dvy = this.getIntFromKey(LF2Constants.GameDataConstant.DVY);
		e.vrest = this.getIntFromKey(LF2Constants.GameDataConstant.VREST);
		e.bdefend = this.getIntFromKey(LF2Constants.GameDataConstant.BDEFEND);
		e.injury = this.getIntFromKey(LF2Constants.GameDataConstant.INJURY);
		e.arest = this.getIntFromKey(LF2Constants.GameDataConstant.AREST);
	}
	
	
	private boolean isWeapon(int type){
		return (type == GameObject.Type.THROWABLE_BALL
				|| type == GameObject.Type.DRINKABLE
				|| type == GameObject.Type.THROWABLE_HEAVY 
				|| type == GameObject.Type.THROWABLE_LIGHT);
	}
	
	public void prepareGameObject(String fileName, int id, int type){
		
		Metadata metaData = new Metadata(new String[LF2Constants.MAX_SPRITE_FILES]);
		metaData.id = id;
		GameObject go = null;
		FileHandle fh = Gdx.files.internal(fileName);
		String file = fh.readString();
		String[] lines = file.split(TOKEN_LINE_BREAK);
		String currTag = "";
		String currFrameTag = "";
		GameObjectFrame[] gofs = new GameObjectFrame[LF2Constants.MAX_FRAME];
		int fileNum = 0, frameNum = 0, weaponStrengthListCount = 0;
		
		
		
		
		if(type == GameObject.Type.CHARACTER){			
			go = new LF2Character(metaData);
		}else if(type == GameObject.Type.CHARACTER_MOVE){
			go = new Moves(metaData);
		}else if(isWeapon(type)){
			go = new Weapon(metaData);			
		}else if(type == GameObject.Type.CHARACTER_MOVE){
			go = new Moves(metaData);
		}else if(type == GameObject.Type.OTHERS){
			go = null;
		}
		
				
		for(int i = 0; i < lines.length; i++){
			String str = lines[i];
			
			if(str.equals(LF2Constants.GameDataConstant.BMP_BEGIN) 
					|| str.contains(LF2Constants.GameDataConstant.FRAME)
					|| str.equals(LF2Constants.GameDataConstant.WEAPON_STRENGTH_LIST)){
				currTag = str;
				if(str.contains(LF2Constants.GameDataConstant.FRAME)){
					//TODO: refactor later
					frameNum = Integer.parseInt(str.split(TOKEN_SPACE)[1]);
				}
				continue;
			}else if(str.equals(LF2Constants.GameDataConstant.BMP_END) 
					|| str.equals(LF2Constants.GameDataConstant.FRAME_END)
					|| str.equals(LF2Constants.GameDataConstant.WEAPON_STRENGTH_LIST_END)){
				currTag = str;
				continue;
			}
			
			
			if(currTag.equals(LF2Constants.GameDataConstant.BMP_END)){
				
				if(type == GameObject.Type.CHARACTER){
					setCharacterBMPBegin((LF2Character)go);		
				}else if(isWeapon(type)){
					setWeaponBMPBegin((Weapon)go);
				}
						
			}
			
			if(currTag.equals(LF2Constants.GameDataConstant.BMP_BEGIN)){
				if(str.contains("file(")){
					parseFileLine(str, metaData, fileNum);
					fileNum++;
				}else{
					parseLine(str);
				}
				
			}else if(currTag.contains(LF2Constants.GameDataConstant.FRAME)){
				if(gofs[frameNum] == null){
					gofs[frameNum] = new GameObjectFrame();
					prepareFrame(gofs[frameNum], str, currFrameTag);
				}else{
					GameObjectFrame gof = gofs[frameNum];
					gof.frameId = frameNum;
					if(str.contains(LF2Constants.GameDataConstant.OPOINT)
							|| str.contains(LF2Constants.GameDataConstant.WPOINT)
							|| str.contains(LF2Constants.GameDataConstant.ITR)
							|| str.contains(LF2Constants.GameDataConstant.BDY)){
						currFrameTag = str.trim();
						continue;
					}
					
					if(str.contains(LF2Constants.GameDataConstant.OPOINT_END)
							|| str.contains(LF2Constants.GameDataConstant.WPOINT_END)
							|| str.contains(LF2Constants.GameDataConstant.ITR_END)
							|| str.contains(LF2Constants.GameDataConstant.BDY_END)){
						currFrameTag = str.trim();
						continue;
					}
					prepareFrame(gof, str, currFrameTag);
				}
				
			}else if(currTag.equals(LF2Constants.GameDataConstant.WEAPON_STRENGTH_LIST)){
				if(str.contains(LF2Constants.GameDataConstant.ENTRY)){
					Weapon w = (Weapon)go;
					LF2Entry e = w.new LF2Entry();
					
					w.addEntry(e);
					
				}else{
					parseLine(str);
					
					Weapon w = (Weapon)go;
					LF2Entry e = w.getEntry(weaponStrengthListCount);
					
					setWeaponStrengthEntry(e);
					
					weaponStrengthListCount++;
				}
			}
			
			if(currTag.equals(LF2Constants.GameDataConstant.FRAME_END)){
				currTag = LF2Constants.GameDataConstant.FRAME_END;
			}
			
			if(currTag.equals(LF2Constants.GameDataConstant.WEAPON_STRENGTH_LIST_END)){
				currTag = LF2Constants.GameDataConstant.WEAPON_STRENGTH_LIST_END;
			}
			
		}
		
		if(go != null){
			go.setFrames(gofs);
			CacheManager.put(metaData.id, go);
		}
		
	}
	
	public void loadMetadata(String dataFileName){
		FileHandle fh = Gdx.files.internal(dataFileName);
		
		String allLines = fh.readString();
		String[] lineArray = allLines.split(TOKEN_LINE_BREAK);
		String currTag = "";
		
		for(int i = 0; i < lineArray.length; i++){
			String str = lineArray[i];
			
			if(str.equals("")){
				continue;
			}
			
			if(str.equals(LF2Constants.GameDataConstant.OBJECT) 
					|| str.equals(LF2Constants.GameDataConstant.BACKGROUND)
					|| str.equals(LF2Constants.GameDataConstant.FILE_EDITING)){
				currTag = str;
				continue;
			}
			
			if(str.equals(LF2Constants.GameDataConstant.OBJECT_END) 
					|| str.equals(LF2Constants.GameDataConstant.FILE_EDITING_END) 
					|| str.equals(LF2Constants.GameDataConstant.BACKGROUND_END)){
				currTag = str;
			}
			
			
			if(currTag.equals(LF2Constants.GameDataConstant.OBJECT) 
					|| currTag.equals(LF2Constants.GameDataConstant.BACKGROUND)
					|| currTag.equals(LF2Constants.GameDataConstant.FILE_EDITING)){
				parseLine(str);
				
				if(currTag.equals(LF2Constants.GameDataConstant.OBJECT)){
					int id = Integer.parseInt(this.attrValuePair.get(LF2Constants.GameDataConstant.ID));
					int type = Integer.parseInt(this.attrValuePair.get(LF2Constants.GameDataConstant.TYPE));
					String fileName = this.attrValuePair.get(LF2Constants.GameDataConstant.FILE + ":");
					
					prepareGameObject(fileName, id, type);
					clearAttrValueMap();
				}
			}
			
		}
		
	}

	@Override
	public void run() {
		this.loadMetadata("data\\data.txt");
	}
}
