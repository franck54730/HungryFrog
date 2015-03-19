package fr.univ_lorraine.hungry_frog.view.button;

import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.hungry_frog.model.Constantes;

public class CheckBox extends Button {

	public CheckBox(int x, int y) {
		super(50, 50, x, y);
		// TODO Stub du constructeur généré automatiquement
		texture1 = new Texture(Constantes.TEXTURE_CBOX_1);
		texture2 = new Texture(Constantes.TEXTURE_CBOX_2);
	}

}
