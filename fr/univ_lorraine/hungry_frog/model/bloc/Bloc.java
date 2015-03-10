package fr.univ_lorraine.hungry_frog.model.bloc;


import java.awt.Rectangle;

import com.badlogic.gdx.graphics.Texture;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Element;
import fr.univ_lorraine.hungry_frog.model.Hitbox;
import fr.univ_lorraine.hungry_frog.model.Sprite;

/**
 * classe qui reprÃ©sente un bloc de texture de fond : Herbe, Route, Ligne
 * @author audiger2u
 *
 */
public class Bloc extends Element{
	
	public Bloc(int cx, int cy, String t){
		super(Constantes.BLOC_DIMENSION, Constantes.BLOC_DIMENSION, cx, cy);
	}

	@Override
	public void updateHitboxs() {
		// TODO Stub de la méthode généré automatiquement
		
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Stub de la méthode généré automatiquement
		return null;
	}
}
