package controlador;

import java.util.List;
import cartas.*;
import juego.Juego;
import jugador.Jugador;

public class ControladorDelJuego implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cantJugadores;
	private List<String> nombres;
	private Juego juego;	
	
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
	
	/**
	 * Retorna el index del siguiente jugador
	 * @param index index del jugador actual
	 * @return index del siguiente jugador
	 */
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
	
	/**
	 * Retorna el valor de la carta del jugador actual
	 * @param index index del jugador actual
	 * @return valor de la carta
	 */
	public String valorCartaJActualIndex(int index) {
		return getJugadorActual().getMano().getMano().get(index).getValor();
	}
	
	public Carta getCartaMazo() {
		return juego.getMazo().pop();
	}
	
	/**
	 * Retorna el color de la carta del jugador actual
	 * @param index index del jugador actual
	 * @return color de la carta
	 */
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
		juego.darCartaAJugador(juego.getActual());
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

	public boolean faltanCartas() {
		return juego.getFaltanCartas();
	}
	
	public int indexActual() {
		return juego.getIndexActual();
	}

	/**
	 * Verifica si el jugador actual tiene solo dos cartas en la mano
	 * @return true si tiene dos cartas
	 */
	public boolean tieneDosCartas() {
		if(juego.getActual().getMano().getMano().size() == 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si el jugador actual tiene una carta en la mano
	 * @return true si tiene una carta
	 */
	public boolean tieneUnaCarta() {
		if(juego.getActual().getMano().getMano().size() == 1) {
			return true;
		}
		return false;
	}
	
	public boolean terminoParitda() {
		return juego.getEstadoPartida();
	}
	
	public boolean sumarPuntos() {
		juego.puntaje();
		if(juego.getActual().getPuntaje() >= 500) {
			return true;
		}
		return false;
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
	
	public String getJANombre() {
		return juego.getActual().getNombre();
	}
}
