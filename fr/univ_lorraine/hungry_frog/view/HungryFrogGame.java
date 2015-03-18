package fr.univ_lorraine.hungry_frog.view;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

public class HungryFrogGame extends Game {
	private GameScreen animscreen;
	protected MenuScreen menuscreen;
	protected EndScreen endscreen;
	protected GameOverScreen gameoverscreen;
	protected FPSLogger logger;
	
	@Override
	public void create () {
		logger = new FPSLogger();
		setAnimscreen(new GameScreen(this));	
		menuscreen = new MenuScreen(this);
		endscreen = new EndScreen(this);
		gameoverscreen = new GameOverScreen(this);
		//setGameScreen();
		setScreen(menuscreen);	
	}
	
	@Override
	public void render () {
		super.render();
		//logger.log();
	}

	public GameScreen getAnimscreen() {
		return animscreen;
	}

	public void setAnimscreen(GameScreen animscreen) {
		this.animscreen = animscreen;
	}
}


