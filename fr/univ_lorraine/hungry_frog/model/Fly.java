package fr.univ_lorraine.hungry_frog.model;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Fly extends Sprite {
	
	protected int randomTempo;
	protected Random rand;
	

	public Fly() {
		super(50, 50, Constantes.POS_X_START_FLY, Constantes.POS_Y_START_FLY);
		tempoMax = Constantes.TEMPO_FLY;
		speed = Constantes.VITESSE_NORMAL;
		hitbox = new Hitbox[4][3];
		hitbox[0][0] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 10, 11, 8, 21 );
		hitbox[0][1] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 10, 9, 17, 20 );
		hitbox[0][2] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 10, 9, 17, 18 );
		hitbox[1][0] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 11, 11, 18, 21);
		hitbox[1][1] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 10, 9, 22, 20 );
		hitbox[1][2] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 11, 9, 21, 18 );
		hitbox[2][0] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 9, 16, 21 );
		hitbox[2][1] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 10, 4, 14 );
		hitbox[2][2] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 9, 16, 21 );
		hitbox[3][0] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 9, 16, 21 );
		hitbox[3][1] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 9, 16, 23 );
		hitbox[3][2] = new Hitbox(Constantes.POS_X_START_FLY,Constantes.POS_Y_START_FLY, 15, 10, 16, 21);
		rand = new Random();
		randomTempo = rand.nextInt(10);
		lastDirection = "right";
		int dir = rand.nextInt(3);
		switch(dir){
			case 0 : 
				direction = DIRECTION.RIGHT ;
				break;
			case 1 : 
				direction = DIRECTION.LEFT ;
				break;
			case 2 : 
				direction = DIRECTION.UP ;
				break;
			case 3 : 
				direction = DIRECTION.DOWN ;
				break;
		}
		initTexture();
		updateTemplate(); 
	}

	@Override
	public void updateTemplate() {
		randomTempo = rand.nextInt(8);
		if(randomTempo == 0){
			int dir = rand.nextInt(3);
			switch(dir){
				case 0 : 
					direction = DIRECTION.RIGHT ;
					break;
				case 1 : 
					direction = DIRECTION.LEFT ;
					break;
				case 2 : 
					direction = DIRECTION.UP ;
					break;
				case 3 : 
					direction = DIRECTION.DOWN ;
					break;
			}
		}
		texture = animation[Constantes.getDirectionInt(direction)][position-1];
	}

	@Override
	protected void initTexture() {
		animation = new TextureRegion[4][3];
		Texture texture = new Texture(Constantes.TEXTURE_FLY);
		for(int direction = 0; direction < 4; direction++){
			for(int image = 0; image < 3; image++){
				int x = (direction*(width*3))+(image*width);
				animation[direction][image] = new TextureRegion(texture, x, 0, width, width);
			}
		}
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
}
