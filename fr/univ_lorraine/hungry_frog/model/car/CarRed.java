package fr.univ_lorraine.hungry_frog.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class CarRed extends Car {
	
	public CarRed(int x, int y, DIRECTION d, int xD) {
		super(x, y, d, xD);
		speed = Constantes.VITESSE_NORMAL;
		hitbox = new Hitbox[2][2];
		hitbox[0][0] = new Hitbox(x, y, 93, 49, 3, 16 );
		hitbox[0][1] = new Hitbox(x, y, 93, 49, 3, 16 );
		hitbox[1][0] = new Hitbox(x, y, 93, 49, 3, 16 );
		hitbox[1][1] = new Hitbox(x, y, 93, 49, 3, 16 );
		texturePath = Constantes.TEXTURE_CAR_RED;
		initTexture();
		updateTemplate(); 
	}
}
