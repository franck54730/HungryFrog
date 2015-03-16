package fr.univ_lorraine.hungry_frog.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public abstract class Sprite extends Element {

	protected String lastDirection;
	protected TextureRegion texture;	
	protected Constantes.DIRECTION direction = Constantes.DIRECTION.STOP;
	protected int position;
	protected int tempo = 0;
	protected int tempoMax;
	protected int speed;
	protected TextureRegion[][] animation;
	protected int maxPosition;
	protected Animation animationTest;
	
	public TextureRegion getTexture() {
		return texture;
	}
	
	public void animationTest(){
		//TextureRegion
	}

	public void setTexture(TextureRegion texture) {
		this.texture = texture;
	}
	
	public Sprite(int h, int w, int cx, int cy){
		super(h, w, cx, cy);
		//initTexture();
		position = 1;
		maxPosition = 3;
	}
	
	protected abstract void initTexture();

	public void setDirection(Constantes.DIRECTION d){
		direction = d;
	}
	
	public Constantes.DIRECTION getDirection(){
		return direction;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int i){
		speed = i;
	}

	public void update(float delta){
		//if(translate)
		int last; 
		switch(direction){
		case DOWN:
			last = y;
			y -= (delta*speed);
			if(y == last)
				y--;
			break;
		case LEFT:
			last = x;
			x -= (delta*speed);
			if(x == last)
				x--;
			break;
		case RIGHT:
			 x+=delta*speed+1;
			break;
		case UP:
			 y+=delta*speed+1;
			break;
		case STOP:
			break;
		default:
			break;
		}
		if(direction == DIRECTION.STOP){
			stopMove();
		}else{
			move();
		}
	}
	
	public void stopMove(){
		position = 1;
	}
	
	public void move(){
		if(tempo < tempoMax){
			tempo++;
		}else{
			if(position < maxPosition)
				position++;
			else 
				position = 1;
			tempo = 0;
		}
	}
	
	public void updateHitboxs(){
		for(int i = 0; i < hitbox.length;i++){
			for(int j = 0; j < hitbox[i].length; j++){
				hitbox[i][j].setX(x);
				hitbox[i][j].setY(y);
			}
		}
	}
	
	public Hitbox getHitbox(){
		return hitbox[Constantes.getDirectionInt(direction)][position-1];
	}

	public void updateTemplate() {
		texture = animation[Constantes.getDirectionInt(direction)][position-1];
	}
}
