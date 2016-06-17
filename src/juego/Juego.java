package juego;

import java.util.List;
import cartas.CambiaColor;
import cartas.Carta;
import cartas.MasCuatro;
import jugador.Jugador;
import mazo.Mazo;

public class Juego implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Jugador actual;
	private Mazo mazo;
	private Mazo pozo;
	private Ronda l;
	private Integer cantJugadores;
	private Carta cartaPozo;
	private int indexActual;
	private int primerIndex;
	private  boolean estadoPartida;
	private boolean faltanCartas;
	
	/**
	 * Constructor de la clase Juego. Crea el mazo y el pozo
	 * @param ronda ronda de jugadores
	 * @param primerIndex index del primer jugador
	 */
	public Juego(Ronda ronda, int primerIndex) {
		this.faltanCartas = false;
		this.estadoPartida = false;
		this.mazo = new Mazo();
		this.pozo = new Mazo();
		this.l = ronda;
		limpiaManoJugadores();
		this.cantJugadores = getJugadores().size();
		this.l.setSentidoRonda(true);
		this.primerIndex = l.indexSiguiente(primerIndex);
		this.l.setIndexActual(this.primerIndex);
		this.indexActual = this.primerIndex;
		mazo.llenarMazo();
		mazo.mezclar();
		repartirCartas();
		cartaPozo = mazo.pop();
		while(cartaPozo.esCambiaColor() || cartaPozo.esMasCuatro() || cartaPozo.esMasDos()) {
			pozo.push(cartaPozo);
			cartaPozo = mazo.pop();
		}
		pozo.push(cartaPozo);
		if(cartaPozo.esCambiaSentido()) {
			cambiarSentido();
		}
	}

	/**
	 * Constructor de la clase Juego. Crea el mazo, el pozo y la ronda de jugadores
	 * @param cantJugadores cantidad de jugadores
	 * @param nombres nombres de los jugadores
	 */
	public Juego(Integer cantJugadores, List<String> nombres) {
		this.faltanCartas = false;
		this.estadoPartida = false;
		this.mazo = new Mazo();
		this.pozo = new Mazo();
		this.cantJugadores = cantJugadores;
		this.l = new Ronda(nombres);
		indexActual = l.getIndexActual();
		primerIndex = indexActual;
		setActual(l.get(indexActual));
		mazo.llenarMazo();
		mazo.mezclar();
		repartirCartas();
		cartaPozo = mazo.pop();
		while(cartaPozo.esCambiaColor() || cartaPozo.esMasCuatro() || cartaPozo.esMasDos()) {
			pozo.push(cartaPozo);
			cartaPozo = mazo.pop();
		}
		pozo.push(cartaPozo);
		if(cartaPozo.esCambiaSentido()) {
			cambiarSentido();
		}
	}
	
	/**
	 * Metodo que reparte las primeras 7 cartas a los jugadores
	 */
	private void repartirCartas() {
		for(Jugador j : l) {
			for(int i = 0; i < 7; i++) {
				j.recibirCarta(getMazo().pop());
			}			
		}
	}
	
	public Ronda getJugadores() {
		return l;
	}
	
	public Mazo getMazo() {
		return this.mazo;
	}

	public Mazo getPozo() {
		return this.pozo;
	}
	
	public Carta getCartaPozo() {
		return this.cartaPozo;
	}
	
	public void setCartaPozo(Carta cartaPozo) {
		this.cartaPozo = cartaPozo;
	}
	
	public void turnoSiguiente() {
		indexActual = getJugadores().indexSiguiente();
		l.setIndexActual(getJugadores().indexSiguiente());
		setActual(getJugadores().get(indexActual));
	}
	
	public void darCartaAJugador(Jugador j) {
		if(!validaHayCartasEnMazo(getMazo()) && getPozo().tamanoMazo() == 1) {
			this.faltanCartas = true;
			return;
		}
		if(!validaHayCartasEnMazo(getMazo())){
			Carta carta = getPozo().pop();
			getPozo().mezclar();
			setMazo(getPozo());
			Mazo nuevoPozo = new Mazo();
			setPozo(nuevoPozo);
			getPozo().push(carta);
		}
		j.recibirCarta(getMazo().pop());
	}
	
	public boolean validaHayCartasEnMazo(Mazo mazo){
		if(mazo.isEmpty()){
			return false;
		}
		return true;
	}
	
	public Integer getCantJugadores() {
		return this.cantJugadores;
	}
	
	public int getIndexActual() {
		return this.indexActual;
	}
	
	public void cambiaColor( CambiaColor carta, String color) {
		carta.setColorElegido(color);	
	}

	public Jugador getActual() {
		return actual;
	}

	public void setActual(Jugador actual) {
		this.actual = actual;
	}
	
	/**
	 * Suma el puntaje a los jugadores
	 */
	public void puntaje() {
		int index = getJugadores().indexSiguiente();
		Jugador j = getJugadores().get(index);
		while(!j.equals(getActual())) {
			for( Carta c : j.getMano().getMano()){
				String valor = c.getValor();
				if(valor.equals("+2") || valor.equals("cambiaSentido") || valor.equals("saltea")){
				 getActual().incrementarPuntaje(20);
				}
				else if(valor.equals("cambiaColor") || valor.equals("+4")){
					 getActual().incrementarPuntaje(50);
				}
				else{	
				getActual().incrementarPuntaje(Integer.valueOf(c.getValor()));
				}
			}
			j = getJugadores().get(getJugadores().indexSiguiente(index));
			index = getJugadores().indexSiguiente(index);
		}		
	}
	
	/**
	 * Valida el color de la carta a tirar
	 * @param delPozo ultima carta del pozo
	 * @param aTirar carta a tirar
	 * @return true si el color de la carta a tirar coincide con el de la carta del pozo
	 */
	private boolean validaColor(Carta delPozo, Carta aTirar) {
		if(delPozo.getColor().equals(aTirar.getColor()) || aTirar.getColor().equals("NULL") || validaColorEspecial(delPozo, aTirar)) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Valida el color de la carta a tirar
	 * @param delPozo ultima carta del pozo
	 * @param aTirar carta a tirar
	 * @return true si el color de la carta a tirar coincide con el elegido en el turno anterior
	 */
	private boolean validaColorEspecial(Carta delPozo, Carta aTirar) {
		if(delPozo.esCambiaColor()) {
			if(((CambiaColor)delPozo).getColorElegido().equals(aTirar.getColor()) || ((CambiaColor)delPozo).getColorElegido().equals("")) {
				return true;
			}
		} else if(delPozo.esMasCuatro()) {
			if(((MasCuatro)delPozo).getColorElegido().equals(aTirar.getColor()) || ((MasCuatro)delPozo).getColorElegido().equals("")) {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Valida el valor de la carta a tirar
	 * @param delPozo ultima carta del pozo
	 * @param aTirar carta a tirar
	 * @return true si el valor de la carta a tirar coincide con el de la carta del pozo
	 */
	private boolean validaValor (Carta delPozo, Carta aTirar) {
		if(delPozo.getValor().equals(aTirar.getValor()))
			return true;
		return false;
	}
	
	/**
	 * Metodo para jugar una carta. Si es la ultima carta de la mano, se termina la partida
	 * Si le quedaban dos cartas al jugador y no "dijo" uno, se le llena la mano
	 * Si el jugador tira una carta no valida, el mismo recibe dos cartas
	 * @param delPozo ultima carta del pozo
	 * @param aTirar carta a tirar
	 * @param indexCarta index de la carta
	 */
	public void jugarCarta(Carta delPozo, Carta aTirar, int indexCarta) {
		if(validaJugada(delPozo, aTirar)) {
			if(getActual().getMano().getMano().size() == 1) {
				terminoPartida();
				return;
			}
			if((getActual().getMano().getMano().size() == 2 && getActual().getUno()) || getActual().getMano().getMano().size() > 2) {
				getPozo().push(aTirar);
				setCartaPozo(aTirar);
				getJugadores().get(getIndexActual()).getMano().juegaCarta(getCartaIndex(indexCarta));
				getActual().setUno(false);
				if(aTirar.esEspecial()) {
					aplicaPoder(aTirar);
				}
			} else if(getActual().getMano().getMano().size() == 2 && !getActual().getUno()) {
				darCartaAJugador(getActual());
				darCartaAJugador(getActual());
				darCartaAJugador(getActual());
				darCartaAJugador(getActual());
				darCartaAJugador(getActual());
				darCartaAJugador(getActual());				
			}
		} else {
			if(getActual().getUno()) {
				getActual().setUno(false);
			}
			darCartaAJugador(getActual());
			darCartaAJugador(getActual());
		}		
	}
	
	private void terminoPartida() {
		this.estadoPartida = true;
	}
	
	private Carta getCartaIndex(int index) {
		return getJugadores().get(getIndexActual()).getMano().getMano().get(index);
	}
	
	public boolean getEstadoPartida() {
		return this.estadoPartida;
	}
	
	/**
	 * Metodo que aplica el poder o habilidad de la carta especial dada
	 * @param carta carta a tirar
	 */
	private void aplicaPoder(Carta carta) {
		if(carta.esMasDos()) {
			Jugador j = getJugadores().get(getJugadores().indexSiguiente());
			darCartaAJugador(j);
			darCartaAJugador(j);
			turnoSiguiente();
		} else if(carta.esMasCuatro()) {
			Jugador j = getJugadores().get(getJugadores().indexSiguiente());
			darCartaAJugador(j);
			darCartaAJugador(j);
			darCartaAJugador(j);
			darCartaAJugador(j);
			turnoSiguiente();
		} else if(carta.esCambiaSentido()) {
			cambiarSentido();
		} else if(carta.esSaltea()) {
			indexActual = getJugadores().indexSiguiente();
			getJugadores().setIndexActual(getJugadores().indexSiguiente());
		}
	}
	
	private void cambiarSentido() {
		l.cambiaSentido();
	}
	
	/**
	 * Valida la carta a tirar
	 * @param delPozo ultima carta del pozo
	 * @param aTirar carta a tirar
	 * @return true si la carta a tirar el valida con respecto a la carta del pozo
	 */
	public boolean validaJugada (Carta delPozo, Carta aTirar){
		if(!(validaColor(delPozo, aTirar) || validaValor(delPozo, aTirar))){
			return false;
		} else if(delPozo.esCambiaColor()){
			if(aTirar.esMasCuatro()) {
				return true;
			}
			if(!aTirar.getColor().equals(((CambiaColor)delPozo).getColorElegido())){
				return false;
			}
		} else if(delPozo.esMasCuatro()) {
			if(aTirar.esCambiaColor()) {
				return true;
			}
			if(!aTirar.getColor().equals(((MasCuatro)delPozo).getColorElegido())){
				return false;
			}
		}
		return true;
	}
	
	public int getPrimerIndex() {
		return this.primerIndex;
	}
	
	private void limpiaManoJugadores() {
		for(Jugador j : getJugadores()) {
			j.vaciarMano();
		}
	}	
	
	private void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	private void setPozo(Mazo pozo) {
		this.pozo = pozo;
	}
	
	public boolean getFaltanCartas() {
		return this.faltanCartas;
	}
}
