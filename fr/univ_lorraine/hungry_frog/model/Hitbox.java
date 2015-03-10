package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.math.Rectangle;

public class Hitbox extends Rectangle {
	protected int decalageX;
	protected int decalageY;
	
	public Hitbox(int x, int y, int width, int height, int decX, int decY){
		super(x,y,width,height);
		decalageX = decX;
		decalageY = decY;
	}
	
	@Override
	public Rectangle setX(float i){
		super.setX(i+decalageX);
		return this;
	}
	
	@Override
	public Rectangle setY(float i){
		super.setY(i+decalageY);
		return this;
	}

	public boolean hasCollision(Hitbox hitbox) {
		// TODO Stub de la méthode généré automatiquement
		return this.overlaps((Rectangle)hitbox);
	}
	
	public String toString(){
		return "{x : "+x+", y : "+y+", width : "+width+", height : "+height+"}";
	}
}
