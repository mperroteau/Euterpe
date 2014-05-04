package com.libgdx.fighter.model;

import java.util.ArrayList;

import com.libgdx.fighter.Metadata;

public class Weapon extends GameObject {

	public int weapon_hp;
	public int weapon_drop_hurt;
	public String weapon_hit_sound;
	public String weapon_drop_sound;
	public String weapon_broken_sound;
	
	private ArrayList<LF2Entry> entries;
	
	public Weapon(Metadata metaData) {
		super(metaData);
		this.entries = new ArrayList<LF2Entry>();
	}
	
	public void addEntry(LF2Entry e){
		this.entries.add(e);
	}
	
	public LF2Entry getEntry(int i){
		return this.entries.get(i);
	}
	
	public class LF2Entry{
		public final static int NORMAL = 1, JUMP = 2, RUN = 3, DASH = 4;   
		public int effectType, dvx, dvy, fall, arest, vrest, bdefend, injury, effect;
	}
	
	
	

}
