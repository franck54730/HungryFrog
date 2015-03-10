package fr.univ_lorraine.hungry_frog.model;

import com.badlogic.gdx.math.Rectangle;


public abstract class Element {

	protected Rectangle hitbox;	
	protected int decalageX;
	protected int decalageY;
	protected int height;
	protected int width;
	protected int x;
	protected int y;
	
	public Element(int h, int w, int cx, int cy) {
		height = h;
		width = w;
		x = cx;
		y = cy;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle getHitbox(){
		return hitbox;
	}
	
	public boolean hasCollision(Element e){
		return e.getHitbox().overlaps(hitbox);
	}
}