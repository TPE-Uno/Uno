package juego;

import java.util.List;
import java.util.ListIterator;

import cartas.CambiaColor;
import jugador.Jugador;

public class Juego {
	
	private Jugador actual;
	
	ListIterator<Jugador> li;
	
	public void cambiaColor( CambiaColor carta, String color) {
		carta.setColorElegido(color);	
	}
	
	public void saltear(List <Jugador> l) {
		li = l.listIterator(0);
		actual = li.next();		
	}

	public Jugador getActual() {
		return actual;
	}

	public void setActual(Jugador actual) {
		this.actual = actual;
	}
}