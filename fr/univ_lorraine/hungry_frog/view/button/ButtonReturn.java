package fr.univ_lorraine.hungry_frog.view.button;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes;

public class ButtonReturn extends Button {

	public ButtonReturn(int x, int y) {
		super(70, 100, x, y);
		// TODO Stub du constructeur généré automatiquement
		texture1 = new Texture(Constantes.TEXTURE_BT_RETURN_1);
		texture2 = new Texture(Constantes.TEXTURE_BT_RETURN_2);
	}
}
