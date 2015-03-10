package fr.univ_lorraine.hungry_frog.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Frog extends Sprite {
	
	public Frog() {
		super(50, 50, Constantes.POS_X_START_FROG, Constantes.POS_Y_START_FROG);
		tempoMax = Constantes.TEMPO_FROG;
		decalageX=6;
		decalageY=13;
		lastDirection = "down";
		hitbox = new Rectangle(Constantes.POS_X_START_FROG+decalageX,Constantes.POS_Y_START_FROG+decalageY, 38,35);
	}

	@Override
	public void updateTemplate() {
		texture = new Texture(getTextureName());
	}
	
	protected String getTextureName(){
		String dir = Constantes.getDirectionString(direction, lastDirection);
		lastDirection = dir;
		return Constantes.TEXTURE_FROG+"_"+lastDirection+"_"+position+".png";
		
	}
}
