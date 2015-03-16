package fr.univ_lorraine.hungry_frog.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class CarYellow extends Car {
	
	public CarYellow(int x, int y, DIRECTION d, int xD) {
		super(x, y, d, xD);
		speed = Constantes.VITESSE_RAPIDE;
		hitbox = new Hitbox[2][2];
		hitbox[0][0] = new Hitbox(x, y, 88, 32, 6, 27 );
		hitbox[0][1] = new Hitbox(x, y, 88, 32, 6, 27 );
		hitbox[1][0] = new Hitbox(x, y, 88, 32, 7, 27 );
		hitbox[1][1] = new Hitbox(x, y, 88, 32, 7, 27 );
		texturePath = Constantes.TEXTURE_CAR_YELLOW;
		initTexture();
		updateTemplate(); 
	}
}
