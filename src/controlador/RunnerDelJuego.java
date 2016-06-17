package controlador;

import vista.JuegoFrame;

public class RunnerDelJuego {

	public static void main(String[] args) {
		ControladorDelJuego juegoControl = new ControladorDelJuego();
		@SuppressWarnings("unused")
		JuegoFrame juegoFrame = new JuegoFrame(juegoControl);
	}
}