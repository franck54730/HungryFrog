package fr.univ_lorraine.hungry_frog.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.controller.MenuListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Settings;
import fr.univ_lorraine.hungry_frog.view.button.ButtonSettings;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;

public class MenuScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture img;
	Music fond;
	ButtonPlay btPlay;
	ButtonQuit btQuit;
	ButtonSettings btOptions;
	OrthographicCamera camera;
	Viewport viewport;
	boolean start = true;
	
	public MenuScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_MENU);
		fond = Gdx.audio.newMusic(Gdx.files.internal(Constantes.SON_THEME));
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,500/2,0);
		btPlay = new ButtonPlay( 325, 212);
		btOptions = new ButtonSettings( 325, 122);
		btQuit = new ButtonQuit( 325, 22);
	}

	
	public void start(){
		start=true;
	}

	@Override
	public void hide() {
		fond.pause();
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
		start();
		btPlay.initialize();
		btOptions.initialize();
		btQuit.initialize();
		Gdx.input.setInputProcessor(new MenuListener(btPlay, btQuit, btOptions, hungryfrog));
		if(Settings.getInstance().isSound())
			fond.play();
	}
	
	public void render(float delta){
    	if(Settings.getInstance().isSound())
			if(!fond.isPlaying())
				fond.play();
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		if(start){
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img,0,0);
			batch.draw(btPlay.getTexture(), btPlay.getX(), btPlay.getY());
			batch.draw(btQuit.getTexture(), btQuit.getX(), btQuit.getY());
			batch.draw(btOptions.getTexture(), btOptions.getX(), btOptions.getY());
			batch.end();
		}
	}

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(500/2,500/2,0);
	   }
}
