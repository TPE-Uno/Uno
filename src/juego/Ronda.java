package juego;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import jugador.Jugador;


public class Ronda extends LinkedList<Jugador> {
	
	private static final long serialVersionUID = 1L;
	
	private int indexActual;
	private Jugador actual;
	private boolean sentidoRonda;

	/**
	 * Constructor de la clase Ronda. Crea a los jugadores
	 * @param nombres nombres de los jugadores
	 */
	public Ronda(List<String> nombres){
		for ( String j : nombres){
			Jugador j1 = new Jugador(j);
			this.add(j1);
		}
		this.sentidoRonda = true; //sentido antihorario
		Random rand = new Random();
		indexActual = rand.nextInt(nombres.size());
		setActual(this.get(indexActual));
	}

	public int indexSiguiente(){
		if(this.sentidoRonda){
			return indexSiguienteAntiHorario();
		}else{
			return indexSiguienteHorario();
		}
	}
	
	/**
	 * Indica cual es el proximo jugador en la ronda
	 * @param index index del jugador actual
	 * @return index del siguiente jugador
	 */
	public int indexSiguiente(int index) {
		if(this.sentidoRonda){
			return indexSiguienteAntiHorario(index);
		}else{
			return indexSiguienteHorario(index);
		}
	}
	
	/**
	 * Cierra la LinkedList, la hace ciruclar. Sentido antihorario
	 */
	private int indexSiguienteAntiHorario() {
		if(getIndexActual()+1 == cantidadJugadores().intValue()) {
			return 0;
		}
		return getIndexActual() + 1;
	}
	
	private int indexSiguienteAntiHorario(int index) {
		if(index +1 == cantidadJugadores().intValue()) {
			return 0;
		}
		return index + 1;
	}
	
	/**
	 * Cierra la LinkedList, la hace ciruclar. Sentido horario
	 */
	private int indexSiguienteHorario() {
		
		if(getIndexActual() == 0){
			return cantidadJugadores().intValue() - 1;
		} 
		return getIndexActual() - 1;
	}
	
	private int indexSiguienteHorario(int index) {
		
		if(index == 0){
			return cantidadJugadores().intValue() - 1;
		}
		return index - 1;
	}
	
	private Integer cantidadJugadores() {
		return this.size();
	}
	
	/**
	 * Cambia el sentido de la ronda
	 */
	public void cambiaSentido() {
		if(getSentidoRonda()){
			setSentidoRonda(false);
		}else{
		setSentidoRonda(true);
		}
	}
	
	public void setSentidoRonda(boolean sentido){
		this.sentidoRonda = sentido;
	}
	
	public boolean getSentidoRonda() {
		return this.sentidoRonda;
	}
	
	public void setActual(Jugador actual) {
		this.actual = actual;
	}
	
	public Jugador getActual() {
		return this.actual;
	}
	
	public int getIndexActual() {
		return indexActual;
	}

	public void setIndexActual(int indexActual) {
		this.indexActual = indexActual;
	}
}
