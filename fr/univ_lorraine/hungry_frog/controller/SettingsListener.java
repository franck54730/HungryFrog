package fr.univ_lorraine.hungry_frog.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.Level;
import fr.univ_lorraine.hungry_frog.model.Pad;
import fr.univ_lorraine.hungry_frog.model.Settings;
import fr.univ_lorraine.hungry_frog.view.HungryFrogGame;
import fr.univ_lorraine.hungry_frog.view.button.ButtonReturn;
import fr.univ_lorraine.hungry_frog.view.button.ButtonSettings;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;
import fr.univ_lorraine.hungry_frog.view.button.CheckBox;

public class SettingsListener implements InputProcessor {

	protected ButtonReturn btReturn;
	protected CheckBox boxSound;
	protected CheckBox boxPad;
	protected CheckBox boxAccelerometre;
	protected static enum SELECTION { NONE, SOUND, RETURN, PAD, ACCELEROMETRE};
	protected SELECTION selection;
	protected HungryFrogGame hungryfrog;
	protected Settings settings;
	
	public SettingsListener(ButtonReturn b1, CheckBox b2, CheckBox b3, CheckBox b4, HungryFrogGame h) {
		btReturn = b1;
		boxSound = b2;
		boxPad = b3;
		boxAccelerometre = b4;
		selection = SELECTION.NONE;
		hungryfrog = h;
		settings = Settings.getInstance();
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
			if(btReturn.isIn(screenX, screenY)){
				btReturn.click();
				selection = SELECTION.RETURN;
			} else if(boxSound.isIn(screenX, screenY)){
				boxSound.click();
				selection = SELECTION.SOUND;
			} else if(boxPad.isIn(screenX, screenY)){
				boxPad.click();
				boxAccelerometre.click();
				selection = SELECTION.PAD;
			} else if(boxAccelerometre.isIn(screenX, screenY)){
				boxPad.click();
				boxAccelerometre.click();
				selection = SELECTION.ACCELEROMETRE;
			}
		}
		return selection != SELECTION.NONE;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		switch (selection) {
		case RETURN:
			hungryfrog.setScreen(hungryfrog.getMenuScreen());
			break;
		case SOUND:
			settings.changeSound();
			break;
		case PAD:
			settings.changePad();
			break;
		case ACCELEROMETRE:
			settings.changePad();
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
