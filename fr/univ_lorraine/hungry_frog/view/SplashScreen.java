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

public class SplashScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture img;
	Sound fond;
	   OrthographicCamera camera;
	   Viewport viewport;
	boolean start = true;
	
	public SplashScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_ACCEUIL);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_THEME));
		camera = new OrthographicCamera();
		viewport = new FitViewport(100,100,camera);
		viewport.apply();

		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
	}

	
	public void start(){
		start=true;
		fond.loop(0.2f);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		fond.pause();
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
		start();
	}
	
	public void render(float delta){
	    camera.update();
		if(start){
			if(Gdx.input.justTouched()){
				hungryfrog.animscreen.show();
				hungryfrog.setScreen(hungryfrog.animscreen);
			}
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img,0,0);
			batch.end();
			updateCamera();
		}
	}

	   @Override
	   public void resize(int width, int height){
		  hungryfrog.animscreen.resize(width, height);
	      viewport.update(width,height);
	      camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
	   }
	

		public void updateCamera(){
			int heigthScreen = Gdx.graphics.getHeight()/2;
			int widthScreen = Gdx.graphics.getWidth()/2; 
			//camera.position.set(w,camera.viewportHeight/2,0);
			//int posX = 1
			//int posY = 
		}
}
