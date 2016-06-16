package archivos;

import controlador.ControladorDelJuego;

public class SaveData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ControladorDelJuego juegoControl;

	public ControladorDelJuego getJuegoControl() {
		return juegoControl;
	}

	public void setJuegoControl(ControladorDelJuego juegoControl) {
		this.juegoControl = juegoControl;
	}
	
}