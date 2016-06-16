package vista;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import controlador.ControladorDelJuego;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CartaMazoLabel extends JLabel {

	private boolean active;
	
	public CartaMazoLabel(ControladorDelJuego juegoControl, PartidaPanel partida) {
		this.active = true;
		setIcon(new ImageIcon(PartidaPanel.class.getResource("/imagenes/TraseraUNO.jpg")));
		setBounds(568, 180, 90, 65);
		setSize(new Dimension(54, 62));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(active) {
					juegoControl.darCartaAJugador();
					if(juegoControl.faltanCartas()) {
						FaltaDeCartasPanel frame = new FaltaDeCartasPanel();
						juegoControl.getJuegoFrame().setupFrame(frame);	
					}
					partida.remove(partida.getJugadorActualPanel());
					JugadorPanel nuevoJugadorActual = new JugadorPanel(juegoControl, partida);
					partida.setJugadorActuaLabel(nuevoJugadorActual);
					partida.add(partida.getJugadorActualPanel());
					partida.cartaMazoOff();
					partida.pasoOn();
					partida.repaint();
				}			
			}
		});
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
