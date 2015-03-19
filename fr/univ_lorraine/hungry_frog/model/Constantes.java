package fr.univ_lorraine.hungry_frog.model;

public class Constantes {
	public static final String TEXTURE_ACCEUIL = "acceuil.png";
	public static final String TEXTURE_GAME_OVER = "game_over.png";
	public static final String TEXTURE_END = "end.png";
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
	public static final String TEXTURE_BEECH_150 = "beech1.png";
	public static final String TEXTURE_BEECH_100 = "beech2.png";
	public static final String TEXTURE_BEECH_50 = "beech3.png";
	public static final String TEXTURE_BT_PLAY_1 = "button_play_1.png";
	public static final String TEXTURE_BT_PLAY_2 = "button_play_2.png";
	public static final String TEXTURE_BT_REPLAY_1 = "button_replay_1.png";
	public static final String TEXTURE_BT_REPLAY_2 = "button_replay_2.png";
	public static final String TEXTURE_BT_QUIT_1 = "button_quit_1.png";
	public static final String TEXTURE_BT_QUIT_2 = "button_quit_2.png";
	
	public static final String SON_COLLISION_CAR = "collision_car.wav";
	public static final String SON_COLLISION_WATER = "collision_water.wav";
	public static final String SON_COLLISION_TREE = "collision_tree.wav";
	public static final String SON_THEME = "theme.wav";
	public static final String SON_FOND = "fond.wav";
	public static final String SON_LIFE = "life.wav";
	public static final String SON_WIN = "win.wav";
	public static final String SON_GAME_OVER = "game_over.wav";
	
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
	public static final int RIVER1 = 113;
	public static final int RIVER2 = 88;
	public static final int RIVER3 = 63;
	
	public static final int RIVER_START = 58;
	public static final int RIVER_END = 128;
	
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

	public static int positionYCameraFromFrog(int yFrog, int viewportHeight){
		int start = 500-(viewportHeight/2);
		int end = (viewportHeight/2);
		if(yFrog>start)
			yFrog = start;
		if(yFrog<end)
			yFrog = end;
		return yFrog;
		
	}
	
	public static final int VITESSE_TRES_LENT = 5;
	public static final int VITESSE_LENT = 20;
	public static final int VITESSE_NORMAL = 80;
	public static final int VITESSE_RAPIDE = 100;
	public static final int VITESSE_TRES_RAPIDE = 120;
}
