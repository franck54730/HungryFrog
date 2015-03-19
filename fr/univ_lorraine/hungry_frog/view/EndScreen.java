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

import fr.univ_lorraine.hungry_frog.controller.EndListener;
import fr.univ_lorraine.hungry_frog.controller.MenuListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;
import fr.univ_lorraine.hungry_frog.view.button.ButtonReplay;

public class EndScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	int camY = 750;
	SpriteBatch batch;
	Texture img;
	Sound fond;
	OrthographicCamera camera;
	Viewport viewport;
	boolean start = true;
	ButtonReplay btReplay;
	ButtonQuit btQuit;
	boolean finished;
	
	public EndScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		finished = false;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_END);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_WIN));
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,camY,0);
		btReplay = new ButtonReplay( 275, 40);
		btQuit = new ButtonQuit( 75, 40);
	}

	
	public void start(){
		start=true;
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
		Gdx.input.setInputProcessor(new EndListener(btReplay, btQuit, hungryfrog));
	}
	
	public void render(float delta){
		if(camY>250){
			camY-=2;
		}else{
			finished = true;
		}
		camera.position.set(500/2,camY,0);
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		if(start){
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img,0,0);
			if(finished){
				batch.draw(btReplay.getTexture(), btReplay.getX(), btReplay.getY());
				batch.draw(btQuit.getTexture(), btQuit.getX(), btQuit.getY());
			}
			batch.end();
		}
	}

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(500/2,500/2,0);
	   }
}
