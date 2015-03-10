package fr.univ_lorraine.hungry_frog;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Fly;
import fr.univ_lorraine.hungry_frog.model.Frog;
import fr.univ_lorraine.hungry_frog.model.Level;
import fr.univ_lorraine.hungry_frog.model.car.Car;

public class GameScreen extends ApplicationAdapter implements Screen{

	GameListener listener;
	SpriteBatch batch;
	Level level;
	   OrthographicCamera camera;
	   Viewport viewport;
	
	public GameScreen(HungryFrogGame g){
		level = new Level();
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		viewport = new FitViewport(100,100,camera);
		viewport.apply();

		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		Gdx.input.setInputProcessor(new GameListener(level));
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
	    camera.update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(new Texture(Constantes.TEXTURE_BACKGROUND),0,0);
		Frog frog = level.getFrog();
		frog.update(delta);
		frog.updateTemplate();
		frog.updateHitboxs();
		batch.draw(frog.getTexture(), frog.getX(), frog.getY());
		if(!level.isFlyEaten()){
			Fly fly = level.getFly();
			fly.update(delta);
			fly.updateTemplate();
			fly.updateHitboxs();
			if(frog.hasCollision(fly)){
				System.out.println("collision");
				level.eatFly();
			}
			batch.draw(fly.getTexture(), fly.getX(), fly.getY());
		}
		for(Car c : level){
			c.update(delta);
			c.updateTemplate();
			c.updateHitboxs();
			if(frog.hasCollision(c)){
				System.out.println("collision v");
				level.hitCar();
				frog.updateHitboxs();
				batch.draw(frog.getTexture(), frog.getX(), frog.getY());
			}
			batch.draw(c.getTexture(), c.getX(), c.getY());
		}
		/* boucle pour cr�e le background a partir du tableau et des bloc
		for(Bloc b : level){
			batch.draw(b.getTexture(), b.getX(), b.getY());
		}*/
		batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	   public void dispose(){
	   }

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
	   }
	   @Override
	public void create(){
	}
}
