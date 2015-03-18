package fr.univ_lorraine.hungry_frog.view.button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public abstract class Button {

	protected int height;
	protected int width;
	protected int x;
	protected int y;
	protected Texture texture1;
	protected Texture texture2;
	protected boolean clicked;
	
	public Button(int h, int w, int cx, int cy) {
		height = h;
		width = w;
		x = cx;
		y = cy;
		clicked = false;
	}
	
	public Texture getTexture(){
		if(clicked)
			return texture2;
		else
			return texture1;
	}
	
	public void click(){
		clicked = true;
	}
	
	public boolean isIn(int cx, int cy){
		return cx > x && cx < x+width && cy > y && cy < y+height;
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
}
