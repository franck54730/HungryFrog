package fr.univ_lorraine.hungry_frog.model.beech;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Beech50 extends Beech {
	
	public Beech50(int x, int y, DIRECTION d, int xD) {
		super(25, 50, x, y, d, xD);
		speed = Constantes.VITESSE_LENT;
		hitbox = new Hitbox[1][1];
		hitbox[0][0] = new Hitbox(x, y,  width-6, height, 0, 3);
		texturePath = Constantes.TEXTURE_BEECH_50;
		initTexture();
		updateTemplate(); 
	}
}
