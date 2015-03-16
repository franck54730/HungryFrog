package fr.univ_lorraine.hungry_frog.model;

public class Constantes {
	public static final String TEXTURE_ACCEUIL = "acceuil.png";
	public static final String TEXTURE_HEARTH = "hearth.png";
	public static final String TEXTURE_GRASS = "grass.png";
	public static final String TEXTURE_LINE = "line.png";
	public static final String TEXTURE_ROAD = "road.png";
	public static final String TEXTURE_TREE = "tree.png";
	public static final String TEXTURE_BACKGROUND = "background.png";
	public static final String TEXTURE_FROG = "frog.png";
	public static final String TEXTURE_FLY = "fly.png";
	public static final String TEXTURE_CAR_RED = "car_red.png";
	public static final String TEXTURE_CAR_YELLOW = "car_yellow.png";
	public static final String TEXTURE_CAR_BLUE = "car_blue.png";
	public static final String TEXTURE_PAD = "pad";
	public static final String SON_COLLISION_CAR = "collision_car.mp3";
	public static final String SON_THEME = "theme.mp3";
	public static final String SON_FOND = "fond.mp3";
	public static final String SON_LIFE = "life.mp3";
	
	public static final int BLOC_DIMENSION = 50;
	
	//nombre de frame avant changement de texture
	public static final int TEMPO_FROG = 9;
	public static final int TEMPO_CAR = 2;
	public static final int TEMPO_FLY = 8;
	
	//represente le fond
	public static final int[][] LEVEL_BACKGROUND_INT = {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		{3,3,3,3,3,3,3,3,3,3,3,3,3,3},
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		{3,3,3,3,3,3,3,3,3,3,3,3,3,3},
		{2,2,2,2,2,2,2,2,2,2,2,2,2,2},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
	public static final int LEVEL_NB_BLOC_WIDTH = 14;
	public static final int LEVEL_NB_BLOC_HEIGHT = 10;
	
	public static final int POS_X_START_FROG = 200;
	public static final int POS_Y_START_FROG = 480;
	public static final int POS_X_START_FLY = 200;
	public static final int POS_Y_START_FLY = 0;
	
	public static final int BLOC_GRASS = 1;
	public static final int BLOC_ROAD = 2;
	public static final int BLOC_LINE = 3;
	
	public static final int ROAD1 = 385;
	public static final int ROAD2 = 335;
	public static final int ROAD3 = 235;
	public static final int ROAD4 = 185;
	public static final int RIVER1 = 125;
	public static final int RIVER2 = 45;
	
	public static final int NB_LEVEL = 10;
	
	public static enum DIRECTION { LEFT, RIGHT, UP, DOWN, STOP };
	public static String getDirectionString(DIRECTION d, String last) {
		String rep = null;
		switch(d){
			case LEFT : rep = "left"; break;
			case RIGHT : rep = "right"; break;
			case UP : rep = "up"; break;
			case DOWN : rep = "down"; break;
			case STOP : rep = last;
		}
		return rep;
	}
	
	public static String getDirectionString(DIRECTION d) {
		String rep = null;
		switch(d){
			case LEFT : rep = "left"; break;
			case RIGHT : rep = "right"; break;
			case UP : rep = "up"; break;
			case DOWN : rep = "down"; break;
			case STOP : rep = "center";
		}
		return rep;
	}
	
	public static int getDirectionInt(DIRECTION d){
		int rep = 0;
		switch(d){
			case LEFT : rep = 0; break;
			case RIGHT : rep = 1; break;
			case UP : rep = 2; break;
			case DOWN : rep = 3; break;
			case STOP : rep = 3;
		}
		return rep;
	}
	
	public static int getDirectionIntPad(DIRECTION d){
		int rep = 0;
		switch(d){
			case LEFT : rep = 0; break;
			case RIGHT : rep = 1; break;
			case UP : rep = 2; break;
			case DOWN : rep = 3; break;
			case STOP : rep = 4;
		}
		return rep;
	}

	public static final int VITESSE_TRES_LENT = 5;
	public static final int VITESSE_LENT = 20;
	public static final int VITESSE_NORMAL = 80;
	public static final int VITESSE_RAPIDE = 100;
	public static final int VITESSE_TRES_RAPIDE = 120;
}
