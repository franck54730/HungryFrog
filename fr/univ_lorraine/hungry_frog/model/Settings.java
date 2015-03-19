package fr.univ_lorraine.hungry_frog.model;

public class Settings {
	public static Settings instance = new Settings();
	protected boolean sound;
	protected boolean pad;
	
	private Settings(){
		sound = true;
		pad = true;
	}

	public void setPad(boolean p){
		pad = p;
	}
	
	public boolean isPad(){
		return pad;
	}
	
	public static Settings getInstance(){
		return instance;
	}
	
	public void changeSound(){
		sound = !sound;
	}
	
	public boolean isSound(){
		return sound;
	}

	public void changePad() {
		pad = !pad;
	}
}
