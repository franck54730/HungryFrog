package fr.univ_lorraine.hungry_frog.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.univ_lorraine.hungry_frog.controller.GameListener;
import fr.univ_lorraine.hungry_frog.controller.MenuListener;
import fr.univ_lorraine.hungry_frog.controller.SettingsListener;
import fr.univ_lorraine.hungry_frog.model.Constantes;
import fr.univ_lorraine.hungry_frog.model.Settings;
import fr.univ_lorraine.hungry_frog.view.button.ButtonPlay;
import fr.univ_lorraine.hungry_frog.view.button.ButtonQuit;
import fr.univ_lorraine.hungry_frog.view.button.ButtonReturn;
import fr.univ_lorraine.hungry_frog.view.button.CheckBox;

public class SettingsScreen extends ScreenAdapter{
	HungryFrogGame hungryfrog;
	SpriteBatch batch;
	Texture img;
	Sound fond;
	CheckBox boxSound;
	CheckBox boxPad;
	CheckBox boxAccelerometre;
    BitmapFont soundLabel;
	ButtonReturn btReturn;
	OrthographicCamera camera;
	Viewport viewport;
	boolean start = true;
	
	public SettingsScreen(HungryFrogGame hungryfrog){
		this.hungryfrog = hungryfrog;
		batch = new SpriteBatch();
		img = new Texture(Constantes.TEXTURE_SETTINGS);
		fond = Gdx.audio.newSound(Gdx.files.internal(Constantes.SON_SETTINGS));
		camera = new OrthographicCamera();
		viewport = new FitViewport(500,500,camera);
		viewport.apply();
		camera.position.set(500/2,500/2,0);
		btReturn = new ButtonReturn( 325, 62);
		boxSound = new CheckBox(265, 150);
		boxPad = new CheckBox(265, 220);
		boxAccelerometre = new CheckBox(265, 290);
		if(Settings.getInstance().isSound()){
			boxSound.click();
		}
		if(Settings.getInstance().isPad()){
			boxPad.click();
		}else{
			boxAccelerometre.click();
		}
		soundLabel = new BitmapFont();
		soundLabel.setColor(Color.BLACK);
		soundLabel.scale(1.2f);
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
		btReturn.initialize();
		Gdx.input.setInputProcessor(new SettingsListener(btReturn, boxSound, boxPad, boxAccelerometre, hungryfrog));
	}
	
	public void render(float delta){
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
		if(start){
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img,0,0);
			batch.draw(boxSound.getTexture(), boxSound.getX(), boxSound.getY());
			batch.draw(boxAccelerometre.getTexture(), boxAccelerometre.getX(), boxAccelerometre.getY());
			batch.draw(boxPad.getTexture(), boxPad.getX(), boxPad.getY());
			batch.draw(btReturn.getTexture(), btReturn.getX(), btReturn.getY());
			soundLabel.draw(batch, "Son : ", 190, 190);
			soundLabel.draw(batch, "Pad : ", 190, 260);
			soundLabel.draw(batch, "Accelerometre : ", 42, 330);
			batch.end();
		}
	}

	   @Override
	   public void resize(int width, int height){
	      viewport.update(width,height);
	      camera.position.set(500/2,500/2,0);
	   }
}
