package fr.univ_lorraine.hungry_frog.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Constantes.DIRECTION;
import fr.univ_lorraine.hungry_frog.model.Level;
import fr.univ_lorraine.hungry_frog.model.Pad;

public class GameListener implements InputProcessor {

	protected Level level;
	protected Pad pad;
	
	public GameListener(Level l, Pad p){
		level = l;
		pad = p;
	}

	public boolean keyUp(int keycode) {
		boolean rep = false;
		if( keycode == Input.Keys.DPAD_DOWN || keycode == Input.Keys.DPAD_UP || keycode == Input.Keys.DPAD_RIGHT || keycode == Input.Keys.DPAD_LEFT){
			level.decNbInput();
			if(level.getNbInput() == 0)
				level.getFrog().setDirection(Constantes.DIRECTION.STOP);
			rep = true;
		}
		redirection();
		return rep;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
		case Input.Keys.DPAD_DOWN : level.getFrog().setDirection(Constantes.DIRECTION.DOWN); 
									level.incNbInput();
									break;
		case Input.Keys.DPAD_UP : level.getFrog().setDirection(Constantes.DIRECTION.UP); 
									level.incNbInput();
									break;
		case Input.Keys.DPAD_RIGHT : level.getFrog().setDirection(Constantes.DIRECTION.RIGHT); 
									level.incNbInput();
									break;
		case Input.Keys.DPAD_LEFT : level.getFrog().setDirection(Constantes.DIRECTION.LEFT);
									level.incNbInput();
									break;
		}
		return false;
	}
	
	public void redirection(){
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
			 level.getFrog().setDirection(Constantes.DIRECTION.LEFT);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
			 level.getFrog().setDirection(Constantes.DIRECTION.RIGHT);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			 level.getFrog().setDirection(Constantes.DIRECTION.DOWN);
		else if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			 level.getFrog().setDirection(Constantes.DIRECTION.UP);
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("touch : (x : "+screenX+" ) (y : "+screenY+" )");
		pad.setPosition(screenX, screenY);
		pad.show();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Stub de la méthode généré automatiquement
		pad.hide();
		level.getFrog().setDirection(DIRECTION.STOP);
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
