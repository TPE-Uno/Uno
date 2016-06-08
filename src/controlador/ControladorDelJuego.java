package controlador;

import vista.JuegoFrame;

public class ControladorDelJuego {

	private JuegoFrame juegoFrame;
	
	public void inicio() {
		juegoFrame = new JuegoFrame(this);
	}
	
	public JuegoFrame getJuegoFrame() {
		return this.juegoFrame;
	}
}
