package fr.univ_lorraine.hungry_frog.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Frog extends Sprite {
	
	protected int lastX;
	protected int lastY;
	protected boolean onBeech = false;
	
	public Frog() {
		super(50, 50, Constantes.POS_X_START_FROG, Constantes.POS_Y_START_FROG);
		tempoMax = Constantes.TEMPO_FROG;
		lastDirection = "down";
		speed = Constantes.VITESSE_RAPIDE;
		hitbox = new Hitbox[4][3];
		//left
		hitbox[0][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 28, 21, 11, 4);
		hitbox[0][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 28, 22, 15, 11);
		hitbox[0][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 27, 18, 14, 7);
		//right
		hitbox[1][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 28, 21, 14, 4);
		hitbox[1][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 28, 22, 9, 12);
		hitbox[1][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 27, 18, 12, 7);
		//up
		hitbox[2][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 21, 26, 15 ,5);
		hitbox[2][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 19, 26, 16, 10);
		hitbox[2][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 19, 23, 16, 10);
		//down
		hitbox[3][0] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 21, 16, 14, 7);
		hitbox[3][1] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 21, 21, 15, 11);
		hitbox[3][2] = new Hitbox(Constantes.POS_X_START_FROG,Constantes.POS_Y_START_FROG, 23, 26, 14, 2);
		initTexture();
		updateTemplate(); 
	}

	@Override
	protected void initTexture() {
		animation = new TextureRegion[4][3];
		Texture texture = new Texture(Constantes.TEXTURE_FROG);
		for(int direction = 0; direction < 4; direction++){
			for(int image = 0; image < 3; image++){
				int x = (direction*(width*3))+(image*width);
				animation[direction][image] = new TextureRegion(texture, x, 0, width, width);
			}
		}
	}
	
	@Override
	public void update(float delta){
		lastX = x;
		lastY = y;
		super.update(delta);
		if(x < 0)
			x = 0;
		else if( x > 450)
			x = 500-50;
		if(y < 0)
			y = 0;
		else if( y > 480)
			y = 500-20;
	}
	
	public boolean isFinish(){
		return y < 10;
	}

	public void backPosition() {
		// TODO Stub de la méthode généré automatiquement
		x=lastX;
		y=lastY;
	}

	public void outBeech() {
		onBeech=false;
	}

	public void onBeech() {
		onBeech=true;
	}

	public boolean isOnBeech() {
		return onBeech;
	}
}
