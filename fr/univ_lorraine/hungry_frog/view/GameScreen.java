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
	int yCamera;
	int viewportHeight;
	int viewportWidth;
	
	
	public GameScreen(HungryFrogGame g){
		hearth = new Texture(Constantes.TEXTURE_HEARTH);
		game = g;
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_FOND));
		collisionCar = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_CAR));
		collisionWater = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_WATER));
		collisionTree = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_COLLISION_TREE));
		life = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_LIFE));
		level = new Level();
		pad = new Pad(100,100,0,0,level.getFrog());
		batch = new SpriteBatch();
		lifeLabel = new BitmapFont();
		lifeLabel.setColor(Color.WHITE);
		levelLabel = new BitmapFont();
		levelLabel.setColor(Color.WHITE);
		camera = new OrthographicCamera();
		viewportWidth = 500;
		viewportHeight = (500*Gdx.graphics.getHeight())/Gdx.graphics.getWidth();
		viewport = new StretchViewport(viewportWidth,viewportHeight,camera);
		viewport.apply();
		camera.position.set(500/2, Constantes.positionYCameraFromFrog(level.getFrog().getY(), viewportHeight),0);
	}
	
	public void updateCamera(){
		int heigthScreen = Gdx.graphics.getHeight();
		int widthScreen = Gdx.graphics.getWidth();
	}
	
	public void start(){
		start=true;
	}
	
	@Override
	public void show(){
		batch = new SpriteBatch();
		start();		
		fond.loop(0.2f);
		Gdx.input.setInputProcessor(new GameListener(level,pad));
	}

	@Override
	public void render(float delta) {
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(level.getBackground(),0,0);
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
		int cameraTravelingY = (int) camera.position.y;
		camera.position.set(500/2, Constantes.positionYCameraFromFrog(level.getFrog().getY(), viewportHeight),0);
		cameraTravelingY -= camera.position.y;
		batch.draw(frog.getTexture(), frog.getX(), frog.getY());
		
		//calcul de la position du haut de l'ecran par rapport au fond
		int yCamera = Constantes.positionYCameraFromFrog(level.getFrog().getY(), viewportHeight);
		int decalage = viewportHeight/2;
		int yTop = (yCamera+decalage);
		//affichag du hud
		batch.draw(hearth, 10, yTop-25);
		lifeLabel.draw(batch, " : "+level.getLife(), 35, yTop-10);
		lifeLabel.draw(batch, "Level : "+level.getLevel(), 440, yTop-10);

		if(pad.isShown()){
			pad.translateY(cameraTravelingY);
			pad.updateTemplate();
			batch.draw(pad.getTexture(), pad.getX(), pad.getY(), pad.getWidth(), pad.getWidth());
		}
		if(level.isLoose())
			game.setScreen(game.gameoverscreen);
		else if(level.isEnd())
			game.setScreen(game.endscreen);
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
		fond.dispose();
	}

	@Override
	   public void dispose(){
	   }

	   @Override
	   public void resize(int width, int height){
		      viewport.update(width,height);
			  camera.position.set(500/2, Constantes.positionYCameraFromFrog(level.getFrog().getY(), viewportHeight),0);
	   }
	   @Override
	public void create(){
	}
}
