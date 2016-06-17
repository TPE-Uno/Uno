package vista;

import javax.swing.JPanel;
import controlador.ControladorDelJuego;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class JugadorEnEsperaPanel extends JPanel {
	
	public JugadorEnEsperaPanel(ControladorDelJuego juegoControl, PartidaPanel partida, int indexJugador) {
		setBackground(new Color(153, 204, 255));
		setLayout(null);
		JLabel lblNewLabel = new JLabel(juegoControl.getJugadorIndexNombre(indexJugador));
		lblNewLabel.setBounds(10, 11, 386, 19);
		add(lblNewLabel);
		JLabel lblPuntos = new JLabel("Puntos: "+juegoControl.getJugadorIndexPuntaje(indexJugador));
		lblPuntos.setBounds(10, 29, 140, 19);
		add(lblPuntos);
		JLabel lblNewLabel_1 = new JLabel("#Cartas: "+juegoControl.getJugadorIndexManoSize(indexJugador));
		lblNewLabel_1.setBounds(10, 49, 155, 19);
		add(lblNewLabel_1);
	}
}