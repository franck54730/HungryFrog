package fr.univ_lorraine.hungry_frog.view;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Fly;
import fr.univ_lorraine.hungry_frog.model.Frog;
import fr.univ_lorraine.hungry_frog.model.Level;
import fr.univ_lorraine.hungry_frog.model.Pad;
import fr.univ_lorraine.hungry_frog.model.car.Car;

public class GameScreen extends ApplicationAdapter implements Screen{

	GameListener listener;
    BitmapFont lifeLabel;
    BitmapFont levelLabel;
    Pad pad;
	SpriteBatch batch;
	Level level;
	Sound collisionCar;
	Sound fond;
	Sound life;
	   OrthographicCamera camera;
	   Viewport viewport;
	
	public GameScreen(HungryFrogGame g){
		pad = new Pad(100,100,0,0);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_FOND));
		fond.loop(0.2f);
		collisionCar = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_CAR));
		life = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_LIFE));
		level = new Level();
		batch = new SpriteBatch();
		lifeLabel = new BitmapFont();
		lifeLabel.setColor(Color.WHITE);
		levelLabel = new BitmapFont();
		levelLabel.setColor(Color.WHITE);
		camera = new OrthographicCamera();
		viewport = new FitViewport(100,100,camera);
		viewport.apply();

		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		Gdx.input.setInputProcessor(new GameListener(level,pad));
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
		if(frog.isFinish())
			level.levelUp();
		else{
			frog.updateTemplate();
			frog.updateHitboxs();
			batch.draw(frog.getTexture(), frog.getX(), frog.getY());
			if(!level.isFlyEaten()){
				Fly fly = level.getFly();
				fly.update(delta);
				fly.updateTemplate();
				fly.updateHitboxs();
				if(frog.hasCollision(fly)){
					life.play(0.5f);
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
					collisionCar.play(1f);
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
		}
		lifeLabel.draw(batch, "Vie : "+level.getLife(), 10, 490);
		lifeLabel.draw(batch, "Level : "+level.getLevel(), 440, 490);

		if(pad.isShown()){
			pad.updateTemplate();
			batch.draw(pad.getTexture(), pad.getX(), pad.getY());
		}
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
