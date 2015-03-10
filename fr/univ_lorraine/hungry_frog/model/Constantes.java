package fr.univ_lorraine.hungry_frog.model;

public class Constantes {
	public static final String TEXTURE_GRASS = "grass.png";
	public static final String TEXTURE_LINE = "line.png";
	public static final String TEXTURE_ROAD = "road.png";
	public static final String TEXTURE_TREE = "tree.png";
	public static final String TEXTURE_BACKGROUND = "background.png";
	public static final String TEXTURE_FROG = "frog";
	public static final String TEXTURE_FLY = "fly";
	public static final String TEXTURE_CAR_RED = "car_red";
	public static final String TEXTURE_CAR_YELLOW = "car_yellow";
	
	public static final int BLOC_DIMENSION = 50;
	
	//nombre de frame avant changement de texture
	public static final int TEMPO_FROG = 11;
	public static final int TEMPO_CAR = 5;
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
	
	public static final int POS_X_START_FROG = 450;
	public static final int POS_Y_START_FROG = 450;
	public static final int POS_X_START_FLY = 200;
	public static final int POS_Y_START_FLY = 0;
	
	public static final int BLOC_GRASS = 1;
	public static final int BLOC_ROAD = 2;
	public static final int BLOC_LINE = 3;
	
	public static final int ROAD1 = 325;
	public static final int ROAD2 = 245;
	public static final int ROAD3 = 125;
	public static final int ROAD4 = 45;
	
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

	public static final int VITESSE_TRES_LENT = 5;
	public static final int VITESSE_LENT = 10;
	public static final int VITESSE_NORMAL = 30;
	public static final int VITESSE_RAPIDE = 40;
	public static final int VITESSE_TRES_RAPIDE = 60;
}
