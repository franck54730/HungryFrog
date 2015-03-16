package fr.univ_lorraine.hungry_frog.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Tree extends Sprite {
	
	public Tree(int x, int y) {
		super(50, 50, x, y);
		tempoMax = Constantes.TEMPO_FROG;
		lastDirection = "down";
		speed = Constantes.VITESSE_RAPIDE;
		hitbox = new Hitbox[1][1];
		hitbox[0][0] = new Hitbox(x, y, 47, 48, 1, 1);
		direction = DIRECTION.STOP;
		maxPosition = 1;
		initTexture();
		updateTemplate(); 
	}

	@Override
	protected void initTexture() {
		animation = new TextureRegion[1][1];
		Texture texture = new Texture(Constantes.TEXTURE_TREE);
		for(int direction = 0; direction < 1; direction++){
			for(int image = 0; image < 1; image++){
				int x = (direction*(width*1))+(image*width);
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
	
	@Override
	public Hitbox getHitbox(){
		return hitbox[0][position-1];
	}

	@Override
	public void updateTemplate() {
		texture = animation[0][position-1];
	}
}
