package fr.univ_lorraine.hungry_frog.model.beech;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.Sprite;

public abstract class Beech extends Sprite {
	protected int xDepart;
	protected String texturePath;
	
	public Beech(int width, int height, int x, int y, DIRECTION d, int xD) {
		super(width, height, x, y);
		tempoMax = Constantes.TEMPO_CAR;
		lastDirection = "left";
		direction = d;
		xDepart = xD;
		maxPosition = 2;
	}

	@Override
	public void update(float delta){
		super.update(delta);
		if(x<-200){
			x=xDepart;
		}else if(x>xDepart){
			x=-200;
		}
	}
	
	protected void initTexture(){
		animation = new TextureRegion[1][1];
		Texture texture = new Texture(texturePath);
		animation[0][0] = new TextureRegion(texture, 0, 0, width, height);
	}
	
	public void updateTemplate() {
		texture = animation[0][0];
	}
	
	public Hitbox getHitbox(){
		return hitbox[0][0];
	}
	
}
