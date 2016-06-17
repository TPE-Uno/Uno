package vista;

import controlador.ControladorDelJuego;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CartaLabel extends JLabel {
	
	public CartaLabel(String valor, String color, ControladorDelJuego juegoControl, PartidaPanel partida) {
		setIcon(new ImageIcon(CartaLabel.class.getResource("/imagenes/"+color+"/"+valor+".jpg")));
		this.setSize(new Dimension(40,62));
	}
}