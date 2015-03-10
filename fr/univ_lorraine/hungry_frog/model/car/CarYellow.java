package fr.univ_lorraine.hungry_frog.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class CarYellow extends Car {
	
	public CarYellow(int x, int y, DIRECTION d, int xD) {
		super(x, y, d, xD);
		speed = Constantes.VITESSE_TRES_RAPIDE;
		hitbox = new Hitbox[2][2];
		hitbox[0][0] = new Hitbox(x, y, 92, 72, 6, 27 );
		hitbox[0][1] = new Hitbox(x, y, 92, 72, 6, 27 );
		hitbox[1][0] = new Hitbox(x, y, 92, 72, 6, 27 );
		hitbox[1][1] = new Hitbox(x, y, 92, 72, 6, 27 );
	}

	@Override
	protected void initTexture() {
		animation = new Texture[2][2];
		animation[0][0] = new Texture(Constantes.TEXTURE_CAR_RED+"_left_1.png");
		animation[0][1] = new Texture(Constantes.TEXTURE_CAR_RED+"_left_2.png");
		animation[1][0] = new Texture(Constantes.TEXTURE_CAR_RED+"_right_1.png");
		animation[1][1] = new Texture(Constantes.TEXTURE_CAR_RED+"_right_2.png");
	}
}
