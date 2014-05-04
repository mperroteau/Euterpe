package com.libgdx.fighter;

public class LF2Constants {
	
	public static final int MAX_FRAME = 400;
	public static final int MAX_SPRITE_FILES = 10;
	public static final int NO_MOVE = 0;
	
	public static class GameDataConstant{
		
		public static final String ID = "id:";
		public static final String TYPE = "type:";
		
		/*Tags*/
		public static final String BMP_BEGIN = "<bmp_begin>";
		public static final String BMP_END = "<bmp_end>";
		public final static String OBJECT = "<object>";
		public final static String OBJECT_END = "<object_end>";
		public final static String FILE_EDITING = "<file_editing>";
		public final static String FILE_EDITING_END = "<file_editing_end>";
		public final static String BACKGROUND = "<background>";
		public final static String BACKGROUND_END = "<background_end>";
		public final static String END = "_end>";
		public final static String WEAPON_STRENGTH_LIST = "<weapon_strength_list>";
		public final static String WEAPON_STRENGTH_LIST_END = "<weapon_strength_list_end>";
		
		/*bmp_begin*/
		public static final String NAME = "name:";
		public static final String HEAD = "head:";
		public static final String SMALL = "small:";
		public static final String FILE = "file";
		public static final String W = "w:";
		public static final String H = "h:";
		public static final String ROW = "row:";
		public static final String COL = "col:";
		public static final String WALKING_FRAME_RATE = "walking_frame_rate";
		public static final String WALKING_SPEED = "walking_speed";
		public static final String WALKING_SPEEDZ = "walking_speedz";
		public static final String RUNNING_FRAME_RATE = "running_frame_rate";
		public static final String RUNNING_SPEED = "running_speed";
		public static final String RUNNING_SPEEDZ = "running_speedz";
		public static final String HEAVY_WALKING_SPEED = "heavy_walking_speed";
		public static final String HEAVY_WALKING_SPEEDZ = "heavy_walking_speedz";
		public static final String HEAVY_RUNNING_SPEED = "heavy_running_speed";
		public static final String HEAVY_RUNNING_SPEEDZ = "heavy_running_speedz";
		public static final String JUMP_HEIGHT = "jump_height";
		public static final String JUMP_DISTANCE = "jump_distance";
		public static final String JUMP_DISTANCEZ = "jump_distancez";
		public static final String DASH_HEIGHT = "dash_height";
		public static final String DASH_DISTANCE = "dash_distance";
		public static final String DASH_DISTANCEZ = "dash_distancez";
		public static final String ROWING_HEIGHT = "rowing_height";
		public static final String ROWING_DISTANCE = "rowing_distance";
		public static final String WEAPON_HP = "weapon_hp:";
		public static final String WEAPON_DROP_HURT = "weapon_drop_hurt:";
		public static final String WEAPON_HIT_SOUND = "weapon_hit_sound:";
		public static final String WEAPON_DROP_SOUND = "weapon_drop_sound:";
		public static final String WEAPON_BROKEN_SOUND = "weapon_broken_sound:";
		
		/*Frame constant*/
		public static final String FRAME = "<frame>";
		public static final String FRAME_END = "<frame_end>";
		public static final String PIC = "pic:";
		public static final String STATE = "state:";
		public static final String WAIT = "wait:";
		public static final String NEXT = "next:";
		public static final String DVX = "dvx:";
		public static final String DVY = "dvy:";
		public static final String DVZ = "dvz:";
		public static final String CENTERX = "centerx:";
		public static final String CENTERY = "centery:";
		public static final String HIT_A = "hit_a:";
		public static final String HIT_D = "hit_d:";
		public static final String HIT_J = "hit_j:";
		public static final String HIT_DA = "hit_Da:";
		public static final String HIT_FA = "hit_Fa:";
		public static final String HIT_UA = "hit_Ua:";
		public static final String HIT_DJ = "hit_Dj:";
		public static final String HIT_FJ = "hit_Fj:";
		public static final String HIT_UJ = "hit_Uj:";
		public static final String HIT_JA = "hit_ja:";
		public static final String MP = "mp:";
		public static final String SOUND = "sound:";

		/*itr constants*/
		public static final String ITR = "itr:";
		public static final String ITR_END = "itr_end:";
		public static final String KIND = "kind:";
		public static final String X = "x:";
		public static final String Y = "y:";
//		public static final String W = "w";
//		public static final String H = "h";
		public static final String AREST = "arest:";
		public static final String VREST = "vrest:";
//		public static final String DVX = "dvx";
//		public static final String DVY = "dvy";
		public static final String FALL = "fall:";
		public static final String BDEFEND = "bdefend:";
		public static final String INJURY = "injury:";
		public static final String ZWIDTH = "zwidth:";
		public static final String EFFECT = "effect:";
		public static final String CATCHINGACT = "catchingact:";
		public static final String CAUGHTACT = "caughtact:";
		public static final String PICKINGACT = "pickingact:";
		
		/*bdy constants*/
		public static final String BDY = "bdy:";
		public static final String BDY_END = "bdy_end:";
//		public static final String KIND = "kind";
//		public static final String X = "x";
//		public static final String Y = "y";
//		public static final String W = "w";
//		public static final String H = "h";
		
		
		/*cpoint constants*/
		public static final String CPOINT = "cpoint:";
		public static final String CPOINT_END = "cpoint_end:";
//		public static final String KIND = "kind";
//		public static final String X = "x";
//		public static final String Y = "y";
//		public static final String INJURY = "injury";
		public static final String COVER = "cover:";
		public static final String VACTION = "vaction:";
		public static final String AACTION = "aaction:";
		public static final String JACTION = "jaction:";
		public static final String TACTION = "taction:";
		public static final String THROWVX = "throwvx:";
		public static final String THROWVY = "throwvy:";
		public static final String THROWVZ = "throwvz:";
		public static final String HURTABLE = "hurtable:";
		public static final String THROWINJURY = "throwinjury:";
		public static final String FRONTHURTACT = "fronthurtact:";
		public static final String BACKHURTACT = "backhurtact:";
		public static final String DECREASE = "decrease:";
		public static final String DIRCONTROL = "dircontrol:";


		public static final String OPOINT = "opoint:";
		public static final String OPOINT_END = "opoint_end:";
//		public static final String KIND = "kind";
//		public static final String X = "x";
//		public static final String Y = "y";
//		public static final String DVX = "dvx";
//		public static final String DVY = "dvy";
		public static final String ACTION = "action:";
		public static final String OID = "oid:";
		public static final String FACING = "facing:";
		
		/*wpoint constants*/
		public static final String WPOINT = "wpoint:";
		public static final String WPOINT_END = "wpoint_end:";
//		public static final String KIND = "kind";
//		public static final String X = "x";
//		public static final String Y = "y";
		public static final String WEAPONACT = "weaponact:";
		public static final String ATTACKING = "attacking:";
//		public static final String COVER = "cover";
//		public static final String DVX = "dvx";
//		public static final String DVY = "dvy";
//		public static final String DVZ = "dvz";
		
		public static final String BPOINT = "bpoint:";
		
		/*bg constants*/
		public static final String BG = "bg";
		public static final String TRANSPARENCY = "transparency:";
		public static final String WIDTH = "width:";
//		public static final String X = "x";
//		public static final String Y = "y";
		public static final String LOOP = "¡@loop:";
		public static final String CC = "¡@cc:";
		public static final String C1 = "¡@c1:";
		public static final String C2 = "¡@c2:";

		/*Weapon constants*/
		public static final String ENTRY = "entry:";

	}
	



}
