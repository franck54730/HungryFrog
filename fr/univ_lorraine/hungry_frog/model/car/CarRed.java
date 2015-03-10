package fr.univ_lorraine.hungry_frog.model.car;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class CarRed extends Car {
	
	public CarRed(int x, int y, DIRECTION d, int xD) {
		super(x, y, d, xD);
		speed = Constantes.VITESSE_RAPIDE;
	}
	
	protected String getTextureName(){
		String dir = Constantes.getDirectionString(direction, lastDirection);
		lastDirection = dir;
		return Constantes.TEXTURE_CAR_RED+"_"+lastDirection+"_"+position+".png";
		
	}
}
