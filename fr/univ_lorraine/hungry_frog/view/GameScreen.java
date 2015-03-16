package fr.univ_lorraine.hungry_frog.view;


import java.util.ArrayList;

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
import fr.univ_lorraine.hungry_frog.model.Tree;
import fr.univ_lorraine.hungry_frog.model.beech.Beech;
import fr.univ_lorraine.hungry_frog.model.car.Car;

public class GameScreen extends ApplicationAdapter implements Screen{

    HungryFrogGame game; // Note it's "MyGame" not "Game"
	GameListener listener;
	Texture hearth;
    BitmapFont lifeLabel;
    BitmapFont levelLabel;
    Pad pad;
	SpriteBatch batch;
	Level level;
	Sound collisionCar;
	Sound collisionWater;
	Sound collisionTree;
	Sound fond;
	Sound life;
	boolean start = false;
	   OrthographicCamera camera;
	   Viewport viewport;
	
	public GameScreen(HungryFrogGame g){
		hearth = new Texture(Constantes.TEXTURE_HEARTH);
		game = g;
		pad = new Pad(100,100,0,0);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_FOND));
		collisionCar = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_CAR));
		collisionWater = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_WATER));
		collisionTree = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_TREE));
		life = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_LIFE));
		level = new Level();
		batch = new SpriteBatch();
		lifeLabel = new BitmapFont();
		lifeLabel.setColor(Color.WHITE);
		levelLabel = new BitmapFont();
		levelLabel.setColor(Color.WHITE);
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,500/2,0);
		Gdx.input.setInputProcessor(new GameListener(level,pad));
	}
	
	public void updateCamera(){
		int heigthScreen = Gdx.graphics.getHeight();
		int widthScreen = Gdx.graphics.getWidth();
	}
	
	public void start(){
		start=true;
		fond.loop(0.2f);
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
		start();
	}

	@Override
	public void render(float delta) {
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(new Texture(Constantes.TEXTURE_BACKGROUND),0,0);
		Frog frog = level.getFrog();
		frog.update(delta);
		Fly fly = level.getFly();;
		if(frog.isFinish())
			level.levelUp();
		else{
			frog.updateTemplate();
			frog.updateHitboxs();
			batch.draw(frog.getTexture(), frog.getX(), frog.getY());
			if(!level.isFlyEaten()){
				fly.update(delta);
				fly.updateTemplate();
				fly.updateHitboxs();
				if(frog.hasCollision(fly)){
					life.play(0.5f);
					level.eatFly();
				}
			}
			for(Car c : level){
				c.update(delta);
				c.updateTemplate();
				c.updateHitboxs();
				if(frog.hasCollision(c)){
					collisionCar.play(1f);
					level.hitCar();
					frog.updateHitboxs();
					batch.draw(frog.getTexture(), frog.getX(), frog.getY());
				}
				batch.draw(c.getTexture(), c.getX(), c.getY());
			}
			ArrayList<Tree> trees = level.getTrees();
			for(Tree t : trees){
				t.update(delta);
				t.updateTemplate();
				t.updateHitboxs();
				if(frog.hasCollision(t)){
					collisionTree.play(1f);
					level.hitTree();
					frog.updateHitboxs();
					batch.draw(frog.getTexture(), frog.getX(), frog.getY());
				}
				batch.draw(t.getTexture(), t.getX(), t.getY());
			}
			ArrayList<Beech> beechs = level.getBeechs();
			frog.outBeech();
			for(Beech b : beechs){
				b.update(delta);
				b.updateTemplate();
				b.updateHitboxs();
				if(frog.hasCollision(b)){
					frog.onBeech();
					frog.updateHitboxs();
				}
				batch.draw(b.getTexture(), b.getX(), b.getY());
			}
			// si la grenouille est dans l'eau
			if(Constantes.RIVER_START < frog.getY() && frog.getY() < Constantes.RIVER_END ){
				if(!frog.isOnBeech()){
					collisionWater.play(1f);
					level.hitCar();
					frog.updateHitboxs();
				}
			}
		}
		if(!level.isFlyEaten())
			batch.draw(fly.getTexture(), fly.getX(), fly.getY());
		batch.draw(frog.getTexture(), frog.getX(), frog.getY());
		batch.draw(hearth, 10, 475);
		lifeLabel.draw(batch, " : "+level.getLife(), 35, 490);
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
		      camera.position.set(500/2,500/2,0);
	   }
	   @Override
	public void create(){
	}
}
