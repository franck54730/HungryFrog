package fr.univ_lorraine.hungry_frog.view;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

public class HungryFrogGame extends Game {
	private GameScreen animscreen;
	private MenuScreen menuscreen;
	protected EndScreen endscreen;
	protected GameOverScreen gameoverscreen;
	protected FPSLogger logger;
	
	@Override
	public void create () {
		logger = new FPSLogger();
		setAnimscreen(new GameScreen(this));	
		setMenuscreen(new MenuScreen(this));
		endscreen = new EndScreen(this);
		gameoverscreen = new GameOverScreen(this);
		//setGameScreen();
		setScreen(getMenuscreen());	
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

	public MenuScreen getMenuscreen() {
		return menuscreen;
	}

	public void setMenuscreen(MenuScreen menuscreen) {
		this.menuscreen = menuscreen;
	}
	
	public void restart(){
		setAnimscreen(new GameScreen(this));	
		setMenuscreen(new MenuScreen(this));
		endscreen = new EndScreen(this);
		gameoverscreen = new GameOverScreen(this);
		setScreen(menuscreen);
	}
}


