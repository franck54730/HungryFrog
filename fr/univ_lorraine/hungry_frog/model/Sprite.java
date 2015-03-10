package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;

public abstract class Sprite extends Element {

	protected String lastDirection;
	protected Texture texture;	
	protected Constantes.DIRECTION direction = Constantes.DIRECTION.LEFT;
	protected int position;
	protected int tempo = 0;
	protected int tempoMax;
	protected int speed = Constantes.VITESSE_RAPIDE;

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public Sprite(int h, int w, int cx, int cy){
		super(h, w, cx, cy);
		position = 1;
		texture = new Texture(getTextureName());
	}
	


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
		if(x == 0){
			System.out.println("arrivé");
		}
		
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
		hitbox.setPosition(x+decalageX, y+decalageY);
	}
	
	public void stopMove(){
		position = 1;
	}
	
	public void move(){
		if(tempo < tempoMax){
			tempo++;
		}else{
			if(position < 3)
				position++;
			else 
				position = 1;
			tempo = 0;
		}
	}
	
	public abstract void updateTemplate();
	protected abstract String getTextureName();
}
