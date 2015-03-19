package fr.univ_lorraine.hungry_frog.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.Level;
import fr.univ_lorraine.hungry_frog.model.Pad;
import fr.univ_lorraine.hungry_frog.view.HungryFrogGame;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;
import fr.univ_lorraine.hungry_frog.view.button.ButtonReplay;

public class EndListener implements InputProcessor {

	protected ButtonReplay btReplay;
	protected ButtonQuit btQuit;
	protected static enum SELECTION { NONE, QUIT, REPLAY };
	protected SELECTION selection;
	protected HungryFrogGame hungryfrog;
	
	public EndListener(ButtonReplay b1, ButtonQuit b2, HungryFrogGame h){
		btReplay = b1;
		btQuit = b2;
		selection = SELECTION.NONE;
		hungryfrog = h;
	}


	@Override
	public boolean keyDown(int keycode) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Stub de la méthode généré automatiquement
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		screenX -= (w-h)/2;
		if(!(screenX < 0 || screenX > h)){
			screenY = h-screenY;
			
			//nous somme dans l'image
			//transformation des coordonnées au repere 500
			screenX = screenX*500/h;
			screenY = screenY*500/h;
			if(btReplay.isIn(screenX, screenY)){
				btReplay.click();
				selection = SELECTION.REPLAY;
			} else if(btQuit.isIn(screenX, screenY)){
				btQuit.click();
				selection = SELECTION.QUIT;
			}
		}
		return selection != SELECTION.NONE;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		switch (selection) {
		case REPLAY:
			hungryfrog.restart();
			break;
		case QUIT:
			System.exit(0);
			break;
		}
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}
}
