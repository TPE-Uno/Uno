package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CartaEstandar extends Carta {

	/**
	 * M�todo constructor que crea una carta est�ndar
	 * 
	 * @param numero de la carta
	 * @param color de la carta
	 */
	public CartaEstandar(final  String numero, final String color) {
		super(numero, color);
		if(!validaNumero(numero)) {
			throw new IllegalArgumentException("No es un numero valido");
		}
		if(!validaColor(color)) {
			throw new IllegalArgumentException("No es un color valido");
		}
	}	

	/**
	 * M�todo que valida si el n�mero que se pasa por parametro est� dentro
	 * de los n�meros permitidos por el juego
	 *
	 * @param numero
	 * @return "true" si el n�mero es v�lido y "false" si no lo es
	 */
	private static boolean validaNumero(String numero) {
		for(String valor : VALORES) {
			if(valor.equals(numero)) {
				return true;
			}
		}
		return false;
	}
}