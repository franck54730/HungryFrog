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

	//avec cx et cy origine en haut a gauche de la fenetre
	public void setPosition(int cx, int cy){
		//recalculer en fonction de la screen et du viewport
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cy=h-cy;
		
		//on retire la valeur des bandes a gauche et en haut (pour etre dans un contexte largeur = hauteur
		int toRemoveLeft = (w-h);
		toRemoveLeft = toRemoveLeft>0?toRemoveLeft:0;
		int toRemoveUp = (h-w);
		toRemoveUp = toRemoveUp>0?toRemoveUp:0;
		//maj de cx et cy, on retire la moitier de ce qu'il y a a retirer
		cx -= toRemoveLeft/2;
		cy -= toRemoveUp/2;
		
		int contexte = w<h?w:h;
		//calcul avec une largeur et une hauteur de 500 px
		cy = (cy*500)/contexte;
		cx = (cx*500)/contexte;
		x = cx-50;//-(w>h?(w-h):w);
		y = cy-50;//-(w<h?(h-w)/2:h);
		centerX = cx;
		centerY = cy;
	}
	
	public void update(int cx, int cy){
		//TODO mettre les formules vue en td
		//System.out.println("cx : "+cx + " cy : "+  cy);
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cy=h-cy;
		
		//on retire la valeur des bandes a gauche et en haut (pour etre dans un contexte largeur = hauteur
		int toRemoveLeft = (w-h);
		toRemoveLeft = toRemoveLeft>0?toRemoveLeft:0;
		int toRemoveUp = (h-w);
		toRemoveUp = toRemoveUp>0?toRemoveUp:0;
		//maj de cx et cy, on retire la moitier de ce qu'il y a a retirer
		cx -= toRemoveLeft/2;
		cy -= toRemoveUp/2;
		
		int contexte = w<h?w:h;
		//calcul avec une largeur et une hauteur de 500 px
		cy = (cy*500)/contexte;
		cx = (cx*500)/contexte;
		
		int coorX = centerX-cx;
		coorX = -coorX;
		int coorY = centerY-cy;
		//boolean gauche = (18 < coordX && cordX < 50) && () ;
		int a = coorY+coorX;
		int b = coorY-coorX;
		boolean left = a < 0 && b > 0 && coorX > -70 && coorX < -18;
		boolean right = a > 0 && b < 0 && coorX > 18 && coorX < 70;
		boolean up = a < 0 && b < 0 && coorY > -70 && coorY < -18;
		boolean down = a > 0 && b > 0 && coorY > 18 && coorY < 70;
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
	/*	y+x = a
				y-x = b
		xNow = cx;
		yNow = cy;
		int y2 = y-centerY; 
		gauche = (y2+x < 0)&& (y2-x > 0) && (condition encadrement x)
		droite = (y2+x > 0) && (y2-x < 0) && (condition encadrement x)
		haut = (y2+x > 0) && (y2-x > 0) && (condition encadrement x)
		bas = (y2+x < 0) && (y2-x < 0) && (condition encadrement x)
		*/
	}

	@Override
	public Hitbox getHitbox() {
		return null;
	}
}
