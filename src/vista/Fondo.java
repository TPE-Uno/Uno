package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import controlador.ControladorDelJuego;

@SuppressWarnings("serial")
public class Fondo extends JLabel {
	
	public Fondo(ControladorDelJuego juegoControl) {
		setIcon(new ImageIcon(PartidaPanel.class.getResource("/imagenes/fondo.jpg")));
		setBounds(0, 0, 600, 450);
	}
}
