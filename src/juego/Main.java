package juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cartas.Carta;
import jugador.Jugador;
import mazo.Mazo;

public class Main {

	private Mazo mazo = new Mazo();
	private Mazo pozo = new Mazo();
	private List <Jugador> l = new LinkedList<Jugador>();
	private Integer cantJugadores;
	private Carta c;
	private String color;
	Random rand;


	public static void main(String[] args) {
		Main inicio = new Main();
		Menu menu = new Menu();

		menu.opciones();

		switch (menu.getOpcion()){
			case 1: 			
				inicio.iniciarJuego(menu.getCantJugadores(), menu.getJugadores());
				break;
			case 2: //reanudar partida
				break;
			case 3: //salir
				break;
			case 4: //instrucciones
				break;
			
		}
	}


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
		repartir();

	}
	
	public void repartir(){
		for( Jugador j : l){
			j.tomaCartas(mazo.pop(),7);
		}
	}


}

