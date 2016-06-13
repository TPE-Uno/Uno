package juego;

import java.util.List;
import cartas.CambiaColor;
import cartas.Carta;
import cartas.MasCuatro;
import jugador.Jugador;
import mazo.Mazo;

public class Juego implements java.io.Serializable {

	/**
	 * 
	 */
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
	
	public Juego(Ronda ronda, int primerIndex) {
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
		while(cartaPozo.esCambiaColor() || cartaPozo.esMasCuatro()) {
			pozo.push(cartaPozo);
			cartaPozo = mazo.pop();
		}
		pozo.push(cartaPozo);
		if(cartaPozo.esMasCuatro()) {
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
		} else if(cartaPozo.esMasDos()) {
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
		} else if(cartaPozo.esCambiaSentido()) {
			cambiarSentido();
		}
	}

	public Juego(Integer cantJugadores, List<String> nombres) {
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
		while(cartaPozo.esCambiaColor() || cartaPozo.esMasCuatro()) {
			pozo.push(cartaPozo);
			cartaPozo = mazo.pop();
		}
		pozo.push(cartaPozo);
		if(cartaPozo.esMasCuatro()) {
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
		} else if(cartaPozo.esMasDos()) {
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
		} else if(cartaPozo.esCambiaSentido()) {
			cambiarSentido();
		}
	}
	
	private void repartirCartas() {
		for(Jugador j : l) {
			for(int i = 0; i < 7; i++) {
				j.recibirCarta(mazo.pop());
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
		indexActual = l.indexSiguiente();
		l.setIndexActual(l.indexSiguiente());
		setActual(l.get(indexActual));
	}
	
	public void darCartaAJugador() {
		getActual().getMano().tomaCarta(mazo.pop());
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
	
	private boolean validaColor(Carta delPozo, Carta aTirar) {
		if(delPozo.getColor().equals(aTirar.getColor()) || aTirar.getColor().equals("NULL") || validaColorEspecial(delPozo, aTirar)) {
			return true;
		} 
		return false;
	}
	
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
	
	private boolean validaValor (Carta delPozo, Carta aTirar) {
		if(delPozo.getValor().equals(aTirar.getValor()))
			return true;
		return false;
	}
	
	public void jugarCarta(Carta delPozo, Carta aTirar, int indexCarta) {
		if(validaJugada(delPozo, aTirar)) {
			if(getActual().getMano().getMano().size() == 1) {
				terminoPartida();
				return;
			}
			if((getActual().getMano().getMano().size() == 2 && getActual().getUno()) || getActual().getMano().getMano().size() > 2) {
				pozo.push(aTirar);
				setCartaPozo(aTirar);
				l.get(indexActual).getMano().juegaCarta(getCartaIndex(indexCarta));
				getActual().setUno(false);
				if(aTirar.esEspecial()) {
					aplicaPoder(aTirar);
				}
			} else if(getActual().getMano().getMano().size() == 2 && !getActual().getUno()) {
				getActual().getMano().tomaCarta(mazo.pop());
				getActual().getMano().tomaCarta(mazo.pop());
				getActual().getMano().tomaCarta(mazo.pop());
				getActual().getMano().tomaCarta(mazo.pop());
				getActual().getMano().tomaCarta(mazo.pop());
				getActual().getMano().tomaCarta(mazo.pop());
			}
		} else {
			if(getActual().getUno()) {
				getActual().setUno(false);
			}
			getActual().getMano().tomaCarta(mazo.pop());
			getActual().getMano().tomaCarta(mazo.pop());
		}		
	}
	
	private void terminoPartida() {
		this.estadoPartida = true;
	}
	
	private Carta getCartaIndex(int index) {
		return l.get(indexActual).getMano().getMano().get(index);
	}
	
	public boolean getEstadoPartida() {
		return this.estadoPartida;
	}
	
	private void aplicaPoder(Carta carta) {
		if(carta.esMasDos()) {
			Jugador j = l.get(l.indexSiguiente());
			j.recibirCarta(mazo.pop());
			j.recibirCarta(mazo.pop());
			turnoSiguiente();
		} else if(carta.esMasCuatro()) {
			Jugador j = l.get(l.indexSiguiente());
			j.recibirCarta(mazo.pop());
			j.recibirCarta(mazo.pop());
			j.recibirCarta(mazo.pop());
			j.recibirCarta(mazo.pop());
			turnoSiguiente();
		} else if(carta.esCambiaSentido()) {
			cambiarSentido();
		} else if(carta.esSaltea()) {
			indexActual = l.indexSiguiente();
			l.setIndexActual(l.indexSiguiente());
		}
	}
	
	private void cambiarSentido() {
		l.cambiaSentido();
	}
	
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
}
