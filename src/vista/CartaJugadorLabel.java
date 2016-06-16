package vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controlador.ControladorDelJuego;

@SuppressWarnings("serial")
public class CartaJugadorLabel extends CartaLabel{
	
	public CartaJugadorLabel(String valor, String color, ControladorDelJuego juegoControl, int indexCarta, PartidaPanel partida) {
		super(valor, color, juegoControl, partida);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(juegoControl.cambiaColor(indexCarta) && !juegoControl.tieneUnaCarta()) {
					juegoControl.getJuegoFrame().setEnabled(false);
					CambiaColorPanel cambiaColorPanel = new CambiaColorPanel(juegoControl, indexCarta);
					cambiaColorPanel.setVisible(true);
				}
				juegoControl.jugarCarta(indexCarta);
				if(juegoControl.terminoParitda()) {
					juegoControl.sumarPuntos();
					juegoControl.iniciaNuevaPartida();
				}
				else if(juegoControl.faltanCartas()) {
					FaltaDeCartasPanel frame = new FaltaDeCartasPanel();
					juegoControl.getJuegoFrame().setupFrame(frame);				
				}
				partida.remove(partida.getCartaPozoLabel());
				CartaPozoLabel nuevaCartaPozo = new CartaPozoLabel(juegoControl.getCartaValor(juegoControl.getCartaPozo()), juegoControl.getCartaColor(juegoControl.getCartaPozo()), juegoControl,partida);
				partida.setCartaPozoLabel(nuevaCartaPozo);
				partida.add(partida.getCartaPozoLabel());
				juegoControl.cambiaTurno();
				partida.remove(partida.getJugadorActualPanel());
				JugadorPanel nuevoJugadorActual = new JugadorPanel(juegoControl, partida);
				partida.setJugadorActuaLabel(nuevoJugadorActual);
				partida.add(partida.getJugadorActualPanel());
				partida.cartaMazoOn();
				partida.removeJEEspera();
				partida.mostrarJugadoresEnEspera();
				partida.pasoOff();
				partida.repaint();				
			}
		});
	}
}
