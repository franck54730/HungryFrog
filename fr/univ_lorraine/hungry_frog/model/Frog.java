package fr.univ_lorraine.hungry_frog.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Frog extends Sprite {
	
	public Frog() {
		super(50, 50, Constantes.POS_X_START_FROG, Constantes.POS_Y_START_FROG);
		tempoMax = Constantes.TEMPO_FROG;
		lastDirection = "down";
		hitbox = new Hitbox[4][3];
		hitbox[0][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[0][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[0][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[1][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[1][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[1][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[2][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[2][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[2][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[3][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[3][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		hitbox[3][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2 );
		updateTemplate(); 
	}

	@Override
	protected void initTexture() {
		animation = new Texture[4][3];
		animation[0][0] = new Texture(Constantes.TEXTURE_FROG+"_left_1.png");
		animation[0][1] = new Texture(Constantes.TEXTURE_FROG+"_left_2.png");
		animation[0][2] = new Texture(Constantes.TEXTURE_FROG+"_left_3.png");
		animation[1][0] = new Texture(Constantes.TEXTURE_FROG+"_right_1.png");
		animation[1][1] = new Texture(Constantes.TEXTURE_FROG+"_right_2.png");
		animation[1][2] = new Texture(Constantes.TEXTURE_FROG+"_right_3.png");
		animation[2][0] = new Texture(Constantes.TEXTURE_FROG+"_up_1.png");
		animation[2][1] = new Texture(Constantes.TEXTURE_FROG+"_up_2.png");
		animation[2][2] = new Texture(Constantes.TEXTURE_FROG+"_up_3.png");
		animation[3][0] = new Texture(Constantes.TEXTURE_FROG+"_down_1.png");
		animation[3][1] = new Texture(Constantes.TEXTURE_FROG+"_down_2.png");
		animation[3][2] = new Texture(Constantes.TEXTURE_FROG+"_down_3.png");
	}
}
