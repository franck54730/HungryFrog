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
		lastDirection = "left";
		direction = d;
		xDepart = xD;
		maxPosition = 2;
		updateTemplate(); 
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
	
	protected abstract void initTexture();
	
}
