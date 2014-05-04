package com.libgdx.fighter.model;

import java.util.ArrayList;

public class GameObjectFrame {
	public int frameId;
	
	public int pic;
	public int state;
	public int wait;
	public int next;
	public int dvx;
	public int dvy;
	public int dvz;
	public int centerx;
	public int centery;
	public int hit_a;
	public int hit_d;
	public int hit_j;
	public int hit_Da;
	public int hit_Fa;
	public int hit_Ua;
	public int hit_Dj;
	public int hit_Fj;
	public int hit_Uj;
	public int mp;
	
	public String sound;
	public ArrayList<GameObjectInteraction> itrs;

	public ArrayList<GameObjectBody> bdys;
	
	public GameObjectCatchPoint cpoint;
	public GameObjectBloodPoint bpoint;
	public GameObjectObjectPoint opoint;
	public GameObjectWeaponPoint wpoint;
	
	public GameObjectFrame(){
		itrs = new ArrayList<GameObjectInteraction>();
		bdys = new ArrayList<GameObjectBody>();
		
		cpoint = new GameObjectCatchPoint();
		bpoint = new GameObjectBloodPoint();
		opoint = new GameObjectObjectPoint();
		wpoint = new GameObjectWeaponPoint();
	}
	
	public void addItr(GameObjectInteraction itr){
		this.itrs.add(itr);
	}
	
	public void addBdy(GameObjectBody bdy){
		this.bdys.add(bdy);
	}
	
	public GameObjectBody getLastBdy(){
		return this.bdys.get(this.bdys.size() - 1);
	}
	
	public GameObjectInteraction getLastItr(){
		return this.itrs.get(this.itrs.size() - 1);
	}
	
	
	public class GameObjectInteraction {
		public int kind;
		public int x;
		public int y;
		public int w;
		public int h;
		public int arest;
		public int vrest;
		public int dvx;
		public int dvy;
		public int fall;
		public int bdefend;
		public int injury;
		public int zwidth;
		public int effect;
		public int catchingact1;
		public int catchingact2;
		public int caughtact1;
		public int caughtact2;
		public int pickingact;
				
		public class Kind{
			public static final int NORMAL_ATK = 0;
			public static final int PICK_STATE16 = 1; //Pick object with state 16, using with walk
			public static final int PICK_WPN = 2;
			public static final int PICK_ENEMY = 3;
			public static final int CPOINT_THW = 4; //Effective only when character is thrown by enemy
			public static final int WPN_BEHAVIOUR = 5; //Related to <weapon_strength_list>
			public static final int FRAME70_ON_ATK = 6;
			public static final int PICK_LIGHT_WPN = 7; //http://gjp4860sev.myweb.hinet.net/lf2/page3.htm
			public static final int HEAL = 8;
			public static final int OTHER = 9;	//When hitting type 0, self hp turns 0, If it is Qigong, no injury
			public static final int FLUTE = 10; //Henry's flute effect
			public static final int UNKNOWN = 11;
			public static final int BLOCK = 14; //Object block
			public static final int WHIRLWIND_FLY = 15;
			public static final int WHIRLWIND_FLY_FROZEN = 16;
		}
		
		public class Effect{
			public static final int PUNCH = 0;
			public static final int BLEED = 1;
			public static final int FLAME1 = 2;
			public static final int FLAME2 = 20; //Cannot hit Qiqong, state 18, 19
			public static final int FLAME3 = 21; //Cannot hit state 18, 19
			public static final int FLAME4 = 22; //Flame attack towards character himself
			public static final int ICE = 3;
			public static final int ICE1 = 30;
			public static final int CANNOT_HIT_TYPE0 = 4;
		}

	}
	
	public class GameObjectBody{
		public int kind;
		public int x;
		public int y;
		public int w;
		public int h;		
		
	}
	
	public class GameObjectBloodPoint{
		public int x;
		public int y;
	}
	
	public class GameObjectCatchPoint{
		public int kind;
		public int x;
		public int y;
		public int injury;
		public int cover;
		public int vaction;
		public int aaction;
		public int jaction;
		public int taction;
		public int throwvx;
		public int throwvy;
		public int throwvz;
		public int hurtable; //Can the caught character fight back?
		public int throwinjury;
		public int fronthurtact;
		public int backhurtact;
		public int decrease;
		public int dircontrol;
	}
	
	public class GameObjectObjectPoint{
		public int kind;
		public int x;
		public int y;
		public int dvx;
		public int dvy;
		public int action;
		public int oid;
		public int facing;
		
		public class Kind{
			public static final int MAKE_OBJ = 0;
			public static final int MAKE_N_HOLD = 1;
		}
		
		public class Facing{
			public static final int MAKE_OBJ_FRONT = 0;
			public static final int MAKE_OBJ_REV = 1;
		}
	}
	
	public class GameObjectWeaponPoint{
		public int kind;
		public int x;
		public int y;
		public int weaponact;
		public int attacking;
		public int cover;
		public int dvx;
		public int dvy;
		public int dvz;
		
		public class Kind{
			public static final int WPN_IN_HAND = 1;
			public static final int WPN_IN_USE = 2;
			public static final int WPN_DROP = 3;
		}
		
		public class Cover{
			public static final int FRONT = 0;
			public static final int BEHIND = 1;
		}
		
	}
	
}
