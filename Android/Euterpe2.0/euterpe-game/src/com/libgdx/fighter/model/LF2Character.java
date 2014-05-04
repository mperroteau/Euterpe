package com.libgdx.fighter.model;

import com.libgdx.fighter.Metadata;

public class LF2Character extends GameObject {	
	public int walking_frame_rate;
	public float walking_speed;
	public float walking_speedz;
	public float running_frame_rate;
	public float running_speed;
	public float running_speedz;
	public float heavy_walking_speed;
	public float heavy_walking_speedz;
	public float heavy_running_speed;
	public float heavy_running_speedz;
	public float jump_height;
	public float jump_distance;
	public float jump_distancez;
	public float dash_height;
	public float dash_distance;
	public float dash_distancez;
	public float rowing_height;
	public float rowing_distance;
	public float weapon_hp;
	public float weapon_drop_hurt;
	public float weapon_hit_sound;
	public float weapon_drop_sound;
	public float weapon_broken_sound;

	
	public float hp;
	public float mp;
	public int team;
	public int fallPoint = 70;
	public boolean isPlayer;
	
	
	public static class Team{
		public static final int INDEPENDENT = 0;
		public static final int TEAM1 = 1;
		public static final int TEAM2 = 2;
		public static final int TEAM3 = 3;
		public static final int TEAM4 = 4;
	}
	
	
	public LF2Character(Metadata metaData) {
		super(metaData);
		metaData.type = GameObject.Type.CHARACTER;
		
	}


	public boolean isPlayer() {
		return isPlayer;
	}


	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}


	public int getTeam() {
		return team;
	}


	public void setTeam(int team) {
		this.team = team;
	}

}
