package fr.univ_lorraine.hungry_frog.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Frog extends Sprite {
	
	public Frog() {
		super(50, 50, Constantes.POS_X_START_FROG, Constantes.POS_Y_START_FROG);
		tempoMax = Constantes.TEMPO_FROG;
		lastDirection = "down";
		speed = Constantes.VITESSE_NORMAL;
		hitbox = new Hitbox[4][3];
		hitbox[0][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2);
		hitbox[0][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 37, 34, 6, 2);
		hitbox[0][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 37, 30, 6, 0);
		hitbox[1][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 26, 9, 2);
		hitbox[1][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 38, 24, 9, 2);
		hitbox[1][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 38, 30, 9, 0);
		hitbox[2][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 35, 31, 8 ,2);
		hitbox[2][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 33, 38, 9, 0);
		hitbox[2][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 33, 33, 9, 2);
		hitbox[3][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 33, 26, 8, 2);
		hitbox[3][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 27, 30, 12, 5);
		hitbox[3][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 33, 30, 8,0);
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
	
	@Override
	public void update(float delta){
		super.update(delta);
		if(x < 0)
			x = 0;
		else if( x > 450)
			x = 500-50;
		if(y < 0)
			y = 0;
		else if( y > 450)
			y = 500-50;
	}
	
	public boolean isFinish(){
		return y < 10;
	}
}
