package fr.univ_lorraine.hungry_frog.view;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class HungryFrogGame extends Game {
	protected GameScreen gameScreen;
	protected MenuScreen menuScreen;
	protected EndScreen endScreen;
	protected GameOverScreen gameoverScreen;
	protected SettingsScreen settingsScreen;
	protected FPSLogger logger;
	
	@Override
	public void create () {
		logger = new FPSLogger();
		gameScreen = new GameScreen(this);	
		menuScreen = new MenuScreen(this);
		endScreen = new EndScreen(this);
		gameoverScreen = new GameOverScreen(this);
		settingsScreen = new SettingsScreen(this);
		setScreen(menuScreen);	
	}
	
	@Override
	public void render () {
		super.render();
		//logger.log();
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	public void setMenuScreen(MenuScreen menuScreen) {
		this.menuScreen = menuScreen;
	}
	
	public void restart(){
		gameScreen = new GameScreen(this);	
		menuScreen = new MenuScreen(this);
		endScreen = new EndScreen(this);
		gameoverScreen = new GameOverScreen(this);
		settingsScreen = new SettingsScreen(this);
		setScreen(menuScreen);
	}

	public Screen getSettingsScreen() {
		return settingsScreen;
	}

	public void setSettingsScreen(SettingsScreen settingsScreen) {
		this.settingsScreen = settingsScreen;
	}
}


