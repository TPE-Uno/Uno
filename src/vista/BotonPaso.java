package vista;

import javax.swing.JButton;
import controlador.ControladorDelJuego;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class BotonPaso extends JButton {

	public BotonPaso(ControladorDelJuego juegoControl, PartidaPanel partida) {
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoControl.cambiaTurno();
				partida.remove(partida.getJugadorActualPanel());
				JugadorPanel nuevoJugadorActual = new JugadorPanel(juegoControl, partida);
				partida.setJugadorActuaLabel(nuevoJugadorActual);
				partida.add(partida.getJugadorActualPanel());
				partida.cartaMazoOn();
				partida.pasoOff();
				partida.removeJEEspera();
				partida.mostrarJugadoresEnEspera();
				partida.repaint();
			}
		});
		setText("PASO");
		setBounds(139, 280, 89, 42);
	}
}
