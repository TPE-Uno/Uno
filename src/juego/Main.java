package juego;

import mazo.Mazo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cartas.Carta;
import jugador.Jugador;

public class Main {

	private Mazo mazo = new Mazo();
	private Mazo pozo = new Mazo();
	private List <Jugador> l = new LinkedList<Jugador>();
	private int cantJugadores;
	private Carta c;
	private String color;
	Random rand;


	public void iniciarJuego( int cantJugadores, ArrayList<String> nombres  ) {
		this.cantJugadores = cantJugadores;
		for ( String j : nombres){
			Jugador j1 = new Jugador(j);
			l.add(j1);
		}
		Juego juego = new Juego();
		juego.setActual(l.get((rand.nextInt(cantJugadores - 1) +1)));
		mazo.llenarMazo();
		mazo.mezclar();
		c = mazo.pop();
		pozo.push(c);
		color = c.getColor();
		
	}
	
	
}
