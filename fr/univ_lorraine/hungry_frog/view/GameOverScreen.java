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

import fr.univ_lorraine.hungry_frog.model.Constantes;

public class GameOverScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture img;
	boolean show = false;
	Sound fond;
	int tempo = 0;
	OrthographicCamera camera;
	Viewport viewport;
	boolean start = true;
	
	public GameOverScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_GAME_OVER);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_GAME_OVER));
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,500/2,0);
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
	}
	
	public void render(float delta){
		tempo++;
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		if(start){
			if(Gdx.input.justTouched()){
				System.exit(0);
			}
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			if(tempo == 60){
				show = true;
				fond.loop(0.2f);
			}
			if(show)
				batch.draw(img,0,0);
			batch.end();
		}
	}

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(500/2,500/2,0);
	   }
}
