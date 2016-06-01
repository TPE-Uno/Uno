package Jugador;

import Jugador.Jugador.jugadas;

public class Jugador {

	private String nombre;
	private int puntaje;
	private Mano mano; 
	private enum jugadas { TOMACARTA, JUEGACARTA, GRITAUNO, PASOTURNO };
	
	public Jugador (String nombre){
		this.nombre = nombre;
		this.puntaje = 0;
		this.mano = new Mano();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void setPuntaje(int puntaje){
		this.puntaje = puntaje;
	}
	
	public void incrementarPuntaje(int puntaje){
		this.puntaje+=puntaje; //setPuntaje(this.puntaje + puntaje); 
	}
	
	public void jugada (int opc){
		jugadas opcion = opc;
		switch(opcion){
		case TOMACARTA :
			//pido datos
			this.mano.tomaCartas(cartas, cantidad);
			break;
		case JUEGACARTA:
			this.mano.tomaCarta(carta);
			break;
		case GRITAUNO:
			//metodo para gritar uno
			break;
		case PASOTURNO:
			//metodo para pasar de turno
			break;	
		}
	}
		
}

