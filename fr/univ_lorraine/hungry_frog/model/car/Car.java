package fr.univ_lorraine.hungry_frog.model.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.Sprite;

public abstract class Car extends Sprite {
	protected int xDepart;
	
	public Car(int x, int y, DIRECTION d, int xD) {
		super(100, 100, x, y);
		tempoMax = Constantes.TEMPO_CAR;
		hitbox = new Rectangle(x,y, 100,100);
		lastDirection = "left";
		direction = d;
		xDepart = xD;
	}

	@Override
	public void updateTemplate() {
		texture = new Texture(getTextureName());
	}
	
	protected abstract String getTextureName();
	
	@Override
	public void update(float delta){
		super.update(delta);
		System.out.println("x : "+x);
		if(x<-200){
			x=xDepart;
		}else if(x>xDepart){
			x=-200;
		}
	}

	@Override
	public void move(){
		if(tempo < tempoMax){
			tempo++;
		}else{
			if(position < 2)
				position++;
			else 
				position = 1;
			tempo = 0;
		}
	}
	
}
