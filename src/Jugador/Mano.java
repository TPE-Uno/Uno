package Jugador;
import java.util.List;
import java.util.ArrayList;

public class Mano {

	private List <Integer> mano;
	public static final int totalCartas = 7;
	
	
	public Mano (){
		mano = new ArrayList<Integer>(totalCartas);
	}
	
	public ArrayList<Integer> getMano(){
		return (ArrayList<Integer>) this.mano;
	}
	
	public ArrayList<Integer> tomaCarta (Integer carta){
		this.mano.add(carta);
		return (ArrayList<Integer>) this.mano;
	}
	
	public ArrayList<Integer> tomaCartas (ArrayList<Integer> cartas){
		this.mano.addAll(cartas);
		return (ArrayList<Integer>) this.mano;	
	}
	
	public ArrayList<Integer> tomaCartas (ArrayList<Integer> cartas, int cantidad){
		if(cantidad == 1){
			tomaCarta(cartas.get(0));
		}
		else{
			tomaCartas(cartas);
		}
		return (ArrayList<Integer>) this.mano;
	}
	
	public ArrayList <Integer> juegaCarta (Integer carta){
		this.mano.remove(carta);
		((ArrayList<Integer>)this.mano).trimToSize();
		return (ArrayList<Integer>) this.mano;
	}
	
	public void verMano(){
		for(int i = 0; i<this.mano.size(); i++){
			System.out.println(this.mano.get(i));
		}
	}
