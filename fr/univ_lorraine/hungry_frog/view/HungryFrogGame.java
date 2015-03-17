package fr.univ_lorraine.hungry_frog.view;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

public class HungryFrogGame extends Game {
	protected GameScreen animscreen;
	protected SplashScreen splashscreen;
	protected EndScreen endscreen;
	protected GameOverScreen gameoverscreen;
	protected FPSLogger logger;
	
	@Override
	public void create () {
		logger = new FPSLogger();
		animscreen = new GameScreen(this);	
		splashscreen = new SplashScreen(this);
		endscreen = new EndScreen(this);
		gameoverscreen = new GameOverScreen(this);
		//setGameScreen();
		setScreen(splashscreen);	
	}
	
	@Override
	public void render () {
		super.render();
		//logger.log();
	}
}


