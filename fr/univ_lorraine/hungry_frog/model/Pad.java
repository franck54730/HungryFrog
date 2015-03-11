package fr.univ_lorraine.hungry_frog.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public class Pad extends Element {

	protected Constantes.DIRECTION direction = Constantes.DIRECTION.STOP;
	protected Texture[] animation;
	protected Texture texture;
	protected int xNow;
	protected int yNow;
	protected int centerX;
	protected int centerY;
	protected boolean shown = false;
	
	public Pad(int h, int w, int cx, int cy){
		super(h, w, cx, cy);
		direction = DIRECTION.STOP;
		animation = new Texture[5];
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
	}

	public void setPosition(int cx, int cy){
		//recalculer en fonction de la screen et du viewport
		x = cx-50;
		y = 500-(cy+50);
		centerX = cx;
		centerY = cy;
	}
	
	public void update(int cx, int cy){
		//TODO mettre les formules vue en td
	}

	@Override
	public Hitbox getHitbox() {
		return null;
	}
}
