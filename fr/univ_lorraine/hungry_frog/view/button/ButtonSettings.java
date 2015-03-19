package fr.univ_lorraine.hungry_frog.view.button;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes;

public class ButtonSettings extends Button {

	public ButtonSettings(int x, int y) {
		super(70, 150, x, y);
		// TODO Stub du constructeur g�n�r� automatiquement
		texture1 = new Texture(Constantes.TEXTURE_BT_SETTINGS_1);
		texture2 = new Texture(Constantes.TEXTURE_BT_SETTINGS_2);
	}

}
