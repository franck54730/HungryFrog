package fr.univ_lorraine.hungry_frog.model;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Pad extends Element {

	protected Constantes.DIRECTION direction = Constantes.DIRECTION.STOP;
	protected Texture[] animation;
	protected Texture texture;
	protected int centerX;
	protected int centerY;
	protected boolean shown = false;
	protected Frog frog;
	
	public Pad(int h, int w, int cx, int cy, Frog f){
		super(h, w, cx, cy);
		frog = f;
		direction = DIRECTION.STOP;
		animation = new Texture[5];
		width = 150;
		//conversion avec une largeur d'ecran de 500
		width = 500*width/Gdx.graphics.getWidth();
		animation[0] = new Texture(Constantes.TEXTURE_PAD+"_left.png");
		animation[1] = new Texture(Constantes.TEXTURE_PAD+"_right.png");
		animation[2] = new Texture(Constantes.TEXTURE_PAD+"_up.png");
		animation[3] = new Texture(Constantes.TEXTURE_PAD+"_down.png");
		animation[4] = new Texture(Constantes.TEXTURE_PAD+"_center.png");
	}
	
	public void setDirection(Constantes.DIRECTION d){
		direction = d;
	}
	
	public Constantes.DIRECTION getDirection(){
		return direction;
	}

	public void updateTemplate() {
		texture = animation[Constantes.getDirectionIntPad(direction)];
	}
	
	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public boolean isShown(){
		return shown;
	}

	@Override
	public void updateHitboxs() {
		
	}
	
	public void show() {
		shown = true;
	}
	

	public void hide() {
		shown = false;
		direction = DIRECTION.STOP;
	}

	//avec cx et cy origine en haut a gauche de la fenetre
	public void setPosition(int cx, int cy){
		//replacement en fonction de l'origine
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cy=h-cy;
		//on recalcul les coordonnées dans le view port
		int viewportHeight = (500*Gdx.graphics.getHeight())/Gdx.graphics.getWidth();
		int viewportWidth = 500;
		cx = viewportWidth*cx/w;
		cy = viewportHeight*cy/h;
		int viewportPosY = Constantes.positionYCameraFromFrog(frog.getY(), viewportHeight)-(viewportHeight/2);
		cy = viewportPosY+cy;
		//on retranche la moitier de la largeur et de la hauteur de l'image
		x = cx-(width/2);
		y = cy-(width/2);
		centerX = cx;
		centerY = cy;
	}
	
	public void update(int cx, int cy){
		//replacement en fonction de l'origine
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cy=h-cy;
		//on recalcul les coordonnées dans le view port
		int viewportHeight = (500*Gdx.graphics.getHeight())/Gdx.graphics.getWidth();
		int viewportWidth = 500;
		cx = viewportWidth*cx/w;
		cy = viewportHeight*cy/h;
		int viewportPosY = Constantes.positionYCameraFromFrog(frog.getY(), viewportHeight)-(viewportHeight/2);
		cy = viewportPosY+cy;
		
		int coorX = centerX-cx;
		coorX = -coorX;
		int coorY = centerY-cy;
		int a = coorY+coorX;
		int b = coorY-coorX;
		boolean left = a < 0 && b > 0 && coorX > -100 && coorX < -13;
		boolean right = a > 0 && b < 0 && coorX > 13 && coorX < 100;
		boolean up = a < 0 && b < 0 && coorY > -100 && coorY < -13;
		boolean down = a > 0 && b > 0 && coorY > 13 && coorY < 100;
		if(left)
			direction = DIRECTION.LEFT;
		else if(right)
			direction = DIRECTION.RIGHT;
		else if(up)
			direction = DIRECTION.UP;
		else if(down) 
			direction = DIRECTION.DOWN;
		else 
			direction = DIRECTION.STOP;
	}

	@Override
	public Hitbox getHitbox() {
		return null;
	}

	public void translateY(int cameraTravelingY) {
		y -= cameraTravelingY;
		centerY -= cameraTravelingY;
	}
}
