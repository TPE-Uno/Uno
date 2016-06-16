package jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartas.Carta;

public class Mano implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List <Carta> mano;
	public static final int totalCartas = 7;
	
	/**
	 * Constructor de la clase Mano. Crea un ArrayList de cartas
	 */
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
	
	/**
	 * Muestra las cartas de la mano
	 */
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
	
	public Iterator<Carta> iterator(){
		return mano.iterator();
	}
	
	public void limpia() {
		getMano().clear();
	}
}
