package vista;

import controlador.ControladorDelJuego;

@SuppressWarnings("serial")
public class CartaPozoLabel extends CartaLabel {

	public CartaPozoLabel(String valor, String color, ControladorDelJuego juegoControl, PartidaPanel partida) {
		super(valor, color, juegoControl, partida);
		setBounds(620, 180, 49, 62);
	}
}
