package Jugador;
import java.util.List;

import Cartas.Carta;

import java.util.ArrayList;

public class Mano {

	private List <Carta> mano;
	public static final int totalCartas = 7;
	
	
	public Mano () {
		mano = new ArrayList<Carta>(totalCartas);
	}
	
	public ArrayList<Carta> getMano() {
		return (ArrayList<Carta>) this.mano;
	}
	
	public void tomaCarta (Carta carta) {
		this.mano.add(carta);
	}
	
	
	public void juegaCarta (Carta carta) {
		this.mano.remove(carta);
		((ArrayList<Carta>)this.mano).trimToSize();
	}
	
	public void verMano() {
		for(int i = 0; i<this.mano.size(); i++){
			System.out.println(this.mano.get(i));
		}
	}
	
	@Override
	public String toString() {
		String string = "";
		for(int i=0; i<this.mano.size(); i++){
			string += this.mano.get(i).toString();
		}
		return string;
	}
	
	
}