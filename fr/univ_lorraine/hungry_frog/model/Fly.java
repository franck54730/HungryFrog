package fr.univ_lorraine.hungry_frog.model;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Fly extends Sprite {
	
	protected int randomTempo;
	protected Random rand;
	

	public Fly() {
		super(50, 50, Constantes.POS_X_START_FLY, Constantes.POS_Y_START_FLY);
		tempoMax = Constantes.TEMPO_FLY;
		decalageX=16;
		decalageY=35;
		hitbox = new Rectangle(Constantes.POS_X_START_FLY+decalageX,Constantes.POS_Y_START_FLY+decalageY, 15,10);
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
		direction = DIRECTION.STOP;
		texture = new Texture(getTextureName());
	}
	
	protected String getTextureName(){
		String dir = Constantes.getDirectionString(direction, lastDirection);
		lastDirection = dir;
		return Constantes.TEXTURE_FLY+"_"+lastDirection+"_"+position+".png";
		
	}

}
