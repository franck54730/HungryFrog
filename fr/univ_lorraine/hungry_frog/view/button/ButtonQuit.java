package fr.univ_lorraine.hungry_frog.view.button;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes;

public class ButtonQuit extends Button {

	public ButtonQuit(int x, int y) {
		super(70, 150, x, y);
		// TODO Stub du constructeur généré automatiquement
		texture1 = new Texture(Constantes.TEXTURE_BT_QUIT_1);
		texture2 = new Texture(Constantes.TEXTURE_BT_QUIT_2);
	}

}
