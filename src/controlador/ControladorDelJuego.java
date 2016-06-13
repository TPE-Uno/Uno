package controlador;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import cartas.*;
import juego.Juego;
import jugador.Jugador;
import vista.JuegoFrame;

public class ControladorDelJuego implements java.io.Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cantJugadores;
	private List<String> nombres;
	private Juego juego;
	private JuegoFrame juegoFrame;
	
	public void abreVentana() {
		juegoFrame = new JuegoFrame(this);
	}
	
	public JuegoFrame getJuegoFrame() {
		return this.juegoFrame;
	}
	
	public void CrearJugadores(String[] nombres) {
		
	}
	
	public void jugarCarta(int index) {
		Carta cartaIndex = getCartaIndex(index);
		juego.jugarCarta(getCartaPozo(), cartaIndex, index);
	}
	
	public boolean cambiaColor(int index) {
		Carta carta = getCartaIndex(index);
		if(carta.esCambiaColor() || carta.esMasCuatro()) {
			return true;
		}
		return false;
	}
	
	public int indexSiguiente(int index) {
		return juego.getJugadores().indexSiguiente(index);
	}
	
	public void setColor(String color) {
		if(getCartaPozo().esMasCuatro()) {
			((MasCuatro)getCartaPozo()).setColorElegido(color);
		} else {
		((CambiaColor)getCartaPozo()).setColorElegido(color);
		}
	}
	
	public void cambiaTurno() {
		juego.turnoSiguiente();
	}
	
	public void quitarCartaAlJugador(int index) {
		juego.getActual().getMano().juegaCarta(getCartaIndex(index));
	}
	
	public String valorCartaJActualIndex(int index) {
		return getJugadorActual().getMano().getMano().get(index).getValor();
	}
	
	public Carta getCartaMazo() {
		return juego.getMazo().pop();
	}
	
	public String colorCartaJActualIndex(int index) {
		return getJugadorActual().getMano().getMano().get(index).getColor();
	}
	
	public void agregarCartaAlPozo(Carta carta) {
		juego.getPozo().push(carta);
		juego.setCartaPozo(carta);
	}
	
	public String getCartaColor(Carta carta) {
		return carta.getColor();
	}
	
	public String getCartaValor(Carta carta) {
		return carta.getValor();
	}
	
	public Carta getCartaPozo() {
		return juego.getCartaPozo();
	}
	
	public void inicioDelJuego() {
		juego = new Juego(cantJugadores, nombres);
	}
	
	public List<String> getNombres() {
		return this.nombres;
	}
	
	public Integer getCantJugadores() {
		return this.cantJugadores;
	}
	
	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}
	
	public void setCantJugadores(Integer cantJugadores) {
		this.cantJugadores = cantJugadores;
	}
	
	public Jugador getJugadorActual() {
		return juego.getActual();
	}
	
	public Carta getCartaIndex(int index) {
		return getJugadorActual().getMano().getMano().get(index);
	}
	
	public int jugadoresSize() {
		return juego.getJugadores().size();
	}
	
	public void darCartaAJugador() {
		juego.darCartaAJugador();
	}
	
	public int getJugadorIndexPuntaje(int index) {
		return getJugadorIndex(index).getPuntaje();
	}
	
	public int getJugadorIndexManoSize(int index) {
		return getJugadorIndex(index).getMano().getMano().size();
	}
	
	public String getJugadorIndexNombre(int index) {
		return getJugadorIndex(index).getNombre();
	}

	public Jugador getJugadorIndex(int index) {
		return juego.getJugadores().get(index);
	}

	public int indexActual() {
		return juego.getIndexActual();
	}

	public boolean tieneDosCartas() {
		if(juego.getActual().getMano().getMano().size() == 2) {
			return true;
		}
		return false;
	}
	
	public boolean terminoParitda() {
		return juego.getEstadoPartida();
	}
	
	public void sumarPuntos() {
		juego.puntaje();
		if(juego.getActual().getPuntaje() >= 500) {
			getJuegoFrame().dispose();
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "GANO "+juego.getActual().getNombre()+"!!!");
		}
	}
	
	public void iniciaNuevaPartida() {
		Juego nuevaPartida = new Juego(juego.getJugadores(), juego.getPrimerIndex());
		setJuego(nuevaPartida);
	}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public Juego getJuego() {
		return this.juego;
	}
}
