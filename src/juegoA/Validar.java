package juegoA;
import cartas.CambiaColor;
import cartas.Carta;
import jugador.Mano;

public class Validar {

	private boolean validaColor(Carta delPozo, Carta aTirar) {
		
		if(delPozo.getColor().equals(aTirar.getColor()))
			return true;
		return false;
	}
	
	private boolean validaValor (Carta delPozo, Carta aTirar) {
		
		if(delPozo.getValor().equals(aTirar.getValor()))
			return true;
		return false;
	}
	
	public boolean validaJugada (Carta delPozo, Carta aTirar){
		
		if(!validaColor(delPozo, aTirar) || validaValor(delPozo, aTirar)){
			return false;
		} else if(delPozo.esCambiaColor()){
			if(!aTirar.getColor().equals(delPozo.getColorElegido())){
				return false;
			}
		}
		return true;
	}
	
	//Debido a que tengo dos cartas en la mano y una puede ser tirada, puedo decir uno. "Se activa el boton"
	public boolean validarUno (Mano jugador){
		
		if(jugador.getMano().size() == 2){
			for(int i=0; i<jugador.getMano().size(); i++){
				if(validaJugada(getCartaPozo(), jugador.getMano().get(i))){
					return true;
				} //Con que al menos una de las dos cartas se pueda tirar, el boton ya se habilita
			}
		}	
		return false;	
	}	
	
}
