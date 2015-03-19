package fr.univ_lorraine.hungry_frog.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.controller.GameOverListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Settings;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;
import fr.univ_lorraine.hungry_frog.view.button.ButtonReplay;

public class GameOverScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture img;
	Sound fond;
	OrthographicCamera camera;
	Viewport viewport;
	boolean start = true;
	ButtonReplay btReplay;
	ButtonQuit btQuit;
	
	public GameOverScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_GAME_OVER);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_GAME_OVER));
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,500/2,0);
		btReplay = new ButtonReplay( 275, 40);
		btQuit = new ButtonQuit( 75, 40);
	}

	
	public void start(){
		start=true;
		if(Settings.getInstance().isSound())
			fond.play(0.2f);
	}

	@Override
	public void hide() {
		fond.pause();
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
		start();
		Gdx.input.setInputProcessor(new GameOverListener(btReplay, btQuit, hungryfrog));
	}
	
	public void render(float delta){
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		if(start){
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img,0,0);
			batch.draw(btReplay.getTexture(), btReplay.getX(), btReplay.getY());
			batch.draw(btQuit.getTexture(), btQuit.getX(), btQuit.getY());
			batch.end();
		}
	}

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(500/2,500/2,0);
	   }
}
